DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_account_id NUMBER;
    v_balance NUMBER;
BEGIN
    FOR rec IN ApplyAnnualFee LOOP
        v_account_id := rec.AccountID;
        v_balance := rec.Balance;
        UPDATE Accounts
        SET Balance = v_balance - 100 
        WHERE AccountID = v_account_id;
    END LOOP;
    COMMIT;
END;