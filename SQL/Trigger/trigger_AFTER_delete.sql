DELIMITER //
CREATE TRIGGER after_salaires_delete
AFTER DELETE
ON salaires
FOR EACH ROW
BEGIN
	
	UPDATE salaireBudget
    SET total = total - OLD.salaire
    ORDER BY total ASC
    LIMIT 1;
    
END //