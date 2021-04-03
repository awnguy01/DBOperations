#!/usr/bin/python3
# !/usr/bin/python3

from argparse import ArgumentParser
from local_antlr4.SQLiteLexer import SQLiteLexer
from local_antlr4.SQLiteParser import SQLiteParser
from local_antlr4.src.SQLVisitor import SQLVisitor
from local_antlr4.src.SQLExecutionVisitor import SQLExecutionVisitor

from antlr4 import InputStream, CommonTokenStream


def user_interface():
    parser = ArgumentParser()
    parser.add_argument('sql', nargs=1, help='SQL statement to run')
    return parser.parse_args()


def main():

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

    except Exception as e:
        print(e)


if __name__ == '__main__':
    main()
