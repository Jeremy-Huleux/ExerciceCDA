DELIMITER //

CREATE TRIGGER after_members_insert
AFTER INSERT ON members
FOR EACH ROW
BEGIN
	IF NEW.birthday IS NULL
    THEN
		INSERT INTO reminders(memberId, message)
        VALUES(NEW.id, CONCAT("Bonjour " , NEW.name , ", veuillez mettre à jour votre date de naissance."));
	END IF;
END//