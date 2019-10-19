CREATE DATABASE  IF NOT EXISTS `chatbot` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `chatbot`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: chatbot
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `actions`
--

DROP TABLE IF EXISTS `actions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actions` (
  `id` bigint(20) NOT NULL,
  `action_method` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actions`
--

LOCK TABLES `actions` WRITE;
/*!40000 ALTER TABLE `actions` DISABLE KEYS */;
INSERT INTO `actions` VALUES (1,'defaultaction');
/*!40000 ALTER TABLE `actions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cities` (
  `id` bigint(20) NOT NULL,
  `cityname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Riyadh'),(2,'Jeddah'),(3,'Dammam'),(4,'Makkah');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conversation`
--

DROP TABLE IF EXISTS `conversation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conversation` (
  `id` bigint(20) NOT NULL,
  `last_action` bigint(20) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `last_story_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4raopfrau3u2lr2eifwp71xr6` (`last_action`),
  KEY `FKnybqm1lkue8xwd8b2gip0tjg3` (`language_id`),
  KEY `FKok6lg8bwwj6rbt11okvssnu2y` (`last_story_id`),
  CONSTRAINT `FK4raopfrau3u2lr2eifwp71xr6` FOREIGN KEY (`last_action`) REFERENCES `actions` (`id`),
  CONSTRAINT `FKnybqm1lkue8xwd8b2gip0tjg3` FOREIGN KEY (`language_id`) REFERENCES `languages` (`id`),
  CONSTRAINT `FKok6lg8bwwj6rbt11okvssnu2y` FOREIGN KEY (`last_story_id`) REFERENCES `story_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversation`
--

LOCK TABLES `conversation` WRITE;
/*!40000 ALTER TABLE `conversation` DISABLE KEYS */;
INSERT INTO `conversation` VALUES (1,NULL,0,1),(2,NULL,0,1),(3,NULL,1,9),(4,NULL,1,1),(8,NULL,0,9),(10,NULL,0,9);
/*!40000 ALTER TABLE `conversation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (12),(12),(12),(12),(12),(12),(12),(12),(12),(12);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intent`
--

DROP TABLE IF EXISTS `intent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intent` (
  `id` bigint(20) NOT NULL,
  `intentname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intent`
--

LOCK TABLES `intent` WRITE;
/*!40000 ALTER TABLE `intent` DISABLE KEYS */;
INSERT INTO `intent` VALUES (1,'greeting'),(2,'new reservation');
/*!40000 ALTER TABLE `intent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `languages`
--

DROP TABLE IF EXISTS `languages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `languages` (
  `id` bigint(20) NOT NULL,
  `lang_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `languages`
--

LOCK TABLES `languages` WRITE;
/*!40000 ALTER TABLE `languages` DISABLE KEYS */;
INSERT INTO `languages` VALUES (0,'english'),(1,'arabic');
/*!40000 ALTER TABLE `languages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messeges`
--

DROP TABLE IF EXISTS `messeges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messeges` (
  `messege_id` bigint(20) NOT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `language_id` bigint(20) NOT NULL,
  PRIMARY KEY (`language_id`,`messege_id`),
  CONSTRAINT `FKffictlbjgphs1bgox2hril6dh` FOREIGN KEY (`language_id`) REFERENCES `languages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messeges`
--

LOCK TABLES `messeges` WRITE;
/*!40000 ALTER TABLE `messeges` DISABLE KEYS */;
INSERT INTO `messeges` VALUES (1,'Welcome to SAPTCO , Please choose our services , 1-New reservation , 2- Resevation status , 3-reschedual reservation , 4-cancel reservation , send 0 at any time to cancel ',0),(2,'Thank you and hope to see you again',0),(3,'Please select one of showen nmbers',0),(4,'please select start city : 1-Riyadh 2-jeddah 3-dammam 4-makkah',0),(5,'Sorry , this service is coming soon',0),(6,'please select destination city : 1-Riyadh 2-jeddah 3-dammam 4-makkah',0),(7,'please choose month you would like to reserve',0),(8,'please choose day of month from 1 to 31',0),(9,'please choose trip type from 1 to 10',0),(10,'please enter full name',0),(11,'please enter phone number',0),(12,'please enter full name',0),(13,'please enter phone number',0),(14,'please confirm reservation details',0),(15,'Start City',0),(16,'Destination city',0),(17,'Trip Date',0),(18,'Trip number',0),(19,'full name',0),(20,'phone number',0),(21,'please send 1 to confirm or 0 to cancel',0),(22,'Thank you for using SAPTCO , your resevation number is ',0),(1,'اهلا بكم في سابتكو الرجاء اختيار احد الخيارات 1-حجز جديد 2-تفاصيل حجز سابق 3- تغيير حجز سابق 4- الغاء حجز سابق , ارسل 0 في اي وقت للالغاء',1),(2,'شكرا ونرجو استخدامكم لخدمات سابتكو مرة اخرى',1),(3,'الرقم المدخل غير صحيح الرجاء ادخال رقم واحد من الخيارات السابقة',1),(4,'الرجاء اختيار مدينة الانطلاق : 1-الرياض 2-جدة  3-الدمام 4-مكة',1),(5,'عذرا هذه الخدمة غير متوفرة بعد',1),(6,'الرجاء اختيار الوجهة : 1- الرياض 2-جدة 3-الدمام 4-مكة',1),(7,'الرجاء اختيار الشهر الذي تود السفر فيه من 1 الى 12',1),(8,'الرجاء اختيار اليوم من 1 الى 31',1),(9,'الرجاء اختيار تصنيف الرحلة من 1 الى 10 ',1),(10,'الرحاء ادخال الاسم الكامل',1),(11,'الرجاء ادخال رقم الهاتف',1),(12,'الرجاء ادخال الاسم الكامل',1),(13,'الرجاء ادخال رقم الهاتف',1),(14,'الرجاء تأكيد معلومات الحجز',1),(15,'مدينة الانطلاق',1),(16,'مدينة الوجهة',1),(17,'تاريخ الرحلة',1),(18,'رقم الرحلة',1),(19,'الاسم الكامل',1),(20,'رقم الهاتف',1),(21,'الرجاء ارسال 1 للموافقة او 0 للالغاء',1),(22,'شكرا لاستخدامكم خدمات سابتكو ان رقم الحجز الخاص بك هو ',1);
/*!40000 ALTER TABLE `messeges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nlu`
--

DROP TABLE IF EXISTS `nlu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nlu` (
  `id` bigint(20) NOT NULL,
  `nlutext` varchar(255) DEFAULT NULL,
  `intent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2934wptw3k7ebo93v0i4s2bce` (`intent_id`),
  CONSTRAINT `FK2934wptw3k7ebo93v0i4s2bce` FOREIGN KEY (`intent_id`) REFERENCES `intent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nlu`
--

LOCK TABLES `nlu` WRITE;
/*!40000 ALTER TABLE `nlu` DISABLE KEYS */;
INSERT INTO `nlu` VALUES (1,'default nlu',1);
/*!40000 ALTER TABLE `nlu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saptco_form`
--

DROP TABLE IF EXISTS `saptco_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saptco_form` (
  `id` bigint(20) NOT NULL,
  `day_of_moth` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `user_full_name` varchar(35) DEFAULT NULL,
  `user_phone` varchar(15) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `conversation_id` bigint(20) DEFAULT NULL,
  `dest_city` bigint(20) DEFAULT NULL,
  `start_city` bigint(20) DEFAULT NULL,
  `trip_id` bigint(20) DEFAULT NULL,
  `is_canceled` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKflgdvle1i9hu26umwinw3r5yo` (`conversation_id`),
  KEY `FKq9aribkr3w7oc2dhyj3lpmfs` (`dest_city`),
  KEY `FKnydpxvb8uokyqg8gv7jgex5g6` (`start_city`),
  KEY `FK5kxbovhe9sygjpxpokwjsamsa` (`trip_id`),
  CONSTRAINT `FK5kxbovhe9sygjpxpokwjsamsa` FOREIGN KEY (`trip_id`) REFERENCES `saptco_trips` (`id`),
  CONSTRAINT `FKflgdvle1i9hu26umwinw3r5yo` FOREIGN KEY (`conversation_id`) REFERENCES `conversation` (`id`),
  CONSTRAINT `FKnydpxvb8uokyqg8gv7jgex5g6` FOREIGN KEY (`start_city`) REFERENCES `cities` (`id`),
  CONSTRAINT `FKq9aribkr3w7oc2dhyj3lpmfs` FOREIGN KEY (`dest_city`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saptco_form`
--

LOCK TABLES `saptco_form` WRITE;
/*!40000 ALTER TABLE `saptco_form` DISABLE KEYS */;
INSERT INTO `saptco_form` VALUES (6,20,4,'خالد الرفاعي','0527444302',0,3,3,1,5,0),(7,0,0,NULL,NULL,0,3,NULL,3,NULL,0),(9,22,11,'khaled alrefai','0527444302',0,8,3,2,3,0),(11,29,4,'Elham albaroudi','0509233222',0,10,2,1,7,0);
/*!40000 ALTER TABLE `saptco_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saptco_trips`
--

DROP TABLE IF EXISTS `saptco_trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saptco_trips` (
  `id` bigint(20) NOT NULL,
  `trip_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saptco_trips`
--

LOCK TABLES `saptco_trips` WRITE;
/*!40000 ALTER TABLE `saptco_trips` DISABLE KEYS */;
INSERT INTO `saptco_trips` VALUES (1,'الرحلة الاولى'),(2,'الرحلة الثانية'),(3,'الرحلة الثالة'),(4,'الرحلة الرابعة'),(5,'الرحلة الخامسة'),(6,'الرحلة السادسة'),(7,'الرحلة السابعة'),(8,'الرحلة الثامنة'),(9,'الرحلة التاسعة'),(10,'الرحلة العاشرة');
/*!40000 ALTER TABLE `saptco_trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stories`
--

DROP TABLE IF EXISTS `stories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stories` (
  `id` bigint(20) NOT NULL,
  `storyname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stories`
--

LOCK TABLES `stories` WRITE;
/*!40000 ALTER TABLE `stories` DISABLE KEYS */;
INSERT INTO `stories` VALUES (1,'happy story');
/*!40000 ALTER TABLE `stories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story_detail`
--

DROP TABLE IF EXISTS `story_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story_detail` (
  `id` bigint(20) NOT NULL,
  `action_to_do` bigint(20) DEFAULT NULL,
  `intent_recived` bigint(20) DEFAULT NULL,
  `story_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK62y75ye4ldquutwn2374lwmwg` (`action_to_do`),
  KEY `FKlggi14t9ym453crlhbnxb5se7` (`intent_recived`),
  KEY `FK6udptt1cnffkswn6uu5dm84b1` (`story_id`),
  CONSTRAINT `FK62y75ye4ldquutwn2374lwmwg` FOREIGN KEY (`action_to_do`) REFERENCES `actions` (`id`),
  CONSTRAINT `FK6udptt1cnffkswn6uu5dm84b1` FOREIGN KEY (`story_id`) REFERENCES `stories` (`id`),
  CONSTRAINT `FKlggi14t9ym453crlhbnxb5se7` FOREIGN KEY (`intent_recived`) REFERENCES `intent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story_detail`
--

LOCK TABLES `story_detail` WRITE;
/*!40000 ALTER TABLE `story_detail` DISABLE KEYS */;
INSERT INTO `story_detail` VALUES (1,1,1,1),(2,1,1,1),(3,1,1,1),(4,1,1,1),(5,1,1,1),(6,1,1,1),(7,1,1,1),(8,1,1,1),(9,1,1,1);
/*!40000 ALTER TABLE `story_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-19 19:42:13
