
from os import path
import re
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

def extract_conditions(ctx: SQLiteParser.Where_clauseContext) -> str:
    def check_for_join(expr_ctx: SQLiteParser.ExprContext):
        if expr_ctx.EQ():
            if len(in_order_traversal(expr_ctx, SQLiteParser.Column_nameContext)) > 1:
                return True
        return False
    
    def in_order_no_joins_traversal(nodes: List[TerminalNodeImpl], inner_ctx):
        for i in range(inner_ctx.getChildCount()):
            child = inner_ctx.getChild(i)
            if (type(child) is TerminalNodeImpl):
                nodes.append(child)
            elif hasattr(inner_ctx, 'AND') and inner_ctx.AND():
                left = inner_ctx.expr(0)
                right = inner_ctx.expr(1)
                if check_for_join(left):
                    in_order_no_joins_traversal(nodes, right)
                elif check_for_join(right):
                    in_order_no_joins_traversal(nodes, left)
                else:
                    in_order_no_joins_traversal(nodes, child)    
            else:
                in_order_no_joins_traversal(nodes, child)
                
    tokens: List = []
    in_order_no_joins_traversal(tokens, ctx)

    return ' '.join([token.getText()
                     for token
                     in tokens
                     if token.getText() != 'WHERE']).strip()
