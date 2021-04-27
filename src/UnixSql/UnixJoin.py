from copy import deepcopy
import re
from typing import List
from validators.antlr4.SQLiteParser import SQLiteParser
from models.Join import Join, JoinType
from utils.db import find_target_source
from models.Attribute import Attribute, AttributeType
from models.Table import Table
from UnixSql import UnixOrderBy


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
                
                join_header = f'({left_source.name}.' + \
                    re.sub(r'.*\.', '', left_attribute) + ',' + f'{right_source.name}.' + \
                    re.sub(r'.*\.', '', right_attribute) + ')'
                # join_header = f'{left_headers.pop(left_headers.index(left_attribute))}|{left_headers.pop(left_headers.index(right_attribute))}'
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
    if from_clause_ctx.join_clause():
        join_clause_ctx = from_clause_ctx.join_clause()
        join.left = join_clause_ctx.table_or_subquery().table_name().getText()
        for _, join_condition_ctx in enumerate(join_clause_ctx.join_condition()):
            join.right = join_condition_ctx.table_or_subquery().table_name().getText().upper()

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

        find_eq(ctx.where_clause().expr())

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

    # tmp_headers = [header for header in join_source.headers]
    # for source in joined_sources:
    #     for i, source_header in enumerate(source.headers):
    #         tmp_headers = [re.sub(rf'({source.name}\.){source_header}',
    #                               f'\1#{i + 1}', header) for header in tmp_headers]

    # print(tmp)
    return tmp_attributes


def filter_join_attributes(attributes: List[Attribute]) -> List[Attribute]:
    return [attribute for attribute in attributes if attribute.association != AttributeType.JOIN]
