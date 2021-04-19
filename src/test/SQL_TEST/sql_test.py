import os
from io import StringIO
import pytest
from sql import SQL
from sql_executor import SQLExecutor
import sys
from subprocess import check_output
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
    ('SELECT_FROM_TWO_ORDERED.csv',
     'SELECT EMPLOYEES.id, title, salary, name, city, state FROM EMPLOYEES JOIN DEPARTMENTS ON d_id == DEPARTMENTS.id ORDER BY EMPLOYEES.id',
     2)
])
def test_sql(monkeypatch, test_file: str, stmt: str, confirms: int):
    confirm_seq = ''.join(['1\nY\nY\n' for _ in range(confirms)])
    monkeypatch.setattr('sys.stdin', StringIO(confirm_seq))
    sql = SQL()
    sql.validate_sql(stmt)
    command = SQLExecutor().execute_sql(stmt, sql.schema)
    sql_out = check_output(command, shell=True, universal_newlines=True)
    with open(test_file, 'r') as expected:
        assert sql_out == expected.read()


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
