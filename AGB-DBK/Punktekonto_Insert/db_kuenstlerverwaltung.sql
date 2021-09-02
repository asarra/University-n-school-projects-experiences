-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: kuenstlerverwaltung
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB
CREATE DATABASE kuenstlerverwaltung;
use kuenstlerverwaltung;
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
-- Table structure for table `kuenstlerin`
--

DROP TABLE IF EXISTS `kuenstlerin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kuenstlerin` (
  `KuenstlerID` int(11) NOT NULL,
  `Nachname` varchar(32) DEFAULT NULL,
  `Vorname` varchar(32) DEFAULT NULL,
  `Telefon` int(11) DEFAULT NULL,
  `Email` varchar(32) DEFAULT NULL,
  `Stimme` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`KuenstlerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kuenstlerin`
--

LOCK TABLES `kuenstlerin` WRITE;
/*!40000 ALTER TABLE `kuenstlerin` DISABLE KEYS */;
INSERT INTO `kuenstlerin` VALUES (1,'poggemeier','ralf',0,'NULL','tief'),(2,'kornetzki','nadine',0,'NULL','tief'),(3,'aschemeyer','stefanie',0,'NULL','tief'),(5,'priesmeyer','katharina',0,'NULL','tief'),(6,'bieber','holger',0,'NULL','tief'),(7,'schmitt','peter',0,'NULL','tief'),(8,'klute','stefan',0,'NULL','tief'),(9,'birnbaum','stefan',0,'NULL','tief'),(10,'szislofski','sigrun',0,'NULL','tief'),(11,'gieselmann','holger',0,'NULL','tief'),(12,'horn','thomas',0,'NULL','tief'),(13,'wegmann','florian',0,'NULL','tief'),(14,'engelking','mika',0,'NULL','tief'),(15,'veerkamp','lucas',0,'NULL','tief');
/*!40000 ALTER TABLE `kuenstlerin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kuenstlerzulied`
--

DROP TABLE IF EXISTS `kuenstlerzulied`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kuenstlerzulied` (
  `KuenstlerID` int(11) DEFAULT NULL,
  `LiedNr` int(11) DEFAULT NULL,
  KEY `KuenstlerID` (`KuenstlerID`),
  KEY `LiedNr` (`LiedNr`),
  CONSTRAINT `kuenstlerzulied_ibfk_1` FOREIGN KEY (`KuenstlerID`) REFERENCES `kuenstlerin` (`KuenstlerID`),
  CONSTRAINT `kuenstlerzulied_ibfk_2` FOREIGN KEY (`LiedNr`) REFERENCES `lied` (`LiedNr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kuenstlerzulied`
--

LOCK TABLES `kuenstlerzulied` WRITE;
/*!40000 ALTER TABLE `kuenstlerzulied` DISABLE KEYS */;
INSERT INTO `kuenstlerzulied` VALUES (14,3),(13,12),(12,1),(11,14),(10,10),(15,5);
/*!40000 ALTER TABLE `kuenstlerzulied` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lied`
--

DROP TABLE IF EXISTS `lied`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lied` (
  `LiedNr` int(11) NOT NULL,
  `Name` varchar(32) DEFAULT NULL,
  `Kategorie` varchar(32) DEFAULT NULL,
  `Begleitung` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`LiedNr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lied`
--

LOCK TABLES `lied` WRITE;
/*!40000 ALTER TABLE `lied` DISABLE KEYS */;
INSERT INTO `lied` VALUES (1,'bangarang','dubstep','NULL'),(2,'hells-bells','hard-rock','NULL'),(3,'millionaer','hip-hop','NULL'),(4,'firework','pop','NULL'),(5,'dicke-lippen','pop','NULL'),(6,'doggy','schlager','NULL'),(7,'wap-bap','scheisse','NULL'),(8,'friends','edm','NULL'),(9,'hubschrauber-117','schlager','NULL'),(10,'atemlos','schlager','NULL'),(11,'herzbeben','schlager','NULL'),(12,'schwarze-natascha','schlager','NULL'),(13,'heroin','trap','NULL'),(14,'royal-bunker','hiphop','NULL'),(15,'chemie-chemie-ya','rap-rock','NULL');
/*!40000 ALTER TABLE `lied` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-04 12:30:27
