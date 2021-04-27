
from os import path
import re
from src.utils.db import find_target_source
from typing import List
from models.Table import Table
from utils.db import in_order_traversal
from validators.antlr4.SQLiteParser import SQLiteParser
from antlr4.tree.Tree import TerminalNodeImpl


SELECT_PATH = path.join(path.dirname(__file__), '..', 'select.py')

def compute_select_where_command(condition: str, projections: List[str], source: Table) -> str:
    args = [f'python3 "{SELECT_PATH}"']
    args.append("-i '" + source.full_path + "'")
    args.append("-s '" + source.delimiter + "'")

    proj_str = ','.join(projections)
    cond_str = re.sub('\'', '"', condition)

    for i, header in enumerate(source.headers):
        proj_str = re.sub(fr'\b{header}\b', f'#{i + 1}',
                          proj_str, flags=re.IGNORECASE)
        cond_str = re.sub(fr'\b{header}\b', f'#{i + 1}',
                          cond_str, flags=re.IGNORECASE)

    args.append(f"-p '{proj_str}'")
    args.append(f"-c '{cond_str}'")

    if type(source.headers[0]) is str:
        args.append('-h | tail -n+2')

    return ' '.join(args)

def extract_conditions(ctx: SQLiteParser.Where_clauseContext, sources: List[Table], target_source_name: str) -> str:
    def invalid_source_reference(expr_ctx: SQLiteParser.ExprContext):
        op_expr_ctx_list = in_order_traversal(expr_ctx, SQLiteParser.ExprContext)
        for op_expr_ctx in op_expr_ctx_list:
            if op_expr_ctx.column_name():
                if target_source_name != find_target_source(op_expr_ctx, sources).name:
                    return True
            
        return False
    
    def in_order_source_filtered_traversal(nodes: List[TerminalNodeImpl], inner_ctx):
        for i in range(inner_ctx.getChildCount()):
            child = inner_ctx.getChild(i)
            if (type(child) is TerminalNodeImpl):
                if child.getText().upper() not in ['.', target_source_name]:
                    nodes.append(child)
            elif hasattr(child, 'AND') and child.AND() or hasattr(child, 'OR') and child.OR():
                left_invalid_ref = invalid_source_reference(child.expr(0))
                right_invalid_ref = invalid_source_reference(child.expr(1))

                if left_invalid_ref or right_invalid_ref:
                    if not left_invalid_ref:
                        in_order_source_filtered_traversal(nodes, child.expr(0))
                    if not right_invalid_ref:
                        in_order_source_filtered_traversal(nodes, child.expr(1))    
                else:
                    in_order_source_filtered_traversal(nodes, child)    
            else:
                in_order_source_filtered_traversal(nodes, child)
                
    tokens: List = []
    in_order_source_filtered_traversal(tokens, ctx)

    return ' '.join([token.getText()
                     for token
                     in tokens
                     if token.getText() != 'WHERE']).strip()
