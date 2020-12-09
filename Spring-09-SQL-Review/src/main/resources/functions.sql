CREATE OR REPLACE function get_department_count_by_name(dep_name varchar)
    returns int
    language plpgsql
as
$$
declare
    department_count integer;
begin
    SELECT count(*)
    INTO department_count
    FROM employees
    WHERE department=dep_name;

    return department_count;
end;
$$;

SELECT get_department_count_by_name('Sports');

CREATE OR REPLACE function get_department(p_pattern varchar)
    returns table(
                     employee_name varchar,
                     employee_email varchar
                 )
    language plpgsql
as
$$
begin
    return query
        SELECT first_name, email
        FROM employees
        WHERE department ILIKE p_pattern;
end;
$$;

SELECT *
FROM get_department('%othi%');

DROP FUNCTION get_department(p_pattern varchar);