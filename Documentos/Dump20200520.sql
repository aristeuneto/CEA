-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: db_cea
-- ------------------------------------------------------
-- Server version	5.5.62

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
-- Table structure for table `tbl_acesso`
--

DROP TABLE IF EXISTS `tbl_acesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_acesso` (
  `aces_id` int(11) NOT NULL AUTO_INCREMENT,
  `pes_id` int(11) DEFAULT NULL,
  `aces_nome` varchar(30) NOT NULL,
  `aces_login` varchar(10) NOT NULL,
  `aces_senha` varchar(10) NOT NULL,
  `aces_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`aces_id`),
  KEY `pes_id` (`pes_id`),
  CONSTRAINT `tbl_acesso_ibfk_1` FOREIGN KEY (`pes_id`) REFERENCES `tbl_professor` (`pes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_acesso`
--

LOCK TABLES `tbl_acesso` WRITE;
/*!40000 ALTER TABLE `tbl_acesso` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_acesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_aluno`
--

DROP TABLE IF EXISTS `tbl_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_aluno` (
  `pes_id` int(11) NOT NULL AUTO_INCREMENT,
  `alu_escola_origem` varchar(100) NOT NULL,
  `alu_obs` varchar(500) DEFAULT NULL,
  `alu_status` varchar(20) DEFAULT NULL,
  `turma_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pes_id`),
  KEY `turma_id` (`turma_id`),
  CONSTRAINT `tbl_aluno_ibfk_1` FOREIGN KEY (`pes_id`) REFERENCES `tbl_pessoa` (`pes_id`),
  CONSTRAINT `tbl_aluno_ibfk_2` FOREIGN KEY (`turma_id`) REFERENCES `tbl_turma` (`turma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_aluno`
--

LOCK TABLES `tbl_aluno` WRITE;
/*!40000 ALTER TABLE `tbl_aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_aux_bole_disc`
--

DROP TABLE IF EXISTS `tbl_aux_bole_disc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_aux_bole_disc` (
  `aux_id` int(11) NOT NULL AUTO_INCREMENT,
  `bole_id` int(11) DEFAULT NULL,
  `disc_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`aux_id`),
  KEY `bole_id` (`bole_id`),
  KEY `disc_id` (`disc_id`),
  CONSTRAINT `tbl_aux_bole_disc_ibfk_1` FOREIGN KEY (`bole_id`) REFERENCES `tbl_boletim` (`bole_id`),
  CONSTRAINT `tbl_aux_bole_disc_ibfk_2` FOREIGN KEY (`disc_id`) REFERENCES `tbl_disciplina` (`disc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_aux_bole_disc`
--

LOCK TABLES `tbl_aux_bole_disc` WRITE;
/*!40000 ALTER TABLE `tbl_aux_bole_disc` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_aux_bole_disc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_aux_prof_disc`
--

DROP TABLE IF EXISTS `tbl_aux_prof_disc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_aux_prof_disc` (
  `aux_id` int(11) NOT NULL AUTO_INCREMENT,
  `pes_id` int(11) DEFAULT NULL,
  `disc_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`aux_id`),
  KEY `pes_id` (`pes_id`),
  KEY `disc_id` (`disc_id`),
  CONSTRAINT `tbl_aux_prof_disc_ibfk_1` FOREIGN KEY (`pes_id`) REFERENCES `tbl_professor` (`pes_id`),
  CONSTRAINT `tbl_aux_prof_disc_ibfk_2` FOREIGN KEY (`disc_id`) REFERENCES `tbl_disciplina` (`disc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_aux_prof_disc`
--

LOCK TABLES `tbl_aux_prof_disc` WRITE;
/*!40000 ALTER TABLE `tbl_aux_prof_disc` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_aux_prof_disc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_aux_prof_turma`
--

DROP TABLE IF EXISTS `tbl_aux_prof_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_aux_prof_turma` (
  `aux_id` int(11) NOT NULL AUTO_INCREMENT,
  `pes_id` int(11) DEFAULT NULL,
  `turma_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`aux_id`),
  KEY `pes_id` (`pes_id`),
  KEY `turma_id` (`turma_id`),
  CONSTRAINT `tbl_aux_prof_turma_ibfk_1` FOREIGN KEY (`pes_id`) REFERENCES `tbl_professor` (`pes_id`),
  CONSTRAINT `tbl_aux_prof_turma_ibfk_2` FOREIGN KEY (`turma_id`) REFERENCES `tbl_turma` (`turma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_aux_prof_turma`
--

LOCK TABLES `tbl_aux_prof_turma` WRITE;
/*!40000 ALTER TABLE `tbl_aux_prof_turma` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_aux_prof_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_aux_turma_disc`
--

DROP TABLE IF EXISTS `tbl_aux_turma_disc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_aux_turma_disc` (
  `aux_id` int(11) NOT NULL AUTO_INCREMENT,
  `turma_id` int(11) DEFAULT NULL,
  `disc_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`aux_id`),
  KEY `turma_id` (`turma_id`),
  KEY `disc_id` (`disc_id`),
  CONSTRAINT `tbl_aux_turma_disc_ibfk_1` FOREIGN KEY (`turma_id`) REFERENCES `tbl_turma` (`turma_id`),
  CONSTRAINT `tbl_aux_turma_disc_ibfk_2` FOREIGN KEY (`disc_id`) REFERENCES `tbl_disciplina` (`disc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_aux_turma_disc`
--

LOCK TABLES `tbl_aux_turma_disc` WRITE;
/*!40000 ALTER TABLE `tbl_aux_turma_disc` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_aux_turma_disc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_boletim`
--

DROP TABLE IF EXISTS `tbl_boletim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_boletim` (
  `bole_id` int(11) NOT NULL AUTO_INCREMENT,
  `pes_id` int(11) DEFAULT NULL,
  `bole_nota_01` float(3,1) DEFAULT NULL,
  `bole_nota_02` float(3,1) DEFAULT NULL,
  `bole_nota_03` float(3,1) DEFAULT NULL,
  `bole_nota_04` float(3,1) DEFAULT NULL,
  `bole_situacao` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`bole_id`),
  KEY `pes_id` (`pes_id`),
  CONSTRAINT `tbl_boletim_ibfk_1` FOREIGN KEY (`pes_id`) REFERENCES `tbl_aluno` (`pes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_boletim`
--

LOCK TABLES `tbl_boletim` WRITE;
/*!40000 ALTER TABLE `tbl_boletim` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_boletim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_contato`
--

DROP TABLE IF EXISTS `tbl_contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_contato` (
  `cont_id` int(11) NOT NULL AUTO_INCREMENT,
  `cont_celular` varchar(20) NOT NULL,
  `cont_telefone` varchar(20) NOT NULL,
  `cont_email` varchar(50) NOT NULL,
  `cont_terceiros` varchar(100) NOT NULL,
  PRIMARY KEY (`cont_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_contato`
--

LOCK TABLES `tbl_contato` WRITE;
/*!40000 ALTER TABLE `tbl_contato` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_contato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_disciplina`
--

DROP TABLE IF EXISTS `tbl_disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_disciplina` (
  `disc_id` int(11) NOT NULL AUTO_INCREMENT,
  `disc_nome` varchar(30) NOT NULL,
  `disc_desc` varchar(200) NOT NULL,
  `disc_carga` int(3) NOT NULL,
  `disc_status` varchar(10) NOT NULL,
  PRIMARY KEY (`disc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_disciplina`
--

LOCK TABLES `tbl_disciplina` WRITE;
/*!40000 ALTER TABLE `tbl_disciplina` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_endereco`
--

DROP TABLE IF EXISTS `tbl_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_endereco` (
  `end_id` int(11) NOT NULL AUTO_INCREMENT,
  `end_pais` varchar(30) NOT NULL,
  `end_estado` varchar(30) NOT NULL,
  `end_cidade` varchar(50) NOT NULL,
  `end_bairro` varchar(30) NOT NULL,
  `end_rua` varchar(50) NOT NULL,
  `end_cep` varchar(20) NOT NULL,
  `end_num` int(5) NOT NULL,
  PRIMARY KEY (`end_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_endereco`
--

LOCK TABLES `tbl_endereco` WRITE;
/*!40000 ALTER TABLE `tbl_endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_matricula`
--

DROP TABLE IF EXISTS `tbl_matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_matricula` (
  `mat_id` int(11) NOT NULL AUTO_INCREMENT,
  `pes_id` int(11) DEFAULT NULL,
  `mat_ano_letivo` varchar(30) NOT NULL,
  `mat_turno` varchar(30) NOT NULL,
  `mat_serie` varchar(20) NOT NULL,
  `mat_data` date DEFAULT NULL,
  `mat_status` varchar(10) NOT NULL,
  PRIMARY KEY (`mat_id`),
  KEY `pes_id` (`pes_id`),
  CONSTRAINT `tbl_matricula_ibfk_1` FOREIGN KEY (`pes_id`) REFERENCES `tbl_aluno` (`pes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_matricula`
--

LOCK TABLES `tbl_matricula` WRITE;
/*!40000 ALTER TABLE `tbl_matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pessoa`
--

DROP TABLE IF EXISTS `tbl_pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pessoa` (
  `pes_id` int(11) NOT NULL AUTO_INCREMENT,
  `pes_nome` varchar(100) NOT NULL,
  `pes_rg` varchar(15) NOT NULL,
  `pes_cpf` int(20) NOT NULL,
  `pes_dtnasc` date DEFAULT NULL,
  `pes_filiacao` varchar(200) NOT NULL,
  `pes_naturalidade` varchar(50) NOT NULL,
  `pes_status` varchar(20) DEFAULT NULL,
  `cont_id` int(11) DEFAULT NULL,
  `end_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pes_id`),
  KEY `cont_id` (`cont_id`),
  KEY `end_id` (`end_id`),
  CONSTRAINT `tbl_pessoa_ibfk_1` FOREIGN KEY (`cont_id`) REFERENCES `tbl_contato` (`cont_id`),
  CONSTRAINT `tbl_pessoa_ibfk_2` FOREIGN KEY (`end_id`) REFERENCES `tbl_endereco` (`end_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pessoa`
--

LOCK TABLES `tbl_pessoa` WRITE;
/*!40000 ALTER TABLE `tbl_pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_professor`
--

DROP TABLE IF EXISTS `tbl_professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_professor` (
  `pes_id` int(11) NOT NULL AUTO_INCREMENT,
  `prof_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pes_id`),
  CONSTRAINT `tbl_professor_ibfk_1` FOREIGN KEY (`pes_id`) REFERENCES `tbl_pessoa` (`pes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_professor`
--

LOCK TABLES `tbl_professor` WRITE;
/*!40000 ALTER TABLE `tbl_professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_turma`
--

DROP TABLE IF EXISTS `tbl_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_turma` (
  `turma_id` int(11) NOT NULL AUTO_INCREMENT,
  `turma_nome` varchar(30) NOT NULL,
  `turma_descricao` varchar(100) NOT NULL,
  `turma_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`turma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_turma`
--

LOCK TABLES `tbl_turma` WRITE;
/*!40000 ALTER TABLE `tbl_turma` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_cea'
--

--
-- Dumping routines for database 'db_cea'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-20 19:51:02
