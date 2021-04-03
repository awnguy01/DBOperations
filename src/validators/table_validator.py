from utils.db import find_table
from validators.antlr4.SQLiteParser import SQLiteParser
from .antlr4.SQLiteParserVisitor import SQLiteParserVisitor


class TableValidator(SQLiteParserVisitor):

    def visitFrom_clause(self, ctx: SQLiteParser.From_clauseContext):
        for table_or_subquery_ctx in ctx.table_or_subquery():
            table_or_subquery = self.visitTable_or_subquery(
                table_or_subquery_ctx)
            if type(table_or_subquery) is str:
                if find_table(table_or_subquery) is None:
                    raise Exception(
                        'Source table not found in current working directory')

        return super().visitFrom_clause(ctx)

    def visitTable_or_subquery(self, ctx: SQLiteParser.Table_or_subqueryContext):
        return self.visitTable_name(ctx.table_name())

    def visitTable_name(self, ctx: SQLiteParser.Table_nameContext):
        return ctx.getText()
