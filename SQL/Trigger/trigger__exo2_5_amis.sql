-- Créer un déclencheur qui supprime le lien d’amitié entre deux
-- personnes, si le lien de famille entre ces deux personnes est
-- supprimé. Si la paire (x, y) n’est plus dans FAMILLE, la
-- paire est automatiquement supprimée de AMI. Vérifier que le
-- déclencheur est correct en supprimant une paire qui existe
-- dans FAMILLE et dans AMI.

DELIMITER //
CREATE TRIGGER suppr_amis_when_famille_suppr
AFTER DELETE
ON famille 
FOR EACH ROW
BEGIN
	DELETE FROM ami 
    WHERE (idPersonne1 = OLD.idPersonne1 AND idPersonne2 = OLD.idPersonne2) 
	OR (idPersonne2 = OLD.idPersonne1 AND idPersonne1 = OLD.idPersonne2);
END //