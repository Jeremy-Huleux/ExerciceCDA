CREATE VIEW aboveAvgProducts
AS 
SELECT productCode, productName, buyPrice
FROM products
WHERE buyPrice > (SELECT AVG(buyPrice) FROM products)
ORDER BY buyPrice DESC;
	