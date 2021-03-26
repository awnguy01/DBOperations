#!/usr/bin/python3
import argparse
from SQLiteParser import SQLiteParser
from SQLiteLexer import SQLiteLexer
from SQLVisitor import SQLVisitor

from antlr4 import *


def user_interface():
    parser = argparse.ArgumentParser()
    parser.add_argument('sql', nargs=1, help='SQL statement to run')
    return parser.parse_args()


def main():
    # database: Database = scan_directory()
    # print(database)

    try:
        arguments = user_interface()
        in_stream = InputStream(arguments.sql[0])
        lexer = SQLiteLexer(in_stream)
        stream = CommonTokenStream(lexer)
        parser = SQLiteParser(stream)
        visitor = SQLVisitor()
        valid = visitor.visit(parser.parse())
        if valid:
            print('SQL IS VALID')
        else:
            print('SQL IS NOT VALID')

        # sql_stmt = sqlparse.parse(arguments.sql[0])
        # print(sql_stmt[0])
        # tokens: TokenList = sql_stmt[0].tokens
        # for token in tokens:
        #     if isinstance(token, Where):
        #         for w_token in token.tokens:
        #             if isinstance(w_token, Comparison):
        #                 print(w_token)

        # print(arguments.sql)
    except Exception as e:
        print(e)


if __name__ == '__main__':
    main()
