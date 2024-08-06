CREATE OR REPLACE FUNCTION HasSufficientBalance(
    account_id IN NUMBER,
    amount IN NUMBER
) RETURN BOOLEAN AS
    account_balance NUMBER;
BEGIN
    SELECT Balance INTO account_balance FROM Accounts WHERE AccountID = account_id;
    RETURN account_balance >= amount;
END HasSufficientBalance;