DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_loan_id NUMBER;
    v_interest_rate NUMBER;
BEGIN
    FOR rec IN UpdateLoanInterestRates LOOP
        v_loan_id := rec.LoanID;
        v_interest_rate := rec.InterestRate;
        IF v_interest_rate < 5 THEN
            UPDATE Loans
            SET InterestRate = v_interest_rate + 0.5 
            WHERE LoanID = v_loan_id;
        END IF;
    END LOOP;
    COMMIT;
END;