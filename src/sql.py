#!/usr/bin/python3

from prompt_toolkit import prompt
from utils.valid import parse_context
from validators.projection_validator import ProjectionValidator

from validators.table_validator import TableValidator


def validate_sql(input: str):
    ctx = parse_context(input)
    try:
        TableValidator().visit(ctx)
        # ProjectionValidator().visit(ctx)
    except Exception as e:
        print(e)
        return False
    return True


def main():
    while 1:
        input: str = prompt('>> ')

        if input == 'exit':
            break
        else:
            valid = validate_sql(input)
            if valid:
                print('SQL IS VALID')


if __name__ == '__main__':
    main()
