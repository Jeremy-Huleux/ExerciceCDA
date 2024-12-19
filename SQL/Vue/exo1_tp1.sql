CREATE VIEW salesPerOrder
AS
SELECT SUM(quantityOrdered * priceEach) AS total, o.orderNumber, o.customerNumber 
FROM orderdetails
JOIN 
	orders o USING (orderNumber)
GROUP BY o.orderNumber;