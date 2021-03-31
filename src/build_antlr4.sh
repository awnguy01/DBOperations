#!/bin/bash

shopt -s expand_aliases
source ~/.bash_profile
antlr4 -visitor -Dlanguage=Python3 SQLiteLexer.g4
antlr4 -visitor -Dlanguage=Python3 SQLiteParser.g4