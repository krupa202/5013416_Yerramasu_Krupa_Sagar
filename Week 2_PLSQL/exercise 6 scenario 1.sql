DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT DISTINCT C.CustomerID, C.FirstName, C.LastName, T.TransactionID, T.TransactionType, T.Amount, T.TransactionDate
        FROM Customers C
        JOIN Transactions T ON C.CustomerID = T.CustomerID
        WHERE EXTRACT(MONTH FROM T.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        ORDER BY C.CustomerID, T.TransactionDate;

    v_customer_id NUMBER;
    v_first_name VARCHAR2(50);
    v_last_name VARCHAR2(50);
    v_transaction_id NUMBER;
    v_transaction_type VARCHAR2(50);
    v_amount NUMBER;
    v_transaction_date DATE;
BEGIN
    FOR rec IN GenerateMonthlyStatements LOOP
        IF v_customer_id IS NULL THEN
            v_customer_id := rec.CustomerID;
            v_first_name := rec.FirstName;
            v_last_name := rec.LastName;
            DBMS_OUTPUT.PUT_LINE('Monthly Statement for ' || v_first_name || ' ' || v_last_name);
            DBMS_OUTPUT.PUT_LINE('-----------------------------------');
        END IF;
        IF rec.TransactionType = 'Deposit' THEN
            v_amount := rec.Amount;
            DBMS_OUTPUT.PUT_LINE('Deposit: $' || v_amount || ' on ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY'));
        ELSIF rec.TransactionType = 'Withdrawal' THEN
            v_amount := -rec.Amount;
            DBMS_OUTPUT.PUT_LINE('Withdrawal: $' || v_amount || ' on ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY'));
        END IF;
        v_transaction_id := rec.TransactionID;
        v_transaction_date := rec.TransactionDate;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('End of Statement for ' || v_first_name || ' ' || v_last_name);
END;