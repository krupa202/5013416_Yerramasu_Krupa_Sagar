ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);
DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;

    customer_rec customer_cursor%ROWTYPE;

BEGIN
    OPEN customer_cursor;

    LOOP
        FETCH customer_cursor INTO customer_rec;
        EXIT WHEN customer_cursor%NOTFOUND;

        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;

    CLOSE customer_cursor;
END;