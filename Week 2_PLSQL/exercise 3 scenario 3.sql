CREATE OR REPLACE PROCEDURE TransferFunds(
    source_account_number IN NUMBER,
    target_account_number IN NUMBER,
    transfer_amount IN NUMBER
) AS
    source_balance NUMBER;
    target_balance NUMBER;
BEGIN
    SELECT Balance INTO source_balance FROM Accounts WHERE AccountNumber = source_account_number;
    SELECT Balance INTO target_balance FROM Accounts WHERE AccountNumber = target_account_number;

    IF source_balance < transfer_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - transfer_amount
    WHERE AccountNumber = source_account_number;

    UPDATE Accounts
    SET Balance = Balance + transfer_amount
    WHERE AccountNumber = target_account_number;
END TransferFunds;