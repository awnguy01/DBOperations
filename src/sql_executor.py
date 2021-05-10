from utils.db import find_table_by_name, in_order_traversal, transform_headers_to_refs
from typing import Dict, List, Tuple
from validators.antlr4.SQLiteParser import SQLiteParser
from utils.valid import parse_context
from utils.db import find_table_by_alias, find_target_source
from models.Attribute import Attribute, AttributeType
from models.Join import Join, JoinType
from models.Table import Table
from antlr4.tree.Tree import TerminalNodeImpl
from UnixSql import UnixAgg, UnixSelect, UnixGroupBy, UnixJoin, UnixOrder, UnixProject
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
                    command = compute_sql_pipeline(
                        select_stmt_ctx, self.schema)
                commands.append(command)
        return ' & '.join(commands)


def compute_sql_pipeline(select_stmt_ctx: SQLiteParser.Select_stmtContext, schema: Dict[str, Table]) -> str:
    commands: List[str] = []
    select_core_ctx = select_stmt_ctx.select_core(0)
    sources = list(schema.values())
    attributes: List[Attribute] = map_table_attributes(
        select_stmt_ctx, sources)

    joins: List[Join] = UnixJoin.extract_joins(select_core_ctx, sources)
    defer_select = len(dict.fromkeys(
        [attribute.source.name for attribute in attributes if attribute.association == AttributeType.WHERE])) > 1

    cond_map: Dict[str, str] = {}

    if any(attr.association == AttributeType.WHERE for attr in attributes):
        if defer_select:
            cond_map['JOIN'] = UnixSelect.extract_conditions(
                select_core_ctx.where_clause(), sources, [source.name for source in sources])
            for source in sources:
                for i, header in enumerate(source.headers):
                    cond_map['JOIN'] = re.sub(
                        fr'\b{header}\b', f'#{i + 1}', cond_map['JOIN'])
                if source.alias:
                    cond_map['JOIN'] = re.sub(
                        fr'\b{source.alias}.', f'{source.name}.', cond_map['JOIN'])
        else:
            for source in sources:
                cond_map[source.name] = UnixSelect.extract_conditions(
                    select_core_ctx.where_clause(), sources, [source.name])
                for i, header in enumerate(source.headers):
                    if header[0] != '#':
                        cond_map[source.name] = re.sub(
                            fr'\b{header}\b', f'#{i + 1}', cond_map[source.name])
                if source.alias:
                    cond_map[source.name] = re.sub(
                        fr'\b{source.alias}.', f'{source.name}.', cond_map[source.name])

    commands.append(compute_header_command(attributes))

    for attribute in attributes:
        col_name = re.sub(STRIP_FN_AND_TABLE_REGEX, '', attribute.name)
        if col_name[0] != '#':
            attribute.name = re.sub(
                col_name, f'#{attribute.source.headers.index(col_name) + 1}', attribute.name)

    for source in sources:
        source.headers = [f'#{i + 1}' for i in range(len(source.headers))]

    for source in sources:
        related_attributes = [
            attribute for attribute in attributes if attribute.source.name == source.name]

        projections = []

        if not defer_select and any(attr.association == AttributeType.WHERE for attr in related_attributes):
            projections = UnixProject.find_all_projections_for_source(
                UnixSelect.filter_select_attributes(attributes), source)
            commands.append(UnixSelect.compute_select_command(
                cond_map[source.name], projections, source, False))
        else:
            projections = UnixProject.find_all_projections_for_source(
                attributes, source)
            commands.append(UnixProject.compute_project_command(
                projections, source, True))

        # Realign order of table headers
        source.headers = [source.headers[idx] for idx in [
            int(projection[1:]) - 1 if projection[0] == '#' else source.headers.index(projection) for projection in projections]]
        # If more than one source, send to intermediate file
        if joins:
            commands[-1] += f' > /tmp/term_sql_{source.name}'

    attributes = [
        attribute for attribute in attributes if attribute.association != AttributeType.WHERE or defer_select]

    if joins:
        commands += UnixJoin.compute_join_commands(joins, sources)
        attributes = UnixJoin.filter_join_attributes(attributes)
        attributes = UnixJoin.relabel_post_join_attributes(
            attributes, joins, sources[0])
        projections = UnixProject.find_all_projections_for_source(
            attributes, sources[0])
        if len(projections) < len(sources[0].headers):
            commands[-1] += f' | {UnixProject.compute_project_command(projections, sources[0], False)}'
        sources[0].headers = projections
        sources = [sources[0]]

    if defer_select:
        attributes = UnixSelect.filter_select_attributes(attributes)
        projections = UnixProject.find_all_projections_for_source(
            attributes, sources[0])
        stdin_select = len(joins) <= 1
        select_command = UnixSelect.compute_select_command(
            cond_map[sources[0].name], projections, sources[0], stdin_select)
        if stdin_select:
            commands[-1] += f' | {select_command}'
        else:
            commands.append(select_command)

        sources[0].headers = projections

    groups = find_all_attribute_names_for_type(
        attributes, AttributeType.GROUP_BY)
    aggregates = find_all_attribute_names_for_type(
        attributes, AttributeType.AGG)

    if groups or aggregates:
        if groups and aggregates:
            commands[-1] += f' | {UnixGroupBy.compute_group_by_with_agg_command(groups + aggregates, sources[0].headers)} | tail -n+2'
        elif groups:
            commands[-1] += f' | {UnixGroupBy.compute_group_by_command(groups, sources[0].headers)}'
        elif aggregates:
            commands[-1] += f' | {UnixAgg.compute_agg_command(aggregates, sources[0].headers)}'

        sources[0].headers = groups + aggregates

    sorts = [
        attribute.name
        for attribute
        in attributes
        if attribute.association == AttributeType.ORDER_BY
    ]
    if sorts:
        commands[-1] += f' | {UnixOrder.compute_order_by_command(sorts, sources[0].headers)}'

    if select_stmt_ctx.limit_stmt():
        limit, offset = extract_limit_offset(select_stmt_ctx.limit_stmt())
        commands[-1] += f' | {compute_limit_command(limit, offset)}'
    return ' ; '.join(commands)


def compute_limit_command(limit: int, offset: int) -> str:
    pipe: List[str] = []
    range_max = limit + offset
    pipe.append('head -n' + str(range_max))
    if offset > 0:
        pipe.append('tail -n+' + str(offset + 1))
    return ' | '.join(pipe)


def compute_header_command(attributes: List[Attribute]) -> str:
    return 'echo "' + ','.join([
        attribute.alias if attribute.alias else attribute.name for attribute in attributes
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
        alias = re.sub(r'\'', '', result_column_ctx.column_alias().getText(
        ).upper()) if result_column_ctx.column_alias() else None
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
        elif result_column_ctx.expr().REF_FIELD():
            attributes.append(Attribute(result_column_ctx.expr(
            ).REF_FIELD().getText(), alias, table, AttributeType.SELECT))
        else:
            agg_attr = re.sub(
                r'\(.*\.', '(', result_column_ctx.expr().getText().upper())
            attributes.append(Attribute(agg_attr, alias,
                                        table, AttributeType.AGG))

    def recursive_attribute_append(ctx, attribute_type):
        for inner_expr_ctx in in_order_traversal(ctx, SQLiteParser.ExprContext):
            if inner_expr_ctx.column_name() or inner_expr_ctx.REF_FIELD():
                col_name = inner_expr_ctx.column_name().getText().upper(
                ) if inner_expr_ctx.column_name() else inner_expr_ctx.REF_FIELD().getText()
                alias = next((attr.alias for attr in attributes if attr.name ==
                              col_name), col_name)
                source = find_target_source(inner_expr_ctx, sources)
                attributes.append(
                    Attribute(col_name, alias, source, attribute_type))
            else:
                if attribute_type == AttributeType.WHERE and inner_expr_ctx.EQ():
                    if all(expr.column_name() for expr in inner_expr_ctx.expr()):
                        recursive_attribute_append(
                            inner_expr_ctx, AttributeType.JOIN)
                        continue
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
