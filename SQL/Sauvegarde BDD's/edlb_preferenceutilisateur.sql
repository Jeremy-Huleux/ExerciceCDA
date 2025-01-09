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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferenceutilisateur`
--

LOCK TABLES `preferenceutilisateur` WRITE;
/*!40000 ALTER TABLE `preferenceutilisateur` DISABLE KEYS */;
INSERT INTO `preferenceutilisateur` VALUES (1,0,1,1,1),(2,1,1,0,1),(3,1,0,1,0),(4,0,1,0,1),(5,1,0,1,1),(6,0,0,1,1),(7,1,0,0,1),(8,1,1,0,0),(9,1,0,1,1),(10,1,1,1,0),(11,1,0,0,1),(12,1,0,0,1),(13,1,0,0,1),(14,1,0,0,1),(15,1,0,0,1),(16,1,0,0,1),(17,1,0,0,1),(18,1,0,0,1),(19,1,0,0,1),(20,1,0,0,1),(21,1,0,0,1),(22,1,0,0,1),(23,1,0,0,1),(24,1,0,0,1),(25,1,0,0,1),(26,1,0,0,1),(27,1,0,0,1),(28,1,0,0,1),(29,1,0,0,1),(30,1,0,0,1),(31,1,0,0,1),(32,1,0,0,1),(33,1,0,0,1),(34,1,0,0,1),(35,1,0,0,1),(36,1,0,0,1),(37,1,0,0,1),(38,1,0,0,1),(39,1,0,0,1),(40,1,0,0,1),(41,1,0,0,1),(42,1,0,0,1),(43,1,0,0,1),(44,1,0,0,1),(45,1,0,0,1);
/*!40000 ALTER TABLE `preferenceutilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-09  9:22:51
