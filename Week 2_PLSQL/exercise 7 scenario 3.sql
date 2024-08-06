CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenNewAccount(p_account_id NUMBER, p_customer_id NUMBER, p_balance NUMBER);
    PROCEDURE CloseAccount(p_account_id NUMBER);
    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER;
END AccountOperations;

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenNewAccount(p_account_id NUMBER, p_customer_id NUMBER, p_balance NUMBER) AS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, Balance)
        VALUES (p_account_id, p_customer_id, p_balance);
    END OpenNewAccount;

    PROCEDURE CloseAccount(p_account_id NUMBER) AS
    BEGIN
        UPDATE Accounts
        SET Status = 'Closed'
        WHERE AccountID = p_account_id;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER AS
        v_balance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;
        RETURN v_balance;
    END GetTotalBalance;
END AccountOperations;