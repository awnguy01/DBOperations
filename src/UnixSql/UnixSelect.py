
from os import path
import re
from utils.db import find_target_source, replace_columns_with_field_refs
from typing import List
from models.Table import Table
from models.Attribute import Attribute, AttributeType
from utils.db import in_order_traversal
from validators.antlr4.SQLiteParser import SQLiteParser
from antlr4.tree.Tree import TerminalNodeImpl
from UnixSql import UnixProject


SELECT_PATH = path.join(path.dirname(__file__), '..', 'select.py')


def compute_select_command(condition: str, projections: List[str], source: Table, stdin: bool) -> str:
    """
    Modular function for translating WHERE clauses in the SQL statement into UNIX commands.
    """
    # Call select.py with python3 (path to select.py is stored as a global constant in sql_executor.py)
    args = [f'python3 "{SELECT_PATH}"']
    # Append path to source table if not reading from stdin
    if not stdin:
        args.append("-i '" + source.full_path + "'")

    # Use the specified delimiter of the source table
    args.append("-s '" + source.delimiter + "'")

    # Construct condition and projection arguments for select.py while replacing any column names with
    # field references
    proj_str, cond_str = replace_columns_with_field_refs(
        source.headers,
        [','.join(projections), re.sub('\'', '"', condition)],
        source.name)

    args.append(f"-p '{proj_str}'")
    args.append(f"-c '{cond_str}'")

    if source.has_header_row and not stdin:
    # If original source table has a header, disregard using tail command in lieu of the program-generated header
        args.append('-h | tail -n+2')

    return ' '.join(args)


def extract_conditions(ctx: SQLiteParser.Where_clauseContext, sources: List[Table], target_source_names: List[str]) -> str:
    """
    Extract the conditions for the specified source tables in the WHERE clause used as the argument for select.py while 
    removing equijoin conditions
    """
    def invalid_source_reference(expr_ctx: SQLiteParser.ExprContext):
        """
        Determines if the condition partial should be included in the final extracted condition
        """
        op_expr_ctx_list = in_order_traversal(
            expr_ctx, SQLiteParser.ExprContext)
        if len([op_expr_ctx for op_expr_ctx in op_expr_ctx_list if op_expr_ctx.column_name() or op_expr_ctx.REF_FIELD()]) > 1:
            # Condition partial is invalid if more than 1 source table (indicating an equijoin)
            return True
        for op_expr_ctx in op_expr_ctx_list:
            if op_expr_ctx.column_name():
                # Condition partial is invalid if referencing any table not specifed
                if find_target_source(op_expr_ctx, sources).name not in target_source_names:
                    return True

        return False

    def in_order_source_filtered_traversal(nodes: List[TerminalNodeImpl], inner_ctx):
        """
        Recursively traverse WHERE clause to filter out any invalid condition partials
        """
        if hasattr(inner_ctx, 'AND') and inner_ctx.AND() or hasattr(inner_ctx, 'OR') and inner_ctx.OR():
            # If condition is complex, the recursion must factor in each AND/OR conditional branch 
            left = inner_ctx.expr(0)
            right = inner_ctx.expr(1)

            # Determine if left and right side of the condition are invalid
            left_invalid_ref = invalid_source_reference(left)
            right_invalid_ref = invalid_source_reference(right)

            if left_invalid_ref and right_invalid_ref:
                # If both sides of the condition are invalid, do nothing
                return
            elif left_invalid_ref:
                # If left side of the condition is invalid, continue recursion only on right side of branch
                in_order_source_filtered_traversal(nodes, right)
                return
            elif right_invalid_ref:
                # If right side of the condition is invalid, continue recursion only on left side of branch
                in_order_source_filtered_traversal(nodes, left)
                return

            # If both sides are valid, the function continues recursion on both sides

        elif hasattr(inner_ctx, 'expr'):
            if hasattr(inner_ctx.expr(), '__len__') and len(inner_ctx.expr()) == 2:
                # This scenario applies to two expressions separated by an '=' sign
                if invalid_source_reference(inner_ctx):
                    return

        for i in range(inner_ctx.getChildCount()):
            child = inner_ctx.getChild(i)
            if (type(child) is TerminalNodeImpl):
                # Append each valid atomic condition partial
                nodes.append(child)
            else:
                # If this recursion does not encounter an atomic condition partial, continue the recursion for each remaining branch
                in_order_source_filtered_traversal(nodes, child)

    tokens: List = []
    in_order_source_filtered_traversal(tokens, ctx)

    # Combine all the atomic condition partials into a single condition with the WHERE keyword
    condition = ' '.join([token.getText()
                          for token
                          in tokens
                          if token.getText() != 'WHERE']).strip()
    # Replace any unintended spaces between tables and their referenced columns in the condition (i.e. TABLE . #1 -> TABLE.#1)
    return re.sub(r'\b(\w+|#\d+)\s\.\s(\w+|#\d+)\b', r'\1.\2', condition).upper()


def filter_select_attributes(attributes: List[Attribute]) -> List[Attribute]:
    """
    Convenience function for filtering out all WHERE attributes from the attributes list
    """
    return [attribute for attribute in attributes if attribute.association != AttributeType.WHERE]
