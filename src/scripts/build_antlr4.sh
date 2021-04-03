#!/bin/bash

shopt -s expand_aliases
source ~/.bash_profile
cd "/media/andrew/Shared/UofL_Spring_2021/CSE Project/DBOperations/src/antlr4"
antlr4 -visitor -Dlanguage=Python3 SQLiteLexer.g4
antlr4 -visitor -Dlanguage=Python3 SQLiteParser.g4