from utils.db import find_table
from validators.antlr4.SQLiteParser import SQLiteParser
from .antlr4.SQLiteParserVisitor import SQLiteParserVisitor


class TableValidator(SQLiteParserVisitor):

    def visitFrom_clause(self, ctx: SQLiteParser.From_clauseContext):
        for table_or_subquery_ctx in ctx.table_or_subquery():
            if table_or_subquery_ctx.table_name():
                if not find_table(table_or_subquery_ctx.table_name().getText()):
                    raise Exception(
                        'Source table not found in current working directory')
