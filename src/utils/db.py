import os
import glob
import re
from validators.antlr4.SQLiteParser import SQLiteParser
from typing import Dict, List
from antlr4.tree.Tree import TerminalNodeImpl
from models.Attribute import Attribute
from models.Table import Table

STRIP_FN_REGEX = r'\b(SUM|COUNT|AVG|MIN|MAX)\(|\)'


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
    return next((table for table in sources if table_name.upper() in [table.name.upper(), table.alias.upper()]), None)


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
    elif hasattr(table_ref_ctx, 'function_name') and table_ref_ctx.function_name():
        fn_expr_ctx = table_ref_ctx.expr(0)
        if fn_expr_ctx.table_name():
            source = find_table_by_name(
                fn_expr_ctx.table_name().getText(), sources)
            source = source if source else find_table_by_alias(
                fn_expr_ctx.table_name().getText(), sources)
            return source
        else:
            return next((source for source in sources if fn_expr_ctx.getText().upper() in source.headers), None)
    elif hasattr(table_ref_ctx, 'expr') and table_ref_ctx.expr():
        return find_target_source(table_ref_ctx.expr(), sources)
    return None


def convert_attribute_name_to_ref_field(attribute: Attribute):
    raw_name = re.sub(STRIP_FN_REGEX, '', attribute.name)
    if raw_name[0] != '#':
        attribute.name = f'#{attribute.source.headers.index(raw_name) + 1}'
    return attribute


def transform_headers_to_refs(source: Table):
    source.headers = (f'#{i + 1}' for i in range(len(source.headers)))


def replace_columns_with_field_refs(headers: List[str], sub_targets: List[str], source_name: str = ''):
    for i, header in enumerate(headers):
        col_refs: List[str] = [header]
        if ',' in header:
            col_refs = re.sub(r'\(|\)', '',  header).split(',')
        for ref in col_refs:
            sub_targets = [re.sub(fr'\b({source_name}\.)?{ref}\b', f'#{i + 1}',
                                  target_str, flags=re.IGNORECASE) for target_str in sub_targets]
    return sub_targets


def find_all_relevant_source_names(from_clause_ctx: SQLiteParser.From_clauseContext):
    relevant_source_names = [table_ctx.table_name().getText()
                             for table_ctx in from_clause_ctx.table_or_subquery()]
    if (from_clause_ctx.join_clause()):
        join_clause_ctx = from_clause_ctx.join_clause()
        relevant_source_names += [join_clause_ctx.table_or_subquery().table_name().getText()] + [
            join_condition_ctx.table_or_subquery().table_name().getText()
            for join_condition_ctx in join_clause_ctx.join_condition()]
    return relevant_source_names
