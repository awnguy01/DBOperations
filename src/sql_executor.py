import os
from typing import Dict, List
from validators.antlr4.SQLiteParser import SQLiteParser
from validators.antlr4.SQLiteParserVisitor import SQLiteParserVisitor
from utils.valid import parse_context
from utils.db import find_table, read_table_header
from models.Table import Table


class SQLExecutor(SQLiteParserVisitor):
    def execute_sql(self, sql: str):
        self.visit(parse_context(sql))

    def visitSql_stmt_list(self, ctx: SQLiteParser.Sql_stmt_listContext):
        for sql_stmt_ctx in ctx.sql_stmt():
            if sql_stmt_ctx.select_stmt():
                for select_core_ctx in sql_stmt_ctx.select_stmt().select_core():
                    command = self.visitSelect_core(select_core_ctx)
                    os.system(command)

    def visitSelect_core(self, ctx: SQLiteParser.Select_coreContext):
        command = ''
        sources: List[Table] = self.visitFrom_clause(ctx.from_clause())
        projections: Dict[str, List[int]] = self.map_table_projections(
            ctx.result_column(), sources)

        for source in sources:
            if not projections.get(source.name):
                continue
            elif 0 in projections.get(source.name):
                command += 'cat "' + source.full_path + '" '
            else:
                command += 'cut "' + source.full_path + '" -d , -f '
                command += str(projections[source.name][0])
                for field_number in projections[source.name][1:]:
                    command += ',' + str(field_number)
        return command

    def visitFrom_clause(self, ctx: SQLiteParser.From_clauseContext):
        tables: List[Table] = []

        for table_or_subquery_ctx in ctx.table_or_subquery():
            table = find_table(table_or_subquery_ctx.table_name().getText())
            if table_or_subquery_ctx.table_alias():
                table.alias = table_or_subquery_ctx.table_alias().getText()
            tables.append(table)

        return tables

    def map_table_projections(self, result_columns: SQLiteParser.Result_columnContext, sources: List[Table]):
        projections: Dict[str, List[int]] = {}

        def find_table_in_tables(table_name: str):
            return next((table for table in sources if table.name.upper()
                         == table_name.upper()), None)
        for result_column_ctx in result_columns:
            table_name_ctx = result_column_ctx.table_name()
            table = None
            if table_name_ctx:
                table = find_table_in_tables(table_name_ctx.getText())
            elif len(sources) == 1:
                table = find_table_in_tables(sources[0].name)

            field_number = self.projection_to_field_number(
                result_column_ctx, table)
            if table.name in projections.keys():
                projections[table.name].append(field_number)
            else:
                projections[table.name] = [field_number]

        return projections

    def projection_to_field_number(self, result_column_ctx: SQLiteParser.Result_columnContext, source: Table):
        expr_ctx = result_column_ctx.expr()
        if expr_ctx:
            if expr_ctx.REF_FIELD():
                return int(expr_ctx.REF_FIELD().getText()[1:])
            else:
                return read_table_header(source.full_path).index(
                    expr_ctx.column_name().getText().upper()) + 1
        return 0
