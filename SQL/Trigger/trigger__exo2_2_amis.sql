-- Créer un déclencheur qui avant l’insertion d’une personne
-- dans la table PERSONNE, vérifie que son nom n’existe pas. Si
-- le nom existe, un message d’erreur est retourné à
-- l’utilisateur. Vérifier que le déclencheur est correct en
-- insérant la ligne (18, ’Elvia’, 28) dans la table PERSONNE.

DELIMITER //
CREATE TRIGGER verif_exist_nom
BEFORE INSERT
ON personne
FOR EACH ROW
BEGIN
	IF EXISTS (SELECT nomPersonne 
				FROM personne
                WHERE nomPersonne LIKE NEW.nomPersonne) 
	THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = "La personne existe deja dans la base";
	END IF;
END //