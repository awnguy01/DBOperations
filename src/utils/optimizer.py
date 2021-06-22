from typing import List
from validators.antlr4.SQLiteParser import SQLiteParser
from models.Attribute import Attribute, AttributeType


def simplify_basic_star_select(select_core_ctx: SQLiteParser.Select_coreContext, attributes: List[Attribute]):
    if len(select_core_ctx.result_column()) == 1 and select_core_ctx.result_column(0).STAR() and len([attribute for attribute in attributes if attribute.association != AttributeType.SELECT]) == 0:
        return f'cat "{attributes[0].source.full_path}"'
    return None
