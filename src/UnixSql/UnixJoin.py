from copy import deepcopy
from os import error
import re
from typing import List, Tuple
from validators.antlr4.SQLiteParser import SQLiteParser
from models.Join import Join, JoinType
from utils.db import find_target_source
from models.Attribute import Attribute, AttributeType
from models.Table import Table
from UnixSql import UnixOrder


def compute_join_commands(joins: List[Join], sources: List[Table]):
    """
    Modular function for translating any JOIN clauses in the SQL statement into UNIX commands
    """
    commands = []
    # Track the source tables that have already been joined
    joined_sources: List[str] = []
    # Track the running headers of the final joined result
    left_headers: List[str] = []
    # Track the current file name of the left hand side of the join
    left_f_name = None
    # Track the number of remaining joins that need to occur
    join_counter = len(joins)

    while join_counter:
        for i in range(join_counter):
            join = joins[i]
            if not joined_sources or join.left in joined_sources:
                # Analyze Join condition if this is the first or if the left hand side of the Join condition is already part of the joined result
                left_source = None
                right_source = None

                for source in sources:
                    # Search for the source tables referenced in the left and right properties of the Join condition
                    if left_source and right_source:
                        break
                    if source.name == join.left:
                        left_source = source
                    if source.name == join.right:
                        right_source = source
                # Read left hand side of the join from the intermediate temporary file
                # If a join has already occurred, this becomes the last right-hand intermediate file
                left_f_name = left_f_name if left_f_name else f'/tmp/term_sql_{left_source.name}'
                # Read right hand side of the join from the intermediate temporary file
                right_f_name = f'/tmp/term_sql_{right_source.name}'
                # Get column references for left-hand side table
                # If a join has already occurred, these are the columns for the current join result
                left_headers = left_headers if left_headers else [
                    f'{left_source.name}.{header}' for header in left_source.headers]
                # Get column references for right-hand side table
                right_headers = [
                    f'{right_source.name}.{header}' for header in right_source.headers]

                join_args: List[str] = []
                left_attribute = ''
                right_attribute = ''

                if join.join_type == JoinType.CROSS:
                    # If this is a cartesian product, append a simple join command with a -j argument greater than the max number of headers
                    # from either the left or right-hand side
                    join_args.append('join -t ","')
                    join_args.append(
                        f'-j {max(len(left_headers), len(right_headers)) + 1}')
                else:
                    left_attribute = f'{left_source.name}.{join.left_attribute}'
                    right_attribute = f'{right_source.name}.{join.right_attribute}'

                    # Source or intermediate files must be sorted before joining
                    commands.append(
                        f'{UnixOrder.compute_order_by_command([left_attribute], left_headers)} -o {left_f_name} {left_f_name}')
                    commands.append(
                        f'{UnixOrder.compute_order_by_command([right_attribute], right_headers)} -o {right_f_name} {right_f_name}')
                    join_args.append('join -t ","')

                    # Apply appropriate arguments for LEFT and RIGHT joins
                    if join.join_type == JoinType.LEFT:
                        join_args.append('-a1')
                    elif join.join_type == JoinType.RIGHT:
                        join_args.append('-a2')

                    # Append arguments specifying which columns to join on from each side of the join
                    join_args.append(
                        f'-1{left_headers.index(left_attribute) + 1}')
                    join_args.append(
                        f'-2{right_headers.index(right_attribute) + 1}')

                # Add left and right hand files to complete the join command
                join_args.append(f'{left_f_name}')
                join_args.append(f'{right_f_name}')

                if len(joins) > 1:
                    # If there is more than one join, output the result to an intermediate file whose name is
                    # the combination of both sides of the join
                    left_f_name += f'_{right_source.name}'
                    join_args.append(f'> {left_f_name}')
                commands.append(' '.join(join_args))
                
                if join.join_type == JoinType.CROSS:
                    # If cartesian product was applied, remove first two columns
                    commands[-1] += ' | cut -c 2-'
                left_headers += right_headers

                if left_attribute and right_attribute:
                    left_headers.pop(left_headers.index(left_attribute))
                    left_headers.pop(left_headers.index(right_attribute))

                    # Associate each field reference with its corresponding source table for future reference
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
    """
    Parse the SQL statement for all join intersections, constructing a Join object with details on how that join should occur
    """
    joins: List[Join] = []
    from_clause_ctx = ctx.from_clause()
    join = Join()

    # Parse all equijoins from the WHERE clause
    eq_conditions: List[Tuple[SQLiteParser.ExprContext,
                              SQLiteParser.ExprContext]] = extract_join_conditions(ctx.where_clause())

    if from_clause_ctx.join_clause():
        # Parse the JOIN clause for join conditions if applicable
        join_clause_ctx = from_clause_ctx.join_clause()
        # Set the left-hand side of the join
        join.left = join_clause_ctx.table_or_subquery().table_name().getText()
        for _, join_condition_ctx in enumerate(join_clause_ctx.join_condition()):
            # Set the right-hand side of the join
            join.right = join_condition_ctx.table_or_subquery().table_name().getText().upper()

            # Determine the type of join
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
                # Determine which columns are being joined on and specify them in the Join object
                attribute_0, attribute_1 = join_condition_ctx.join_constraint().expr().expr()

                source_0 = find_target_source(attribute_0, sources)

                table_0 = (attribute_0.table_name().getText() if attribute_0.table_name(
                ) else source_0.name).upper()

                left_source = next(
                    (source for source in sources if source.name == join.left.upper()), None)
                right_source = next(
                    (source for source in sources if source.name == join.right.upper()), None)

                # Assign or flip the joined columns between the left and right hand side depending on which side matches table_0
                if table_0 in [left_source.name, left_source.alias]:
                    join.left_attribute = get_expr_col_ref(attribute_0)
                    join.right_attribute = get_expr_col_ref(attribute_1)
                elif table_0 == [right_source.name, right_source.alias]:
                    join.left_attribute = get_expr_col_ref(attribute_1)
                    join.right_attribute = get_expr_col_ref(attribute_0)
                joins.append(join)
                join = Join(left=join.right)

    elif len(sources) > 1:
        # If no join clause but multiple sources are specified, expect a cartesian product or equijoins
        join.left = from_clause_ctx.table_or_subquery(
            0).table_name().getText().upper()
        for table_or_subquery_ctx in from_clause_ctx.table_or_subquery()[1:]:
            join.right = table_or_subquery_ctx.table_name().getText().upper()
            join.join_type = JoinType.INNER if is_join_in_eq_conditions(
                join, sources, eq_conditions) else JoinType.CROSS
            joins.append(join)
            join = Join(left=join.right)

    # Previous steps may not be able to find the correct attributes being joined on. Apply this function to 
    # perform a deeper search
    determine_missing_join_attributes(joins, sources, eq_conditions)
    # Change any column names to field references
    transform_join_attributes_to_refs(joins, sources)
    return joins


def extract_join_conditions(ctx: SQLiteParser.Where_clauseContext) -> List[Tuple[SQLiteParser.ExprContext,
                                                                                 SQLiteParser.ExprContext]]:
    """
    Recursively search for any equijoin conditions in the WHERE clause
    """
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
    """
    Determine if a condition in the WHERE clause is an equijoin
    """
    return any(all(join_table in [find_target_source(cond_expr, sources).name for cond_expr in cond] for join_table in [join.left, join.right]) for cond in eq_conditions)


def determine_missing_join_attributes(joins: List[Join],
                                      sources: List[Table],
                                      eq_conditions: List[Tuple[SQLiteParser.ExprContext,
                                                                SQLiteParser.ExprContext]]) -> None:
    """
    Determine which Join objects are missing the columns on which the join is occurring and fill in the missing column information
    """                  
    # Deep search for any Joined tables that may be missing the attributes on which the join is occurring
    # Analyze join objects that aren't cartesian products and are missing the join attribute for the left-hand side
    uncertains = [join for join in joins if not join.join_type ==
                  JoinType.CROSS and not join.left_attribute]

    for eq_condition in eq_conditions:
        source_0 = find_target_source(eq_condition[0], sources)
        source_1 = find_target_source(eq_condition[1], sources)
        if source_0 and source_1:
            attribute_0 = get_expr_col_ref(eq_condition[0])
            attribute_1 = get_expr_col_ref(eq_condition[1])

            # Loop through the list of joins with uncertain attributes and assign the attribute name when the matching source is found
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
    """
    Change any header names used in the join attributes to their corresponding field references
    """
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
    """
    Prepend the original source table names to each attrbute after the join occurs so that reference to them is not lost
    """

    # Determine the order of headers after the join, keeping the name of the source tables
    join_order: List[str] = list(dict.fromkeys([header for header in [re.sub(
        r'\bJOIN.*|\..*', '', header) for header in join_source.headers] if header]))

    # Find the attrbutes relevant to the source tables used
    for source_name in join_order:
        related_attributes = [
            attribute for attribute in attributes if attribute.source.name == source_name]

    # Format each join attribute into a list of tuples consisting of the source table and attribute name 
    join_attributes_abbr = [
        (attribute.source.name, attribute.name) for attribute in attributes if attribute.association == AttributeType.JOIN]
    tmp_attributes = [deepcopy(attribute) for attribute in attributes]
    for attribute in tmp_attributes:
        if attribute.association == AttributeType.AGG:
            # Prepend the original source table name to the columns used in aggregate functions
            attribute.name = re.sub(
                r'\(', f'({attribute.source.name}.', attribute.name)
        elif (attribute.source.name, attribute.name) in join_attributes_abbr:
            for join in joins:
                # If this is a joined attribute, prepend both original source tables along with the JOIN identifier
                if attribute.name in [join.left_attribute, join.right_attribute]:
                    attribute.name = f'JOIN.{join.left_attribute}.{join.right_attribute}'
        else:
            # Default to prepending the original source table name to the column
            attribute.name = f'{attribute.source.name}.{attribute.name}'

        attribute.source = join_source

    return tmp_attributes


def filter_join_attributes(attributes: List[Attribute]) -> List[Attribute]:
    """
    Filter out all attributes used in the JOIN
    """
    return [attribute for attribute in attributes if attribute.association != AttributeType.JOIN]


def get_expr_col_ref(expr_ctx: SQLiteParser.ExprContext):
    """
    Convenience function to get the column name or field reference from an ANTLR4 token of type expr()
    """
    return (expr_ctx.column_name() if expr_ctx.column_name() else expr_ctx.REF_FIELD()).getText().upper()
