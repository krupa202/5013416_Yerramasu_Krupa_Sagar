-- Scenario 2: Promote customers to vip status based on their balance
DECLARE
    v_customer_id NUMBER;
    v_balance NUMBER;

BEGIN
    FOR cur_customer IN (SELECT CustomerID, Balance FROM Customers) LOOP
        v_customer_id := cur_customer.CustomerID;
        v_balance := cur_customer.Balance;

        IF v_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;
END;