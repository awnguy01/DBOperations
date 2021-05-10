from copy import deepcopy
import re
from typing import List, Tuple
from validators.antlr4.SQLiteParser import SQLiteParser
from models.Join import Join, JoinType
from utils.db import find_target_source
from models.Attribute import Attribute, AttributeType
from models.Table import Table
from UnixSql import UnixOrder


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

                join_args: List[str] = []
                left_attribute = ''
                right_attribute = ''

                if join.join_type == JoinType.CROSS:
                    join_args.append('join -t ","')
                    join_args.append(
                        f'-j {max(len(left_headers), len(right_headers)) + 1}')
                else:
                    left_attribute = f'{left_source.name}.{join.left_attribute}'
                    right_attribute = f'{right_source.name}.{join.right_attribute}'

                    commands.append(
                        f'{UnixOrder.compute_order_by_command([left_attribute], left_headers)} -o {left_f_name} {left_f_name}')
                    commands.append(
                        f'{UnixOrder.compute_order_by_command([right_attribute], right_headers)} -o {right_f_name} {right_f_name}')
                    join_args.append('join -t ","')

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
                if join.join_type == JoinType.CROSS:
                    commands[-1] += ' | cut -c 2-'
                left_headers += right_headers

                if left_attribute and right_attribute:
                    left_headers.pop(left_headers.index(left_attribute))
                    left_headers.pop(left_headers.index(right_attribute))

                    join_header = f'({left_source.name}.' + \
                        re.sub(r'.*\.', '', left_attribute) + ',' + f'{right_source.name}.' + \
                        re.sub(r'.*\.', '', right_attribute) + ')'
                    left_headers.insert(0, join_header)

                join_counter -= 1
    sources.insert(0, Table(
        full_path=left_f_name,
        name='JOIN',
        delimiter=',',
        headers=left_headers
    ))

    return commands


def extract_joins(ctx: SQLiteParser.Select_coreContext, sources: List[Table]) -> List[Join]:
    joins: List[Join] = []
    from_clause_ctx = ctx.from_clause()
    join = Join()

    eq_conditions: List[Tuple[SQLiteParser.ExprContext,
                              SQLiteParser.ExprContext]] = extract_join_conditions(ctx.where_clause())

    if from_clause_ctx.join_clause():
        join_clause_ctx = from_clause_ctx.join_clause()
        join.left = join_clause_ctx.table_or_subquery().table_name().getText()
        for _, join_condition_ctx in enumerate(join_clause_ctx.join_condition()):
            join.right = join_condition_ctx.table_or_subquery().table_name().getText().upper()

            if join_condition_ctx.join_operator().LEFT():
                join.join_type = JoinType.LEFT
            elif join_condition_ctx.join_operator().RIGHT():
                join.join_type = JoinType.RIGHT
            elif join_condition_ctx.join_constraint() or is_join_in_eq_conditions(join, sources, eq_conditions):
                join.join_type = JoinType.INNER
            else:
                join.join_type = JoinType.CROSS
                continue

            if join_condition_ctx.join_constraint():
                attribute_0, attribute_1 = join_condition_ctx.join_constraint().expr().expr()

                source_0 = find_target_source(attribute_0, sources)

                table_0 = (attribute_0.table_name().getText() if attribute_0.table_name(
                ) else source_0.name).upper()

                left_source = next(
                    (source for source in sources if source.name == join.left.upper()), None)
                right_source = next(
                    (source for source in sources if source.name == join.right.upper()), None)

                if table_0 in [left_source.name, left_source.alias]:
                    join.left_attribute = get_expr_col_ref(attribute_0)
                    join.right_attribute = get_expr_col_ref(attribute_1)
                elif table_0 == [right_source.name, right_source.alias]:
                    join.left_attribute = get_expr_col_ref(attribute_1)
                    join.right_attribute = get_expr_col_ref(attribute_0)
                joins.append(join)
                join = Join(left=join.right)

    elif len(sources) > 1:
        join.left = from_clause_ctx.table_or_subquery(
            0).table_name().getText().upper()
        for table_or_subquery_ctx in from_clause_ctx.table_or_subquery()[1:]:
            join.right = table_or_subquery_ctx.table_name().getText().upper()
            join.join_type = JoinType.INNER if is_join_in_eq_conditions(
                join, sources, eq_conditions) else JoinType.CROSS
            joins.append(join)
            join = Join(left=join.right)

    determine_missing_join_attributes(joins, sources, eq_conditions)
    transform_join_attributes_to_refs(joins, sources)
    return joins


def extract_join_conditions(ctx: SQLiteParser.Where_clauseContext) -> List[Tuple[SQLiteParser.ExprContext,
                                                                                 SQLiteParser.ExprContext]]:
    if not ctx:
        return []

    eq_conditions: List[Tuple[SQLiteParser.ExprContext,
                              SQLiteParser.ExprContext]] = []

    def find_eq(ctx: SQLiteParser.ExprContext):
        if ctx.EQ():
            eq_conditions.append([ctx.expr(0), ctx.expr(1)])
        else:
            for inner_expr_ctx in ctx.expr():
                find_eq(inner_expr_ctx)

    find_eq(ctx.expr())
    return eq_conditions


def is_join_in_eq_conditions(join: Join,
                             sources: List[Table],
                             eq_conditions: List[Tuple[SQLiteParser.ExprContext,
                                                       SQLiteParser.ExprContext]]):
    return any(all(join_table in [find_target_source(cond_expr, sources).name for cond_expr in cond] for join_table in [join.left, join.right]) for cond in eq_conditions)


def determine_missing_join_attributes(joins: List[Join],
                                      sources: List[Table],
                                      eq_conditions: List[Tuple[SQLiteParser.ExprContext,
                                                                SQLiteParser.ExprContext]]) -> None:
    uncertains = [join for join in joins if not join.join_type ==
                  JoinType.CROSS and not join.left_attribute]

    for eq_condition in eq_conditions:
        source_0 = find_target_source(eq_condition[0], sources)
        source_1 = find_target_source(eq_condition[1], sources)
        if source_0 and source_1:
            attribute_0 = get_expr_col_ref(eq_condition[0])
            attribute_1 = get_expr_col_ref(eq_condition[1])

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


def transform_join_attributes_to_refs(joins: List[Join], sources: List[Table]) -> None:
    for join in joins:
        if join.join_type != JoinType.CROSS:
            left_source = next(
                (source for source in sources if source.name == join.left), None)
            right_source = next(
                (source for source in sources if source.name == join.right), None)
            join.left_attribute = join.left_attribute if join.left_attribute[
                0] == '#' else f'#{left_source.headers.index(join.left_attribute) + 1}'
            join.right_attribute = join.right_attribute if join.right_attribute[
                0] == '#' else f'#{right_source.headers.index(join.right_attribute) + 1}'


def relabel_post_join_attributes(attributes: List[Attribute], joins: List[Join], join_source: Table) -> List[Attribute]:

    # joined_sources = ([join.left for join in joins] +
    #                   [join.right for join in joins])

    # tmp_attributes = [deepcopy(attribute) for attribute in attributes]
    # for attribute in tmp_attributes:
    #     if attribute.name[0] != '#':
    #         attribute.name =

    # for i, header in enumerate(join_source.headers):
    #     if 'JOIN' == header[0:4]:
    #         for attribute in attributes:

    join_order: List[str] = list(dict.fromkeys([header for header in [re.sub(
        r'\bJOIN.*|\..*', '', header) for header in join_source.headers] if header]))

    for source_name in join_order:
        related_attributes = [
            attribute for attribute in attributes if attribute.source.name == source_name]

    join_attributes_abbr = [
        (attribute.source.name, attribute.name) for attribute in attributes if attribute.association == AttributeType.JOIN]
    tmp_attributes = [deepcopy(attribute) for attribute in attributes]
    for attribute in tmp_attributes:
        if attribute.association == AttributeType.AGG:
            attribute.name = re.sub(
                r'\(', f'({attribute.source.name}.', attribute.name)
        elif (attribute.source.name, attribute.name) in join_attributes_abbr:
            for join in joins:
                if attribute.name in [join.left_attribute, join.right_attribute]:
                    attribute.name = f'JOIN.{join.left_attribute}.{join.right_attribute}'
        else:
            attribute.name = f'{attribute.source.name}.{attribute.name}'

        attribute.source = join_source

    return tmp_attributes


def filter_join_attributes(attributes: List[Attribute]) -> List[Attribute]:
    return [attribute for attribute in attributes if attribute.association != AttributeType.JOIN]


def get_expr_col_ref(expr_ctx: SQLiteParser.ExprContext):
    return (expr_ctx.column_name() if expr_ctx.column_name() else expr_ctx.REF_FIELD()).getText().upper()
