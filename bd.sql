-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: patronessoftware
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Tecnologia'),(2,'Telefonia'),(3,'Linea Blanca');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineaordencompras`
--

DROP TABLE IF EXISTS `lineaordencompras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lineaordencompras` (
  `cantidad` int(11) DEFAULT NULL,
  `ordencompras_id` int(11) NOT NULL,
  `productos_id` int(11) NOT NULL,
  KEY `fk_LineaOrdenCompras_ordencompras_idx` (`ordencompras_id`),
  KEY `fk_lineacompra_producto_idx` (`productos_id`),
  CONSTRAINT `fk_lineacompra_ordencompra` FOREIGN KEY (`ordencompras_id`) REFERENCES `ordencompras` (`id`),
  CONSTRAINT `fk_lineacompra_producto` FOREIGN KEY (`productos_id`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineaordencompras`
--

LOCK TABLES `lineaordencompras` WRITE;
/*!40000 ALTER TABLE `lineaordencompras` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineaordencompras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordencompras`
--

DROP TABLE IF EXISTS `ordencompras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ordencompras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordencompras`
--

LOCK TABLES `ordencompras` WRITE;
/*!40000 ALTER TABLE `ordencompras` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordencompras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `unidad` int(11) DEFAULT NULL,
  `categorias_id` int(11) NOT NULL,
  `proveedor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_producto_categoria_idx` (`categorias_id`),
  KEY `fk_producto_proveedor_idx` (`proveedor_id`),
  CONSTRAINT `fk_producto_categoria` FOREIGN KEY (`categorias_id`) REFERENCES `categorias` (`id`),
  CONSTRAINT `fk_producto_proveedor` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(45) DEFAULT NULL,
  `rubro` varchar(45) DEFAULT NULL,
  `ruc` double DEFAULT NULL,
  `nombre_comercial` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `referencia` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contacto` varchar(45) DEFAULT NULL,
  `fax` double DEFAULT NULL,
  `telefono_uno` double DEFAULT NULL,
  `telefono_dos` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-22  1:44:42
