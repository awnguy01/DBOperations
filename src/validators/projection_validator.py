from typing import List
from models.Table import Table
from utils.db import find_table
from validators.antlr4.SQLiteParser import SQLiteParser
from validators.antlr4.SQLiteParserVisitor import SQLiteParserVisitor


class ProjectionValidator(SQLiteParserVisitor):
    def visitSelect_core(self, ctx: SQLiteParser.Select_coreContext):
        sources: List[Table] = self.visitFrom_clause(ctx.from_clause())
        for result_column in ctx.result_column():
            if result_column.STAR():
                continue
            else:
                table_name_ctx: SQLiteParser.Table_nameContext = result_column.expr().table_name()
                if not result_column.expr().column_name():
                    continue
                col_name_text = result_column.expr().column_name().getText()
                if table_name_ctx:
                    self.check_projection_in_table(
                        col_name_text, table_name_ctx.getText(), sources)
                else:
                    self.check_projection_in_all_tables(col_name_text, sources)

        return super().visitSelect_core(ctx)

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

    def check_projection_in_table(self, projection: str, table_or_alias_raw: str, sources: List[Table]):
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
                'Projection "' + projection + '" specified by table or alias "' + table_or_alias + '" not found')
        elif projection.upper() not in map(lambda header: header.upper(), source.headers):
            raise Exception(
                'Projection "' + projection + '" not found in table or alias "' + table_or_alias + '"')

    def check_projection_in_all_tables(self, projection: str, sources: List[Table]):
        found = False
        for source in sources:
            if projection.upper() in map(lambda header: header.upper(), source.headers):
                if found:
                    raise Exception(
                        'Ambiguous projection "' + projection + '" found in multiple tables')
                found = True
        if not found:
            raise Exception('Projection "' + projection +
                            '" was not found in any tables')
