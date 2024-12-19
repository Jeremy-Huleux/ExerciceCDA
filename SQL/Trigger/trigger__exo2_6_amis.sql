-- Créer un déclencheur qui supprime toutes les références à une
-- personne dans la table FAMILLE et 2dans la table AMI si cette
-- personne est supprimée.
DELIMITER €€
CREATE TRIGGER delete_on_cascade_personne
BEFORE DELETE
ON personne
FOR EACH ROW
BEGIN
	IF EXISTS (	SELECT idPersonne1, idPersonne2 FROM famille
				WHERE OLD.idPersonne = idPersonne1 OR OLD.idPersonne = idPersonne2)
	THEN
		DELETE FROM famille
        WHERE idPersonne1 = OLD.idPersonne 
        OR idPersonne2 = OLD.idPersonne;
	END IF;
	IF EXISTS (	SELECT idPersonne1, idPersonne2 FROM ami
				WHERE OLD.idPersonne = idPersonne1 OR OLD.idPersonne = idPersonne2)
	THEN
		DELETE FROM ami
        WHERE idPersonne1 = OLD.idPersonne 
        OR idPersonne2 = OLD.idPersonne;
	END IF;
END €€