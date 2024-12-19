DELIMITER //
CREATE TRIGGER contrainte_parking_prix
BEFORE INSERT ON appartement
FOR EACH ROW
BEGIN
	DECLARE parkingImmeuble INT;
    SET parkingImmeuble = (SELECT parkingPrivatif 
							FROM immeuble
							WHERE id = NEW.immeuble);
                            
	IF (parkingImmeuble = 0 OR parkingImmeuble IS NULL)
	THEN
		SET NEW.placeParking = 0;
		SET NEW.prixParking = NULL;
	END IF;
    
    IF EXISTS (SELECT NEW.superficie) 
    THEN
		SET NEW.superficie = 0;
	ELSEIF NOT EXISTS (SELECT NEW.superficie) 
    THEN
		SET NEW.superficie = 0;
	END IF;
    
END //