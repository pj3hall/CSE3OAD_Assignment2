-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)


USE `your-database-name`; -- TODO: you have been assigned a database name by ICT change this line accordingly

DROP TABLE IF EXISTS `grocery`;
DROP TABLE IF EXISTS `item`;

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `name` varchar(20) NOT NULL,
  `expires` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`name`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;

INSERT INTO `item` VALUES ('Beef',1),('Broccoli',1),('Cabbage',1),('Fish',1),('Frozen Yogurt',0),('Gorgonzola',1),('Milk',0),('Oranges',0),('Paddle Pop',0),('Pecorino',1),('Tangerines',0),('Tofu',0);

UNLOCK TABLES;

--
-- Table structure for table `grocery`
--

CREATE TABLE `grocery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(20) NOT NULL,
  `date` varchar(10) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `section` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `itemName_idx` (`itemName`),
  CONSTRAINT `fk_grocery_item` FOREIGN KEY (`itemName`) REFERENCES `item` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `grocery`
--

LOCK TABLES `grocery` WRITE;

INSERT INTO `grocery` VALUES (5,'Frozen Yogurt','16/08/2018',1,'FREEZER'),(6,'Paddle Pop','17/08/2018',1,'FREEZER'),(19,'Beef','23/08/2018',1,'MEAT'),(33,'Beef','24/08/2018',3,'MEAT');

UNLOCK TABLES;

-- Dump completed