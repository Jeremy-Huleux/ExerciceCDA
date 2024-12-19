DELIMITER //
CREATE TRIGGER add_piece_sum
AFTER INSERT 
ON piece
FOR EACH ROW
BEGIN
		UPDATE appartement
		SET superficie = superficie + NEW.superficie
		WHERE num = NEW.appartement;
END //