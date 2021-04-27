from utils.db import find_table_by_name, in_order_traversal
from typing import Dict, List, Tuple
from validators.antlr4.SQLiteParser import SQLiteParser
from utils.valid import parse_context
from utils.db import find_table_by_alias, find_target_source
from models.Attribute import Attribute, AttributeType
from models.Join import Join, JoinType
from models.Table import Table
from antlr4.tree.Tree import TerminalNodeImpl
from UnixSql import UnixAgg, UnixWhere, UnixGroupBy, UnixJoin, UnixOrderBy
import re
from copy import deepcopy
from os import path

SELECT_PATH = path.join(path.dirname(__file__), 'select.py')
GROUP_PATH = path.join(path.dirname(__file__), 'group.py')
AGG_PATH = path.join(path.dirname(__file__), 'agg.py')

STRIP_FN_AND_TABLE_REGEX = r'\b(SUM|COUNT|AVG|MIN|MAX)\((.*\.)?|\)'
STRIP_FN_REGEX = r'\b(SUM|COUNT|AVG|MIN|MAX)\(|\)'


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
                    command = compute_sql_pipline(
                        select_stmt_ctx, self.schema)
                commands.append(command)
        return ' & '.join(commands)


def compute_sql_pipline(select_stmt_ctx: SQLiteParser.Select_stmtContext, schema: Dict[str, Table]) -> str:
    commands: List[str] = []
    select_core_ctx = select_stmt_ctx.select_core(0)
    sources = list(schema.values())
    attributes: List[Attribute] = map_table_attributes(
        select_stmt_ctx, sources)
    joins = UnixJoin.extract_joins(select_core_ctx, sources)

    for attribute in [attribute for attribute in attributes if attribute.association == AttributeType.WHERE]:
        if attribute.name in [join.left_attribute for join in joins] + [join.right_attribute for join in joins]:
            join_attribute = deepcopy(attribute)
            join_attribute.association = AttributeType.JOIN
            attributes.append(join_attribute)

    results_headers = []

    commands.append(compute_header_command(attributes))

    for source in sources:
        related_attributes = [
            attribute for attribute in attributes if attribute.source.name == source.name]

        # Project all involved attributes

        initial_projections = sorted((
            projection
            for projection
            in dict.fromkeys([
                re.sub(
                    STRIP_FN_AND_TABLE_REGEX, '', attribute.name, flags=re.IGNORECASE)
                for attribute
                in related_attributes
                if attribute.association != AttributeType.WHERE
            ])), key=(lambda projection: source.headers.index(projection)))

        if any(attr.association == AttributeType.WHERE for attr in related_attributes):
            condition = UnixWhere.extract_conditions(
                select_core_ctx.where_clause(), sources, source.name)
            if condition:
                commands.append(UnixWhere.compute_select_where_command(
                    condition, initial_projections, source))
            else:
                commands.append(compute_project_command(
                    initial_projections, source, True))
        else:
            commands.append(compute_project_command(
                initial_projections, source, True))

        # Realign order of table headers
        source.headers = initial_projections
        if joins:
            commands[-1] += f' > /tmp/term_sql_{source.name}'

    attributes = [
        attribute for attribute in attributes if attribute.association != AttributeType.WHERE]

    if joins:
        commands += compute_join_commands(joins, sources)
        join_attributes_abbr = [
            (attribute.source.name, attribute.name) for attribute in attributes if attribute.association == AttributeType.JOIN]
        attributes = [
            attribute for attribute in attributes if attribute.association != AttributeType.JOIN]
        for attribute in attributes:
            if attribute.association == AttributeType.AGG:
                attribute.name = re.sub(
                    r'\(', f'({attribute.source.name}.', attribute.name)
            elif (attribute.source.name, attribute.name) in join_attributes_abbr:
                for join in joins:
                    if attribute.name in [join.left_attribute, join.right_attribute]:
                        attribute.name = f'JOIN.{join.left_attribute}.{join.right_attribute}'
            else:
                attribute.name = f'{attribute.source.name}.{attribute.name}'

        projections = sorted((
            projection
            for projection
            in dict.fromkeys([
                re.sub(
                    STRIP_FN_REGEX, '', attribute.name, flags=re.IGNORECASE)
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
            commands[-1] += f' | {UnixGroupBy.compute_group_by_with_agg_command(groups + aggregates, results_headers)} | tail -n+2'
        elif groups:
            commands[-1] += f' | {UnixGroupBy.compute_group_by_command(groups, results_headers)}'
        elif aggregates:
            commands[-1] += f' | {UnixAgg.compute_agg_command(aggregates, results_headers)}'

        results_headers = groups + aggregates

    sorts = [
        # f'{attribute.source.name}.{attribute.name}'
        attribute.name
        for attribute
        in attributes
        if attribute.association == AttributeType.ORDER_BY
    ]
    if sorts:
        commands[-1] += f' | {UnixOrderBy.compute_order_by_command(sorts, results_headers)}'

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


def compute_join_commands(joins: List[Join], sources: List[Table]):
    commands = []
    joined_sources: List[str] = []
    left_headers: List[str] = []
    left_f_name = None
    join_counter = len(joins)

    while join_counter:
        for i in range(join_counter):
            join = joins[i]
            if not joined_sources or join.left in joined_sources:
                left_source = None
                right_source = None

                for source in sources:

                    if left_source and right_source:
                        break
                    if source.name == join.left:
                        left_source = source
                    if source.name == join.right:
                        right_source = source
                left_f_name = left_f_name if left_f_name else f'/tmp/term_sql_{left_source.name}'
                right_f_name = f'/tmp/term_sql_{right_source.name}'
                left_headers = left_headers if left_headers else [
                    f'{left_source.name}.{header}' for header in left_source.headers]
                right_headers = [
                    f'{right_source.name}.{header}' for header in right_source.headers]

                left_attribute = f'{left_source.name}.{join.left_attribute}'
                right_attribute = f'{right_source.name}.{join.right_attribute}'

                commands.append(
                    f'{UnixOrderBy.compute_order_by_command([left_attribute], left_headers)} -o {left_f_name} {left_f_name}')
                commands.append(
                    f'{UnixOrderBy.compute_order_by_command([right_attribute], right_headers)} -o {right_f_name} {right_f_name}')
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
                left_headers.pop(left_headers.index(left_attribute))
                left_headers.pop(left_headers.index(right_attribute))
                join_header = 'JOIN.' + \
                    re.sub(r'.*\.', '', left_attribute) + '.' + \
                    re.sub(r'.*\.', '', right_attribute)
                # join_header = f'{left_headers.pop(left_headers.index(left_attribute))}|{left_headers.pop(left_headers.index(right_attribute))}'
                left_headers.insert(0, join_header)
                join_counter -= 1

    sources.insert(0, Table(
        full_path=left_f_name,
        name='FINAL_JOIN',
        delimiter=',',
        headers=left_headers
    ))

    return commands


def compute_limit_command(limit: int, offset: int) -> str:
    pipe: List[str] = []
    range_max = limit + offset
    pipe.append('head -n' + str(range_max))
    if offset > 0:
        pipe.append('tail -n+' + str(offset + 1))
    return ' | '.join(pipe)


def compute_header_command(attributes: List[Attribute]) -> str:
    return 'echo "' + ','.join([
        attribute.name for attribute in attributes
        if attribute.association in [AttributeType.SELECT, AttributeType.AGG]]) + '"'


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
            agg_attr = re.sub(
                r'\(.*\.', '(', result_column_ctx.expr().getText().upper())
            attributes.append(Attribute(agg_attr, alias,
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


def find_all_attribute_names_for_type(attributes: List[Attribute], attribute_type: AttributeType) -> List[Attribute]:
    return [
        attribute
        for attribute
        in attributes
        if attribute.association == attribute_type
    ]
