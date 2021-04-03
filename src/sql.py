#!/usr/bin/python3

import sys
from prompt_toolkit import prompt
from utils.valid import parse_context
from validators.projection_validator import ProjectionValidator
from validators.table_validator import TableValidator
from validators.group_by_validator import GroupByValidator


def validate_sql(input: str):
    ctx = parse_context(input)
    TableValidator().visit(ctx)
    ProjectionValidator().visit(ctx)
    GroupByValidator().visit(ctx)


def main():
    while 1:
        input: str = prompt('>> ')

        if input == 'exit':
            break
        else:
            try:
                validate_sql(input)
                print('SQL IS VALID')
            except Exception as e:
                print(e, file=sys.stderr)


if __name__ == '__main__':
    main()
