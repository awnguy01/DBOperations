from utils.db import find_table_by_name, in_order_traversal
from typing import Dict, List, Tuple
from validators.antlr4.SQLiteParser import SQLiteParser
from utils.valid import parse_context
from utils.db import find_table_by_alias
from models.Attribute import Attribute, AttributeType
from models.Join import Join, JoinType
from models.Table import Table
from antlr4.tree.Tree import TerminalNodeImpl
import re
from copy import deepcopy


class SQLExecutor:
    def execute_sql(self, sql: str, schema: Dict[str, Table]):
        self.schema = deepcopy(schema)
        commands = []
        sql_stmt_list_ctxs = parse_context(sql).sql_stmt_list()
        for sql_stmt_list_ctx in sql_stmt_list_ctxs:
            for sql_stmt_ctx in sql_stmt_list_ctx.sql_stmt():
                command = ''
                select_stmt_ctx = sql_stmt_ctx.select_stmt()
                if select_stmt_ctx:
                    command = compute_select_command(
                        select_stmt_ctx, self.schema)
                commands.append(command)
        return ' & '.join(commands)


def compute_select_command(select_stmt_ctx: SQLiteParser.Select_stmtContext, schema: Dict[str, Table]) -> str:
    commands: List[str] = []
    select_core_ctx = select_stmt_ctx.select_core(0)
    sources = list(schema.values())
    attributes: List[Attribute] = map_table_attributes(
        select_stmt_ctx, sources)
    joins = extract_joins(select_core_ctx, sources)
    results_headers = []

    for source in sources:
        source_attributes = [
            attr for attr in attributes if attr.source.name == source.name]

        # Project all involved attributes
        initial_projections = sorted((
            projection
            for projection
            in dict.fromkeys([
                re.sub(
                    r'\b(SUM|COUNT|AVG|MIN|MAX)\(|\)\b', '', attribute.name, flags=re.IGNORECASE)
                for attribute
                in source_attributes
                if attribute.association != AttributeType.WHERE
            ])), key=(lambda projection: source.headers.index(projection)))

        if any(attr.association == AttributeType.WHERE for attr in attributes):
            condition = extract_conditions(
                select_core_ctx.where_clause())
            commands.append(compute_select_where_command(
                condition, initial_projections, source))
        else:
            commands.append(compute_project_command(
                initial_projections, source, True))

        # Realign order of table headers
        source.headers = initial_projections
        if joins:
            commands[-1] += f' > /tmp/term_sql_{source.name}'

    if joins:
        commands += compute_join_commands(joins, sources)
        attributes = [
            attribute for attribute in attributes if attribute.association != AttributeType.JOIN]
        projections = sorted((
            projection
            for projection
            in dict.fromkeys([
                re.sub(
                    r'\b(SUM|COUNT|AVG|MIN|MAX)\(|\)\b', '', f'{attribute.source.name}.{attribute.name}', flags=re.IGNORECASE)
                for attribute
                in attributes
            ])), key=(lambda projection: sources[0].headers.index(projection)))
        commands[-1] += f' | {compute_project_command(projections, sources[0], False)}'
        sources[0].headers = projections

    results_headers = sources[0].headers

    groups = find_all_attribute_names_for_type(
        attributes, AttributeType.GROUP_BY)
    aggregates = find_all_attribute_names_for_type(
        attributes, AttributeType.AGG)

    if groups or aggregates:
        if groups and aggregates:
            commands[-1] += f' | {compute_group_by_with_agg_command(groups + aggregates, results_headers)}'
        elif groups:
            commands[-1] += f' | {compute_group_by_command(groups, results_headers)}'
        elif aggregates:
            commands[-1] += f' | {compute_agg_command(aggregates, results_headers)}'

        results_headers = groups + aggregates

    sorts = [
        f'{attribute.source.name}.{attribute.name}'
        for attribute
        in attributes
        if attribute.association == AttributeType.ORDER_BY
    ]
    if sorts:
        commands[-1] += f' | {compute_order_by_command(sorts, results_headers)}'

    if select_stmt_ctx.limit_stmt():
        limit, offset = extract_limit_offset(select_stmt_ctx.limit_stmt())
        commands[-1] += f' | {compute_limit_command(limit, offset)}'
    return ' ; '.join(commands)


def compute_project_command(selects: List[str], source: Table, initial: bool) -> str:
    pipes: List[str] = []

    if set(source.headers).issubset(selects):
        pipes.append('cat ' + f'"{source.full_path}"' if initial else '')
    else:
        cut_args = ['cut']
        projections = ','.join(selects)
        for i, header in enumerate(source.headers):
            projections = re.sub(fr'\b{header}\b', str(
                i + 1), projections, flags=re.IGNORECASE)
        if initial:
            cut_args.append(f'"{source.full_path}"')
        cut_args.append(f'-d "{source.delimiter}" -f "{projections}"')
        pipes.append(' '.join(cut_args))

    if initial and type(source.headers[0]) is str:
        pipes.append('tail -n+2')

    return ' | '.join(pipes)


def compute_select_where_command(condition: str, projections: List[str], source: Table) -> str:
    args = ['python3 ../select.py']
    args.append("-i '" + source.full_path + "'")
    args.append("-s '" + source.delimiter + "'")
    if type(source.headers[0]) is str:
        args.append('-h')

    proj_str = ','.join(projections)
    cond_str = re.sub('\'', '"', condition)

    for i, header in enumerate(source.headers):
        proj_str = re.sub(fr'\b{header}\b', f'#{i + 1}',
                          proj_str, flags=re.IGNORECASE)
        cond_str = re.sub(fr'\b{header}\b', f'#{i + 1}',
                          cond_str, flags=re.IGNORECASE)

    args.append(f"-p '{proj_str}'")
    args.append(f"-c '{cond_str}'")

    return ' '.join(args)


def compute_join_commands(joins: List[Join], sources: List[Table]):
    commands = []
    joined_sources: List[str] = []
    left_headers: List[str] = []
    left_f_name = None

    while joins:
        for i in range(len(joins)):
            join = joins[i]
            if not joined_sources or join.left in joined_sources:
                left_source = next(
                    source for source in sources if source.name == join.left)
                right_source = next(
                    source for source in sources if source.name == join.right)
                left_f_name = left_f_name if left_f_name else f'/tmp/term_sql_{left_source.name}'
                right_f_name = f'/tmp/term_sql_{right_source.name}'
                left_headers = left_headers if left_headers else [
                    f'{left_source.name}.{header}' for header in left_source.headers]
                right_headers = [
                    f'{right_source.name}.{header}' for header in right_source.headers]

                left_attribute = f'{left_source.name}.{join.left_attribute}'
                right_attribute = f'{right_source.name}.{join.right_attribute}'

                commands.append(
                    f'{compute_order_by_command([left_attribute], left_headers)} -o {left_f_name} {left_f_name}')
                commands.append(
                    f'{compute_order_by_command([right_attribute], right_headers)} -o {right_f_name} {right_f_name}')
                join_args = ['join -t ","']

                if join.join_type == JoinType.LEFT:
                    join_args.append('-a1')
                elif join.join_type == JoinType.RIGHT:
                    join_args.append('-a2')

                join_args.append(
                    f'-1{left_headers.index(left_attribute) + 1}')
                join_args.append(
                    f'-2{right_headers.index(right_attribute) + 1}')
                join_args.append(f'{left_f_name}')
                join_args.append(f'{right_f_name}')
                left_f_name += f'_{right_source.name}'
                if len(joins) > 1:
                    join_args.append(f'> {left_f_name}')
                commands.append(' '.join(join_args))
                left_headers += right_headers
                join_header = f'{left_headers.pop(left_headers.index(left_attribute))}|{left_headers.pop(left_headers.index(right_attribute))}'
                left_headers.insert(0, join_header)
                joins.pop(i)

    sources.insert(0, Table(
        full_path=left_f_name,
        name='FINAL_JOIN',
        delimiter=',',
        headers=left_headers
    ))

    return commands


def compute_group_by_with_agg_command(targets: List[str], src_headers: List[str]) -> str:
    args = ['python3 ../group.py']
    args.append("-h -s ','")
    attributes_arg = ','.join([target
                               for target
                               in targets
                               if '(' not in target])
    fns_arg = ','.join([
        target
        for target
        in targets
        if '(' in target
    ]).lower()

    for i, header in enumerate(src_headers):
        attributes_arg = re.sub(fr'\b{header}\b', f'#{i + 1}',
                                attributes_arg, flags=re.IGNORECASE)
        fns_arg = re.sub(fr'\b{header}\b', f'#{i + 1}',
                         fns_arg, flags=re.IGNORECASE)

    args.append(f"-a '{attributes_arg}'")
    args.append(f"-f '{fns_arg}'")

    return ' '.join(args)


def compute_group_by_command(targets: List[str], src_headers: List[str]) -> str:
    args = ["sort -V -u -t ','"]
    fields = ' '.join(targets)
    for i, header in enumerate(src_headers):
        fields = re.sub(fr'\b{header}\b', f'-k {i + 1},{i + 1}',
                        fields, flags=re.IGNORECASE)
    args.append(fields)
    return ' '.join(args)


def compute_agg_command(targets: List[str], src_headers: List[str]) -> str:
    args = ['python3 ../agg.py']
    args.append('-h -s ","')

    agg_fn_pairs: Tuple[str, str] = [
        re.findall(r'(.+)\((.+)\)', target)
        for target
        in targets
    ]

    fn_arg_list: List[str] = []
    attribute_arg_list: List[str] = []

    for pair in agg_fn_pairs:
        fn_arg_list.append(pair[0].lower())
        attribute_arg_list.append(pair[1].upper())

    fns_arg = ','.join(fn_arg_list)
    attributes_arg = ','.join(attribute_arg_list)

    for i, header in enumerate(src_headers):
        attributes_arg = re.sub(fr'\b{header}\b', f'#{i + 1}',
                                attributes_arg, flags=re.IGNORECASE)

    args.append(f"-a '{attributes_arg}'")
    args.append(f"-f '{fns_arg}'")

    return ' '.join(args)


def compute_order_by_command(targets: List[str], src_headers: List[str]) -> str:
    args = [f'sort -V -t ","']
    fields = ' '.join(targets)
    for i, header in enumerate(src_headers):
        fields = re.sub(fr'\b{header}\b', f'-k {i + 1},{i + 1}',
                        fields, flags=re.IGNORECASE)
    args.append(fields)
    return ' '.join(args)


def compute_limit_command(limit: int, offset: int) -> str:
    pipe: List[str] = []
    range_max = limit + offset
    pipe.append('head -n' + str(range_max))
    if offset > 0:
        pipe.append('tail -n+' + str(offset + 1))
    return ' | '.join(pipe)


def map_table_attributes(select_stmt_ctx: SQLiteParser.Select_stmtContext, sources: List[Table]) -> List[Attribute]:
    select_core_ctx = select_stmt_ctx.select_core(0)
    result_column_ctx_list = select_core_ctx.result_column()
    join_clause_ctx = select_core_ctx.from_clause().join_clause()
    where_clause_ctx = select_core_ctx.where_clause()
    group_by_clause_ctx = select_core_ctx.group_by_clause()
    order_by_stmt_ctx = select_stmt_ctx.order_by_stmt()

    attributes: List[Attribute] = []

    for result_column_ctx in result_column_ctx_list:
        table: Table = find_target_source(result_column_ctx, sources)
        alias = result_column_ctx.column_alias().getText(
        ).upper() if result_column_ctx.column_alias() else None
        if result_column_ctx.STAR():
            if table:
                for header in table.headers:
                    attributes.append(Attribute(
                        header, alias, table, AttributeType.SELECT))
            else:
                for source in sources:
                    for header in source.headers:
                        attributes.append(Attribute(
                            header, alias, source, AttributeType.SELECT))
        elif result_column_ctx.expr().column_name():
            attributes.append(Attribute(result_column_ctx.expr().column_name().getText().upper(), alias,
                                        table, AttributeType.SELECT))
        else:
            attributes.append(Attribute(result_column_ctx.expr().getText().upper(), alias,
                                        table, AttributeType.AGG))

    def recursive_attribute_append(ctx, attribute_type):
        for inner_expr_ctx in in_order_traversal(ctx, SQLiteParser.ExprContext):
            if inner_expr_ctx.column_name():
                alias = inner_expr_ctx.column_name().getText().upper()
                col_name = next((attr.name for attr in attributes if attr.alias ==
                                 alias), alias)
                source = find_target_source(inner_expr_ctx, sources)
                attributes.append(
                    Attribute(col_name, alias, source, attribute_type))
            else:
                recursive_attribute_append(inner_expr_ctx, attribute_type)

    if join_clause_ctx:
        recursive_attribute_append(join_clause_ctx, AttributeType.JOIN)

    if where_clause_ctx:
        recursive_attribute_append(where_clause_ctx, AttributeType.WHERE)

    if group_by_clause_ctx:
        recursive_attribute_append(
            group_by_clause_ctx, AttributeType.GROUP_BY)

    if order_by_stmt_ctx:
        recursive_attribute_append(
            order_by_stmt_ctx, AttributeType.ORDER_BY)

    return attributes


def extract_limit_offset(ctx: SQLiteParser.Limit_stmtContext) -> Tuple[int, int]:
    limit = int(ctx.expr(0).getText())
    offset = int(ctx.expr(1).getText()) if ctx.expr(1) else 0
    return [limit, offset]


def extract_conditions(ctx: SQLiteParser.Where_clauseContext) -> str:
    return ' '.join([token.getText()
                     for token
                     in in_order_traversal(ctx, TerminalNodeImpl)
                     if token.getText() != 'WHERE']).strip()


def extract_joins(ctx: SQLiteParser.Select_coreContext, sources: List[Table]) -> List[Join]:
    joins: List[Join] = []
    from_clause_ctx = ctx.from_clause()
    join = Join()
    if from_clause_ctx.join_clause():
        join_clause_ctx = from_clause_ctx.join_clause()
        join.left = join_clause_ctx.table_or_subquery().getText()
        for _, join_condition_ctx in enumerate(join_clause_ctx.join_condition()):
            join.right = join_condition_ctx.table_or_subquery().getText().upper()

            if join_condition_ctx.join_operator().LEFT():
                join.join_type = JoinType.LEFT
            elif join_condition_ctx.join_operator().RIGHT():
                join.join_type = JoinType.RIGHT
            else:
                join.join_type = JoinType.INNER

            if join_condition_ctx.join_constraint():
                attribute_0 = join_condition_ctx.join_constraint().expr().expr(0)
                attribute_1 = join_condition_ctx.join_constraint().expr().expr(1)

                table_0 = (attribute_0.table_name().getText() if attribute_0.table_name(
                ) else find_target_source(attribute_0, sources).name).upper()

                if table_0 == join.left.upper():
                    join.left_attribute = attribute_0.column_name().getText().upper()
                    join.right_attribute = attribute_1.column_name().getText().upper()
                elif table_0 == join.right.upper():
                    join.left_attribute = attribute_1.column_name().getText().upper()
                    join.right_attribute = attribute_0.column_name().getText().upper()
                joins.append(join)
                join = Join(left=join.right)

    elif len(sources) > 1:
        join.left = from_clause_ctx.table_or_subquery(
            0).table_name().getText().upper()
        for table_or_subquery_ctx in from_clause_ctx.table_or_subquery()[1:]:
            join.join_type = JoinType.INNER
            join.right = table_or_subquery_ctx.table_name().getText().upper()
            joins.append(join)
            join = Join(left=join.right)

    if any(not join.left_attribute for join in joins):
        eq_conditions = []

        uncertains = [join for join in joins if not join.left_attribute]

        def find_eq(ctx: SQLiteParser.ExprContext):
            if ctx.EQ():
                eq_conditions.append([ctx.expr(0), ctx.expr(1)])
            else:
                for inner_expr_ctx in ctx.expr():
                    find_eq(inner_expr_ctx)

        for eq_condition in eq_conditions:
            source_0 = find_target_source(eq_condition[0], sources)
            source_1 = find_target_source(eq_condition[1], sources)
            if source_0 and source_1:
                attribute_0 = eq_condition[0].column_name().getText().upper()
                attribute_1 = eq_condition[1].column_name().getText().upper()
                for u, join in enumerate(uncertains):
                    if source_0.name == join.left and source_1.name == join.right:
                        join.left_attribute = attribute_0
                        join.right_attribute = attribute_1
                        uncertains.pop(u)
                        break
                    elif source_0.name == join.right and source_1.name == join.left:
                        join.left_attribute = attribute_1
                        join.right_attribute = attribute_0
                        uncertains.pop(u)
                        break
    return joins


def find_target_source(table_ref_ctx: any, sources: List[Table]) -> Table:
    if len(sources) == 1:
        return sources[0]
    if table_ref_ctx.table_name():
        return find_table_by_name(table_ref_ctx.table_name().getText(), sources)
    elif hasattr(table_ref_ctx, 'table_alias') and table_ref_ctx.table_alias():
        return find_table_by_alias(table_ref_ctx.table_alias(), sources)
    elif hasattr(table_ref_ctx, 'column_name') and table_ref_ctx.column_name():
        return next((source for source in sources if table_ref_ctx.column_name().getText().upper() in source.headers), None)
    elif table_ref_ctx.expr():
        return find_target_source(table_ref_ctx.expr(), sources)
    # elif table_ref_ctx.expr():
    #     column_name_ctx = table_ref_ctx.expr().column_name()
    #     if table_ref_ctx.expr().function_name():
    #         column_name_ctx = table_ref_ctx.expr().expr().column_name()
    #     if column_name_ctx:
    #         return next((source for source in sources if column_name_ctx.getText().upper() in source.headers), None)
    return None


def find_all_attribute_names_for_type(attributes: List[Attribute], attribute_type: AttributeType) -> List[Attribute]:
    return [
        attribute
        for attribute
        in attributes
        if attribute.association == attribute_type
    ]
