CREATE OR REPLACE PROCEDURE UpdateSalary(
    employee_id IN NUMBER,
    percentage_increase IN NUMBER
) AS
BEGIN
    DECLARE
        employee_not_found EXCEPTION;
        PRAGMA EXCEPTION_INIT(employee_not_found, -20005);

    BEGIN
        IF percentage_increase <= 0 THEN
            RAISE_APPLICATION_ERROR(-20006, 'Percentage increase must be greater than zero.');
        END IF;

        UPDATE Employees
        SET Salary = Salary * (1 + percentage_increase / 100)
        WHERE EmployeeID = employee_id;

        IF SQL%ROWCOUNT = 0 THEN
            RAISE employee_not_found;
        END IF;

        COMMIT;

    EXCEPTION
        WHEN employee_not_found THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee not found.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;
END UpdateSalary;