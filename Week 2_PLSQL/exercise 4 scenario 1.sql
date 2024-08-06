CREATE OR REPLACE FUNCTION CalculateAge(
    birth_date IN DATE
) RETURN NUMBER AS
    current_date DATE;
    age NUMBER;
BEGIN
    current_date := SYSTIMESTAMP;
    age := FLOOR(MONTHS_BETWEEN(current_date, birth_date) / 12);
    RETURN age;
END CalculateAge;