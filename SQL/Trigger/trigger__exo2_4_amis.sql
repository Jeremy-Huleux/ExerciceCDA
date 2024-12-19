-- Créer un déclencheur, qui avant l’insertion dans la table
-- FAMILLE d’une paire (x, y) vérifie que cette paire n’existe
-- pas dans la table FAMILLE, ni sous la forme (x, y) ni sous la
-- forme (y, x). Si la paire existe, elle n’est pas insérée et
-- un message d’erreur est retourné à l’utilisateur. Vérifier
-- que le déclencheur est correct en insérant une ligne
-- existante dans FAMILLE.
DELIMITER //
CREATE TRIGGER anti_doublon_famille
BEFORE INSERT 
ON famille
FOR EACH ROW
BEGIN
	IF EXISTS (	SELECT idPersonne1, idPersonne2 FROM famille
				WHERE (idPersonne1 = NEW.idPersonne1 AND idPersonne2 = NEW.idPersonne2) 
                OR (idPersonne2 = NEW.idPersonne1 AND idPersonne1 = NEW.idPersonne2))
	THEN
		SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "La paire de personne est deja enregistrer en tant que famille";
	END IF;
END //