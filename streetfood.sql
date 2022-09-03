-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: streetfood
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Food'),(2,'Beverage');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `UserId` bigint NOT NULL,
  `CreationTime` datetime(6) NOT NULL,
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0',
  `DeletionTIme` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_Order_User_idx` (`UserId`),
  CONSTRAINT `FK_Order_User` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `RestaurantId` bigint NOT NULL,
  `ProductId` bigint NOT NULL,
  `OrderId` bigint NOT NULL,
  `TotalPrice` decimal(18,2) NOT NULL,
  `CreationTime` datetime(6) NOT NULL,
  `IsDeleted` bit(1) DEFAULT b'0',
  `DeletionTime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_OrderDetail_Restaurant_idx` (`RestaurantId`),
  KEY `Fk_OrderDetail_Product_idx` (`ProductId`),
  KEY `Fk_OrderDetail_Order` (`OrderId`),
  CONSTRAINT `Fk_OrderDetail_Order` FOREIGN KEY (`OrderId`) REFERENCES `order` (`Id`),
  CONSTRAINT `Fk_OrderDetail_Product` FOREIGN KEY (`ProductId`) REFERENCES `product` (`Id`),
  CONSTRAINT `Fk_OrderDetail_Restaurant` FOREIGN KEY (`RestaurantId`) REFERENCES `restaurant` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Price` decimal(18,2) DEFAULT NULL,
  `RestaurantId` bigint DEFAULT NULL,
  `Image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CategoryId` bigint DEFAULT NULL,
  `CreationTime` datetime(6) DEFAULT NULL,
  `LastModificationTime` datetime(6) DEFAULT NULL,
  `IsDeleted` bit(1) DEFAULT b'0',
  `DeletionTime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_Product_Restaurant_idx` (`RestaurantId`),
  KEY `Fk_Product_Category_idx` (`CategoryId`),
  CONSTRAINT `Fk_Product_Category` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`Id`),
  CONSTRAINT `Fk_Product_Restaurant` FOREIGN KEY (`RestaurantId`) REFERENCES `restaurant` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (4,'ehethkejrht',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '\0',NULL),(6,'Test',NULL,200000.00,NULL,'https://res.cloudinary.com/dxhhatnr2/image/upload/v1661087919/dqqj51oreeeywdlfb8x2.jpg',1,NULL,NULL,_binary '\0',NULL),(7,'Test',NULL,200000.00,NULL,'https://res.cloudinary.com/dxhhatnr2/image/upload/v1661087919/bcswyngnlih96r6m0l8n.jpg',1,NULL,NULL,_binary '\0',NULL),(8,'Test',NULL,200000.00,NULL,'https://res.cloudinary.com/dxhhatnr2/image/upload/v1661087919/f26d2hfqf52zge5n97ye.jpg',1,NULL,NULL,_binary '\0',NULL),(9,'Test',NULL,200000.00,NULL,'https://res.cloudinary.com/dxhhatnr2/image/upload/v1661087919/fh6ocx1uk63aznnsv0tx.jpg',1,NULL,NULL,_binary '\0',NULL),(10,'Test',NULL,200000.00,NULL,'https://res.cloudinary.com/dxhhatnr2/image/upload/v1661087920/bghkcbgzjmeyfb3jzies.jpg',1,NULL,NULL,_binary '\0',NULL),(11,'Test 2',NULL,300000.00,NULL,'https://res.cloudinary.com/dxhhatnr2/image/upload/v1661088012/p3fxlcnemfioib9jrwjo.png',1,NULL,NULL,_binary '\0',NULL),(12,'TEST PRODUCT ',NULL,20000000.00,NULL,'https://res.cloudinary.com/dxhhatnr2/image/upload/v1662025539/m3dto5t5jeffbnk3rlc6.jpg',1,NULL,NULL,NULL,NULL),(13,'TEST PRODUCT ',NULL,20000000.00,NULL,'https://res.cloudinary.com/dxhhatnr2/image/upload/v1662025539/pn5xv5li9oktnhga20cl.jpg',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Rating` int DEFAULT NULL,
  `Avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Thumbnail_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TimeOpen` time NOT NULL,
  `TimeClose` time NOT NULL,
  `CreationTime` datetime(6) NOT NULL,
  `LastModificationTime` datetime(6) DEFAULT NULL,
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0',
  `DeletionTime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `LastName` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `UserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `AvatarUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `EmailAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `Role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `CreationTime` datetime(6) DEFAULT NULL,
  `LastModificationTime` datetime(6) DEFAULT NULL,
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0',
  `DeletionTime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'Jin','admin','123456',NULL,'test@gmail.com','Admin',NULL,NULL,_binary '\0',NULL),(2,NULL,'admin','admin1','$2a$10$9zkdqJCQWokNunpMG0/0oe804X6o2GOsnHVlmudcKwiNil/KdqaNC',NULL,NULL,'User',NULL,NULL,_binary '\0',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercomment`
--

DROP TABLE IF EXISTS `usercomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usercomment` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `UserId` bigint NOT NULL,
  `RestaurantId` bigint NOT NULL,
  `Comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CreationTime` datetime(6) NOT NULL,
  `LastModificationTime` datetime(6) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `DeletionTime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_UserComment_User_idx` (`UserId`),
  KEY `Fk_UserComment_Restaurant_idx` (`RestaurantId`),
  CONSTRAINT `Fk_UserComment_Restaurant` FOREIGN KEY (`RestaurantId`) REFERENCES `restaurant` (`Id`),
  CONSTRAINT `Fk_UserComment_User` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercomment`
--

LOCK TABLES `usercomment` WRITE;
/*!40000 ALTER TABLE `usercomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `usercomment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-03 18:46:38
