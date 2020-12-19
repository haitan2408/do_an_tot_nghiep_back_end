-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs1slvnkuemjsq2kj4h3vhx7i1` (`post_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (12,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','I love that you\'re talking about Spring Security',10,8),(13,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','What is this Progressive Web App thing all about? PWAs sound really cool.',10,8),(15,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Thank you for this link related to Spring Boot. I love it, great post!',14,8),(16,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','I love that you\'re talking about Spring Security',14,8),(17,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','What is this Progressive Web App thing all about? PWAs sound really cool.',14,8),(19,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Thank you for this link related to Spring Boot. I love it, great post!',18,8),(20,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','I love that you\'re talking about Spring Security',18,8),(21,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','What is this Progressive Web App thing all about? PWAs sound really cool.',18,8),(23,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Thank you for this link related to Spring Boot. I love it, great post!',22,8),(24,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','I love that you\'re talking about Spring Security',22,8),(25,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','What is this Progressive Web App thing all about? PWAs sound really cool.',22,8),(27,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Thank you for this link related to Spring Boot. I love it, great post!',26,8),(28,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','I love that you\'re talking about Spring Security',26,8),(29,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','What is this Progressive Web App thing all about? PWAs sound really cool.',26,8),(31,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Thank you for this link related to Spring Boot. I love it, great post!',30,8),(32,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','I love that you\'re talking about Spring Security',30,8),(33,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','What is this Progressive Web App thing all about? PWAs sound really cool.',30,8),(35,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Thank you for this link related to Spring Boot. I love it, great post!',34,8),(36,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','I love that you\'re talking about Spring Security',34,8),(37,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','What is this Progressive Web App thing all about? PWAs sound really cool.',34,8),(39,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','Thank you for this link related to Spring Boot. I love it, great post!',38,8),(40,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','I love that you\'re talking about Spring Security',38,8),(41,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','What is this Progressive Web App thing all about? PWAs sound really cool.',38,8),(43,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','Thank you for this link related to Spring Boot. I love it, great post!',42,8),(44,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','I love that you\'re talking about Spring Security',42,8),(45,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','What is this Progressive Web App thing all about? PWAs sound really cool.',42,8),(47,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','Thank you for this link related to Spring Boot. I love it, great post!',46,8),(48,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','I love that you\'re talking about Spring Security',46,8),(49,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','What is this Progressive Web App thing all about? PWAs sound really cool.',46,8),(72,'haitan28102408@gmail.com','2020-12-08 15:15:09','haitan28102408@gmail.com','2020-12-08 15:15:09','hi',60,9),(73,'haitan28102408@gmail.com','2020-12-08 15:15:12','haitan28102408@gmail.com','2020-12-08 15:15:12','hello\n',60,9),(74,'haitan28102408@gmail.com','2020-12-08 15:15:15','haitan28102408@gmail.com','2020-12-08 15:15:15','adasd',60,9);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_recommend`
--

DROP TABLE IF EXISTS `data_recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data_recommend` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `angular` int NOT NULL,
  `assembly` int NOT NULL,
  `c` int NOT NULL,
  `cplus` int NOT NULL,
  `crystal` int NOT NULL,
  `css` int NOT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `go` int NOT NULL,
  `groovy` int NOT NULL,
  `html` int NOT NULL,
  `java` int NOT NULL,
  `java_script` int NOT NULL,
  `kotlin` int NOT NULL,
  `math_lab` int NOT NULL,
  `mongodb` int NOT NULL,
  `my_sql` int NOT NULL,
  `net` int NOT NULL,
  `perl` int NOT NULL,
  `php` int NOT NULL,
  `python` int NOT NULL,
  `ruby_on_rails` int NOT NULL,
  `shell` int NOT NULL,
  `sql_server` int NOT NULL,
  `swift` int NOT NULL,
  `timestamp` varchar(255) DEFAULT NULL,
  `type_script` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_address` (`email_address`(50))
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_recommend`
--

LOCK TABLES `data_recommend` WRITE;
/*!40000 ALTER TABLE `data_recommend` DISABLE KEYS */;
INSERT INTO `data_recommend` VALUES (1,0,0,0,0,0,0,'haitan2810240800@gmail.com',0,0,2,4,0,0,4,0,0,0,0,0,0,0,0,0,0,'12/13/2020 18:55:00',5),(2,0,0,5,5,0,0,'haitan2810240801@gmail.com',0,0,0,0,0,0,0,0,0,4,0,4,0,0,0,0,2,'12/13/2020 18:55:00',0),(3,4,1,0,0,4,0,'haitan2810240802@gmail.com',2,1,4,0,0,2,2,4,0,0,3,0,0,1,3,0,0,'12/13/2020 18:55:00',4),(4,0,0,0,0,0,0,'haitan2810240803@gmail.com',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'12/13/2020 18:55:00',0),(5,0,0,0,0,0,0,'haitan2810240804@gmail.com',0,0,0,0,3,0,0,0,1,0,0,0,1,0,1,0,0,'12/13/2020 18:55:00',0),(6,0,0,0,3,0,2,'haitan2810240805@gmail.com',0,0,1,4,1,0,0,0,5,0,0,0,1,0,0,3,0,'12/13/2020 18:55:00',0),(7,0,0,0,0,0,0,'haitan2810240806@gmail.com',0,1,0,0,0,0,0,3,0,0,1,0,0,0,2,0,0,'12/13/2020 18:55:00',0),(8,0,0,0,4,0,0,'haitan2810240807@gmail.com',0,0,0,0,4,0,0,0,2,0,0,0,1,0,0,4,0,'12/13/2020 18:55:00',0),(9,0,0,2,0,0,0,'haitan2810240808@gmail.com',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'12/13/2020 18:55:00',0),(10,0,0,0,3,0,5,'haitan2810240809@gmail.com',0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,8,'12/13/2020 18:55:00',0),(11,0,0,0,0,0,4,'haitan2810240810@gmail.com',0,0,4,0,1,0,0,0,4,0,0,0,0,0,0,1,0,'12/13/2020 18:55:00',0),(12,0,0,0,0,0,0,'haitan2810240811@gmail.com',0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,'12/13/2020 18:55:00',0),(13,1,0,0,0,0,0,'haitan2810240812@gmail.com',1,0,0,0,0,0,0,0,0,1,0,3,0,1,4,3,2,'12/13/2020 18:55:00',2),(14,0,0,0,0,0,4,'haitan2810240813@gmail.com',0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,3,0,'12/13/2020 18:55:00',0),(15,0,0,0,0,5,0,'haitan2810240814@gmail.com',0,3,0,1,0,0,0,2,0,0,3,0,0,0,0,3,0,'12/13/2020 18:55:00',0),(16,0,0,0,0,0,0,'haitan2810240815@gmail.com',0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,'12/13/2020 18:55:00',0),(17,0,4,0,0,0,0,'haitan2810240816@gmail.com',0,0,0,0,0,2,3,0,0,0,0,0,0,0,0,0,0,'12/13/2020 18:55:00',0),(18,0,0,0,0,0,5,'haitan2810240818@gmail.com',0,0,5,0,1,0,0,0,2,0,0,0,0,0,0,3,0,'12/13/2020 18:55:00',0),(19,1,1,1,1,1,1,'haitan2810240819@gmail.com',1,1,3,3,1,1,1,1,2,1,1,1,1,1,1,1,1,'12/13/2020 19:06:10',1),(20,4,1,2,2,0,5,'haitan2810240820@gmail.com',0,0,4,4,3,0,1,0,4,2,0,1,1,0,0,4,0,'12/15/2020 14:10:18',3),(33,0,0,0,0,0,4,'luyen20112000@gmail.com',0,0,5,4,4,0,0,0,4,0,0,0,0,0,0,4,0,'12/17/2020 9:10:13',0),(32,0,0,0,0,0,3,'nvankhanh001@gmail.com',0,0,3,3,3,0,0,0,3,0,0,0,0,0,0,3,0,'12/17/2020 9:07:04',0),(34,0,0,0,0,0,2,'teosake.1999@gmail.com',0,0,3,3,2,0,0,0,2,0,0,0,0,0,0,2,0,'12/17/2020 9:11:22',0),(35,0,0,0,0,0,3,'long.01.04.1995@gmail.com',0,0,3,3,3,0,0,0,3,0,0,0,0,0,0,0,0,'12/17/2020 9:11:29',0),(36,0,0,0,0,0,1,'tuongtheanh20101997@gmail.com',0,0,3,3,3,0,0,0,3,0,0,0,0,0,0,2,0,'12/17/2020 9:12:20',0),(37,5,4,5,5,0,5,'thanhviet3005@gmail.com',3,0,5,5,5,4,5,4,5,0,0,1,5,5,3,0,0,'12/17/2020 9:13:31',0),(38,5,0,2,0,0,5,'phucle.110898@gmail.com',1,0,5,5,5,0,0,3,5,1,0,1,2,1,1,2,1,'12/17/2020 9:13:46',3),(39,4,2,2,3,1,4,'chiennext@gmail.com',1,1,4,5,5,2,1,3,4,1,1,1,3,1,1,3,1,'12/17/2020 9:19:26',2),(40,0,0,0,0,0,5,'tranquochungqbh@gmail.com',0,0,5,5,5,0,0,0,5,0,0,0,0,0,0,0,0,'12/17/2020 9:20:12',0),(41,0,0,0,0,0,4,'mainamkhanh92@gmail.com',0,0,5,4,4,0,0,0,4,0,0,0,0,0,0,0,0,'12/17/2020 9:20:14',0),(42,5,3,3,3,3,5,'trantuanx1cbkdn@gmail.com',3,3,5,5,5,3,3,3,5,2,3,4,5,4,3,5,2,'12/17/2020 9:20:26',3),(43,0,0,2,2,0,2,'dnbaobk@gmail.com',0,0,3,3,2,0,0,0,1,0,0,0,0,0,0,0,0,'12/17/2020 9:36:24',0),(44,0,0,0,0,0,4,'ldt051202@gmail.com',0,0,4,4,4,0,0,0,4,0,0,0,0,0,0,0,0,'12/17/2020 9:37:09',0),(45,0,0,0,3,0,4,'nguyenthiennhan11chp@gmail.com',0,0,4,4,4,0,0,0,2,0,0,0,0,0,0,0,0,'12/17/2020 9:38:08',0),(46,4,4,4,4,3,4,'tranbao.hht.3090@gmail.com',4,4,4,5,4,4,4,4,3,4,3,4,4,4,4,3,4,'12/17/2020 11:19:33',4),(47,4,3,4,4,3,3,'15l1031177@huaf.edu.vn',3,3,4,5,5,3,3,3,3,4,3,4,4,4,4,2,4,'12/17/2020 11:23:42',4),(48,2,2,2,0,2,5,'Vanlinh12b5@gmail.com',2,3,5,3,5,5,2,5,3,2,2,0,3,5,3,3,5,'12/17/2020 11:30:58',5),(49,0,0,0,0,0,4,'khoa.trananh2@gmail.com',0,0,5,3,3,0,0,0,4,0,0,0,0,0,0,0,0,'12/17/2020 11:32:47',0),(50,0,2,2,0,0,3,'namlee.liv@gmail.com',0,0,3,3,3,0,2,0,3,0,0,0,0,0,0,0,0,'12/17/2020 11:36:38',0),(51,0,0,0,0,0,3,'phucnguyenty1694@gmail.com',0,0,3,3,3,0,0,0,3,0,0,0,3,0,0,0,0,'12/17/2020 11:43:59',0),(52,0,0,0,0,0,3,'Nguyenphucduy12061997@gmail.com',0,0,3,3,3,0,0,0,3,0,0,0,0,0,0,3,0,'12/17/2020 15:17:31',0),(53,5,0,5,5,0,5,'nguyenhoangtu24061999@gmail.com',0,0,5,5,5,0,0,3,5,0,0,0,0,0,0,5,0,'12/17/2020 15:54:09',5),(54,3,4,5,4,3,5,'vtt18011997@gmail.com',3,4,5,5,4,5,3,5,5,5,4,5,4,3,3,5,5,'12/17/2020 16:26:18',3),(55,0,0,3,4,0,4,'baocules@gmail.com',0,0,4,4,4,0,0,0,4,0,0,0,0,0,0,2,0,'12/18/2020 10:28:52',0),(56,0,0,4,5,0,5,'lethingocanh0904@gmail.com',0,0,5,5,3,0,0,0,3,3,0,1,2,0,0,5,0,'12/18/2020 10:29:53',0),(57,0,0,3,4,0,3,'messilonadnb1@gmail.com',0,0,4,5,4,0,0,0,3,0,0,0,1,0,0,0,0,'12/18/2020 10:30:29',0);
/*!40000 ALTER TABLE `data_recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (54),(54),(54),(54);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK72mt33dhhs48hf9gcqrq4fxte` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (10,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Securing Spring Boot APIs and SPAs with OAuth 2.0','https://auth0.com/blog/securing-spring-boot-apis-and-spas-with-oauth2/?utm_source=reddit&utm_medium=sc&utm_campaign=springboot_spa_securing',5),(14,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Add Social Login to Your Spring Boot 2.0 app','https://developer.okta.com/blog/2018/07/24/social-spring-boot',5),(18,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Easy way to detect Device in Java Web Application using Spring Mobile - Source code to download from GitHub','https://www.opencodez.com/java/device-detection-using-spring-mobile.htm',5),(22,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Building Your First Spring Boot Web Application - DZone Java','https://dzone.com/articles/building-your-first-spring-boot-web-application-ex',3),(26,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Spring Cloud GCP 1.0 Released','https://cloud.google.com/blog/products/gcp/calling-java-developers-spring-cloud-gcp-1-0-is-now-generally-available',5),(30,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Detailed steps to send encrypted email using Java / Spring Boot - Source code to download from GitHub','https://www.opencodez.com/java/send-encrypted-email-using-java.htm',5),(34,NULL,'2020-11-06 15:11:46',NULL,'2020-11-06 15:11:46','Building Microservices with Spring Boot Fat (Uber) Jar','https://jelastic.com/blog/building-microservices-with-spring-boot-fat-uber-jar/',3),(38,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','Tutorial series about building microservices with SpringBoot (with Netflix OSS)','https://medium.com/@marcus.eisele/implementing-a-microservice-architecture-with-spring-boot-intro-cdb6ad16806c',5),(42,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','File download example using Spring REST Controller','https://www.jeejava.com/file-download-example-using-spring-rest-controller/',5),(46,NULL,'2020-11-06 15:11:47',NULL,'2020-11-06 15:11:47','Simplest way to Upload and Download Files in Java with Spring Boot - Code to download from Github','https://www.opencodez.com/uncategorized/file-upload-and-download-in-java-spring-boot.htm',5),(62,'haitan28102408@gmail.com','2020-12-10 14:33:01','haitan28102408@gmail.com','2020-12-10 14:33:01','Tuyển job các bạn ơi','5 người\n',9);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `education` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `url_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'Bachelors in Computer Science','user@gmail.com',_binary '','4 Years as a Software Engineer','John Doe','$2a$10$RWxrPfkpEf2xD9VLbJQ90uP4n6e4Z9HORTrPeo93qUC8HPEuUK0xy','React, Spring Boot, Java, Python','JoDoe','https://firebasestorage.googleapis.com/v0/b/do-an-tot-nghiep-b1345.appspot.com/o/avatar%2Favatar.jpg?alt=media&token=cb1c88e3-d058-448f-b441-c3d521cf98b0'),(4,'Master in CS','admin@gmail.com',_binary '','12 Years as a Web Developer','Admin Uiet','$2a$10$RWxrPfkpEf2xD9VLbJQ90uP4n6e4Z9HORTrPeo93qUC8HPEuUK0xy','JavaScript, Angular, Java, Python, Ruby','AdminUe','https://firebasestorage.googleapis.com/v0/b/do-an-tot-nghiep-b1345.appspot.com/o/avatar%2Favatar.jpg?alt=media&token=cb1c88e3-d058-448f-b441-c3d521cf98b0'),(5,'PhD in Artificial Intel.','super@gmail.com',_binary '','23 years as a Database Professional','Super Duper','$2a$10$RWxrPfkpEf2xD9VLbJQ90uP4n6e4Z9HORTrPeo93qUC8HPEuUK0xy','SQL, MangoDB, Spring MVC','SuperrrR','https://firebasestorage.googleapis.com/v0/b/do-an-tot-nghiep-b1345.appspot.com/o/avatar%2Favatar.jpg?alt=media&token=cb1c88e3-d058-448f-b441-c3d521cf98b0'),(9,'Bach Khoa Da Nang','haitan28102408@gmail.com',_binary '','5','Truong Tan Hai','$2a$12$oyVUxz5FGR0FM1Oj1zl6MOXozk65m502o5BupNyUEUXGzHpe2d9NO','Java, Angular','hai_tan','https://firebasestorage.googleapis.com/v0/b/do-an-tot-nghiep-b1345.appspot.com/o/avatar%2Fhai_tan_avatar_1608020060294?alt=media'),(8,'Bach Khoa Da Nang','hai.truong@gmail.com',_binary '','3','Truong Tan Hai','$2a$12$Wjcm0cz6/J8zmAuppsSRBO7L8OaWaUl0ipdlJnI5XVcNncgblvo..','Java, C#','user','https://firebasestorage.googleapis.com/v0/b/do-an-tot-nghiep-b1345.appspot.com/o/avatar%2Fuser_avatar?alt=media');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (3,1),(4,2),(5,1),(5,2),(6,1),(7,1),(8,1),(9,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-19 23:22:46
