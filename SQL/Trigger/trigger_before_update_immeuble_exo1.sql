DELIMITER //
CREATE TRIGGER contrainte_antisupperficie_update
BEFORE UPDATE 
ON appartement
FOR EACH ROW
BEGIN
	IF EXISTS (SELECT NEW.superficie) THEN
		SET NEW.superficie = OLD.superficie;
    END IF;
END //