DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;

    loan_rec loan_cursor%ROWTYPE;
    customer_rec Customers%ROWTYPE;

BEGIN
    OPEN loan_cursor;

    LOOP
        FETCH loan_cursor INTO loan_rec;
        EXIT WHEN loan_cursor%NOTFOUND;

        SELECT * INTO customer_rec
        FROM Customers
        WHERE CustomerID = loan_rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan_rec.LoanID || ' for customer ' || customer_rec.Name || ' is due on ' || loan_rec.EndDate);
    END LOOP;

    CLOSE loan_cursor;
END;