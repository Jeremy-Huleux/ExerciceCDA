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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
INSERT INTO `media` VALUES (1,'avatar','default-profile.png','2023-01-15 14:32:00','Image de profil par défaut'),(2,'avatar','profile1.png','2023-02-20 09:15:00','Image de profil de Sophie'),(3,'avatar','profile2.png','2023-03-12 10:45:00','Image de profil de Luc'),(4,'avatar','profile3.png','2023-04-05 17:00:00','Image de profil d\'Emma'),(5,'avatar','profile4.png','2023-05-17 11:30:00','Image de profil de Thomas'),(6,'avatar','profile5.png','2023-06-22 08:25:00','Image de profil de Camille'),(7,'avatar','profile6.png','2023-07-14 09:00:00','Image de profil de Julie'),(8,'avatar','profile7.png','2023-08-03 15:40:00','Image de profil de Louis'),(9,'avatar','profile8.png','2023-09-10 16:30:00','Image de profil d\'Alice'),(10,'avatar','profile9.png','2023-10-21 11:20:00','Image de profil de Hugo');
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
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
