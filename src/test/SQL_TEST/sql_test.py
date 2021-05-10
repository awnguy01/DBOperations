import os
from io import StringIO
from typing import List
import pytest
from sql import SQL
from sql_executor import SQLExecutor
import sys
from subprocess import check_output
import re


@pytest.fixture(scope="function", autouse=True)
def change_test_dir(request):
    os.chdir(request.fspath.dirname)
    yield
    os.chdir(request.config.invocation_dir)


# Single table star projection
PROJECT_STAR_FROM_ONE = ("PROJECT_STAR_FROM_ONE.csv",
                         "SELECT * FROM EMPLOYEES",
                         1, True, [], 0, 0)
# Single table star projection with ordering, limit, and offset                         
PROJECT_STAR_FROM_ONE_ORDERED_LIMIT_OFFSET = ("PROJECT_STAR_FROM_ONE.csv",
                                              "SELECT * FROM EMPLOYEES ORDER BY salary, age LIMIT 15 OFFSET 4",
                                              1, True, [7, 6], 15, 4)
# Two table star and column projection mixed                                              
PROJECT_STAR_AND_SOME_FROM_TWO = ("PROJECT_STAR_AND_SOME_FROM_TWO.csv",
                                  'SELECT E.*, D.name, D.city, D.state FROM EMPLOYEES E, DEPARTMENTS D',
                                  2, True, [], 0, 0)
# Single table projection with named columns
PROJECT_NAMED_FROM_ONE = ("PROJECT_FROM_ONE.csv",
                          "SELECT last_name, first_name, title, salary FROM EMPLOYEES",
                          1, True, [], 0, 0)
# Single table projection with reference fields from table with headers
PROJECT_REF_FROM_ONE_WITH_HEADERS = ("PROJECT_FROM_ONE.csv",
                                     "SELECT #2 LAST_NAME, #3 FIRST_NAME, #5 TITLE, #7 SALARY FROM EMPLOYEES",
                                     1, True, [], 0, 0)
# Single table projection with reference fields from table without headers
PROJECT_REF_FROM_ONE_WITH_NO_HEADERS = ("PROJECT_FROM_ONE.csv",
                                        "SELECT #2 LAST_NAME, #3 FIRST_NAME, #5 TITLE, #7 SALARY FROM EMPLOYEES_NO_HEADERS",
                                        1, False, [], 0, 0)
# Two table projection with named columns
PROJECT_NAMED_FROM_TWO_INNER_JOINED = ("PROJECT_FROM_TWO.csv",
                                       "SELECT E.id, title, salary, name, city, state FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.d_id == D.id",
                                       2, True, [], 0, 0)
# Two table projection with reference fields from tables with headers
PROJECT_REF_FROM_TWO_INNER_JOINED_WITH_HEADERS = ("PROJECT_FROM_TWO.csv",
                                                  "SELECT E.#1 ID, E.#5 TITLE, E.#7 SALARY, D.#2 NAME, D.#3 CITY, D.#4 STATE FROM EMPLOYEES E JOIN DEPARTMENTS D ON d_id == D.id",
                                                  2, True, [], 0, 0)
# Two table projection with reference fields from tables without headers
PROJECT_REF_FROM_TWO_INNER_JOINED_NO_HEADERS = ("PROJECT_FROM_TWO.csv",
                                                "SELECT E.#1 ID, E.#5 TITLE, E.#7 SALARY, D.#2 NAME, D.#3 CITY, D.#4 STATE FROM EMPLOYEES_NO_HEADERS E JOIN DEPARTMENTS_NO_HEADERS D ON E.#4 == D.#1",
                                                2, False, [], 0, 0)
# Single table simple selection with named columns
SIMPLE_SELECT_NAMED_FROM_ONE = ("SELECT_FROM_WHERE_ONE_SIMPLE.csv",
                                "SELECT last_name, first_name, title, salary FROM EMPLOYEES WHERE SALARY > 85000",
                                1, True, [], 0, 0)
# Single table simple selection with reference fields from table with headers
SIMPLE_SELECT_REF_FROM_ONE_WITH_HEADERS = ("SELECT_FROM_WHERE_ONE_SIMPLE.csv",
                                           "SELECT #2 LAST_NAME, #3 FIRST_NAME, #5 TITLE, #7 SALARY FROM EMPLOYEES WHERE #7 > 85000",
                                           1, True, [], 0, 0)
# Single table simple selection with reference fields from table no headers
SIMPLE_SELECT_REF_FROM_ONE_NO_HEADERS = ("SELECT_FROM_WHERE_ONE_SIMPLE.csv",
                                         "SELECT #2 LAST_NAME, #3 FIRST_NAME, #5 TITLE, #7 SALARY FROM EMPLOYEES_NO_HEADERS WHERE #7 > 85000",
                                         1, False, [], 0, 0)
# Single table complex selection with named columns
COMPLEX_SELECT_NAMED_FROM_ONE = ("SELECT_FROM_WHERE_ONE_COMPLEX.csv",
                                 "SELECT last_name, first_name, title FROM EMPLOYEES WHERE (age < 25 AND salary > 75000 ) OR (age < 30 AND salary > 85000)",
                                 1, True, [], 0, 0)
# Single table complex selection with reference fields from table with headers
COMPLEX_SELECT_REF_FROM_ONE_WITH_HEADERS = ("SELECT_FROM_WHERE_ONE_COMPLEX.csv",
                                            "SELECT #2 LAST_NAME, #3 FIRST_NAME, #5 TITLE FROM EMPLOYEES WHERE (#6 < 25 AND #7 > 75000 ) OR (age < 30 AND salary > 85000)",
                                            1, True, [], 0, 0)
# Single table complex selection with reference fields from table no headers
COMPLEX_SELECT_REF_FROM_ONE_NO_HEADERS = ("SELECT_FROM_WHERE_ONE_COMPLEX.csv",
                                          "SELECT #2 LAST_NAME, #3 FIRST_NAME, #5 TITLE FROM EMPLOYEES_NO_HEADERS WHERE (#6 < 25 AND #7 > 75000 ) OR (#6 < 30 AND #7 > 85000)",
                                          1, False, [], 0, 0)
# Two table complex selection with named columns
COMPLEX_SELECT_NAMED_FROM_TWO = ("SELECT_FROM_WHERE_TWO.csv",
                                 "SELECT last_name, first_name, title, age, D.name, city, state FROM EMPLOYEES E, DEPARTMENTS D WHERE E.d_id == D.id AND D.state == 'CA' AND E.age > 50",
                                 2, True, [], 0, 0)
# Two table complex selection with reference fields from tables with headers
COMPLEX_SELECT_REF_FROM_TWO_WITH_HEADERS = ("SELECT_FROM_WHERE_TWO.csv",
                                            "SELECT E.#2 LAST_NAME, E.#3 FIRST_NAME, E.#5 TITLE, E.#6 AGE, D.#2 NAME, D.#3 CITY, D.#4 STATE FROM EMPLOYEES E, DEPARTMENTS D WHERE E.#4 == D.#1 AND D.#4 == 'CA' AND E.#6 > 50",
                                            2, True, [], 0, 0)
# Two table complex selection with reference fields from tables without headers
COMPLEX_SELECT_REF_FROM_TWO_NO_HEADERS = ("SELECT_FROM_WHERE_TWO.csv",
                                          "SELECT E.#2 LAST_NAME, E.#3 FIRST_NAME, E.#5 TITLE, E.#6 AGE, D.#2 NAME, D.#3 CITY, D.#4 STATE FROM EMPLOYEES_NO_HEADERS E, DEPARTMENTS_NO_HEADERS D WHERE E.#4 == D.#1 AND D.#4 == 'CA' AND E.#6 > 50",
                                          2, False, [], 0, 0)
# Two table join with complex selection by named columns
SELECT_NAMED_FROM_TWO_JOINED = ("SELECT_FROM_WHERE_TWO_JOIN.csv",
                                "SELECT  last_name, first_name, title, age, DEPARTMENTS.name, city, state FROM EMPLOYEES RIGHT JOIN DEPARTMENTS ON EMPLOYEES.d_id == DEPARTMENTS.id WHERE DEPARTMENTS.state == 'CA' AND EMPLOYEES.age > 50",
                                2, True, [], 0, 0)
# Two table join with selection by reference fields from tables with headers
SELECT_REF_FROM_TWO_JOINED_WITH_HEADERS = ("SELECT_FROM_WHERE_TWO_JOIN.csv",
                                           "SELECT  E.#2 last_name, E.#3 first_name, E.#5 title, E.#6 age, D.#2 name, D.#3 city, D.#4 state FROM EMPLOYEES E RIGHT JOIN DEPARTMENTS D ON E.#4 == D.#1 WHERE D.#4 == 'CA' AND E.#6 > 50",
                                           2, True, [], 0, 0)
# Two table join with selection by reference fields from tables without headers
SELECT_REF_FROM_TWO_JOINED_NO_HEADERS = ("SELECT_FROM_WHERE_TWO_JOIN.csv",
                                         "SELECT  E.#2 last_name, E.#3 first_name, E.#5 title, E.#6 age, D.#2 name, D.#3 city, D.#4 state FROM EMPLOYEES_NO_HEADERS E RIGHT JOIN DEPARTMENTS_NO_HEADERS D ON E.#4 == D.#1 WHERE D.#4 == 'CA' AND E.#6 > 50",
                                         2, False, [], 0, 0)
# Single table selection with group by named columns
SELECT_NAMED_FROM_ONE_GROUP_BY_NAMED = ("SELECT_FROM_WHERE_GROUP_ONE_SIMPLE.csv",
                                        "SELECT title, max(age), avg(salary) FROM EMPLOYEES WHERE age > 30 GROUP BY title",
                                        1, True, [], 0, 0)
# Single table selection with group by reference fields from table with headers
SELECT_REF_FROM_ONE_GROUP_BY_REF_WITH_HEADERS = ("SELECT_FROM_WHERE_GROUP_ONE_SIMPLE.csv",
                                                 "SELECT #5 TITLE, max(#6) 'MAX(AGE)', avg(#7) 'AVG(SALARY)' FROM EMPLOYEES WHERE #6 > 30 GROUP BY #5",
                                                 1, True, [], 0, 0)
# Single table selection with group by reference fields from tables without headers
SELECT_REF_FROM_ONE_GROUP_BY_REF_NO_HEADERS = ("SELECT_FROM_WHERE_GROUP_ONE_SIMPLE.csv",
                                               "SELECT #5 TITLE, max(#6) 'MAX(AGE)', avg(#7) 'AVG(SALARY)' FROM EMPLOYEES_NO_HEADERS WHERE #6 > 30 GROUP BY #5",
                                               1, False, [], 0, 0)
# Two table selection with group by named columns
SELECT_NAMED_FROM_TWO_GROUP_BY_NAMED = ("SELECT_FROM_WHERE_GROUP_TWO_SIMPLE.csv",
                                        "SELECT D.name, min(E.salary), max(salary) FROM DEPARTMENTS D, EMPLOYEES E WHERE D.id == E.d_id AND E.age < 30 GROUP BY D.name",
                                        2, True, [], 0, 0)
# Two table selection with group by reference fields from tables with headers
SELECT_REF_FROM_TWO_GROUP_BY_REF_WITH_HEADERS = ("SELECT_FROM_WHERE_GROUP_TWO_SIMPLE.csv",
                                                 "SELECT D.#2 name, min(E.#7) 'MIN(SALARY)', max(E.#7) 'MAX(salary)' FROM DEPARTMENTS D, EMPLOYEES E WHERE D.#1 == E.#4 AND E.#6 < 30 GROUP BY D.#2",
                                                 2, True, [], 0, 0)
# Two table selection with group by reference fields from tables without headers
SELECT_REF_FROM_TWO_GROUP_BY_REF_NO_HEADERS = ("SELECT_FROM_WHERE_GROUP_TWO_SIMPLE.csv",
                                               "SELECT D.#2 name, min(E.#7) 'MIN(SALARY)', max(E.#7) 'MAX(salary)' FROM DEPARTMENTS_NO_HEADERS D, EMPLOYEES_NO_HEADERS E WHERE D.#1 == E.#4 AND E.#6 < 30 GROUP BY D.#2",
                                               2, False, [], 0, 0)


@pytest.mark.parametrize(('test_file', 'stmt', 'table_cnt', 'has_headers', 'sort_fields', 'limit', 'offset'), [
    PROJECT_STAR_FROM_ONE, PROJECT_STAR_FROM_ONE_ORDERED_LIMIT_OFFSET, PROJECT_STAR_AND_SOME_FROM_TWO,
    PROJECT_NAMED_FROM_ONE, PROJECT_REF_FROM_ONE_WITH_HEADERS, PROJECT_REF_FROM_ONE_WITH_NO_HEADERS,
    PROJECT_NAMED_FROM_TWO_INNER_JOINED, PROJECT_REF_FROM_TWO_INNER_JOINED_WITH_HEADERS, PROJECT_REF_FROM_TWO_INNER_JOINED_NO_HEADERS,
    SIMPLE_SELECT_NAMED_FROM_ONE, SIMPLE_SELECT_REF_FROM_ONE_WITH_HEADERS, SIMPLE_SELECT_REF_FROM_ONE_NO_HEADERS,
    COMPLEX_SELECT_NAMED_FROM_ONE, COMPLEX_SELECT_REF_FROM_ONE_WITH_HEADERS, COMPLEX_SELECT_REF_FROM_ONE_NO_HEADERS,
    COMPLEX_SELECT_NAMED_FROM_TWO, COMPLEX_SELECT_REF_FROM_TWO_WITH_HEADERS, COMPLEX_SELECT_REF_FROM_TWO_NO_HEADERS,
    SELECT_NAMED_FROM_TWO_JOINED, SELECT_REF_FROM_TWO_JOINED_WITH_HEADERS, SELECT_REF_FROM_TWO_JOINED_NO_HEADERS,
    SELECT_NAMED_FROM_ONE_GROUP_BY_NAMED, SELECT_REF_FROM_ONE_GROUP_BY_REF_WITH_HEADERS, SELECT_REF_FROM_ONE_GROUP_BY_REF_NO_HEADERS,
    SELECT_NAMED_FROM_TWO_GROUP_BY_NAMED, SELECT_REF_FROM_TWO_GROUP_BY_REF_WITH_HEADERS, SELECT_REF_FROM_TWO_GROUP_BY_REF_NO_HEADERS
])
def test_sql(monkeypatch,
             test_file: str,
             stmt: str,
             table_cnt: int,
             has_headers: bool,
             sort_fields: List[int],
             limit: int,
             offset: int):
    prompt_input = '1\nY\nY\n' if has_headers else '1\nN\nY\n'
    confirm_seq = ''.join([prompt_input for _ in range(table_cnt)])
    monkeypatch.setattr('sys.stdin', StringIO(confirm_seq))
    sql = SQL()
    sql.validate_sql(stmt)
    command = SQLExecutor().execute_sql(stmt, sql.schema)
    sql_out_lines = check_output(
        command, shell=True, universal_newlines=True).splitlines()
    # sql_out = check_output(command, shell=True, universal_newlines=True)
    sql_out = '\n'.join(sql_out_lines) if sort_fields else '\n'.join([sql_out_lines[0]] +
                                                                      sorted(sql_out_lines[1:])).strip()

    print(command)
    print('***********************ACTUAL***********************')
    print(sql_out.strip())
    def get_key(line):
        keys = [line.split(',')[sort_field - 1] for sort_field in sort_fields]
        keys = [float(key) if key.isdigit() else key for key in keys]
        return tuple(keys)
    with open(test_file, 'r') as expected:
        expected_lines = expected.read().splitlines()
        expected_str = '\n'.join(
            [expected_lines[0]] + sorted(expected_lines[1:])).strip() if not sort_fields else '\n'.join(
            [expected_lines[0]] + sorted(expected_lines[1:], key=lambda line: get_key(line))[offset:limit + offset]).strip()
        print('***********************EXPECTED***********************')
        print(expected_str)
        assert sql_out == expected_str


# ********************************

# def test_SELECT_FROM_ONE(monkeypatch):
#     sql = SQL()
#     monkeypatch.setattr('sys.stdin', StringIO('1\nY\nY'))
#     stmt = 'SELECT last_name, first_name, title, salary FROM EMPLOYEES'
#     sql.validate_sql(stmt)
#     command = SQLExecutor().execute_sql(stmt, sql.schema)
#     os.system(command)
#     p_out = check_output(command, shell=True, universal_newlines=True)
#     with open('SELECT_FROM_ONE.csv', 'r') as expected:
#         assert p_out == expected.read()


# def SELECT_FROM_TWO(monkeypatch):
#     assert True


# def SELECT_FROM_ONE_SIMPLE_WHERE(monkeypatch):
#     assert True


# def SELECT_FROM_ONE_COMPLEX_WHERE(monkeypatch):
#     assert True


# def SELECT_FROM_TWO_NO_JOIN_WHERE(monkeypatch):
#     assert True


# def SELECT_FROM_TWO_JOIN_WHERE(monkeypatch):
#     assert True


# def SELECT_FROM_ONE_WHERE_GROUP_SIMPLE_AGG(monkeypatch):
#     assert True


# def SELECT_FROM_TWO_WHERE_GROUP_SIMPLE_AGG(monkeypatch):
#     assert True
