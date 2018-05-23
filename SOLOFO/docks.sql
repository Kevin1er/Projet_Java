-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: docks
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Current Database: `docks`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `docks` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `docks`;

--
-- Table structure for table `t_fichier`
--

DROP TABLE IF EXISTS `t_fichier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fichier` (
  `nom` varchar(25) DEFAULT NULL,
  `texte` text NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_fichier`
--

LOCK TABLES `t_fichier` WRITE;
/*!40000 ALTER TABLE `t_fichier` DISABLE KEYS */;
INSERT INTO `t_fichier` VALUES ('new_file.html','<span class=\"chevron\"><</span><span class=\"balise\">h1</span><span class=\"chevron\">>Titre<span class=\"chevron\"><</span><span class=\"balise\">/h1</span><span class=\"chevron\">><br><span class=\"chevron\"><span class=\"chevron\"><</span><span class=\"balise\">div</span><span class=\"chevron\">>Contenus<span class=\"chevron\"><</span><span class=\"balise\">/div</span><span class=\"chevron\">></span></span></span><span class=\"balise\"></span><span class=\"attr\"><br></span></span></span><input class=\"saisis-cmd\" type=\"text\">',89);
/*!40000 ALTER TABLE `t_fichier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_fichier_projet`
--

DROP TABLE IF EXISTS `t_fichier_projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fichier_projet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_fichier` int(11) NOT NULL,
  `id_projet` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_fichier_projet`
--

LOCK TABLES `t_fichier_projet` WRITE;
/*!40000 ALTER TABLE `t_fichier_projet` DISABLE KEYS */;
INSERT INTO `t_fichier_projet` VALUES (93,89,15),(94,90,15);
/*!40000 ALTER TABLE `t_fichier_projet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_notification`
--

DROP TABLE IF EXISTS `t_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_fichier` int(11) NOT NULL,
  `date_notif` datetime DEFAULT NULL,
  `id_projet` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13348 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_notification`
--

LOCK TABLES `t_notification` WRITE;
/*!40000 ALTER TABLE `t_notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_notification_create`
--

DROP TABLE IF EXISTS `t_notification_create`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_notification_create` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_projet` int(11) DEFAULT NULL,
  `nom_fichier` varchar(50) DEFAULT NULL,
  `date_notif` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_notification_create`
--

LOCK TABLES `t_notification_create` WRITE;
/*!40000 ALTER TABLE `t_notification_create` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_notification_create` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_notification_del`
--

DROP TABLE IF EXISTS `t_notification_del`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_notification_del` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `date_notif` datetime DEFAULT NULL,
  `id_projet` int(11) DEFAULT NULL,
  `nom_fichier` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_notification_del`
--

LOCK TABLES `t_notification_del` WRITE;
/*!40000 ALTER TABLE `t_notification_del` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_notification_del` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_projet`
--

DROP TABLE IF EXISTS `t_projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_projet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `id_admin` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_projet`
--

LOCK TABLES `t_projet` WRITE;
/*!40000 ALTER TABLE `t_projet` DISABLE KEYS */;
INSERT INTO `t_projet` VALUES (15,'Test2',1,'2018-05-22 19:05:47');
/*!40000 ALTER TABLE `t_projet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) DEFAULT NULL,
  `img_path` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'solofo','/img/solo.jpg','solo@solo.solo'),(2,'solo','/img/solo.jpg','solo@solo2.solo'),(3,'oussema','/img/oussema.jpg','oussema@trabelsi.me');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_projet`
--

DROP TABLE IF EXISTS `t_user_projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_projet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `projet_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_projet`
--

LOCK TABLES `t_user_projet` WRITE;
/*!40000 ALTER TABLE `t_user_projet` DISABLE KEYS */;
INSERT INTO `t_user_projet` VALUES (13,1,15),(14,2,15),(15,3,15);
/*!40000 ALTER TABLE `t_user_projet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-22 19:27:14
