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


# @pytest.fixture
# def sql_out(monkeypatch):
#     def _method(stmt: str, confirms: int):
#         confirm_seq = ''.join(['1\nY\nY' for _ in range(confirms)])
#         monkeypatch.setattr('sys.stdin', StringIO(confirm_seq))
#         stmt = 'SELECT last_name, first_name, title, salary FROM EMPLOYEES'
#         sql = SQL()
#         sql.validate_sql(stmt)
#         command = SQLExecutor().execute_sql(stmt, sql.schema)
#         return check_output(command, shell=True, universal_newlines=True)
#     return _method


@pytest.mark.parametrize(('test_file', 'stmt', 'confirms'), [
    ('SELECT_FROM_ONE.csv',
     'SELECT last_name, first_name, title, salary FROM EMPLOYEES',
     1),
    ('SELECT_FROM_TWO.csv',
     'SELECT EMPLOYEES.id, title, salary, name, city, state FROM EMPLOYEES JOIN DEPARTMENTS ON d_id == DEPARTMENTS.id ORDER BY EMPLOYEES.id',
     2),
    ('SELECT_FROM_WHERE_ONE_SIMPLE.csv',
     'SELECT last_name, first_name, title, salary FROM EMPLOYEES WHERE SALARY > 85000',
     1),
    ('SELECT_FROM_WHERE_ONE_COMPLEX.csv',
     'SELECT last_name, first_name, title FROM EMPLOYEES WHERE (age < 25 AND salary > 75000 )OR (age < 30 AND salary > 85000)',
     1),
    # ('SELECT_FROM_WHERE_TWO.csv',
    #  'SELECT last_name, first_name, title, age, DEPARTMENTS.name, city, state FROM DEPARTMENTS, EMPLOYEES WHERE E.d_id == D.id AND D.state == 'CA' AND E.age > 50',
    #  2)
    # ('SELECT_FROM_WHERE_TWO_JOIN.csv',
    #  "SELECT last_name, first_name, title, age, DEPARTMENTS.name, city, state FROM DEPARTMENTS LEFT JOIN EMPLOYEES ON EMPLOYEES.d_id == DEPARTMENTS.id WHERE DEPARTMENTS.state == 'CA' AND EMPLOYEES.age > 50",
    #  2
    #  ),
    ('SELECT_FROM_WHERE_GROUP_ONE_SIMPLE.csv',
     'SELECT title, max(age), avg(salary) FROM EMPLOYEES WHERE age > 30 GROUP BY title',
     1
     ),
    ('SELECT_FROM_WHERE_GROUP_TWO_SIMPLE.csv',
     'SELECT DEPARTMENTS.name, min(EMPLOYEES.salary), max(salary) FROM DEPARTMENTS, EMPLOYEES WHERE DEPARTMENTS.id == EMPLOYEES.d_id AND EMPLOYEES.age < 30 GROUP BY DEPARTMENTS.name',
     2
     )
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
