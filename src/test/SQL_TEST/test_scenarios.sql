-- -only SELECT ... FROM .., one table, no WHERE.
SELECT
    last_name,
    first_name,
    title,
    salary
FROM
    EMPLOYEES;
-- -only SELECT ... FROM ..., two tables, no WHERE.
SELECT
    E.id,
    title,
    salary,
    D.name,
    city,
    state
FROM
    EMPLOYEES E
    INNER JOIN DEPARTMENTS D ON E.d_id == D.id
ORDER BY E.id;
-- -SELECT ... FROM ... WHERE ..., one table, simple condition (one column).
SELECT
    last_name,
    first_name,
    title,
    salary
FROM
    EMPLOYEES
WHERE
    SALARY > 85000;
-- -SELECT ... FROM ... WHERE ..., one table, complex condition (ands and ors). Note: Sai took care of this, you just want to make sure you are generating the right call.
SELECT
    last_name,
    first_name,
    title
FROM
    EMPLOYEES
WHERE
    age < 25
    AND salary > 75000
    OR age < 30
    AND salary > 85000;
-- -SELECT ... FROM ...  WHERE ...., two tables, no join.
SELECT
    last_name,
    first_name,
    title,
    age,
    D.name,
    city,
    state
FROM
    DEPARTMENTS D,
    EMPLOYEES E
WHERE
    E.d_id == D.id
    AND D.state == 'CA'
    AND E.age > 50
-- -SELECT ... FROM ... WHERE ..., two tables, join between them.
SELECT
    last_name,
    first_name,
    title,
    age,
    D.name,
    city,
    state
FROM
    DEPARTMENTS D
    RIGHT JOIN EMPLOYEES E ON E.d_no == D.id
WHERE
    D.state == 'CA'
    AND E.age > 50;
-- -SELECT ... FROM ... WHERE ... GROUP BY .., one table, simple aggregates.
SELECT
    title,
    max(age),
    avg(salary)
FROM
    EMPLOYEES
WHERE
    age > 30
GROUP BY
    title;
-- -SELECT ... FROM ... WHERE ... GROUP BY .., two tables, simple aggregates.
SELECT
    D.id,
    min(salary),
    max(salary)
FROM
    DEPARTMENTS D,
    EMPLOYEES E
WHERE
    E.age < 30
GROUP BY
    d_name