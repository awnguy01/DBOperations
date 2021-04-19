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
