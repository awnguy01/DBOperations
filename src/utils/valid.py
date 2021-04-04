from antlr4 import CommonTokenStream, InputStream
from validators.antlr4.SQLiteLexer import SQLiteLexer

from validators.antlr4.SQLiteParser import SQLiteParser


def parse_context(input: str) -> SQLiteParser.ParseContext:
    return SQLiteParser(
        CommonTokenStream(SQLiteLexer(InputStream(input)))).parse()
