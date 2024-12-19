-- Insertion des données dans la table ARTICLE
INSERT INTO ARTICLE (idArticle, nomArticle) 
VALUES 
    (1, 'Article1'),
    (2, 'Article2'),
    (3, 'Article3'),
    (4, 'Article4'),
    (5, 'Article5');

-- Insertion des données dans la table UNIVERSITE
INSERT INTO UNIVERSITE (idUniversite, nomUniversite) 
VALUES 
    (6, 'Paris 6'),
    (9, 'Paris 9'),
    (13, 'Paris 13');

-- Insertion des données dans la table CHERCHEUR
INSERT INTO CHERCHEUR (idChercheur, nomChercheur, idArticle, idUniversite) 
VALUES 
    (1, 'Pierre', 1, 13),
    (2, 'Boutaina', 2, 9),
    (3, 'Laure', 3, 13),
    (4, 'Kais', 4, 6);
