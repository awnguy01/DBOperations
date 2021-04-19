from typing import Dict, List
from models.Table import Table
from utils.db import find_table_in_directory, col_name_found, ref_field_in_bounds
from validators.antlr4.SQLiteParser import SQLiteParser
from validators.antlr4.SQLiteParserVisitor import SQLiteParserVisitor


class ProjectionValidator(SQLiteParserVisitor):
    def validate_projections(self, ctx: any, schema: Dict[str, Table]):
        self.schema = schema
        self.visit(ctx)

    def visitSelect_core(self, ctx: SQLiteParser.Select_coreContext):
        sources: List[Table] = self.schema.values()
        for result_column in ctx.result_column():
            if result_column.STAR():
                continue
            else:
                expr_ctx = result_column.expr()
                column_name_ctx = expr_ctx.column_name()
                REF_FIELD_ctx = expr_ctx.REF_FIELD()

                if column_name_ctx or REF_FIELD_ctx:
                    table_name_ctx: SQLiteParser.Table_nameContext = expr_ctx.table_name()
                    projection = column_name_ctx.getText() if column_name_ctx else REF_FIELD_ctx.getText()

                    if table_name_ctx:
                        self.check_projection_in_table(
                            projection, table_name_ctx.getText(), sources)
                    else:
                        self.check_projection_in_all_tables(
                            projection, sources)

        return super().visitSelect_core(ctx)

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
                'Table or alias "' + table_or_alias + '" not found for projection or ref field "' + projection + '"')
        elif projection[1:].isdigit():
            if not ref_field_in_bounds(projection, source_match):
                raise Exception('Ref field "' + projection +
                                '" is out of bounds for "' + table_or_alias + '"')
        elif not col_name_found(projection, source_match):
            raise Exception(
                'Projection "' + projection + '" not found in table or alias "' + table_or_alias + '"')

    def check_projection_in_all_tables(self, projection: str, sources: List[Table]):
        found = False
        for source in sources:
            if projection[1:].isdigit() and ref_field_in_bounds(projection, source) or col_name_found(projection, source):
                if found:
                    raise Exception('Ambiguous projection or ref field "' +
                                    projection + '" found in multiple tables')
                found = True
        if not found:
            raise Exception('Projection or ref field "' + projection +
                            '" was not found in any tables')
