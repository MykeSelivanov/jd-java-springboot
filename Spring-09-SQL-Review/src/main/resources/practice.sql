select *
from departments;

SELECT *
FROM employees;

SELECT *
FROM regions;

SELECT employee_id,first_name,department
FROM employees;

SELECT *
FROM employees
WHERE department = 'Sports';

SELECT *
FROM employees
WHERE department LIKE '%nit%';

SELECT *
FROM employees
WHERE salary<=100000;

SELECT *
FROM employees
WHERE department='Clothing'
AND salary>90000;

SELECT *
FROM employees
WHERE salary<40000
AND (department='Clothing'
OR department='Pharmacy');

SELECT *
FROM employees
WHERE department != 'Sports';

SELECT *
FROM employees
WHERE department <> 'Sports';

SELECT *
FROM employees
WHERE email IS NULL;

SELECT *
FROM employees
WHERE email IS NOT NULL;

SELECT *
FROM employees
WHERE department='Sports'
OR department='First Aid'
OR department='Toys'
OR department='Garden';

SELECT *
FROM employees
WHERE department IN('Sports','First Aid','Toys','Garden');

SELECT *
FROM employees
WHERE salary BETWEEN 80000 AND 100000;

SELECT first_name, email
FROM employees
WHERE gender='F'
AND department='Tools'
AND salary>110000;

SELECT first_name, hire_date
FROM employees
WHERE salary > 165000
OR (department='Sports'
AND gender='M');

SELECT *
FROM employees
ORDER BY employee_id DESC;

SELECT DISTINCT department
FROM employees;

SELECT DISTINCT department
FROM employees
FETCH FIRST 3 ROWS ONLY;

SELECT salary AS yearly_salary
FROM employees;

SELECT student_name, age
FROM students
ORDER BY 2 DESC
FETCH FIRST 4 ROWS ONLY;

SELECT *
FROM students
WHERE age <= 20 AND (student_no BETWEEN 3 AND 7 OR student_no = 7)
OR (age > 20 AND student_no >= 4);

-----Functions-----

SELECT upper(first_name), lower(department) department
FROM employees;

SELECT length(first_name)
FROM employees;

SELECT trim('   Hello There   ');

SELECT length(trim('   Hello There   '));

SELECT first_name || ' ' || last_name AS full_name
FROM employees;

SELECT (salary>140000)
FROM employees;

SELECT (salary>140000) AS highly_paid
FROM employees
ORDER BY salary DESC;

SELECT department,(department LIKE'%oth%')
FROM employees;

SELECT 'This is test data' test_data;

SELECT substring('this is test data' FROM 1 FOR 4) as test_data;

SELECT substring('this is test data' FROM 9) as test_data;

SELECT department,replace(department,'Clothing','Clothes')
FROM departments;

----- Grouping functions-----
SELECT max(salary)
FROM employees;

SELECT min(salary)
FROM employees;

SELECT avg(salary)
FROM employees;

SELECT round(avg(salary))
FROM employees;

SELECT count(employee_id)
FROM employees;

SELECT count(email)
FROM employees;

SELECT sum(salary)
FROM employees
WHERE department='Clothing';

SELECT last_name, upper(substring(department,1,3)) AS department, salary, hire_date
FROM professors;

SELECT max(salary) max_salary, min(salary) min_salary
FROM professors
WHERE last_name != 'Wilson';

SELECT count(*), department
FROM employees
GROUP BY department;

SELECT sum(salary) as total_salary,department
FROM employees
GROUP BY department;

SELECT min(salary) min_salary, max(salary) max_salary, avg(salary) avg_salary, count(*) total_number_employees, department
FROM employees
GROUP BY department;

SELECT sum(salary) as total_salary, department
FROM employees
WHERE region_id IN(4,5,6,7)
GROUP BY department;

SELECT department, count(*)
FROM employees
GROUP BY department
HAVING count(*)<36
ORDER BY department;

--show all unique domains and number of employees
SELECT count(*), substring(email,position('@' in email) + 1) email_domain
FROM employees
WHERE email iS NOT NULL
GROUP BY email_domain;

SELECT e.department
FROM employees e, departments d;

SELECT department
FROM departments;

-----Subquery-----

SELECT *
FROM employees
WHERE department NOT IN(SELECT department FROM departments);

SELECT *
FROM (SELECT * FROM employees WHERE salary>150000) a;

--Return all employees that work in electronic division
SELECT *
FROM employees
WHERE department IN (SELECT department FROM departments WHERE division='Electronics');

--Return all employees work in ASIA or CANADA make more than 130000
SELECT *
FROM employees
WHERE region_id IN (SELECT region_id FROM regions WHERE country IN('Asia', 'Canada'));

--First name where work in Asia or Canada and how much less making from the highest payed employee in the company
SELECT first_name, (SELECT max(salary) FROM employees) - salary
FROM employees
WHERE region_id IN (SELECT region_id FROM regions WHERE country IN('Asia', 'Canada'));

--Write the query that returns all of those employees that work in the kids division
-- and the dates at which those employees were hired is greater than
-- all of the hire_dates of employees who work in the maintenance department
SELECT *
FROM employees
WHERE department = ANY (SELECT department FROM departments WHERE division='Kids')
AND hire_date > ALL (SELECT hire_date FROM employees WHERE department='Maintenance');

--Write a query that returns the names of those students that are taking the courses Physics and US History
SELECT student_name
FROM students
WHERE student_no IN
      (SELECT student_no FROM student_enrollment WHERE course_no IN
               (SELECT course_no FROM courses WHERE course_title IN('Physics', 'US History')));

SELECT first_name, salary,
CASE
    WHEN salary<100000 THEN 'UNDER PAID'
    WHEN salary>100000 THEN 'PAID WELL'
    ELSE 'UNPAID'
END as category
FROM employees;

SELECT category, count(*)
FROM (SELECT first_name, salary,
             CASE
                 WHEN salary<100000 THEN 'UNDER PAID'
                 WHEN salary>100000 THEN 'PAID WELL'
                 ELSE 'UNPAID'
                 END as category
    FROM employees) a
GROUP BY category;

-----Joins-----
SELECT first_name,country
FROM employees e,regions r
WHERE r.region_id = e.employee_id;

SELECT first_name,email,division
FROM employees e, departments d, regions r
WHERE e.department = d.department
AND e.region_id = r.region_id;

SELECT first_name,country
FROM employees INNER JOIN regions
ON employees.region_id = regions.region_id;

SELECT first_name, email, division
FROM employees INNER JOIN departments
    ON employees.department = departments.department
WHERE email IS NOT NULL;

SELECT first_name,email,division,country
FROM employees e INNER JOIN departments d
ON e.department = d.department INNER JOIN regions r
ON e.region_id = r.region_id
WHERE email IS NOT NULL;

SELECT DISTINCT department FROM employees;--31
SELECT DISTINCT department FROM departments;--24

SELECT DISTINCT e.department, d.department
FROM employees e LEFT JOIN departments d
ON e.department = d.department;

SELECT DISTINCT e.department, d.department
FROM employees e RIGHT JOIN departments d
ON e.department = d.department;

SELECT DISTINCT e.department, d.department
FROM employees e FULL JOIN departments d
ON e.department = d.department;

-----Union-----
SELECT department
FROM employees
UNION
SELECT department
FROM departments;

SELECT department
FROM employees
UNION
SELECT department
FROM departments
UNION
SELECT country
FROM regions;

SELECT department
FROM employees
UNION ALL
SELECT department
FROM departments;

SELECT department
FROM employees
EXCEPT
SELECT department
FROM departments;

