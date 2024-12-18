USE classicmodels;
DELIMITER //
CREATE TRIGGER before_salaire_delete
BEFORE DELETE 
ON Salaires
FOR EACH ROW
BEGIN
	INSERT INTO salairesArchive(employeeNumber, validFrom, amount, deletedAt)
    VALUES (OLD.employeeNumber, OLD.validFrom, OLD.amount, CURDATE());
END //
