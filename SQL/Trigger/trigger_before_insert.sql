DELIMITER //
CREATE TRIGGER before_workcenters_insert
BEFORE INSERT
ON WorkCenters
FOR EACH ROW
BEGIN
	IF EXISTS (SELECT count(*) 
		FROM WorkCenterStats) 
		THEN
			UPDATE WorkCenterStats
			SET totalCapacity = NEW.capacity + totalCapacity 
			WHERE totalCapacity IS NOT NULL;
	ELSEIF NOT EXISTS (SELECT count(*) 
		FROM WorkCenterStats) 
		THEN
			INSERT INTO WorkCenterStats(totalCapacity)
			VALUES (NEW.capacity);
	END IF;
END //