CREATE OR REPLACE PROCEDURE AddNewCustomer(
    customer_id IN NUMBER,
    name IN VARCHAR2,
    email IN VARCHAR2
) AS
    duplicate_customer EXCEPTION;
    PRAGMA EXCEPTION_INIT(duplicate_customer, -20007);
BEGIN
    BEGIN
        INSERT INTO Customers (CustomerID, Name, Email)  -- Assuming Email is the correct column name
        VALUES (customer_id, name, email);

        COMMIT;

    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            RAISE duplicate_customer;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;

    EXCEPTION
        WHEN duplicate_customer THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer with the same ID already exists.');
END AddNewCustomer;