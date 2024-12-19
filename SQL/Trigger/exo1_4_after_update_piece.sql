DELIMITER //
CREATE TRIGGER maj_superficie_piece
AFTER UPDATE
ON piece
FOR EACH ROW
BEGIN
	IF EXISTS (SELECT NEW.superficie) THEN
		UPDATE appartement
        SET superficie = superficie - OLD.superficie + NEW.superficie
        WHERE num = OLD.appartement;
	END IF;
END //