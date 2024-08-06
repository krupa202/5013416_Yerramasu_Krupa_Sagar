CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireNewEmployee(p_employee_id NUMBER, p_first_name VARCHAR2, p_last_name VARCHAR2, p_job_title VARCHAR2, p_salary NUMBER);
    PROCEDURE UpdateEmployeeDetails(p_employee_id NUMBER, p_first_name VARCHAR2, p_last_name VARCHAR2, p_job_title VARCHAR2, p_salary NUMBER);
    FUNCTION CalculateAnnualSalary(p_employee_id NUMBER) RETURN NUMBER;
END EmployeeManagement;

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireNewEmployee(p_employee_id NUMBER, p_first_name VARCHAR2, p_last_name VARCHAR2, p_job_title VARCHAR2, p_salary NUMBER) AS
    BEGIN
        INSERT INTO Employees (EmployeeID, FirstName, LastName, JobTitle, Salary)
        VALUES (p_employee_id, p_first_name, p_last_name, p_job_title, p_salary);
    END HireNewEmployee;

    PROCEDURE UpdateEmployeeDetails(p_employee_id NUMBER, p_first_name VARCHAR2, p_last_name VARCHAR2, p_job_title VARCHAR2, p_salary NUMBER) AS
    BEGIN
        UPDATE Employees
        SET FirstName = p_first_name, LastName = p_last_name, JobTitle = p_job_title, Salary = p_salary
        WHERE EmployeeID = p_employee_id;
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(p_employee_id NUMBER) RETURN NUMBER AS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;
        RETURN v_salary * 12;
    END CalculateAnnualSalary;
END EmployeeManagement;