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


-- Dumping database structure for vending_machine_management
CREATE DATABASE IF NOT EXISTS `vending_machine_management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vending_machine_management`;

-- Dumping structure for table vending_machine_management.orderitem
CREATE TABLE IF NOT EXISTS `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT '',
  `moneytotal` int(11) DEFAULT 0,
  `status` int(11) DEFAULT 0,
  `storemachineid` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_orderitem_storemachine` (`storemachineid`),
  CONSTRAINT `FK_orderitem_storemachine` FOREIGN KEY (`storemachineid`) REFERENCES `storemachine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Dumping data for table vending_machine_management.orderitem: ~11 rows (approximately)
DELETE FROM `orderitem`;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` (`id`, `name`, `moneytotal`, `status`, `storemachineid`) VALUES
	(1, '', 10, 1, 1),
	(2, '', 10, 1, 1),
	(3, '', 112, 1, 3),
	(4, '', 40, 1, 1),
	(5, '', 110, 1, 2),
	(6, '', 40, 1, 1),
	(7, '', 42, 1, 3),
	(8, '', 10, 1, 1),
	(9, '', 10, 1, 1),
	(10, '', 10, 1, 1),
	(11, '', 10, 1, 1),
	(12, '', 0, 1, 1);
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;

-- Dumping structure for table vending_machine_management.orderitem_product
CREATE TABLE IF NOT EXISTS `orderitem_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) NOT NULL,
  `orderitemid` int(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orderitem_product_orderitem` (`orderitemid`),
  KEY `FK_orderitem_product_product` (`productid`),
  CONSTRAINT `FK_orderitem_product_orderitem` FOREIGN KEY (`orderitemid`) REFERENCES `orderitem` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_orderitem_product_product` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- Dumping data for table vending_machine_management.orderitem_product: ~29 rows (approximately)
DELETE FROM `orderitem_product`;
/*!40000 ALTER TABLE `orderitem_product` DISABLE KEYS */;
INSERT INTO `orderitem_product` (`id`, `productid`, `orderitemid`, `count`) VALUES
	(1, 3, 1, 1),
	(2, 4, 1, 0),
	(3, 5, 1, 0),
	(4, 3, 2, 1),
	(5, 4, 2, 0),
	(6, 5, 2, 0),
	(7, 15, 3, 4),
	(8, 16, 3, 2),
	(9, 17, 3, 4),
	(10, 3, 4, 4),
	(11, 4, 4, 0),
	(12, 5, 4, 0),
	(13, 12, 5, 5),
	(14, 13, 5, 5),
	(15, 14, 5, 1),
	(16, 3, 6, 4),
	(17, 4, 6, 0),
	(18, 5, 6, 0),
	(19, 15, 7, 2),
	(20, 16, 7, 2),
	(21, 17, 7, 0),
	(22, 3, 8, 1),
	(23, 4, 8, 0),
	(24, 5, 8, 0),
	(25, 3, 9, 1),
	(26, 4, 9, 0),
	(27, 5, 9, 0),
	(28, 3, 10, 1),
	(29, 3, 11, 1);
/*!40000 ALTER TABLE `orderitem_product` ENABLE KEYS */;

-- Dumping structure for table vending_machine_management.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT '',
  `price` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `storemachineid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_storemachine` (`storemachineid`),
  CONSTRAINT `FK_product_storemachine` FOREIGN KEY (`storemachineid`) REFERENCES `storemachine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- Dumping data for table vending_machine_management.product: ~9 rows (approximately)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `name`, `price`, `total`, `status`, `storemachineid`) VALUES
	(3, 'cake', 10, 0, 1, 1),
	(4, 'hamberger', 8, 100, 1, 1),
	(5, 'pizza', 12, 100, 1, 1),
	(12, 'coca', 10, 100, 1, 2),
	(13, 'caffee', 10, 100, 1, 2),
	(14, 'juice', 10, 10, 1, 2),
	(15, 'snackOne', 9, 100, 1, 3),
	(16, 'snackSecond', 12, 100, 1, 3),
	(17, 'snackThird', 13, 100, 1, 3),
	(21, 'test', 10, 100, NULL, 5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table vending_machine_management.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(256) NOT NULL,
  `name` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table vending_machine_management.role: ~2 rows (approximately)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `code`, `name`) VALUES
	(1, 'ADMIN', 'ADMIN'),
	(2, 'NORMALSTAFF', 'NORMALSTAFF');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table vending_machine_management.storemachine
CREATE TABLE IF NOT EXISTS `storemachine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_storemachine_user` (`userid`),
  CONSTRAINT `FK_storemachine_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table vending_machine_management.storemachine: ~4 rows (approximately)
DELETE FROM `storemachine`;
/*!40000 ALTER TABLE `storemachine` DISABLE KEYS */;
INSERT INTO `storemachine` (`id`, `userid`, `name`, `address`, `status`) VALUES
	(1, 1, 'food machine', 'address 1', 1),
	(2, 1, 'drink machine', 'address 2', 1),
	(3, 1, 'snack machine', 'address 3', 1),
	(5, 1, 'testmachine', 'address4', 1);
/*!40000 ALTER TABLE `storemachine` ENABLE KEYS */;

-- Dumping structure for table vending_machine_management.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(256) DEFAULT NULL,
  `username` varchar(256) NOT NULL DEFAULT '',
  `password` varchar(256) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table vending_machine_management.user: ~2 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `fullname`, `username`, `password`, `status`) VALUES
	(1, 'admin', 'admin', 'admin', 1),
	(2, 'normalstaff', 'normalstaff', 'normalstaff', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table vending_machine_management.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_role_user` (`userid`) USING BTREE,
  KEY `FK_user_role_role` (`roleid`),
  CONSTRAINT `FK_user_role_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_user_role_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table vending_machine_management.user_role: ~2 rows (approximately)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `userid`, `roleid`) VALUES
	(1, 1, 1),
	(2, 2, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
