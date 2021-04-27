import os
from io import StringIO
import pytest
from sql import SQL
from sql_executor import SQLExecutor
import sys
from subprocess import check_output
import re
# sys.path.append('../../')


@pytest.fixture(scope="function", autouse=True)
def change_test_dir(request):
    os.chdir(request.fspath.dirname)
    yield
    os.chdir(request.config.invocation_dir)


# Single table projection with named columns
PROJECT_NAMED_FROM_ONE = ("PROJECT_FROM_ONE.csv",
                          "SELECT last_name, first_name, title, salary FROM EMPLOYEES",
                          1)
# Single table projection with reference fields
PROJECT_REF_FROM_ONE = ("PROJECT_FROM_ONE.csv",
                        "SELECT #2 LAST_NAME, #3 FIRST_NAME, #5 TITLE, #7 SALARY FROM EMPLOYEES",
                        1)
# Two table projection with named columns
PROJECT_NAMED_FROM_TWO = ("PROJECT_FROM_TWO.csv",
                          "SELECT EMPLOYEES.id, title, salary, name, city, state FROM EMPLOYEES JOIN DEPARTMENTS ON d_id == DEPARTMENTS.id",
                          2)
# Two table projection with reference fields
PROJECT_REF_FROM_TWO = ("PROJECT_FROM_TWO.csv",
                        "SELECT EMPLOYEES.#1 ID, EMPLOYEES.#5 TITLE, EMPLOYEES.#7 SALARY, DEPARTMENTS.#2 NAME, DEPARTMENTS.#3 CITY, DEPARTMENTS.#4 STATE FROM EMPLOYEES JOIN DEPARTMENTS ON d_id == DEPARTMENTS.id",
                        2)
# Single table simple selection with named columns
SIMPLE_SELECT_NAMED_FROM_ONE = ("SELECT_FROM_WHERE_ONE_SIMPLE.csv",
                                "SELECT last_name, first_name, title, salary FROM EMPLOYEES WHERE SALARY > 85000",
                                1)
# Single table complex selection with reference fields
SIMPLE_SELECT_REF_FROM_ONE = ("SELECT_FROM_WHERE_ONE_SIMPLE.csv",
                              "SELECT #2 LAST_NAME, #3 FIRST_NAME, #5 TITLE, #7 SALARY FROM EMPLOYEES WHERE #7 > 85000",
                              1)
# Single table complex selection with named columns
COMPLEX_SELECT_NAMED_FROM_ONE = ("SELECT_FROM_WHERE_ONE_COMPLEX.csv",
                                 "SELECT last_name, first_name, title FROM EMPLOYEES WHERE (age < 25 AND salary > 75000 ) OR (age < 30 AND salary > 85000)",
                                 1)
# Single table complex selection with reference fields
COMPLEX_SELECT_REF_FROM_ONE = ("SELECT_FROM_WHERE_ONE_COMPLEX.csv",
                               "SELECT #2 LAST_NAME, #3 FIRST_NAME, #5 TITLE FROM EMPLOYEES WHERE (#6 < 25 AND #7 > 75000 ) OR (age < 30 AND salary > 85000)",
                               1)
# Two table complex selection with named columns
COMPLEX_SELECT_NAMED_FROM_TWO = ("SELECT_FROM_WHERE_TWO.csv",
                                 "SELECT last_name, first_name, title, age, DEPARTMENTS.name, city, state FROM EMPLOYEES, DEPARTMENTS WHERE EMPLOYEES.d_id == DEPARTMENTS.id AND DEPARTMENTS.state == 'CA' AND EMPLOYEES.age > 50",
                                 2)
# Two table complex selection with reference fields
COMPLEX_SELECT_REF_FROM_TWO = ()
# Two table join with complex selection by named columns
SELECT_NAMED_FROM_TWO_JOINED = ("SELECT_FROM_WHERE_TWO_JOIN.csv",
                                "SELECT last_name, first_name, title, age, DEPARTMENTS.name, city, state FROM EMPLOYEES RIGHT JOIN DEPARTMENTS ON EMPLOYEES.d_id == DEPARTMENTS.id WHERE DEPARTMENTS.state == 'CA' AND EMPLOYEES.age > 50",
                                2)
# Two table join with selection by reference fields
SELECT_REF_FROM_TWO_JOINED = ()
# Single table selection with group by named columns
SELECT_NAMED_FROM_ONE_GROUP_BY_NAMED = ("SELECT_FROM_WHERE_GROUP_ONE_SIMPLE.csv",
                                        "SELECT title, max(age), avg(salary) FROM EMPLOYEES WHERE age > 30 GROUP BY title",
                                        1)
# Single table selection with group by reference fields
SELECT_REF_FROM_ONE_GROUP_BY_REF = ("SELECT_FROM_WHERE_GROUP_ONE_SIMPLE.csv",
                                    "SELECT #5 TITLE, max(#6), avg(#7) FROM EMPLOYEES WHERE #6 > 30 GROUP BY #5",
                                    1)
# Two table selection with group by named columns
SELECT_NAMED_FROM_TWO_GROUP_BY_NAMED = ("SELECT_FROM_WHERE_GROUP_TWO_SIMPLE.csv",
                                        "SELECT DEPARTMENTS.name, min(EMPLOYEES.salary), max(salary) FROM DEPARTMENTS, EMPLOYEES WHERE DEPARTMENTS.id == EMPLOYEES.d_id AND EMPLOYEES.age < 30 GROUP BY DEPARTMENTS.name",
                                        2)
# Two table selection with group by reference fields
SELECT_REF_FROM_TWO_GROUP_BY_REF = ()


@pytest.mark.parametrize(('test_file', 'stmt', 'confirms'), [
    PROJECT_NAMED_FROM_ONE, PROJECT_REF_FROM_ONE,
    PROJECT_NAMED_FROM_TWO,
    # PROJECT_REF_FROM_TWO,
    SIMPLE_SELECT_NAMED_FROM_ONE, SIMPLE_SELECT_REF_FROM_ONE,
    COMPLEX_SELECT_NAMED_FROM_ONE, COMPLEX_SELECT_REF_FROM_ONE,
    COMPLEX_SELECT_NAMED_FROM_TWO,
    SELECT_NAMED_FROM_TWO_JOINED,
    SELECT_NAMED_FROM_ONE_GROUP_BY_NAMED, SELECT_REF_FROM_ONE_GROUP_BY_REF,
    SELECT_NAMED_FROM_TWO_GROUP_BY_NAMED
])
def test_sql(monkeypatch, test_file: str, stmt: str, confirms: int):
    confirm_seq = ''.join(['1\nY\nY\n' for _ in range(confirms)])
    monkeypatch.setattr('sys.stdin', StringIO(confirm_seq))
    sql = SQL()
    sql.validate_sql(stmt)
    command = SQLExecutor().execute_sql(stmt, sql.schema)
    sql_out_lines = check_output(
        command, shell=True, universal_newlines=True).splitlines()
    # sql_out = check_output(command, shell=True, universal_newlines=True)
    sql_out = '\n'.join([sql_out_lines[0]] +
                        sorted(sql_out_lines[1:])).strip()

    print(command)
    print('***********************ACTUAL***********************')
    print(sql_out.strip())
    with open(test_file, 'r') as expected:
        expected_lines = expected.read().splitlines()
        expected_str = '\n'.join(
            [expected_lines[0]] + sorted(expected_lines[1:])).strip()
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
