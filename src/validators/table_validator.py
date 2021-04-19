from models.Table import Table
from typing import Dict, Iterable, List
from utils.db import find_table_in_directory, read_table_header
from validators.antlr4.SQLiteParser import SQLiteParser
from .antlr4.SQLiteParserVisitor import SQLiteParserVisitor


class TableValidator(SQLiteParserVisitor):
    def validate_sources(self, ctx: any, schema: Dict[str, Table]):
        self.schema = schema
        self.visit(ctx)

    def choose(self, prompt: str, *choices: List[str]):
        choice: str = None
        while choice is None:
            answer: str or int = input(prompt)
            answer = int(answer) if answer.isdigit() else 0
            if answer > 0 and answer <= len(choices):
                choice = choices[answer - 1]
            else:
                print('Invalid choice selected')
        return choice

    def confirm(self, prompt: str):
        confirmed: bool = None
        while confirmed is None:
            answer = input(prompt)
            if answer == 'Y':
                confirmed = True
            elif answer == 'N':
                confirmed = False
            else:
                print('Invalid choice selected. Make sure your answer is uppercase.')
        return confirmed

    def set_table_headers(self, table: Table):
        while True:
            confirmed: bool = None
            print('New table file ' + table.name + ' detected.')
            prompt = u'Please choose the delimiter for this file\n(1) ,\n(2) |\n(3) <SPACE>\n(4) <TAB>\n'
            delimiter = self.choose(prompt, ',', '|', ' ', '\t')
            table.delimiter = delimiter
            headers = read_table_header(table.full_path, delimiter)
            prompt = 'Does ' + table.name + ' have headers? (Y/N) '
            has_headers = self.confirm(prompt)

            if has_headers:
                print(str(len(headers)) +
                      ' column(s) detected. Displaying the first few headers:')
                print(str(headers[:5]))
                prompt = 'Are these correct? (Y/N) '
                confirmed = self.confirm(prompt)
                if confirmed:
                    table.headers = headers
            else:
                print(str(len(headers)) + ' column(s) detected.')
                prompt = 'Is this correct? (Y/N) '
                confirmed = self.confirm(prompt)
                if confirmed:
                    table.headers = [i for i in range(len(headers))]

            if confirmed:
                break

    def visitFrom_clause(self, ctx: SQLiteParser.From_clauseContext):
        def parse_tables(parse_ctx: SQLiteParser.From_clauseContext or SQLiteParser.Join_clauseContext):
            table_or_subquery_ctxs = parse_ctx.table_or_subquery() if isinstance(
                parse_ctx.table_or_subquery(), Iterable) else [parse_ctx.table_or_subquery()]
            for table_or_subquery_ctx in table_or_subquery_ctxs:
                if table_or_subquery_ctx.table_name():
                    table_name_text = table_or_subquery_ctx.table_name().getText().upper()
                    if table_name_text not in self.schema.keys():
                        table: Table = find_table_in_directory(table_name_text)
                        if not table:
                            raise Exception(
                                'Source table "' + table_name_text + '" not found in current working directory')
                        else:
                            self.set_table_headers(table)
                            self.schema[table_name_text] = table
        parse_tables(ctx)
        if ctx.join_clause():
            parse_tables(ctx.join_clause())
            for join_condition_ctx in ctx.join_clause().join_condition():
                parse_tables(join_condition_ctx)
