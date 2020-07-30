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


-- Dumping database structure for computer
CREATE DATABASE IF NOT EXISTS `computer` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `computer`;

-- Dumping structure for table computer.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CategoryName` (`CategoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table computer.category: ~7 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `CategoryName`) VALUES
	(4, 'ASUS'),
	(3, 'DELL'),
	(2, 'HP'),
	(6, 'Lenovo'),
	(8, 'lewlew'),
	(5, 'MacBook'),
	(1, 'ThinkPad');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table computer.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_user` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `Money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `FK_customer_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`User`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- Dumping data for table computer.customer: ~5 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `id_user`, `name`, `address`, `sdt`, `Money`) VALUES
	(1, 'user1', 'nghia', 'HCM', '000777', 20000),
	(2, 'user2', 'Minh', 'Đà Nẵng', '000999', 10000),
	(3, 'user3', 'V.Anh', 'Hà Nội', '000888', 0),
	(16, 'user4', 'anonymous', NULL, NULL, 0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table computer.order
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `OrderName` varchar(50) DEFAULT NULL,
  `id_user` varchar(50) DEFAULT NULL,
  `id_product` varchar(200) DEFAULT NULL,
  `OrderDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_user` (`id_user`),
  KEY `FK_order_product` (`id_product`),
  CONSTRAINT `FK_order_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`ProductName`),
  CONSTRAINT `FK_order_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`User`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- Dumping data for table computer.order: ~6 rows (approximately)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`id`, `OrderName`, `id_user`, `id_product`, `OrderDate`) VALUES
	(1, 'order01', 'user3', 'Asus VivoBook A542U i5 Ram 8Gb 15.6inch', '2020-07-24 08:49:31'),
	(2, 'order02', 'user2', 'HP EliteBook X360 830 G6 i7 8665u 8Gb FullHD Touch', '2020-07-20 09:50:09'),
	(3, 'order03', 'user1', 'LENOVO THINKPAD X1 CARBON GEN 6', '2020-07-22 10:50:44'),
	(33, 'order 7', 'user1', 'DellL atitudeE7480i7-6600U 16GB FullHD', '2020-07-30 08:49:30'),
	(43, NULL, 'user2', 'ThinkPad T490 Core i5 10210U New Seal BH Lenovo Vietnam', '2020-07-30 09:25:41'),
	(44, NULL, 'user2', 'ThinkPad T490 Core i5 10210U New Seal BH Lenovo Vietnam', '2020-07-30 09:26:27');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- Dumping structure for table computer.order_detail
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_order` int(10) DEFAULT NULL,
  `id_ProductName` varchar(200) DEFAULT NULL,
  `Quantity` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_detail_order` (`id_order`),
  KEY `FK_order_detail_product` (`id_ProductName`),
  CONSTRAINT `FK_order_detail_order` FOREIGN KEY (`id_order`) REFERENCES `order` (`id`),
  CONSTRAINT `FK_order_detail_product` FOREIGN KEY (`id_ProductName`) REFERENCES `product` (`ProductName`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table computer.order_detail: ~6 rows (approximately)
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` (`id`, `id_order`, `id_ProductName`, `Quantity`) VALUES
	(1, 1, 'Asus VivoBook A542U i5 Ram 8Gb 15.6inch', 1),
	(2, 2, 'HP EliteBook X360 830 G6 i7 8665u 8Gb FullHD Touch', 1),
	(3, 3, 'LENOVO THINKPAD X1 CARBON GEN 6', 3),
	(18, 33, 'DellL atitudeE7480i7-6600U 16GB FullHD', 1),
	(19, 43, 'ThinkPad T490 Core i5 10210U New Seal BH Lenovo Vietnam', 1),
	(20, 44, 'ThinkPad T490 Core i5 10210U New Seal BH Lenovo Vietnam', 1);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;

-- Dumping structure for table computer.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_category` varchar(50) DEFAULT NULL,
  `ProductName` varchar(100) DEFAULT NULL,
  `UnitPrice` int(10) DEFAULT NULL,
  `UnitInStock` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ProductName` (`ProductName`),
  KEY `id_category` (`id_category`),
  CONSTRAINT `FK_product_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`CategoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table computer.product: ~8 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `id_category`, `ProductName`, `UnitPrice`, `UnitInStock`) VALUES
	(2, 'DELL', 'Dell Inspiron 5593 i5 1035G1 Ram 8Gb MX230 2Gb FHD', 600, 13),
	(3, 'HP', 'HP EliteBook X360 830 G6 i7 8665u 8Gb FullHD Touch', 900, 28),
	(4, 'ASUS', 'Asus VivoBook A542U i5 Ram 8Gb 15.6inch', 300, 19),
	(5, 'MacBook', 'MacBook Pro 2020 13 inch MXK32 Gray  i5 1.4GHz / 8GB / 256GB', 1300, 32),
	(6, 'Lenovo', 'LENOVO THINKPAD X1 CARBON GEN 6', 800, 19),
	(7, 'DELL', 'DellL atitudeE7480i7-6600U 16GB FullHD', 700, 32),
	(19, 'ThinkPad', 'ThinkPad T490 Core i5 10210U New Seal BH Lenovo Vietnam', 1000, 6),
	(20, 'lewlew', '(^o|o^)', 9999, 9);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table computer.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `User` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `User` (`User`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- Dumping data for table computer.user: ~6 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `User`, `Password`, `Type`) VALUES
	(1, 'admin', 'admin', 'admin'),
	(2, 'user1', 'user1', 'user'),
	(3, 'user2', 'user2', 'user'),
	(4, 'user3', 'user3', 'user'),
	(34, 'user4', 'user4', 'user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
