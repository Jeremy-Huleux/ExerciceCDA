-- Créer un déclencheur qui après l’insertion de deux personnes
-- dans la table FAMILLE, crée un lien d’amitié entre ces deux
-- personnes, s’il n’existe pas déjà. Si on insère la paire
-- (x,y) dans la table FAMILLE, on doit retrouver soit la paire
-- (x, y), soit la paire (y, x) dans la table AMI. Vérifier que
-- le déclencheur est correct en insérant une nouvelle ligne
-- dans FAMILLE.

DELIMITER //
CREATE TRIGGER insert_famille_deviens_amis
AFTER INSERT
ON famille
FOR EACH ROW
BEGIN
	IF EXISTS (SELECT NEW.idPersonne1) AND (SELECT NEW.idPersonne2)
    THEN
		IF NOT EXISTS (	SELECT idPersonne1, idPersonne2 
						FROM ami
						WHERE (idPersonne1 = NEW.idPersonne1 AND idPersonne2 = NEW.idPersonne2) 
                        OR (idPersonne1 = NEW.idPersonne2 AND idPersonne2 = NEW.idPersonne1)) 
                        THEN
							INSERT INTO ami
							VALUES (NEW.idPersonne1, NEW.idPersonne2);
		END IF;
	END IF;
END //