CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer(p_customer_id NUMBER, p_first_name VARCHAR2, p_last_name VARCHAR2, p_email VARCHAR2, p_phone NUMBER);
    PROCEDURE UpdateCustomerDetails(p_customer_id NUMBER, p_first_name VARCHAR2, p_last_name VARCHAR2, p_email VARCHAR2, p_phone NUMBER);
    FUNCTION GetCustomerBalance(p_customer_id NUMBER) RETURN NUMBER;
END CustomerManagement;

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddNewCustomer(p_customer_id NUMBER, p_first_name VARCHAR2, p_last_name VARCHAR2, p_email VARCHAR2, p_phone NUMBER) AS
    BEGIN
        INSERT INTO Customers (CustomerID, FirstName, LastName, Email, Phone)
        VALUES (p_customer_id, p_first_name, p_last_name, p_email, p_phone);
    END AddNewCustomer;

    PROCEDURE UpdateCustomerDetails(p_customer_id NUMBER, p_first_name VARCHAR2, p_last_name VARCHAR2, p_email VARCHAR2, p_phone NUMBER) AS
    BEGIN
        UPDATE Customers
        SET FirstName = p_first_name, LastName = p_last_name, Email = p_email, Phone = p_phone
        WHERE CustomerID = p_customer_id;
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(p_customer_id NUMBER) RETURN NUMBER AS
        v_balance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;
        RETURN v_balance;
    END GetCustomerBalance;
END CustomerManagement;