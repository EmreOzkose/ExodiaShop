-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: localhost    Database: exodiadb
-- ------------------------------------------------------
-- Server version	5.7.25-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `gender` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `brand` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `color` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `type` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `category` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `size` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `price` double NOT NULL,
  `total` int(11) NOT NULL,
  `image` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `seller` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Lumberjack sport black shoe','male','lumberjack','blue','sport','shoes','42',190,5,'img\\products\\shoes\\1.jpg',''),(2,'Brown Shoe','male','Kemal Tanca','brown','classic','shoes','40',1250,12,'img\\products\\shoes\\2.jpg',''),(3,'Classic Women shoe','female','Kemal Tanca','black','classic','shoes','35',500,8,'img\\products\\shoes\\3.jpg',''),(4,'Sony black headphone',NULL,'sony','black','headphone','electronic','',200,16,'img\\products\\electronic\\1.jpg',''),(5,'Asus Computer',NULL,'Asus','black','computer','electronic',NULL,2000,42,'img\\products\\electronic\\2.jpg',''),(6,'LG TV',NULL,'lg','black','tv','electronic',NULL,4000,32,'img\\products\\electronic\\3.jpg',''),(7,'Huawei black telephone',NULL,'huawei','black','telephone','electronic',NULL,1500,35,'img\\products\\electronic\\4.jpg',' '),(8,'Defacto Gray Skirt','female','Defacto','gray','skirt','clothes','41',102,54,'img\\products\\clothes\\1.jpg',''),(9,'Defacto White Skirt','female','Defacto','white','skirt','clothes','39',130,12,'img\\products\\clothes\\2.jpg',''),(10,'Pierre Cardin blue man shirt','male','pierre cardin','blue','shirt','clothes','43',54,31,'img\\products\\clothes\\4.jpg',''),(11,'Pierre Cardin white female shirt','female','pierre cardin','white','shirt','clothes','37',96,11,'img\\products\\clothes\\5.jpg',''),(12,'Casio gold watch ','male','casio','gold','watch','accessory',NULL,120,4,'img\\products\\accessory\\1.jpg',''),(13,'Gold bracelet','female','sunshine','gold','bracelet','accessory',NULL,432,5,'img\\products\\accessory\\2.jpg',''),(14,'Zen green ring','female','Zen','green','ring','accessory',NULL,4350,12,'img\\products\\accessory\\6.jpg',''),(15,'Zen green necklace','female','Zen','green','necklace','accessory',NULL,4430,43,'img\\products\\accessory\\7.jpg','');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-15  0:38:28
