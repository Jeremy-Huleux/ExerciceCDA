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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'melon','Jean','JDupont','password123','2023-01-15 14:32:00','2023-01-15 14:32:00','abc123','Amateur de lecture',1,1,1,NULL),(2,'Martin','Sophie','Smartin','sophie2024','2023-02-20 09:15:00','2023-02-20 09:15:00','def456','Voyageuse passionnée',2,2,1,NULL),(3,'iuhiygkjjhj','Luc','LucD','lucdev!','2023-03-12 10:45:00','2023-03-12 10:45:00','ghi789','Fan de technologies',3,3,2,'lol'),(4,'fsefesfes','lol','EMoreau','emma123','2023-04-05 17:00:00','2023-04-05 17:00:00','jkl012','Adore les jeux vidéo',4,4,1,NULL),(5,'Bernard','Thomas','TBernard','351354','2023-05-17 11:30:00','2023-05-17 11:30:00','mno345','Cinéphile averti',5,5,1,NULL),(8,'Petit','Louis','LPetit','petitLouis','2023-08-03 15:40:00','2023-08-03 15:40:00','vwx234','Apprend le code',8,8,4,NULL),(10,'Bonnet','Hugo','HBonnet','bonnetHugo','2023-10-21 11:20:00','2023-10-21 11:20:00','qwe890','Fait des randonnées',10,10,3,NULL),(24,'dzqdq','dzqd','qdz','dzdqzd','2024-11-26 00:00:00',NULL,NULL,NULL,27,NULL,2,'dzqd'),(25,'dzqd','dzqd','zqdqz','zqdzqd','2024-11-26 00:00:00',NULL,NULL,NULL,28,NULL,2,'fff'),(29,'','ggs','gesgsg','gesg','2024-11-26 00:00:00',NULL,NULL,NULL,32,NULL,3,'gsees'),(36,'h','h','h','h','2024-11-26 00:00:00',NULL,NULL,NULL,39,NULL,3,'h'),(38,'NomHashed','PrenomHashed','Zhed','$2a$10$QeNboP3I2WPa9rsOcDZQkegWEcOCPU6pQP9KkxFlr69rL0svEBFDm','2024-11-28 00:00:00',NULL,NULL,NULL,42,NULL,2,'zhed@gmail.fr'),(39,'NomHashed','PrneomHashed','Zhed2','$2a$10$.aV4aMTZxJbeuH5ECBVa7uQ1nGmIiJLNiSswvpC3PVDs9SrVzFxwu','2024-11-28 00:00:00',NULL,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJaaGVkMiIsImlhdCI6MTczMjc5Nzc3NCwiZXhwIjoxNzMyODAxMzc0fQ.TPMyPPQ0AdBAwzfnFa3in_Vet56MXmf3_5fmOUjzp9Y',NULL,43,NULL,3,'mail@mail.fr'),(40,'Test1!','Test1!','Test1!','$2a$10$ErB4.G56cJxpc1EQvFAc1OzM4UETLgCNvRsSyvR9kOVVkNztIL2Eq','2024-11-28 00:00:00',NULL,NULL,NULL,44,NULL,3,'Test1@Test1.fr'),(41,'ggrdgrdg','gdgrgdg','esfsfsefsf','$2a$10$pCJLfOBj34YhQfz7GdGbsu1FrApfS7C6VjVIBI.x5R1LP.hWIhVDq','2024-11-28 00:00:00',NULL,NULL,NULL,45,NULL,3,'fesfesf@fsef.fr');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-09  9:22:50
