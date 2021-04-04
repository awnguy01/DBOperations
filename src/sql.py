#!/usr/bin/python3

import sys
from prompt_toolkit import prompt
from prompt_toolkit.history import FileHistory
from utils.valid import parse_context
from validators.projection_validator import ProjectionValidator
from validators.table_validator import TableValidator
from validators.group_by_validator import GroupByValidator
from sql_executor import SQLExecutor


def validate_sql(input: str):
    ctx = parse_context(input)
    TableValidator().visit(ctx)
    ProjectionValidator().visit(ctx)
    GroupByValidator().visit(ctx)


def main():
    executor = SQLExecutor()
    while 1:
        input: str = prompt('>> ', history=FileHistory('/tmp/sql_repl_history.txt'))

        if input == 'exit':
            break
        else:
            try:
                validate_sql(input)
            except Exception as e:
                print(e, file=sys.stderr)
                continue
            executor.execute_sql(input)


if __name__ == '__main__':
    main()
