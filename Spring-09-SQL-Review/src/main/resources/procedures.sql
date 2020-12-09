CREATE OR REPLACE PROCEDURE update_department(emp_id int)
language plpgsql
as
    $$
    declare
    begin
        update employees set department = 'Toys' where employee_id=emp_id;
        commit;
    end
    $$;

call update_department(1);

SELECT *
FROM employees
WHERE employee_id=1;

CREATE OR REPLACE procedure transfer(
    sender int,
    receiver int,
    amoount dec
)
language plpgsql
as
$$
    declare
    begin

        update employees
        set salary = salary - amoount
        where employee_id=sender;

        update employees
        set salary = salary + amoount
        where employee_id=receiver;

        commit;

    end;
$$;

call transfer(1,2,44000);

SELECT *
FROM employees
ORDER BY employee_id;