from typing import List
from validators.antlr4.SQLiteParser import SQLiteParser
from models.Join import Join, JoinType
from utils.db import find_target_source
from models.Table import Table

def extract_joins(ctx: SQLiteParser.Select_coreContext, sources: List[Table]) -> List[Join]:
    joins: List[Join] = []
    from_clause_ctx = ctx.from_clause()
    join = Join()
    if from_clause_ctx.join_clause():
        join_clause_ctx = from_clause_ctx.join_clause()
        join.left = join_clause_ctx.table_or_subquery().table_name().getText()
        for _, join_condition_ctx in enumerate(join_clause_ctx.join_condition()):
            join.right = join_condition_ctx.table_or_subquery().table_name().getText().upper()

            if join_condition_ctx.join_operator().LEFT():
                join.join_type = JoinType.LEFT
            elif join_condition_ctx.join_operator().RIGHT():
                join.join_type = JoinType.RIGHT
            else:
                join.join_type = JoinType.INNER

            if join_condition_ctx.join_constraint():
                attribute_0 = join_condition_ctx.join_constraint().expr().expr(0)
                attribute_1 = join_condition_ctx.join_constraint().expr().expr(1)

                table_0 = (attribute_0.table_name().getText() if attribute_0.table_name(
                ) else find_target_source(attribute_0, sources).name).upper()

                if table_0 == join.left.upper():
                    join.left_attribute = attribute_0.column_name().getText().upper()
                    join.right_attribute = attribute_1.column_name().getText().upper()
                elif table_0 == join.right.upper():
                    join.left_attribute = attribute_1.column_name().getText().upper()
                    join.right_attribute = attribute_0.column_name().getText().upper()
                joins.append(join)
                join = Join(left=join.right)

    elif len(sources) > 1:
        join.left = from_clause_ctx.table_or_subquery(
            0).table_name().getText().upper()
        for table_or_subquery_ctx in from_clause_ctx.table_or_subquery()[1:]:
            join.join_type = JoinType.INNER
            join.right = table_or_subquery_ctx.table_name().getText().upper()
            joins.append(join)
            join = Join(left=join.right)

    if any(not join.left_attribute for join in joins):
        eq_conditions = []
        uncertains = [join for join in joins if not join.left_attribute]

        def find_eq(ctx: SQLiteParser.ExprContext):
            if ctx.EQ():
                eq_conditions.append([ctx.expr(0), ctx.expr(1)])
            else:
                for inner_expr_ctx in ctx.expr():
                    find_eq(inner_expr_ctx)

        find_eq(ctx.where_clause().expr())

        for eq_condition in eq_conditions:
            source_0 = find_target_source(eq_condition[0], sources)
            source_1 = find_target_source(eq_condition[1], sources)
            if source_0 and source_1:
                attribute_0 = eq_condition[0].column_name().getText().upper()
                attribute_1 = eq_condition[1].column_name().getText().upper()
                
                for u, join in enumerate(uncertains):
                    if source_0.name == join.left and source_1.name == join.right:
                        join.left_attribute = attribute_0
                        join.right_attribute = attribute_1
                        uncertains.pop(u)
                        break
                    elif source_0.name == join.right and source_1.name == join.left:
                        join.left_attribute = attribute_1
                        join.right_attribute = attribute_0
                        uncertains.pop(u)
                        break
    return joins