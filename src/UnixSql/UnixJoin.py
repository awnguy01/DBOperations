from copy import deepcopy
import re
from src.sql_executor import STRIP_FN_REGEX
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
                    (f'{left_source.name}.{header[0]}', f'{left_source.name}.{header[1]}') for header in left_source.headers]
                right_headers = [
                    (f'{right_source.name}.{header[0]}', f'{right_source.name}.{header[1]}') for header in right_source.headers]

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
                    f'-1{[header[0] for header in left_headers].index(left_attribute) + 1}')
                join_args.append(
                    f'-2{[header[0] for header in right_headers].index(right_attribute) + 1}')
                join_args.append(f'{left_f_name}')
                join_args.append(f'{right_f_name}')
                left_f_name += f'_{right_source.name}'
                if len(joins) > 1:
                    join_args.append(f'> {left_f_name}')
                commands.append(' '.join(join_args))
                left_headers += right_headers
                left_headers.pop(
                    [header[0] for header in left_headers].index(left_attribute))
                left_headers.pop(
                    [header[0] for header in left_headers].index(right_attribute))

                join_header = (f'JOIN.{left_attribute}.{right_attribute}',
                               f'JOIN.{left_attribute}.{right_attribute}')
                # join_header = f'{left_source.name}.' + \
                #     re.sub(r'.*\.', '', left_attribute) + ',' + f'{right_source.name}.' + \
                #     re.sub(r'.*\.', '', right_attribute) + ''
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

    join_order: List[str] = list(dict.fromkeys([header for header in [re.sub(
        r'\bJOIN.*|\..*', '', header[0]) for header in join_source.headers] if header]))

    join_pairs = [(join.left, join.right) for join in joins]
    join_sequence = []

    for source_name in join_order:
        for i in range(len(join_pairs) - 1, -1, -1):
            if source_name in join_pairs[i]:
                first, second = ['', '']
                if join_pairs[i][0] == source_name:
                    first, second = join_pairs.pop(i)
                elif join_pairs[i][1] == source_name:
                    second, first = join_pairs.pop(i)
                join_sequence.append(first)
                join_sequence.append(second)

    join_source_refs = [header[1] for header in join_source.headers]
    # print('REFSSSSS')
    # print(join_source_refs)

    # print('ORDERED JOIN PAIRS')
    # print(join_sequence)

    tmp_attributes = [deepcopy(attribute) for attribute in attributes]
    # right_joined_attributes = [
    #     (join.right, join.right_attribute) for join in joins]
    sorted_distinct_attributes = sorted(dict.fromkeys(
        [(attribute.source.name, re.sub(STRIP_FN_REGEX, '', attribute.name)) for attribute in tmp_attributes]), key=lambda pair: (join_order.index(pair[0]), int(pair[1][1:])))
    # sorted_distinct_attributes = list(filter(
    #     lambda pair: pair not in right_joined_attributes, sorted_distinct_attributes))

    tmp_sorted_attributes = []

    for i in range(len(sorted_distinct_attributes)):
        attribute = sorted_distinct_attributes.pop()
        if f'{attribute[0]}.{attribute[1]}' in join_source_refs:
            tmp_sorted_attributes.append(attribute)
        elif join_sequence[0] == attribute[0]:
            tmp_sorted_attributes.append(attribute)
            join_sequence.pop()

    tmp_sorted_attributes.reverse()
    sorted_distinct_attributes = tmp_sorted_attributes

    # print('THE HEADERS OF THE JOIN')
    # print(join_source.headers)
    # print(len(join_source.headers))
    print('SORTED ATTRIBUTES')
    print(sorted_distinct_attributes)
    # print('ALL THE TMP ATTRIBUTES')
    # print([attribute.name for attribute in tmp_attributes])

    for attribute in tmp_attributes:
        if attribute.association != AttributeType.JOIN:
            # attribute.name = f'JOIN.#{sorted_distinct_attributes.index((attribute.source.name, re.sub(STRIP_FN_REGEX, "", attribute.name))) + 1}'
            joined_idx = sorted_distinct_attributes.index(
                (attribute.source.name, re.sub(STRIP_FN_REGEX, '', attribute.name)))
            attribute.name = re.sub(
                r'(\w*\.)?#\d+', f'JOIN.#{joined_idx + 1}', attribute.name)
            attribute.source = join_source

    join_source.headers = [(f'JOIN.#{i + 1}', f'JOIN.#{i + 1}')
                           for i in range(len(join_source.headers))]

    print('POST RELABEL')
    print([(attribute.source.name, attribute.name) for attribute in tmp_attributes])

    return tmp_attributes

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

    return tmp_attributes


def filter_join_attributes(attributes: List[Attribute]) -> List[Attribute]:
    return [attribute for attribute in attributes if attribute.association != AttributeType.JOIN]
