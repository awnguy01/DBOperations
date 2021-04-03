from typing import List
from SQLiteParserVisitor import SQLiteParserVisitor
from SQLiteParser import SQLiteParser
from database import Database
from result_column import Result_Column
from db_utils import scan_directory
from table import Table


class SQLVisitor(SQLiteParserVisitor):
    def visitParse(self, ctx: SQLiteParser.ParseContext):
        for sql_stmt_list in ctx.sql_stmt_list():
            if not self.visitSql_stmt_list(sql_stmt_list):
                return False
        return True

    def visitSql_stmt_list(self, ctx: SQLiteParser.Sql_stmt_listContext):
        for sql_stmt in ctx.sql_stmt():
            if not self.visitSql_stmt(sql_stmt):
                return False
        return True

    def visitSql_stmt(self, ctx: SQLiteParser.Sql_stmtContext):
        return self.visitSelect_stmt(ctx.select_stmt())

    def visitSelect_stmt(self, ctx: SQLiteParser.Select_stmtContext):
        for select_core in ctx.select_core():
            if not self.visitSelect_core(select_core):
                return False
        return True

    def visitSelect_core(self, ctx: SQLiteParser.Select_coreContext):
        db: Database = scan_directory()
        if not db.schema:
            raise Exception('No database schema found')
        result_columns: List[Result_Column] = map(
            lambda result_column: self.visitResult_column(result_column), ctx.result_column())
        tables: List[Table] = list(map(lambda table_or_subquery: self.visitTable_or_subquery(
            table_or_subquery), ctx.table_or_subquery()))

        for table in tables:
            if table.table_name not in db.schema:
                raise Exception(table.table_name + ' not in database schema')

        group_by_columns: List[Result_Column] = []

        if ctx.group_by_clause():
            group_by_columns = self.visitGroup_by_clause(ctx.group_by_clause())

        for result_column in result_columns:
            if result_column.table_name:
                schema_table = next(
                    (t.table_name for t in tables if result_column.table_name.upper() in [t.table_alias, t.table_name]), None)

                if not schema_table:
                    raise Exception(result_column.table_name +
                                    ' not found in database schema')

                header = db.schema[(schema_table).upper()]

                if result_column.column_name not in header:
                    raise Exception(result_column.column_name +
                                    ' not found in ' + result_column.table_name)
            elif result_column.column_name:
                col_found = False
                for _, header in db.schema.items():
                    if result_column.column_name in header:
                        if col_found:
                            raise Exception(result_column.column_name +
                                            ' is ambiguously defined')
                        col_found = True
                if not col_found:
                    raise Exception(result_column.column_name +
                                    ' not found in any tables')
            if group_by_columns:
                if result_column.is_star:
                    raise Exception('Cannot select * with GROUP BY clause')
                elif result_column.column_name not in map(lambda col: col.column_name, group_by_columns):
                    raise Exception(result_column.column_name +
                                    ' not in GROUP BY clause')

        return True

    def visitResult_column(self, ctx: SQLiteParser.Result_columnContext):
        col = Result_Column()
        col.star = bool(ctx.STAR())
        if ctx.column_alias():
            col.column_alias = self.visitColumn_alias(ctx.column_alias())

        expr = ctx.expr()
        if expr:
            if expr.table_name():
                col.table_name = self.visitTable_name(expr.table_name())
            if expr.column_name():
                col.column_name = self.visitColumn_name(expr.column_name())
        return col

    def visitTable_or_subquery(self, ctx: SQLiteParser.Table_or_subqueryContext):
        table = Table()
        if ctx.table_name():
            table.table_name = self.visitTable_name(ctx.table_name()).upper()
        if ctx.table_alias():
            table.table_alias = self.visitTable_alias(
                ctx.table_alias()).upper()
        return table

    def visitGroup_by_clause(self, ctx: SQLiteParser.Group_by_clauseContext):
        cols: List[Result_Column] = []
        for expr in ctx.expr():
            col = Result_Column()
            if expr.table_name():
                col.table_name = self.visitTable_name(expr.table_name())
            if expr.column_name():
                col.column_name = self.visitColumn_name(expr.column_name())
            cols.append(col)
        return cols

    def visitTable_name(self, ctx: SQLiteParser.Table_nameContext):
        return self.visitAny_name(ctx.any_name())

    def visitTable_alias(self, ctx: SQLiteParser.Table_aliasContext):
        return self.visitAny_name(ctx.any_name())

    def visitColumn_name(self, ctx: SQLiteParser.Column_nameContext):
        return self.visitAny_name(ctx.any_name()).upper()

    def visitColumn_alias(self, ctx: SQLiteParser.Column_aliasContext):
        if ctx.STRING_LITERAL():
            return ctx.STRING_LITERAL().getText().upper()
        else:
            return ctx.IDENTIFIER().getText().upper()

    def visitAny_name(self, ctx: SQLiteParser.Any_nameContext):
        if ctx.STRING_LITERAL():
            return ctx.STRING_LITERAL().getText()
        else:
            return ctx.IDENTIFIER().getText()
