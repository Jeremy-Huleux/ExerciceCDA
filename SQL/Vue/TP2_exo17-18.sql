-- CREATE VIEW articlesChercheur
-- AS
-- SELECT nomChercheur, COUNT(a.nomArticle) AS quantite
-- FROM chercheur
-- JOIN 
-- 	ARTICLE a USING (idArticle)
-- GROUP BY nomChercheur;

-- 	SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

-- CREATE VIEW articlesUniversite
-- AS
-- SELECT u.nomUniversite, c.nomChercheur, COUNT(a.nomArticle) AS TotalArticle
-- FROM chercheur c
-- JOIN
-- 	universite u ON u.idUniversite = c.idUniversite
-- JOIN
-- 	article a ON c.idArticle = a.idArticle
-- GROUP BY u.nomUniversite;

SELECT * FROM articlesUniversite;

