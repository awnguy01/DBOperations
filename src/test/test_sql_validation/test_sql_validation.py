import os
import sys
sys.path.append('../..')
import pytest
from src.sql import validate_sql

@pytest.fixture(scope="function", autouse=True)
def change_test_dir(request):
    os.chdir(request.fspath.dirname)
    print('Switched to ' + str(request.fspath.dirname))
    yield
    os.chdir(request.config.invocation_dir)


@pytest.mark.parametrize(("sql, except_msg"), [
    ('SELECT * FROM bad', 'Source table "bad" not found in current working directory'),
    ('SELECT E.salary FROM employees_1', 'Table or alias "E" not found for projection or ref field "salary"'),
    (u'SELECT E1.#5 from employees_1 E1', 'Ref field "#5" is out of bounds for "E1"'),
    ('SELECT employees_1.hobbies FROM employees_1', 'Projection "hobbies" not found in table or alias "EMPLOYEES_1"'),
    ('SELECT E.hobbies FROM employees_1 E', 'Projection "hobbies" not found in table or alias "E"'),
    ('SELECT salary FROM employees_1, employees_2', 'Ambiguous projection or ref field "salary" found in multiple tables'),
    ('SELECT hobbies FROM employees_1, employees_2', 'Projection or ref field "hobbies" was not found in any tables'),
    ('SELECT salary FROM employees_1 GROUP BY age', 'Projection or ref field "salary" not found in GROUP BY clause'),
    (u'SELECT #1 FROM employees_1 GROUP BY #3', 'Projection or ref field "#1" not found in GROUP BY clause'),
    ('SELECT salary FROM employees_1 GROUP BY salary, E.hobbies', 'GROUP BY table or alias "E" not found for column or ref field "hobbies"'),
    (u'SELECT #2 FROM employees_1 GROUP BY #2, employees_1.#5','GROUP BY ref field "#5" is out of bounds for table or alias "EMPLOYEES_1"'),
    (u'SELECT #2 FROM employees_1 GROUP BY #2, #5','GROUP BY column or ref field "#5" was not found in any tables'),
    ('SELECT salary FROM employees_1 GROUP BY salary, employees_1.hobbies', 'GROUP BY column "hobbies" not found in table or alias "EMPLOYEES_1"'),
    ('SELECT salary FROM employees_1 E1 GROUP BY salary, E1.hobbies', 'GROUP BY column "hobbies" not found in table or alias "E1"'),
    ('SELECT employees_1.salary FROM employees_1, employees_2 GROUP BY salary', 'Ambiguous GROUP BY column or ref field "salary" found in multiple tables'),
    (u'SELECT employees_1.#1 FROM employees_1, employees_2 GROUP BY #1', 'Ambiguous GROUP BY column or ref field "#1" found in multiple tables'),
    ('SELECT salary FROM employees_1 GROUP BY salary, hobbies', 'GROUP BY column or ref field "hobbies" was not found in any tables'),
    
])
def test_negative_validation(sql, except_msg):
    with pytest.raises(Exception) as excinfo:
        validate_sql(sql)
    print(excinfo.value)
    assert str(excinfo.value) == except_msg
