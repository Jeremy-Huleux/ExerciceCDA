DELIMITER //

CREATE TRIGGER after_sales_update 
AFTER UPDATE ON ventes
FOR EACH ROW
BEGIN
	IF NEW.quantity <> OLD.quantity THEN
		INSERT INTO VentesChanges(salesId, beforeQuantity, afterQuantity, changedAt)
        VALUES (OLD.id, OLD.quantity, NEW.quantity, (CURDATE()));
        END IF;
END //
