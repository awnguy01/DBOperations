
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
    args = [f'python3 "{SELECT_PATH}"']
    if not stdin:
        args.append("-i '" + source.full_path + "'")
    args.append("-s '" + source.delimiter + "'")

    proj_str, cond_str = replace_columns_with_field_refs(
        source.headers,
        [','.join(projections), re.sub('\'', '"', condition)],
        source.name)

    args.append(f"-p '{proj_str}'")
    args.append(f"-c '{cond_str}'")

    if source.has_header_row and not stdin:
        args.append('-h | tail -n+2')

    return ' '.join(args)


def extract_conditions(ctx: SQLiteParser.Where_clauseContext, sources: List[Table], target_source_names: List[str]) -> str:
    def invalid_source_reference(expr_ctx: SQLiteParser.ExprContext):
        op_expr_ctx_list = in_order_traversal(
            expr_ctx, SQLiteParser.ExprContext)
        if len([op_expr_ctx for op_expr_ctx in op_expr_ctx_list if op_expr_ctx.column_name() or op_expr_ctx.REF_FIELD()]) > 1:
            return True
        for op_expr_ctx in op_expr_ctx_list:
            if op_expr_ctx.column_name():
                if find_target_source(op_expr_ctx, sources).name not in target_source_names:
                    return True

        return False

    def in_order_source_filtered_traversal(nodes: List[TerminalNodeImpl], inner_ctx):
        if hasattr(inner_ctx, 'AND') and inner_ctx.AND() or hasattr(inner_ctx, 'OR') and inner_ctx.OR():
            left = inner_ctx.expr(0)
            right = inner_ctx.expr(1)

            left_invalid_ref = invalid_source_reference(left)
            right_invalid_ref = invalid_source_reference(right)

            if left_invalid_ref and right_invalid_ref:
                return
            elif left_invalid_ref:
                in_order_source_filtered_traversal(nodes, right)
                return
            elif right_invalid_ref:
                in_order_source_filtered_traversal(nodes, left)
                return

        elif hasattr(inner_ctx, 'expr'):
            if hasattr(inner_ctx.expr(), '__len__') and len(inner_ctx.expr()) == 2:
                if invalid_source_reference(inner_ctx):
                    return

        for i in range(inner_ctx.getChildCount()):
            child = inner_ctx.getChild(i)
            if (type(child) is TerminalNodeImpl):
                nodes.append(child)
            else:
                in_order_source_filtered_traversal(nodes, child)

    tokens: List = []
    in_order_source_filtered_traversal(tokens, ctx)

    condition = ' '.join([token.getText()
                          for token
                          in tokens
                          if token.getText() != 'WHERE']).strip()
    return re.sub(r'\b(\w+|#\d+)\s\.\s(\w+|#\d+)\b', r'\1.\2', condition).upper()


def filter_select_attributes(attributes: List[Attribute]) -> List[Attribute]:
    return [attribute for attribute in attributes if attribute.association != AttributeType.WHERE]
