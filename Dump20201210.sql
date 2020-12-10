-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bus_booking
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `email_id` varchar(40) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('dhaval123@gmail.com','Dhaval','Kumar','dhaval12345'),('saikat123@gmail.com','Saikat','Barua','saikat218212'),('utsav123@gmail.com','Utsav','Roy','utsav12345');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_detail`
--

DROP TABLE IF EXISTS `booking_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_detail` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `bus_no` int DEFAULT NULL,
  `bus_name` varchar(20) DEFAULT NULL,
  `full_name` varchar(40) DEFAULT NULL,
  `seat_no` int DEFAULT NULL,
  `travel_date` date DEFAULT NULL,
  `booking_date` date DEFAULT NULL,
  `email_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_detail`
--

LOCK TABLES `booking_detail` WRITE;
/*!40000 ALTER TABLE `booking_detail` DISABLE KEYS */;
INSERT INTO `booking_detail` VALUES (1,103,'SLG3 Bus','Digvijay Kumar',3,'2020-12-17','2020-12-10','abhishek123@gmail.com'),(2,103,'SLG3 Bus','Abhishek Kumar',5,'2020-12-17','2020-12-10','abhishek123@gmail.com'),(3,102,'SLG2 Bus','Saikat Barua',1,'2020-12-15','2020-12-10','abhishek123@gmail.com'),(4,102,'SLG2 Bus','Dhaval Kumar',2,'2020-12-15','2020-12-10','abhishek123@gmail.com');
/*!40000 ALTER TABLE `booking_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus_info`
--

DROP TABLE IF EXISTS `bus_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bus_info` (
  `bus_no` int NOT NULL,
  `bus_name` varchar(20) NOT NULL,
  `bus_source` varchar(40) NOT NULL,
  `bus_destination` varchar(40) NOT NULL,
  `price` int DEFAULT NULL,
  `journey_date` date DEFAULT NULL,
  `timing` time DEFAULT NULL,
  `seat` int DEFAULT NULL,
  PRIMARY KEY (`bus_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus_info`
--

LOCK TABLES `bus_info` WRITE;
/*!40000 ALTER TABLE `bus_info` DISABLE KEYS */;
INSERT INTO `bus_info` VALUES (100,'COB1 Bus','cob','njp',100,'2020-12-15','10:00:00',10),(101,'SLG1 Bus','cob','slg',150,'2020-12-16','13:00:00',10),(102,'SLG2 Bus','cob','slg',150,'2020-12-15','15:00:00',8),(103,'SLG3 Bus','cob','slg',150,'2020-12-17','10:00:00',8),(104,'COB2 Bus','cob','njp',100,'2020-12-15','07:00:00',10),(105,'HWH1 Bus','hwh','sdh',300,'2020-12-15','13:00:00',10),(106,'HWH2 Bus','hwh','sdh',300,'2020-12-15','10:00:00',10),(107,'HWH3 Bus','hwh','sdh',300,'2020-12-20','17:00:00',7);
/*!40000 ALTER TABLE `bus_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger_info`
--

DROP TABLE IF EXISTS `passenger_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger_info` (
  `passenger_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(40) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `seat_no` int DEFAULT '0',
  `email_id` varchar(40) DEFAULT NULL,
  `bus_no` int DEFAULT NULL,
  PRIMARY KEY (`passenger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger_info`
--

LOCK TABLES `passenger_info` WRITE;
/*!40000 ALTER TABLE `passenger_info` DISABLE KEYS */;
INSERT INTO `passenger_info` VALUES (1,'Digvijay Kumar','M',23,3,'abhishek123@gmail.com',103),(2,'Abhishek Kumar','M',22,5,'abhishek123@gmail.com',103),(3,'Saikat Barua','M',23,1,'abhishek123@gmail.com',102),(4,'Dhaval Kumar','M',22,2,'abhishek123@gmail.com',102);
/*!40000 ALTER TABLE `passenger_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_detail`
--

DROP TABLE IF EXISTS `seat_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_detail` (
  `bus_no` int DEFAULT NULL,
  `seat_number` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_detail`
--

LOCK TABLES `seat_detail` WRITE;
/*!40000 ALTER TABLE `seat_detail` DISABLE KEYS */;
INSERT INTO `seat_detail` VALUES (100,1),(100,2),(100,3),(100,4),(100,5),(100,6),(100,7),(100,8),(100,9),(100,10),(101,1),(101,2),(101,3),(101,4),(101,5),(101,6),(101,7),(101,8),(101,9),(101,10),(102,3),(102,4),(102,5),(102,6),(102,7),(102,8),(102,9),(102,10),(103,1),(103,2),(103,4),(103,6),(103,7),(103,8),(103,9),(103,10),(104,1),(104,2),(104,3),(104,4),(104,5),(104,6),(104,7),(104,8),(104,9),(104,10),(105,1),(105,2),(105,3),(105,4),(105,5),(105,6),(105,7),(105,8),(105,9),(105,10),(106,1),(106,2),(106,3),(106,4),(106,5),(106,6),(106,7),(106,8),(106,9),(106,10),(107,1),(107,2);
/*!40000 ALTER TABLE `seat_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `email_id` varchar(40) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `mobile_no` varchar(10) NOT NULL,
  `pass` varchar(40) NOT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('abhishek123@gmail.com','Abhishek','Kumar','M','Gumla,Bihar','7845236589','abhishek12345');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-10 18:34:36
