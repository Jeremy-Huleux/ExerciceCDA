-- Créer un déclencheur qui après l’insertion d’une personne
-- dans la table PERSONNE, crée un lien d’amitié entre elle et
-- Elvia. Vérifier que le déclencheur est correct en insérant

-- une nouvelle personne et en vérifiant qu’elle devient amie
-- d’Elvia.

DELIMITER //
CREATE TRIGGER tous_amis_avec_Elvia
AFTER INSERT
ON personne
FOR EACH ROW
BEGIN
	INSERT INTO ami
    VALUES ((SELECT idPersonne
			FROM personne
			WHERE nomPersonne = 'Elvia'), NEW.idPersonne);
END //