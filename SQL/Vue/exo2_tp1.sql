CREATE VIEW bigSalesOrder
AS
SELECT 
	total, orderNumber
FROM
	salesperorder
WHERE total > 60000;
	