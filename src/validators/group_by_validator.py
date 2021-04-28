from typing import Dict, List, Set
from models.Table import Table
from utils.db import find_table_in_directory, col_name_found, ref_field_in_bounds
from validators.antlr4.SQLiteParser import SQLiteParser
from validators.antlr4.SQLiteParserVisitor import SQLiteParserVisitor


class GroupByValidator(SQLiteParserVisitor):
    def validate_group_by(self, ctx, schema: Dict[str, Table]):
        self.schema = schema
        self.visit(ctx)

    def visitSelect_core(self, ctx: SQLiteParser.Select_coreContext):
        if not ctx.group_by_clause():
            return

        # sources: List[Table] = self.visitFrom_clause(ctx.from_clause())
        sources: List[Table] = self.schema.values()
        group_by_columns: List[str] = []

        for expr_ctx in ctx.group_by_clause().expr():
            if expr_ctx.column_name() or expr_ctx.REF_FIELD():
                column_or_ref_field_text = expr_ctx.column_name().getText(
                ) if expr_ctx.column_name() else expr_ctx.REF_FIELD().getText()

                if expr_ctx.table_name():
                    self.check_column_in_table(
                        column_or_ref_field_text, expr_ctx.table_name().getText(), sources)
                else:
                    self.check_column_in_all_tables(
                        column_or_ref_field_text, sources)

                group_by_columns.append(column_or_ref_field_text.upper())

        for result_column_ctx in ctx.result_column():
            expr_ctx = result_column_ctx.expr()
            if expr_ctx:
                if expr_ctx.column_name() or expr_ctx.REF_FIELD():
                    column_or_ref_field_text = expr_ctx.column_name().getText(
                    ) if expr_ctx.column_name() else expr_ctx.REF_FIELD().getText()
                    if column_or_ref_field_text.upper() not in group_by_columns:
                        raise Exception(
                            'Projection or ref field "' + column_or_ref_field_text + '" not found in GROUP BY clause')

    # def visitFrom_clause(self, ctx: SQLiteParser.From_clauseContext) -> List[Table]:
    #     tables: List[Table] = []

    #     for table_or_subquery in ctx.table_or_subquery():
    #         table_name_ctx: SQLiteParser.Table_nameContext = table_or_subquery.table_name()
    #         if table_name_ctx:
    #             found_table: Table = find_table_in_directory(table_name_ctx.getText())
    #             table_alias_ctx: SQLiteParser.Table_aliasContext = table_or_subquery.table_alias()
    #             found_table.alias = None if not table_alias_ctx else table_alias_ctx.getText()
    #             tables.append(found_table)

    #     return tables

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
                'GROUP BY table or alias "' + table_or_alias + '" not found for column or ref field "' + column + '"')
        elif column[1:].isdigit():
            if not ref_field_in_bounds(column, source_match):
                raise Exception(
                    'GROUP BY ref field "' + column + '" is out of bounds for table or alias "' + table_or_alias + '"')
        elif not col_name_found(column, source_match):
            raise Exception(
                'GROUP BY column "' + column + '" not found in table or alias "' + table_or_alias + '"')

    def check_column_in_all_tables(self, column: str, sources: List[Table]):
        found = False
        for source in sources:
            if ref_field_in_bounds(column, source) or col_name_found(column, source):
                if found:
                    raise Exception(
                        'Ambiguous GROUP BY column or ref field "' + column + '" found in multiple tables')
                found = True
        if not found:
            raise Exception('GROUP BY column or ref field "' + column +
                            '" was not found in any tables')
