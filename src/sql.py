#!/usr/bin/env pypy
import argparse

def user_interface():
    parser = argparse.ArgumentParser()
    parser.add_argument("sql")
    return parser.parse_args()

def main():
    try:
        arguments = user_interface()
        print(arguments.sql)
    except Exception as e:
        print(e)

if __name__ == "__main__":
    main()
