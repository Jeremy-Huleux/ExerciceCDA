-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: edlb
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adresse` (
  `idAdresse` bigint NOT NULL AUTO_INCREMENT,
  `Numero` int DEFAULT NULL,
  `Rue` varchar(50) DEFAULT NULL,
  `Ville` varchar(50) DEFAULT NULL,
  `Departement` varchar(50) DEFAULT NULL,
  `Pays` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idAdresse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresse`
--

LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorie` (
  `idCategorie` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chien`
--

DROP TABLE IF EXISTS `chien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chien` (
  `idChien` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `numeroLOF` varchar(100) DEFAULT NULL,
  `numeroICAD` varchar(100) DEFAULT NULL,
  `poids` decimal(15,2) DEFAULT NULL,
  `codeChien` varchar(50) DEFAULT NULL,
  `dateNaissance` date DEFAULT NULL,
  `dateModif` datetime DEFAULT NULL,
  `idUtilisateur` bigint DEFAULT NULL,
  `idPortee` bigint NOT NULL,
  PRIMARY KEY (`idChien`),
  KEY `idUtilisateur` (`idUtilisateur`),
  KEY `idPortee` (`idPortee`),
  CONSTRAINT `chien_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`),
  CONSTRAINT `chien_ibfk_2` FOREIGN KEY (`idPortee`) REFERENCES `portee` (`idPortee`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chien`
--

LOCK TABLES `chien` WRITE;
/*!40000 ALTER TABLE `chien` DISABLE KEYS */;
/*!40000 ALTER TABLE `chien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chien_media`
--

DROP TABLE IF EXISTS `chien_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chien_media` (
  `idChien` bigint NOT NULL,
  `idMedia` bigint NOT NULL,
  PRIMARY KEY (`idChien`,`idMedia`),
  KEY `idMedia` (`idMedia`),
  CONSTRAINT `chien_media_ibfk_1` FOREIGN KEY (`idChien`) REFERENCES `chien` (`idChien`),
  CONSTRAINT `chien_media_ibfk_2` FOREIGN KEY (`idMedia`) REFERENCES `media` (`idMedia`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chien_media`
--

LOCK TABLES `chien_media` WRITE;
/*!40000 ALTER TABLE `chien_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `chien_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commande` (
  `idCommande` bigint NOT NULL AUTO_INCREMENT,
  `statut` char(50) DEFAULT NULL,
  `tracking` varchar(150) DEFAULT NULL,
  `modeLivraison` varchar(150) DEFAULT NULL,
  `dateCreation` datetime DEFAULT NULL,
  `numeroCommande` varchar(50) DEFAULT NULL,
  `idAdresse` bigint NOT NULL,
  `idUtilisateur` bigint NOT NULL,
  PRIMARY KEY (`idCommande`),
  KEY `idAdresse` (`idAdresse`),
  KEY `idUtilisateur` (`idUtilisateur`),
  CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`idAdresse`) REFERENCES `adresse` (`idAdresse`),
  CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`),
  CONSTRAINT `commande_chk_1` CHECK ((`statut` in (_utf8mb4'En préparation',_utf8mb4'Livré',_utf8mb4'En livraison',_utf8mb4'Commandé',_utf8mb4'Panier',_utf8mb4'Annulé',_utf8mb4'En attente')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande_produit`
--

DROP TABLE IF EXISTS `commande_produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commande_produit` (
  `idProduit` bigint NOT NULL,
  `idCommande` bigint NOT NULL,
  PRIMARY KEY (`idProduit`,`idCommande`),
  KEY `idCommande` (`idCommande`),
  CONSTRAINT `commande_produit_ibfk_1` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`),
  CONSTRAINT `commande_produit_ibfk_2` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`idCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande_produit`
--

LOCK TABLES `commande_produit` WRITE;
/*!40000 ALTER TABLE `commande_produit` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande_produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `media` (
  `idMedia` bigint NOT NULL AUTO_INCREMENT,
  `type` char(50) DEFAULT NULL,
  `nomMedia` varchar(50) DEFAULT NULL,
  `dateUpload` datetime DEFAULT NULL,
  `commentaireMedia` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idMedia`),
  CONSTRAINT `media_chk_1` CHECK ((`type` in (_utf8mb4'photo',_utf8mb4'document',_utf8mb4'avatar',_utf8mb4'PP')))
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
INSERT INTO `media` VALUES (1,'avatar','default-profile.png','2023-01-15 14:32:00','Image de profil par défaut'),(2,'avatar','profile1.png','2023-02-20 09:15:00','Image de profil de Sophie'),(3,'avatar','profile2.png','2023-03-12 10:45:00','Image de profil de Luc'),(4,'avatar','profile3.png','2023-04-05 17:00:00','Image de profil d\'Emma'),(5,'avatar','profile4.png','2023-05-17 11:30:00','Image de profil de Thomas'),(6,'avatar','profile5.png','2023-06-22 08:25:00','Image de profil de Camille'),(7,'avatar','profile6.png','2023-07-14 09:00:00','Image de profil de Julie'),(8,'avatar','profile7.png','2023-08-03 15:40:00','Image de profil de Louis'),(9,'avatar','profile8.png','2023-09-10 16:30:00','Image de profil d\'Alice'),(10,'avatar','profile9.png','2023-10-21 11:20:00','Image de profil de Hugo');
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paiement`
--

DROP TABLE IF EXISTS `paiement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paiement` (
  `idPaiement` bigint NOT NULL AUTO_INCREMENT,
  `type` char(50) DEFAULT NULL,
  `datePaiement` datetime DEFAULT NULL,
  `idCommande` bigint NOT NULL,
  PRIMARY KEY (`idPaiement`),
  UNIQUE KEY `idCommande` (`idCommande`),
  CONSTRAINT `paiement_ibfk_1` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`idCommande`),
  CONSTRAINT `paiement_chk_1` CHECK ((`type` in (_utf8mb4'Paypal',_utf8mb4'Carte Bleu',_utf8mb4'Liquide')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paiement`
--

LOCK TABLES `paiement` WRITE;
/*!40000 ALTER TABLE `paiement` DISABLE KEYS */;
/*!40000 ALTER TABLE `paiement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portee`
--

DROP TABLE IF EXISTS `portee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `portee` (
  `idPortee` bigint NOT NULL AUTO_INCREMENT,
  `numeroLOF` varchar(50) DEFAULT NULL,
  `numeroPortee` varchar(50) DEFAULT NULL,
  `dateSaillie` date DEFAULT NULL,
  `dateNaissance` date DEFAULT NULL,
  PRIMARY KEY (`idPortee`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portee`
--

LOCK TABLES `portee` WRITE;
/*!40000 ALTER TABLE `portee` DISABLE KEYS */;
INSERT INTO `portee` VALUES (1,'dqzdqdzd','1','2024-11-01','2025-01-16');
/*!40000 ALTER TABLE `portee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portee_media`
--

DROP TABLE IF EXISTS `portee_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `portee_media` (
  `idPortee` bigint NOT NULL,
  `idMedia` bigint NOT NULL,
  PRIMARY KEY (`idPortee`,`idMedia`),
  KEY `idMedia` (`idMedia`),
  CONSTRAINT `portee_media_ibfk_1` FOREIGN KEY (`idPortee`) REFERENCES `portee` (`idPortee`),
  CONSTRAINT `portee_media_ibfk_2` FOREIGN KEY (`idMedia`) REFERENCES `media` (`idMedia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portee_media`
--

LOCK TABLES `portee_media` WRITE;
/*!40000 ALTER TABLE `portee_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `portee_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferenceutilisateur`
--

DROP TABLE IF EXISTS `preferenceutilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preferenceutilisateur` (
  `idPreferenceUtilisateur` bigint NOT NULL AUTO_INCREMENT,
  `notificationPublication` tinyint(1) DEFAULT '1',
  `notificationPub` tinyint(1) DEFAULT '0',
  `modeSombre` tinyint(1) DEFAULT '0',
  `notificationMessage` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idPreferenceUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferenceutilisateur`
--

LOCK TABLES `preferenceutilisateur` WRITE;
/*!40000 ALTER TABLE `preferenceutilisateur` DISABLE KEYS */;
INSERT INTO `preferenceutilisateur` VALUES (1,0,1,1,1),(2,1,1,0,1),(3,1,0,1,0),(4,0,1,0,1),(5,1,0,1,1),(6,0,0,1,1),(7,1,0,0,1),(8,1,1,0,0),(9,1,0,1,1),(10,1,1,1,0),(11,1,0,0,1),(12,1,0,0,1),(13,1,0,0,1),(14,1,0,0,1),(15,1,0,0,1),(16,1,0,0,1),(17,1,0,0,1),(18,1,0,0,1),(19,1,0,0,1),(20,1,0,0,1),(21,1,0,0,1),(22,1,0,0,1),(23,1,0,0,1),(24,1,0,0,1),(25,1,0,0,1),(26,1,0,0,1),(27,1,0,0,1),(28,1,0,0,1),(29,1,0,0,1),(30,1,0,0,1),(31,1,0,0,1),(32,1,0,0,1),(33,1,0,0,1),(34,1,0,0,1),(35,1,0,0,1),(36,1,0,0,1),(37,1,0,0,1),(38,1,0,0,1),(39,1,0,0,1),(40,1,0,0,1),(41,1,0,0,1),(42,1,0,0,1),(43,1,0,0,1),(44,1,0,0,1),(45,1,0,0,1);
/*!40000 ALTER TABLE `preferenceutilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit` (
  `idProduit` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prix` decimal(15,2) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `dateCreation` datetime DEFAULT NULL,
  `dateMiseEnVente` datetime DEFAULT NULL,
  `affichage` tinyint(1) DEFAULT NULL,
  `descriptionProduit` text,
  `dateModif` datetime DEFAULT NULL,
  PRIMARY KEY (`idProduit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit_categorie`
--

DROP TABLE IF EXISTS `produit_categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit_categorie` (
  `idProduit` bigint NOT NULL,
  `idCategorie` bigint NOT NULL,
  PRIMARY KEY (`idProduit`,`idCategorie`),
  KEY `idCategorie` (`idCategorie`),
  CONSTRAINT `produit_categorie_ibfk_1` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`),
  CONSTRAINT `produit_categorie_ibfk_2` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit_categorie`
--

LOCK TABLES `produit_categorie` WRITE;
/*!40000 ALTER TABLE `produit_categorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `produit_categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit_media`
--

DROP TABLE IF EXISTS `produit_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit_media` (
  `idProduit` bigint NOT NULL,
  `idMedia` bigint NOT NULL,
  PRIMARY KEY (`idProduit`,`idMedia`),
  KEY `idMedia` (`idMedia`),
  CONSTRAINT `produit_media_ibfk_1` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`),
  CONSTRAINT `produit_media_ibfk_2` FOREIGN KEY (`idMedia`) REFERENCES `media` (`idMedia`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit_media`
--

LOCK TABLES `produit_media` WRITE;
/*!40000 ALTER TABLE `produit_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `produit_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication`
--

DROP TABLE IF EXISTS `publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publication` (
  `idPublication` bigint NOT NULL AUTO_INCREMENT,
  `datePublication` datetime DEFAULT NULL,
  `messagePublication` text,
  `type` char(50) DEFAULT NULL,
  `dateModif` datetime DEFAULT NULL,
  `idPublication_1` bigint NOT NULL,
  `idUtilisateur` bigint NOT NULL,
  PRIMARY KEY (`idPublication`),
  KEY `idPublication_1` (`idPublication_1`),
  KEY `idUtilisateur` (`idUtilisateur`),
  CONSTRAINT `publication_ibfk_1` FOREIGN KEY (`idPublication_1`) REFERENCES `publication` (`idPublication`) ON DELETE CASCADE,
  CONSTRAINT `publication_ibfk_2` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE,
  CONSTRAINT `publication_chk_1` CHECK ((`type` in (_utf8mb4'Publication',_utf8mb4'Message')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication`
--

LOCK TABLES `publication` WRITE;
/*!40000 ALTER TABLE `publication` DISABLE KEYS */;
/*!40000 ALTER TABLE `publication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication_media`
--

DROP TABLE IF EXISTS `publication_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publication_media` (
  `idPublication` bigint NOT NULL,
  `idMedia` bigint NOT NULL,
  PRIMARY KEY (`idPublication`,`idMedia`),
  KEY `idMedia` (`idMedia`),
  CONSTRAINT `publication_media_ibfk_1` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`idPublication`),
  CONSTRAINT `publication_media_ibfk_2` FOREIGN KEY (`idMedia`) REFERENCES `media` (`idMedia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication_media`
--

LOCK TABLES `publication_media` WRITE;
/*!40000 ALTER TABLE `publication_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `publication_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication_reaction`
--

DROP TABLE IF EXISTS `publication_reaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publication_reaction` (
  `idPublication` bigint NOT NULL,
  `idReaction` bigint NOT NULL,
  PRIMARY KEY (`idPublication`,`idReaction`),
  KEY `idReaction` (`idReaction`),
  CONSTRAINT `publication_reaction_ibfk_1` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`idPublication`) ON DELETE CASCADE,
  CONSTRAINT `publication_reaction_ibfk_2` FOREIGN KEY (`idReaction`) REFERENCES `reaction` (`idReaction`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication_reaction`
--

LOCK TABLES `publication_reaction` WRITE;
/*!40000 ALTER TABLE `publication_reaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `publication_reaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reaction`
--

DROP TABLE IF EXISTS `reaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reaction` (
  `idReaction` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `uri` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idReaction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reaction`
--

LOCK TABLES `reaction` WRITE;
/*!40000 ALTER TABLE `reaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `reaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relation`
--

DROP TABLE IF EXISTS `relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relation` (
  `idUtilisateur` bigint NOT NULL,
  `idUtilisateur_1` bigint NOT NULL,
  `Statut` char(50) DEFAULT NULL,
  `dateCreation` datetime DEFAULT NULL,
  PRIMARY KEY (`idUtilisateur`,`idUtilisateur_1`),
  KEY `idUtilisateur_1` (`idUtilisateur_1`),
  CONSTRAINT `relation_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`),
  CONSTRAINT `relation_ibfk_2` FOREIGN KEY (`idUtilisateur_1`) REFERENCES `utilisateur` (`idUtilisateur`),
  CONSTRAINT `relation_chk_1` CHECK ((`Statut` in (_utf8mb4'Amis',_utf8mb4'Bloqué',_utf8mb4'Abonné')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relation`
--

LOCK TABLES `relation` WRITE;
/*!40000 ALTER TABLE `relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `idRole` bigint NOT NULL AUTO_INCREMENT,
  `nom` char(15) DEFAULT NULL,
  PRIMARY KEY (`idRole`),
  CONSTRAINT `role_chk_1` CHECK ((`nom` in (_utf8mb4'Admin',_utf8mb4'Proprietaire',_utf8mb4'Visiteur',_utf8mb4'Acheteur')))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Proprietaire'),(3,'Visiteur'),(4,'Acheteur');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `idUtilisateur` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `pseudo` varchar(50) DEFAULT NULL,
  `mdp` varchar(150) NOT NULL,
  `dateInscription` datetime DEFAULT NULL,
  `dateModif` datetime DEFAULT NULL,
  `jeton` mediumtext,
  `bio` varchar(500) DEFAULT NULL,
  `idPreferenceUtilisateur` int DEFAULT NULL,
  `idMedia` bigint DEFAULT NULL,
  `idRole` bigint NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUtilisateur`),
  UNIQUE KEY `mdp` (`mdp`),
  KEY `idPreferenceUtilisateur` (`idPreferenceUtilisateur`),
  KEY `idMedia` (`idMedia`),
  KEY `idRole` (`idRole`),
  CONSTRAINT `utilisateur_ibfk_2` FOREIGN KEY (`idMedia`) REFERENCES `media` (`idMedia`) ON DELETE CASCADE,
  CONSTRAINT `utilisateur_ibfk_3` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'melon','Jean','JDupont','password123','2023-01-15 14:32:00','2023-01-15 14:32:00','abc123','Amateur de lecture',1,1,1,NULL),(2,'Martin','Sophie','Smartin','sophie2024','2023-02-20 09:15:00','2023-02-20 09:15:00','def456','Voyageuse passionnée',2,2,1,NULL),(3,'iuhiygkjjhj','Luc','LucD','lucdev!','2023-03-12 10:45:00','2023-03-12 10:45:00','ghi789','Fan de technologies',3,3,2,'lol'),(4,'fsefesfes','lol','EMoreau','emma123','2023-04-05 17:00:00','2023-04-05 17:00:00','jkl012','Adore les jeux vidéo',4,4,1,NULL),(5,'Bernard','Thomas','TBernard','351354','2023-05-17 11:30:00','2023-05-17 11:30:00','mno345','Cinéphile averti',5,5,1,NULL),(8,'Petit','Louis','LPetit','petitLouis','2023-08-03 15:40:00','2023-08-03 15:40:00','vwx234','Apprend le code',8,8,4,NULL),(10,'Bonnet','Hugo','HBonnet','bonnetHugo','2023-10-21 11:20:00','2023-10-21 11:20:00','qwe890','Fait des randonnées',10,10,3,NULL),(24,'dzqdq','dzqd','qdz','dzdqzd','2024-11-26 00:00:00',NULL,NULL,NULL,27,NULL,2,'dzqd'),(25,'dzqd','dzqd','zqdqz','zqdzqd','2024-11-26 00:00:00',NULL,NULL,NULL,28,NULL,2,'fff'),(29,'','ggs','gesgsg','gesg','2024-11-26 00:00:00',NULL,NULL,NULL,32,NULL,3,'gsees'),(36,'h','h','h','h','2024-11-26 00:00:00',NULL,NULL,NULL,39,NULL,3,'h'),(38,'NomHashed','PrenomHashed','Zhed','$2a$10$QeNboP3I2WPa9rsOcDZQkegWEcOCPU6pQP9KkxFlr69rL0svEBFDm','2024-11-28 00:00:00',NULL,NULL,NULL,42,NULL,2,'zhed@gmail.fr'),(39,'NomHashed','PrneomHashed','Zhed2','$2a$10$.aV4aMTZxJbeuH5ECBVa7uQ1nGmIiJLNiSswvpC3PVDs9SrVzFxwu','2024-11-28 00:00:00',NULL,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJaaGVkMiIsImlhdCI6MTczMjc5Nzc3NCwiZXhwIjoxNzMyODAxMzc0fQ.TPMyPPQ0AdBAwzfnFa3in_Vet56MXmf3_5fmOUjzp9Y',NULL,43,NULL,3,'mail@mail.fr'),(40,'Test1!','Test1!','Test1!','$2a$10$ErB4.G56cJxpc1EQvFAc1OzM4UETLgCNvRsSyvR9kOVVkNztIL2Eq','2024-11-28 00:00:00',NULL,NULL,NULL,44,NULL,3,'Test1@Test1.fr'),(41,'ggrdgrdg','gdgrgdg','esfsfsefsf','$2a$10$pCJLfOBj34YhQfz7GdGbsu1FrApfS7C6VjVIBI.x5R1LP.hWIhVDq','2024-11-28 00:00:00',NULL,NULL,NULL,45,NULL,3,'fesfesf@fsef.fr');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur_adresse`
--

DROP TABLE IF EXISTS `utilisateur_adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur_adresse` (
  `idUtilisateur` bigint NOT NULL,
  `idAdresse` bigint NOT NULL,
  PRIMARY KEY (`idUtilisateur`,`idAdresse`),
  KEY `idAdresse` (`idAdresse`),
  CONSTRAINT `utilisateur_adresse_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`),
  CONSTRAINT `utilisateur_adresse_ibfk_2` FOREIGN KEY (`idAdresse`) REFERENCES `adresse` (`idAdresse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur_adresse`
--

LOCK TABLES `utilisateur_adresse` WRITE;
/*!40000 ALTER TABLE `utilisateur_adresse` DISABLE KEYS */;
/*!40000 ALTER TABLE `utilisateur_adresse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-28 15:35:12
