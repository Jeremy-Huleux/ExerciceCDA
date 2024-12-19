CREATE VIEW customerOrderStats
AS
SELECT customerName, COUNT(total) AS orderCount
FROM
	salesPerOrder
JOIN
	customers c USING (customerNumber)
GROUP BY customerName
ORDER BY orderCount;
