-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: putovanja
-- ------------------------------------------------------
-- Server version	5.7.27

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
-- Table structure for table `kategorija`
--

DROP TABLE IF EXISTS `kategorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategorija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorija`
--

LOCK TABLES `kategorija` WRITE;
/*!40000 ALTER TABLE `kategorija` DISABLE KEYS */;
INSERT INTO `kategorija` VALUES (1,'PLAŽA'),(2,'SUNCE'),(3,'MORE'),(4,'EUROPA'),(5,'AUSTRALIJA'),(6,'AMERIKA'),(7,'PLANINE'),(8,'ZIMA'),(9,'SKIJANJE'),(10,'AFRIKA');
/*!40000 ALTER TABLE `kategorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefon` varchar(45) NOT NULL,
  `korisnicko_ime` varchar(45) NOT NULL,
  `lozinka` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `korisnicko_ime_UNIQUE` (`korisnicko_ime`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'admin','admin','admin','-','admin','$2a$10$WRrMt.oXHrhUmon.HBDf1u9FegkCsI9/nE7JM5VZK3myPN/RgFoyS'),(11,'Marijan','Prezime','email@email.com','123','maki','$2a$10$ySQtUWfLeRNR/sFs8go5ce99ySP7adGwQpP3YiJ8o2JOqGkv7hXrW');
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik_uloga`
--

DROP TABLE IF EXISTS `korisnik_uloga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik_uloga` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_korisnik` int(11) NOT NULL,
  `fk_uloga` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_korisnika_korisnik_uloga_idx` (`fk_korisnik`),
  KEY `fk_uloge_korisnik_uloga_idx` (`fk_uloga`),
  CONSTRAINT `fk_korisnika_korisnik_uloga` FOREIGN KEY (`fk_korisnik`) REFERENCES `korisnik` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uloge_korisnik_uloga` FOREIGN KEY (`fk_uloga`) REFERENCES `uloga` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik_uloga`
--

LOCK TABLES `korisnik_uloga` WRITE;
/*!40000 ALTER TABLE `korisnik_uloga` DISABLE KEYS */;
INSERT INTO `korisnik_uloga` VALUES (1,1,1),(2,1,2),(12,11,2);
/*!40000 ALTER TABLE `korisnik_uloga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lokacija`
--

DROP TABLE IF EXISTS `lokacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lokacija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `opis` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lokacija`
--

LOCK TABLES `lokacija` WRITE;
/*!40000 ALTER TABLE `lokacija` DISABLE KEYS */;
INSERT INTO `lokacija` VALUES (7,'Split','Split je najveći grad u Dalmaciji, te po broju stanovnika i površini drugi najmnogoljudniji tj. najveći grad u Hrvatskoj.\r\n\r\nPrema posljednjem popisu stanovništva, provedenom 2011. godine, Split ima 178.192 stanovnika, druga je po veličini hrvatska trgovačka luka, najveća putnička luka u Hrvatskoj i treća luka na Sredozemlju po broju putnika. Upravno je središte Splitsko-dalmatinske županije i gravitira mu područje triju najjužnijih hrvatskih županija (nekadašnja Zajednica općina Split), te dio Hercegovine, pa i Bosne. U luci Lori na sjevernoj strani poluotoka nalazi se sjedište Hrvatske ratne mornarice. Gradsko središte čini starovjekovna Dioklecijanova palača iz 4. stoljeća (pod UNESCO-vom zaštitom od 26. listopada 1979. godine[2]), što je jedinstven primjer u svijetu.'),(8,'Makarska','Makarska je priobalni grad u Splitsko-dalmatinskoj županiji, smješten podno planine Biokovo. Središte je Makarskog primorja (poznato pod imenom, Makarska Rivijera), mikroregije koja se proteže od Brela na zapadu do Gradca na istoku. Makarska s gradskim naseljem Veliko Brdo ima 13.834 stanovnika.[1]\r\n\r\nPovijesno je Makarska značajna kao nekadašnje sjedište Makarske biskupije, a i današnja Splitsko-makarska nadbiskupija nosi makarsko ime u sebi.'),(9,'Bali','Bali je najzapadniji otok Maloga sundajskog otočja (Indonezija), između Lomboka i Jave, 5.632 km2, 3.900.000 stanovnika (2010).[1].) . Također, to je i istoimena indonezijska pokrajina. Plodno tercijarno humlje izdiže se prema istoku u vulkanskom usponu Gunung Agung 3200 m nad morem. Otok je bogat rižom i kokosovom palmom, kukuruzom i pamukom, duhanom i kavom, različitim voćem i stokom, a izvozi mnogo riže i dosta kave i stoke. Danas je najjača industrija na Baliju turizam.');
/*!40000 ALTER TABLE `lokacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lokacija_kategorija`
--

DROP TABLE IF EXISTS `lokacija_kategorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lokacija_kategorija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_lokacija` int(11) NOT NULL,
  `fk_kategorija` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lokacija_lokacija_kategorija_idx` (`fk_lokacija`),
  KEY `fk_kategorija_lokacija_kategorija_idx` (`fk_kategorija`),
  CONSTRAINT `fk_kategorija_lokacija_kategorija` FOREIGN KEY (`fk_kategorija`) REFERENCES `kategorija` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lokacija_lokacija_kategorija` FOREIGN KEY (`fk_lokacija`) REFERENCES `lokacija` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lokacija_kategorija`
--

LOCK TABLES `lokacija_kategorija` WRITE;
/*!40000 ALTER TABLE `lokacija_kategorija` DISABLE KEYS */;
INSERT INTO `lokacija_kategorija` VALUES (13,7,1),(14,7,2),(15,7,3),(16,7,4),(17,8,1),(18,8,2),(19,8,3),(20,8,4),(21,9,1),(22,9,2),(23,9,3);
/*!40000 ALTER TABLE `lokacija_kategorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezervacija`
--

DROP TABLE IF EXISTS `rezervacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rezervacija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pocetak` datetime NOT NULL,
  `kraj` datetime NOT NULL,
  `ukupna_cijena` decimal(10,2) NOT NULL,
  `broj_osoba` int(11) NOT NULL,
  `fk_korisnik` int(11) NOT NULL,
  `fk_smjestaj` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_korisnika_rezervacija_idx` (`fk_korisnik`),
  KEY `fk_smjestaja_rezervacija_idx` (`fk_smjestaj`),
  CONSTRAINT `fk_korisnika_rezervacija` FOREIGN KEY (`fk_korisnik`) REFERENCES `korisnik` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_smjestaja_rezervacija` FOREIGN KEY (`fk_smjestaj`) REFERENCES `smjestaj` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezervacija`
--

LOCK TABLES `rezervacija` WRITE;
/*!40000 ALTER TABLE `rezervacija` DISABLE KEYS */;
INSERT INTO `rezervacija` VALUES (1,'2020-07-17 00:00:00','2020-07-18 00:00:00',400.00,1,11,4);
/*!40000 ALTER TABLE `rezervacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slika_lokacije`
--

DROP TABLE IF EXISTS `slika_lokacije`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slika_lokacije` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `putanja_slike` varchar(200) NOT NULL,
  `fk_lokacija` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lokacije_slika_idx` (`fk_lokacija`),
  CONSTRAINT `fk_lokacije_slika` FOREIGN KEY (`fk_lokacija`) REFERENCES `lokacija` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slika_lokacije`
--

LOCK TABLES `slika_lokacije` WRITE;
/*!40000 ALTER TABLE `slika_lokacije` DISABLE KEYS */;
INSERT INTO `slika_lokacije` VALUES (4,'/images/uploaded/1594649943933_split_1.jpg',7),(5,'/images/uploaded/1594649943936_split_2.jpg',7),(6,'/images/uploaded/1594649943936_split_3.jpg',7),(7,'/images/uploaded/1594650111456_makarska_1.jpg',8),(8,'/images/uploaded/1594650111456_makarska_2.jpg',8),(9,'/images/uploaded/1594650111456_makarska_3.jpg',8),(10,'/images/uploaded/1594656379396_bali_1.jpg',9),(11,'/images/uploaded/1594656379397_bali_2.jpg',9),(12,'/images/uploaded/1594656379397_bali_3.jpg',9);
/*!40000 ALTER TABLE `slika_lokacije` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slika_smjestaja`
--

DROP TABLE IF EXISTS `slika_smjestaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slika_smjestaja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `putanja_slike` varchar(200) NOT NULL,
  `fk_smjestaj` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_smjestaja_slika_idx` (`fk_smjestaj`),
  CONSTRAINT `fk_smjestaja_slika` FOREIGN KEY (`fk_smjestaj`) REFERENCES `smjestaj` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slika_smjestaja`
--

LOCK TABLES `slika_smjestaja` WRITE;
/*!40000 ALTER TABLE `slika_smjestaja` DISABLE KEYS */;
INSERT INTO `slika_smjestaja` VALUES (1,'/images/uploaded/1594655998535_apartman_1.jpg',3),(2,'/images/uploaded/1594655998545_apartman_2.jpg',3),(3,'/images/uploaded/1594655998546_apartman_3.jpg',3),(4,'/images/uploaded/1594981844401_apartman_4.jpg',4),(5,'/images/uploaded/1594981844403_apartman_5.jpg',4),(6,'/images/uploaded/1594981844403_apartman_6.jpg',4),(7,'/images/uploaded/1595002795125_apartman_1.jpg',5),(8,'/images/uploaded/1595002795126_apartman_2.jpg',5),(9,'/images/uploaded/1595002795126_apartman_3.jpg',5),(10,'/images/uploaded/1595002795126_apartman_4.jpg',5);
/*!40000 ALTER TABLE `slika_smjestaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smjestaj`
--

DROP TABLE IF EXISTS `smjestaj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `smjestaj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `cijena` decimal(10,2) NOT NULL,
  `email` varchar(45) NOT NULL,
  `max_osoba` int(11) NOT NULL,
  `fk_lokacija` int(11) NOT NULL,
  `opis` varchar(1000) NOT NULL,
  `broj_zvjezdica` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lokacije_smjestaj_idx` (`fk_lokacija`),
  CONSTRAINT `fk_lokacije_smjestaj` FOREIGN KEY (`fk_lokacija`) REFERENCES `lokacija` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smjestaj`
--

LOCK TABLES `smjestaj` WRITE;
/*!40000 ALTER TABLE `smjestaj` DISABLE KEYS */;
INSERT INTO `smjestaj` VALUES (3,'Apartman Luka',329.00,'bla@bla.com',3,8,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',3),(4,'Apartman Matko',400.00,'matko@matko.com',3,7,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',4),(5,'Apartman Marko',250.00,'marko@marko.com',2,7,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',4);
/*!40000 ALTER TABLE `smjestaj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uloga`
--

DROP TABLE IF EXISTS `uloga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uloga` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uloga`
--

LOCK TABLES `uloga` WRITE;
/*!40000 ALTER TABLE `uloga` DISABLE KEYS */;
INSERT INTO `uloga` VALUES (1,'ADMIN'),(2,'KORISNIK');
/*!40000 ALTER TABLE `uloga` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-17 22:08:31
