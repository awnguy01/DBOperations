import os
import sys
sys.path.append('../..')
import pytest
from src.sql import validate_sql

@pytest.fixture(scope="function")
def change_test_dir(request):
    os.chdir(request.fspath.dirname)
    yield
    os.chdir(request.config.invocation_dir)


@pytest.mark.parametrize(("sql, except_msg"), [
    ('SELECT * FROM bad', 'Source table "bad" not found in current working directory'),
    ('SELECT E.salary FROM employees_1', 'Projection "salary" specified by table or alias "E" not found'),
    ('SELECT employees_1.hobbies FROM employees_1', 'Projection "hobbies" not found in table or alias "EMPLOYEES_1"'),
    ('SELECT E.hobbies FROM employees_1 E', 'Projection "hobbies" not found in table or alias "E"'),
    ('SELECT salary FROM employees_1, employees_2', 'Ambiguous projection "salary" found in multiple tables'),
    ('SELECT hobbies FROM employees_1, employees_2', 'Projection "hobbies" was not found in any tables'),
    ('SELECT salary FROM employees_1 GROUP BY age', 'Projection "salary" not found in GROUP BY clause'),
    ('SELECT salary FROM employees_1 GROUP BY salary, E.hobbies', 'GROUP BY column "hobbies" specified by table or alias "E" not found'),
    ('SELECT salary FROM employees_1 GROUP BY salary, employees_1.hobbies', 'GROUP BY column "hobbies" not found in table or alias "EMPLOYEES_1"'),
    ('SELECT salary FROM employees_1 E1 GROUP BY salary, E1.hobbies', 'GROUP BY column "hobbies" not found in table or alias "E1"'),
    ('SELECT employees_1.salary FROM employees_1, employees_2 GROUP BY salary', 'Ambiguous GROUP BY column "salary" found in multiple tables'),
    ('SELECT salary FROM employees_1 GROUP BY salary, hobbies', 'GROUP BY column "hobbies" was not found in any tables'),
    
])
def test_negative_validation(change_test_dir, sql, except_msg):
    while(change_test_dir):
        with pytest.raises(Exception) as excinfo:
            validate_sql(sql)
        assert str(excinfo.value) == except_msg
