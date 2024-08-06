CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    loan_amount IN NUMBER,
    interest_rate IN NUMBER,
    loan_duration IN NUMBER
) RETURN NUMBER AS
    monthly_installment NUMBER;
BEGIN
    monthly_installment := loan_amount * (interest_rate / 1200) * POWER(1 + interest_rate / 1200, loan_duration * 12) / (POWER(1 + interest_rate / 1200, loan_duration * 12) - 1);
    RETURN monthly_installment;
END CalculateMonthlyInstallment;