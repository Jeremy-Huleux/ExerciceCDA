CREATE VIEW customersOrders
AS
SELECT customerName, SUM(s.total) AS total_commande
FROM customers
INNER JOIN
	salesPerOrder s USING (customerNumber)
GROUP BY customerName;