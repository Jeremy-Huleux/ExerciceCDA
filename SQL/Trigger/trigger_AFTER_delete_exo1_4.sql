DELIMITER //
CREATE TRIGGER update_appartement_when_delete_piece
AFTER DELETE 
ON piece
FOR EACH ROW
BEGIN
	UPDATE appartement
    SET superficie = superficie - OLD.superficie
    WHERE num = OLD.appartement;
END //
