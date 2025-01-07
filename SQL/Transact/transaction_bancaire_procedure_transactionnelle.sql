DELIMITER //

CREATE PROCEDURE transfer(	IN sender_id INT,
							IN receiver_id INT,
							IN amount DECIMAL(10,2))
BEGIN
	DECLARE rollback_message VARCHAR(255) DEFAULT 'Transaction annulée : Fonds insuffisants';
	DECLARE commit_message VARCHAR(255) DEFAULT 'Transaction réalisée avec succès';
	-- Démarrer la transaction
	START TRANSACTION;

		-- Tentative de débit sur le compte 1
		UPDATE accounts SET balance = balance - amount WHERE
		account_id = sender_id;

		-- Tentative de crédit sur le compte 2
		UPDATE accounts SET balance = balance + amount WHERE
		account_id = receiver_id;

		-- Vérifier si le compte 1 est suffisamment approvisionné
		-- Simuler une situation d'insuffisance de fonds
		IF (SELECT balance FROM accounts WHERE account_id = sender_id) < 0 
		THEN
		-- Annuler la transaction en cas d'insuffisance de fonds
			ROLLBACK;
			SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = rollback_message;
		ELSE
		-- Enregistrer les transactions si les fonds sont suffisants
			INSERT INTO transactions (account_id, amount, transaction_type) VALUES (sender_id, amount, 'RETRAIT');
			INSERT INTO transactions (account_id, amount, transaction_type) VALUES (receiver_id, amount, 'DEPOT');

		-- Valider la transaction
			COMMIT;
			SELECT commit_message AS 'Result';
	END IF;
END //

