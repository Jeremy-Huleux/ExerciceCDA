DELIMITER //

CREATE TRIGGER before_sales_update
BEFORE UPDATE 
ON ventes
FOR EACH ROW
BEGIN
	DECLARE message VARCHAR(255);
	IF NEW.quantity > OLD.quantity*3 THEN
    SET message = CONCAT('La nouvelle quantité ', NEW.quantity ,  
						 ' ne peut être 3 fois supérieure à la quantité actuelle ', OLD.quantity , '.');
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = message;
	END IF;
END //