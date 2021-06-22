#!/usr/bin/python3


from models import Table
from prompt_toolkit import prompt
from prompt_toolkit.history import FileHistory
from sql_executor import SQLExecutor
from sys import stderr
from typing import Dict, List, Tuple
from utils.db import find_table_in_directory, read_table_header
from utils.valid import parse_context
from validators.antlr4 import SQLiteParser, SQLiteParserVisitor
from validators.group_by_validator import GroupByValidator
from validators.projection_validator import ProjectionValidator
from validators.table_validator import TableValidator


class SQL():
    def __init__(self) -> None:
        """
        Initialize single instance for each validator
        """
        super().__init__()
        self.schema: Dict[str, Table] = {}
        self.src_checker = TableValidator()
        self.proj_checker = ProjectionValidator()
        self.group_by_checker = GroupByValidator()

    def validate_sql(self, input: str):
        """
        Function to sequentially run all validation checks
        """
        ctx = parse_context(input)
        self.src_checker.validate_sources(ctx, self.schema)
        self.proj_checker.validate_projections(ctx, self.schema)
        self.group_by_checker.validate_group_by(ctx, self.schema)

    def main(self):
        """
        Main driver function for UNIX SQL Interpreter REPL
        """
        executor = SQLExecutor()
        while 1:
            # Stores command history in a temporary file (cycle through using UP arrow key)
            input: str = prompt('>> ', history=FileHistory(
                '/tmp/sql_repl_history.txt'))

            if input == 'exit':
                # Exit command to escape REPL
                break
            else:
                try:
                    # Run validation checks first for each SQL statement
                    self.validate_sql(input)
                except Exception as e:
                    print(e, file=stderr)
                    continue
                # Generate and print the UNIX pipeline equivalent of the SQL statement
                print(executor.execute_sql(input, self.schema))


if __name__ == '__main__':
    SQL().main()
