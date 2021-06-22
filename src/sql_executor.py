from typing import Dict, List, Tuple
from validators.antlr4.SQLiteParser import SQLiteParser
from utils.valid import parse_context
from utils.db import find_target_source, in_order_traversal
from utils.optimizer import reduce_join_intermediates
from models.Attribute import Attribute, AttributeType
from models.Join import Join
from models.Table import Table
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
        """
        Function parses SQL statements as input and outputs the UNIX pipeline equivalent
        """
        # Deep copy the directory schema information from memory to protect from internal modifications
        self.schema = deepcopy(schema)
        commands = []

        # Generate a pipeline for each SQL statement separated by a semicolon
        sql_stmt_list_ctxs = parse_context(sql).sql_stmt_list()
        for sql_stmt_list_ctx in sql_stmt_list_ctxs:
            for sql_stmt_ctx in sql_stmt_list_ctx.sql_stmt():
                command = ''
                select_stmt_ctx = sql_stmt_ctx.select_stmt()
                if select_stmt_ctx:
                    # Only SQL SELECT statements supported for UNIX pipeline interpretation
                    command = compute_sql_pipeline(
                        select_stmt_ctx, self.schema)
                commands.append(command)
        return ' & '.join(commands)


def compute_sql_pipeline(select_stmt_ctx: SQLiteParser.Select_stmtContext, schema: Dict[str, Table]) -> str:
    """
    Coordinator function using various modular functions that each parse different clauses of the SQL statement
    to produce different parts of the UNIX pipeline
    """

    commands: List[str] = []
    select_core_ctx = select_stmt_ctx.select_core(0)

    # List of all the available tables in the schema
    sources = list(schema.values())

    # Track which clause types apply to which source tables (i.e. a WHERE condition that applies to table 1, etc.)
    attributes: List[Attribute] = map_table_attributes(
        select_stmt_ctx, sources)

    # Track all potential joins in the SQL statement, the presence of which drastically affects the path of logic
    joins: List[Join] = UnixJoin.extract_joins(select_core_ctx, sources)

    # Naive solution for deferring selections if a condition is applied to more than one table
    defer_select = len(dict.fromkeys(
        [attribute.source.name for attribute in attributes if attribute.association == AttributeType.WHERE])) > 1

    # Map associating each condition in the SQL statement to the table it applies to
    cond_map: Dict[str, str] = {}

    if any(attr.association == AttributeType.WHERE for attr in attributes):
        if defer_select:
            # If selection is deferred to after the join, associate the condition to an arbitrary table name called JOIN
            cond_map['JOIN'] = UnixSelect.extract_conditions(
                select_core_ctx.where_clause(), sources, [source.name for source in sources])
            for source in sources:
                for i, header in enumerate(source.headers):
                    # Replace all header names in the condition with their field references to simplify future referencing
                    cond_map['JOIN'] = re.sub(
                        fr'\b{header}\b', f'#{i + 1}', cond_map['JOIN'])
                if source.alias:
                    # If a table alias is used in the condition, replace it with the true table name to simplify future referencing
                    cond_map['JOIN'] = re.sub(
                        fr'\b{source.alias}.', f'{source.name}.', cond_map['JOIN'])
        else:
            for source in sources:
                # Associate each selection condition to the table it applies to
                cond_map[source.name] = UnixSelect.extract_conditions(
                    select_core_ctx.where_clause(), sources, [source.name])
                for i, header in enumerate(source.headers):
                    if header[0] != '#':
                        # Replace all header names in the condition with their field references to simplify future referencing
                        cond_map[source.name] = re.sub(
                            fr'\b{header}\b', f'#{i + 1}', cond_map[source.name])
                if source.alias:
                    # If a table alias is used in the condition, replace it with the true table name to simplify future referencing
                    cond_map[source.name] = re.sub(
                        fr'\b{source.alias}.', f'{source.name}.', cond_map[source.name])

    commands.append(compute_header_command(attributes))

    for attribute in attributes:
        col_name = re.sub(STRIP_FN_AND_TABLE_REGEX, '', attribute.name)
        if col_name[0] != '#':
            # Replace all header names in the attributes list with their field references to simplify future referencing
            attribute.name = re.sub(
                col_name, f'#{attribute.source.headers.index(col_name) + 1}', attribute.name)

    for source in sources:
        # At this point, all parts of the SQL statement should only be using field references
        # Transform the source table headers into numbered field references as well to simplify future referencing
        source.headers = [f'#{i + 1}' for i in range(len(source.headers))]

    # Generate the applicable commands for the initial projections and selections (if not deferred) for each source table
    for source in sources:
        related_attributes = [
            attribute for attribute in attributes if attribute.source.name == source.name]

        projections = []

        if not defer_select and any(attr.association == AttributeType.WHERE for attr in related_attributes):
            # Use select.py if selections are not deferred and there are conditions present in the SQL statement
            projections = UnixProject.find_all_projections_for_source(
                UnixSelect.filter_select_attributes(attributes), source)
            commands.append(UnixSelect.compute_select_command(
                cond_map[source.name], projections, source, False))
        else:
            # Only compute projections first if there are no conditions or the selection is deferred
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

    # Filter out attributes of type WHERE if previously handled
    attributes = [
        attribute for attribute in attributes if attribute.association != AttributeType.WHERE or defer_select]

    if joins:
        # Generate and append commands for joins
        commands += UnixJoin.compute_join_commands(joins, sources)
        # Filter out the JOIN attributes from the attributes list
        attributes = UnixJoin.filter_join_attributes(attributes)
        # Realign attribute field references to joined table columns
        attributes = UnixJoin.relabel_post_join_attributes(
            attributes, joins, sources[0])
        # Project remaining relevant columns
        projections = UnixProject.find_all_projections_for_source(
            attributes, sources[0])
        if len(projections) < len(sources[0].headers):
            commands[-1] += f' | {UnixProject.compute_project_command(projections, sources[0], False)}'
        sources[0].headers = projections
        sources = [sources[0]]

    if defer_select:
        # Compute selection if it was deferred until after the join
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

    # Apply grouping or aggregates if applicable
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

    # Generate and append sort command for ORDER BY
    sorts = [
        attribute.name
        for attribute
        in attributes
        if attribute.association == AttributeType.ORDER_BY
    ]
    if sorts:
        commands[-1] += f' | {UnixOrder.compute_order_by_command(sorts, sources[0].headers)}'

    # Generate and append head/tail commands for LIMIT and OFFSET
    if select_stmt_ctx.limit_stmt():
        limit, offset = extract_limit_offset(select_stmt_ctx.limit_stmt())
        commands[-1] += f' | {compute_limit_command(limit, offset)}'

    # Apply any optimizations
    # reduce_join_intermediates(commands, len(joins))

    return ' ; '.join(commands)


def compute_limit_command(limit: int, offset: int) -> str:
    """
    Apply head command if SQL statement contains LIMIT. 
    If OFFSET is present, append tail to trim extraneous beginning rows.
    """
    pipe: List[str] = []
    range_max = limit + offset
    pipe.append('head -n' + str(range_max))
    if offset > 0:
        pipe.append('tail -n+' + str(offset + 1))
    return ' | '.join(pipe)


def compute_header_command(attributes: List[Attribute]) -> str:
    """
    Simple command to echo the header of the final result
    """
    return 'echo "' + ','.join([
        attribute.alias if attribute.alias else attribute.name for attribute in attributes
        if attribute.association in [AttributeType.SELECT, AttributeType.AGG]]) + '"'


def map_table_attributes(select_stmt_ctx: SQLiteParser.Select_stmtContext, sources: List[Table]) -> List[Attribute]:
    """
    Associate each column in the SQL statement with every clause and source table it applies to. 
    This is used to track which columns are still relevant and need to be projected after the 
    previous clause has been interpreted.
    """
    select_core_ctx = select_stmt_ctx.select_core(0)
    result_column_ctx_list = select_core_ctx.result_column()
    join_clause_ctx = select_core_ctx.from_clause().join_clause()
    where_clause_ctx = select_core_ctx.where_clause()
    group_by_clause_ctx = select_core_ctx.group_by_clause()
    order_by_stmt_ctx = select_stmt_ctx.order_by_stmt()

    attributes: List[Attribute] = []

    for result_column_ctx in result_column_ctx_list:
        # Map all of the SELECT attributes
        table: Table = find_target_source(result_column_ctx, sources)
        alias = re.sub(r'\'', '', result_column_ctx.column_alias().getText(
        ).upper()) if result_column_ctx.column_alias() else None
        if result_column_ctx.STAR():
            if table:
                # If wildcard selecting from a specific source table, add all columns from that table
                for header in table.headers:
                    attributes.append(Attribute(
                        header, alias, table, AttributeType.SELECT))
            else:
                # If wildcard selecting without specifying table, add all columns from all sources
                for source in sources:
                    for header in source.headers:
                        attributes.append(Attribute(
                            header, alias, source, AttributeType.SELECT))
        elif result_column_ctx.expr().column_name():
            # Add SELECT column attribute if column name is specified
            attributes.append(Attribute(result_column_ctx.expr().column_name().getText().upper(), alias,
                                        table, AttributeType.SELECT))
        elif result_column_ctx.expr().REF_FIELD():
            # Add SELECT column attribute if field reference is specified
            attributes.append(Attribute(result_column_ctx.expr(
            ).REF_FIELD().getText(), alias, table, AttributeType.SELECT))
        else:
            # Add AGG column attribute if column is specified in an aggregate function
            agg_attr = re.sub(
                r'\(.*\.', '(', result_column_ctx.expr().getText().upper())
            attributes.append(Attribute(agg_attr, alias,
                                        table, AttributeType.AGG))

    def recursive_attribute_append(ctx, attribute_type):
        """
        Generalized recursive function to parse remaining clauses in SQL statement and
        associate the relevant columns
        """
        for inner_expr_ctx in in_order_traversal(ctx, SQLiteParser.ExprContext):
            if inner_expr_ctx.column_name() or inner_expr_ctx.REF_FIELD():
                # Base case to add the attribute if parsed token is a column name or field reference
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
                        # Add attribute as a JOIN if equijoin is found in the WHERE clause
                        recursive_attribute_append(
                            inner_expr_ctx, AttributeType.JOIN)
                        continue
                # Continue recursion if base case not reached
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
    """
    Simple parsing for the numbers used in the LIMIT and OFFSET clauses if applicable.
    """
    limit = int(ctx.expr(0).getText())
    offset = int(ctx.expr(1).getText()) if ctx.expr(1) else 0
    return [limit, offset]


def find_all_attribute_names_for_type(attributes: List[Attribute], attribute_type: AttributeType) -> List[Attribute]:
    """
    Convenience function for returning all attributes of a specified clause type
    """
    return [
        attribute
        for attribute
        in attributes
        if attribute.association == attribute_type
    ]
