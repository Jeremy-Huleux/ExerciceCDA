-- Création de la table ARTICLE
CREATE TABLE ARTICLE (
    idArticle INT AUTO_INCREMENT,
    nomArticle VARCHAR(255),
    PRIMARY KEY (idArticle)
);

-- Création de la table UNIVERSITE
CREATE TABLE UNIVERSITE (
    idUniversite INT AUTO_INCREMENT,
    nomUniversite VARCHAR(255),
    PRIMARY KEY (idUniversite)
);

-- Création de la table CHERCHEUR
CREATE TABLE CHERCHEUR (
    idChercheur INT AUTO_INCREMENT,
    nomChercheur VARCHAR(255),
    idArticle INT,
    idUniversite INT,
    PRIMARY KEY (idChercheur),
    FOREIGN KEY (idArticle) REFERENCES ARTICLE(idArticle),
    FOREIGN KEY (idUniversite) REFERENCES UNIVERSITE(idUniversite)
);