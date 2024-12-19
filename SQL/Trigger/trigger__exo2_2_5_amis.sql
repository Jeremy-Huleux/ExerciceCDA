-- 3. Créer un déclencheur qui implémente la cascade des mises à
-- jour à partir de la table PERSONNE vers la table AMI. Si
-- l’identifiant d’une personne x change et qu’elle existe dans
-- la table AMI, son identifiant est automatiquement mis à jour.

DELIMITER €€
CREATE TRIGGER maj_idPersonne_personne
BEFORE UPDATE
ON personne
FOR EACH ROW
BEGIN
	DECLARE idPersonne11 INT;
	DECLARE idPersonne22 INT;
	IF NEW.idPersonne <> OLD.idPersonne
    THEN
		IF EXISTS (SELECT idPersonne1 FROM ami WHERE idPersonne1 = OLD.idPersonne) -- si idPersonne existe en tant que idPersonne1
		THEN
			SET @skip_trigger_ami = TRUE;
			SET idPersonne22 = (SELECT idPersonne2 FROM ami WHERE idPersonne1 = OLD.idPersonne); -- On récupére la variable idPersonne2

			INSERT INTO ami
            VALUES (NEW.idPersonne, (idPersonne22)); -- on insert la nouveau lien (nouveau idPersonne, avec ancien idpersonne2)
            
			DELETE FROM ami -- On supprime le lien obselete ancien idPersonne1 Selectionner au dessus
			WHERE idPersonne1 = OLD.idPersonne;
            
        END IF;
        
        IF EXISTS (SELECT idPersonne2 FROM ami WHERE idPersonne2 = OLD.idPersonne) -- si idPersonne existe en tant que idPersonne2
		THEN
			SET @skip_trigger_ami = TRUE;
			SET idPersonne11 = (SELECT idPersonne1 FROM ami WHERE idPersonne2 = OLD.idPersonne); -- On récupére la variable idPersonne1

            INSERT INTO ami
            VALUES ((idPersonne11), NEW.idPersonne); -- on insert la nouveau lien (ancien idPersonne1 , avec nouveau idpersonne)
            
			DELETE FROM ami -- On supprime le lien obselete ancien idPersonne1 Selectionner au dessus
			WHERE idPersonne2 = OLD.idPersonne;
            
        END IF;
        
        -- même chose pour famille sinon l'update ne fonctionne pas
        IF EXISTS (SELECT idPersonne1 FROM famille WHERE idPersonne1 = OLD.idPersonne) -- si idPersonne existe en tant que idPersonne1
		THEN
			SET @skip_trigger_ami = TRUE;
			SET idPersonne22 = (SELECT idPersonne2 FROM famille WHERE idPersonne1 = OLD.idPersonne);
			INSERT INTO famille
            VALUES (NEW.idPersonne, (idPersonne22)); -- on insert la nouveau lien (nouveau idPersonne, avec ancien idpersonne2)
            
			DELETE FROM famille -- On supprime le lien obselete ancien idPersonne1 Selectionner au dessus
			WHERE idPersonne1 = OLD.idPersonne;
            
            
        END IF;
        IF EXISTS (SELECT idPersonne2 FROM famille WHERE idPersonne2 = OLD.idPersonne) -- si idPersonne existe en tant que idPersonne2
		THEN
			SET @skip_trigger_ami = TRUE;
			SET idPersonne11 = (SELECT idPersonne1 FROM famille WHERE idPersonne2 = OLD.idPersonne);
			INSERT INTO famille
            VALUES ((idPersonne11), NEW.idPersonne); -- on insert la nouveau lien (ancien idPersonne1 , avec nouveau idpersonne)
            
			DELETE FROM famille -- On supprime le lien obselete ancien idPersonne1 Selectionner au dessus
			WHERE idPersonne2 = OLD.idPersonne;
            
        END IF;
	END IF;
END €€