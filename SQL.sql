-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: projeto
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `aeronave`
--

DROP TABLE IF EXISTS `aeronave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aeronave` (
  `id_aeronave` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo` int(11) DEFAULT NULL,
  `nome` text,
  `qtd_assentos` int(11) DEFAULT NULL,
  `fileira` int(11) DEFAULT NULL,
  `coluna` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_aeronave`)
) ENGINE=InnoDB AUTO_INCREMENT=252 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeronave`
--

LOCK TABLES `aeronave` WRITE;
/*!40000 ALTER TABLE `aeronave` DISABLE KEYS */;
INSERT INTO `aeronave` VALUES (1,1,'Boing',100,10,6),(250,1,'f',2,2,2);
/*!40000 ALTER TABLE `aeronave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aeroporto`
--

DROP TABLE IF EXISTS `aeroporto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aeroporto` (
  `id_aeroporto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text,
  `cidade` text,
  `estado` text,
  PRIMARY KEY (`id_aeroporto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeroporto`
--

LOCK TABLES `aeroporto` WRITE;
/*!40000 ALTER TABLE `aeroporto` DISABLE KEYS */;
INSERT INTO `aeroporto` VALUES (1,'Congonhas','São Paulo','São Paulo'),(2,'Galeão','Rio de Janeiro','Rio de Janeiro');
/*!40000 ALTER TABLE `aeroporto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passageiro`
--

DROP TABLE IF EXISTS `passageiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passageiro` (
  `id_passageiro` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` text,
  `nome` text,
  `sobrenome` text,
  `tratamento` text,
  `nascimento` date DEFAULT NULL,
  PRIMARY KEY (`id_passageiro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passageiro`
--

LOCK TABLES `passageiro` WRITE;
/*!40000 ALTER TABLE `passageiro` DISABLE KEYS */;
INSERT INTO `passageiro` VALUES (1,'Criança','1','1','Sr',NULL),(2,'Bebê','2','2','Sr',NULL),(3,'Adulto','Fabiano','Garcia','Sra',NULL),(4,'Adulto','Lucas',' Graneri','Sra',NULL),(5,'Adulto','Guilherme ','Mustafe','Sra',NULL);
/*!40000 ALTER TABLE `passageiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passagem`
--

DROP TABLE IF EXISTS `passagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passagem` (
  `id_passagem` int(11) NOT NULL AUTO_INCREMENT,
  `id_voo` int(11) DEFAULT NULL,
  `email` text,
  `celular` text,
  `status` text,
  `fileira` int(11) DEFAULT NULL,
  `coluna` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_passagem`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passagem`
--

LOCK TABLES `passagem` WRITE;
/*!40000 ALTER TABLE `passagem` DISABLE KEYS */;
INSERT INTO `passagem` VALUES (1,1,'e','e','Checked',20,20),(2,1,'fabiano@whitebr.com','111111111','Pendente',0,0),(3,6,'a','1','Pendente',0,0);
/*!40000 ALTER TABLE `passagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_pass_passg`
--

DROP TABLE IF EXISTS `rel_pass_passg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rel_pass_passg` (
  `id_rel` int(11) NOT NULL AUTO_INCREMENT,
  `id_passagem` int(11) DEFAULT NULL,
  `id_passageiro` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_rel`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_pass_passg`
--

LOCK TABLES `rel_pass_passg` WRITE;
/*!40000 ALTER TABLE `rel_pass_passg` DISABLE KEYS */;
INSERT INTO `rel_pass_passg` VALUES (1,1,1),(2,1,2),(3,2,3),(4,2,4),(5,2,5);
/*!40000 ALTER TABLE `rel_pass_passg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_aeronave`
--

DROP TABLE IF EXISTS `tipo_aeronave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_aeronave` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_aeronave`
--

LOCK TABLES `tipo_aeronave` WRITE;
/*!40000 ALTER TABLE `tipo_aeronave` DISABLE KEYS */;
INSERT INTO `tipo_aeronave` VALUES (1,'Comercial'),(2,'Domestico');
/*!40000 ALTER TABLE `tipo_aeronave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo` int(11) DEFAULT NULL,
  `nome` text,
  `usuario` text,
  `senha` text,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'Fabiano','admin','admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voo`
--

DROP TABLE IF EXISTS `voo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voo` (
  `id_voo` int(11) NOT NULL AUTO_INCREMENT,
  `id_origem` int(11) DEFAULT NULL,
  `id_destino` int(11) DEFAULT NULL,
  `id_aeronave` int(11) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `status` text,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`id_voo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voo`
--

LOCK TABLES `voo` WRITE;
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
INSERT INTO `voo` VALUES (1,1,2,1,NULL,'Pendente',150),(6,1,2,1,NULL,'Concluido',190),(7,1,2,1,NULL,'Concluido',190);
/*!40000 ALTER TABLE `voo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-25 23:43:42
