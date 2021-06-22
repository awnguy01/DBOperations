from typing import List
from validators.antlr4.SQLiteParser import SQLiteParser
from models.Attribute import Attribute, AttributeType


def simplify_basic_star_select(select_core_ctx: SQLiteParser.Select_coreContext, attributes: List[Attribute]):
    if len(select_core_ctx.result_column()) == 1 and select_core_ctx.result_column(0).STAR() and len([attribute for attribute in attributes if attribute.association != AttributeType.SELECT]) == 0:
        return f'cat "{attributes[0].source.full_path}"'
    return None


def reduce_join_intermediates(commands: List[str], join_count: int) -> List[str]:
    print(f'Length of joins is {join_count}')
    if not join_count:
        return commands

    for i, command in reversed(enumerate(commands)):
        if command.startswith('join'):
            sort_1 = commands[i - 2]
            intermediate_1 = sort_1.split(' ')[-1]
            sort_2 = commands[i - 1]
            intermediate_2 = sort_2.split(' ')[-1]

        print(commands[i])
    # for i in range(join_count):

    return commands
