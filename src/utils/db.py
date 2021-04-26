import os
import glob
from typing import Dict, List
from antlr4.tree.Tree import TerminalNodeImpl

from models.Table import Table


def find_table_in_directory(search_name: str) -> Table:
    cmp_name = search_name.upper()
    allfiles = glob.glob(os.getcwd() + '/*.csv')
    for fpath in allfiles:
        basename = os.path.splitext(os.path.basename(fpath))[0]
        if basename.upper() == cmp_name:
            table = Table(fpath, basename)
            return table

    return None


def read_table_header(path: str, delimiter: str) -> List[str]:
    with open(path, mode='r', encoding='utf-8-sig') as f:
        return list(map(lambda c: c.upper(),
                        f.readline().strip().split(sep=delimiter)))


def ref_field_in_bounds(projection: str, source: Table):
    return projection[1:].isdigit() and int(projection[1:]) <= len(list(source.headers))


def col_name_found(projection: str, source: Table):
    return projection.upper() in map(lambda header: header.upper(), source.headers)


def find_table_by_name(table_name: str, sources: List[Table]):
    return next((table for table in sources if table.name.upper()
                 == table_name.upper()), None)


def find_table_by_alias(table_alias: str, sources: List[Table]):
    return next((table for table in sources if table.alias.upper()
                 == table_alias.upper()), None)


def in_order_traversal(ctx, stop_type):
    def traverse(nodes: List[TerminalNodeImpl], inner_ctx, stop_type):
        for i in range(inner_ctx.getChildCount()):
            child = inner_ctx.getChild(i)
            if (type(child) is stop_type):
                nodes.append(child)
            else:
                traverse(nodes, child, stop_type)

    tokens: List = []
    traverse(tokens, ctx, stop_type)
    return tokens

def find_target_source(table_ref_ctx, sources: List[Table]) -> Table:
    if len(sources) == 1:
        return sources[0]
    elif hasattr(table_ref_ctx, 'table_name') and table_ref_ctx.table_name():
        return find_table_by_name(table_ref_ctx.table_name().getText(), sources)
    elif hasattr(table_ref_ctx, 'table_alias') and table_ref_ctx.table_alias():
        return find_table_by_alias(table_ref_ctx.table_alias().getText(), sources)
    elif hasattr(table_ref_ctx, 'column_name') and table_ref_ctx.column_name():
        return next((source for source in sources if table_ref_ctx.column_name().getText().upper() in source.headers), None)
    elif hasattr(table_ref_ctx, 'function_name'):
        fn_expr_ctx = table_ref_ctx.expr(0)
        if fn_expr_ctx.table_name():
            source = find_table_by_name(fn_expr_ctx.table_name().getText(), sources) 
            source = source if source else find_table_by_alias(fn_expr_ctx.table_name().getText(), sources)
            return source
        else:
            return next((source for source in sources if fn_expr_ctx.getText().upper() in source.headers), None)    
    elif hasattr(table_ref_ctx, 'expr') and table_ref_ctx.expr():
        return find_target_source(table_ref_ctx.expr(), sources)
    # elif table_ref_ctx.expr():
    #     column_name_ctx = table_ref_ctx.expr().column_name()
    #     if table_ref_ctx.expr().function_name():
    #         column_name_ctx = table_ref_ctx.expr().expr().column_name()
    #     if column_name_ctx:
    #         return next((source for source in sources if column_name_ctx.getText().upper() in source.headers), None)
    return None