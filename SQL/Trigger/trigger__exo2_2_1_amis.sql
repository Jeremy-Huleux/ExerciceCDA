-- 1. Supprimer les clés étrangères de la table AMI.
-- 2. Créer un déclencheur qui implémente le comportement des clés
-- étrangères supprimées par la requête précédente. Si une paire
-- (x, y) est insérée dans AMI, le déclencheur s’assure que x et
-- y se trouvent dans PERSONNE.

DELIMITER $$
CREATE TRIGGER verif_exists_personne
BEFORE INSERT
ON ami
FOR EACH ROW
BEGIN
	
	DECLARE message VARCHAR(100);
	IF @skip_trigger_ami IS NULL 
	THEN
		IF NOT EXISTS (	SELECT idPersonne
						FROM personne
						WHERE idPersonne = NEW.idPersonne1)
		THEN
			SET message = CONCAT("La personne ", NEW.idPersonne1, " n'éxiste pas dans la base");
			SIGNAL SQLSTATE "45000"
				SET MESSAGE_TEXT = message; 
		END IF;
		IF NOT EXISTS (	SELECT idPersonne
						FROM personne
						WHERE idPersonne = NEW.idPersonne2)
		THEN
			SET message = CONCAT("La personne ", NEW.idPersonne2, " n'éxiste pas dans la base");
			SIGNAL SQLSTATE "45000"
				SET MESSAGE_TEXT = message; 
		END IF;
    END IF;
END $$