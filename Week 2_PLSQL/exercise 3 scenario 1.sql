CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE SavingsAccounts
    SET Balance = Balance * 1.01;
END ProcessMonthlyInterest;