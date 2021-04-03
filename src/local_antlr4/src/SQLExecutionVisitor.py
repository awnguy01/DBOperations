import os
from typing import List
from .. import SQLiteParser
from .. import SQLiteParserVisitor
from sql_select import myselect
from database import Database
from db_utils import scan_directory
from result_column import Result_Column
from table import Table
from models.select_args import SelectArgs

class SQLExecutionVisitor(SQLiteParserVisitor):
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
        condition = ''
        if ctx.where_clause():
            condition = self.visitWhere_clause(ctx.where_clause())
        print(condition)
        args = SelectArgs(condition, table.table_name + '.csv', ',', list(
            map(lambda col: col.column_name, result_columns)))
        myselect(args)

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

    def visitWhere_clause(self, ctx: SQLiteParser.Where_clauseContext):
        return self.visitExpr(ctx.expr())

    def visitExpr(self, ctx: SQLiteParser.ExprContext):
        tokens: List = []
        child_count = ctx.getChildCount()
        if child_count == 1:
            if ctx.literal_value():
                return self.visitLiteral_value(ctx.literal_value())
            return ctx.getChild(0).getText()
        elif child_count == 3:
            tokens.append(ctx.getChild(1).getText())
            tokens.append(self.visitExpr(ctx.getChild(0)))
            tokens.append(self.visitExpr(ctx.getChild(2)))

        return tokens

    def visitLiteral_value(self, ctx: SQLiteParser.Literal_valueContext):
        if ctx.NUMERIC_LITERAL():
            return float(ctx.NUMERIC_LITERAL().getText())
        else:
            return ctx.getText().strip()