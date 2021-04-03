from typing import List, Set
from models.Table import Table
from utils.db import find_table
from validators.antlr4.SQLiteParser import SQLiteParser
from validators.antlr4.SQLiteParserVisitor import SQLiteParserVisitor


class GroupByValidator(SQLiteParserVisitor):
    def visitSelect_core(self, ctx: SQLiteParser.Select_coreContext):
        if not ctx.group_by_clause():
            return

        sources: List[Table] = self.visitFrom_clause(ctx.from_clause())
        group_by_columns: List[str] = []

        for expr_ctx in ctx.group_by_clause().expr():
            if expr_ctx.column_name():
                column_name_text = expr_ctx.column_name().getText()

                if expr_ctx.table_name():
                    self.check_column_in_table(
                        column_name_text, expr_ctx.table_name().getText(), sources)
                else:
                    self.check_column_in_all_tables(column_name_text, sources)

                group_by_columns.append(column_name_text.upper())

        for result_column_ctx in ctx.result_column():
            if result_column_ctx.expr() and result_column_ctx.expr().column_name():
                column_name_text = result_column_ctx.expr().column_name().getText()
                if column_name_text.upper() not in group_by_columns:
                    raise Exception(
                        'Projection "' + column_name_text + '" not found in GROUP BY clause')

    def visitFrom_clause(self, ctx: SQLiteParser.From_clauseContext) -> List[Table]:
        tables: List[Table] = []

        for table_or_subquery in ctx.table_or_subquery():
            table_name_ctx: SQLiteParser.Table_nameContext = table_or_subquery.table_name()
            if table_name_ctx:
                found_table: Table = find_table(table_name_ctx.getText())
                table_alias_ctx: SQLiteParser.Table_aliasContext = table_or_subquery.table_alias()
                found_table.alias = None if not table_alias_ctx else table_alias_ctx.getText()
                tables.append(found_table)

        return tables

    def check_column_in_table(self, column: str, table_or_alias_raw: str, sources: List[Table]):
        table_or_alias: str = table_or_alias_raw.upper()
        source_match = None
        for source in sources:
            if source.name.upper() == table_or_alias:
                source_match = source
                break
            elif source.alias:
                if source.alias.upper() == table_or_alias:
                    source_match = source
                    break
        if not source_match:
            raise Exception(
                'GROUP BY column "' + column + '" specified by table or alias "' + table_or_alias + '" not found')
        elif column.upper() not in map(lambda header: header.upper(), source.headers):
            raise Exception(
                'GROUP BY column "' + column + '" not found in table or alias "' + table_or_alias + '"')

    def check_column_in_all_tables(self, column: str, sources: List[Table]):
        found = False
        for source in sources:
            if column.upper() in map(lambda header: header.upper(), source.headers):
                if found:
                    raise Exception(
                        'Ambiguous GROUP BY column "' + column + '" found in multiple tables')
                found = True
        if not found:
            raise Exception('GROUP BY column "' + column +
                            '" was not found in any tables')
