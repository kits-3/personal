-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.4-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for shoes_shop
CREATE DATABASE IF NOT EXISTS `shoes_shop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shoes_shop`;

-- Dumping structure for table shoes_shop.mainorder
CREATE TABLE IF NOT EXISTS `mainorder` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `UserLoginID` text DEFAULT NULL,
  `OrderItemID` int(11) DEFAULT NULL,
  `TotalPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table shoes_shop.orderitem
CREATE TABLE IF NOT EXISTS `orderitem` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OrderItemID` int(11) DEFAULT NULL,
  `CustomerLoginID` varchar(50) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `ProductName` varchar(50) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_orderitem_product` (`ProductID`),
  KEY `FK_orderitem_user` (`CustomerLoginID`),
  KEY `FK_orderitem_product_2` (`ProductName`),
  CONSTRAINT `FK_orderitem_product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_orderitem_product_2` FOREIGN KEY (`ProductName`) REFERENCES `product` (`ProductName`),
  CONSTRAINT `FK_orderitem_user` FOREIGN KEY (`CustomerLoginID`) REFERENCES `user` (`UserLoginID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table shoes_shop.product
CREATE TABLE IF NOT EXISTS `product` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(50) DEFAULT NULL,
  `ProductPrice` int(11) DEFAULT NULL,
  `ProductQuantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProductID`) USING BTREE,
  UNIQUE KEY `ProductName` (`ProductName`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table shoes_shop.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table shoes_shop.user
CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) DEFAULT NULL,
  `UserLoginID` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `Moneyleft` int(11) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UserID`) USING BTREE,
  UNIQUE KEY `UserLoginID` (`UserLoginID`),
  KEY `FK_customer_role` (`role`),
  CONSTRAINT `FK_customer_role` FOREIGN KEY (`role`) REFERENCES `role` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
