from utils.db import find_table
from validators.antlr4.SQLiteParser import SQLiteParser
from .antlr4.SQLiteParserVisitor import SQLiteParserVisitor


class TableValidator(SQLiteParserVisitor):

    def visitFrom_clause(self, ctx: SQLiteParser.From_clauseContext):
        for table_or_subquery_ctx in ctx.table_or_subquery():
            if table_or_subquery_ctx.table_name():
                table_name_text = table_or_subquery_ctx.table_name().getText()
                if not find_table(table_name_text):
                    raise Exception(
                        'Source table "' + table_name_text + '" not found in current working directory')
