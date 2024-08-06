CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, TransactionType, Amount, LogDate)
    VALUES (:NEW.TransactionID, :NEW.TransactionType, :NEW.Amount, SYSTIMESTAMP);
END LogTransaction;