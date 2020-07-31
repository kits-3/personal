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


-- Dumping database structure for orderfood
CREATE DATABASE IF NOT EXISTS `orderfood` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `orderfood`;

-- Dumping structure for table orderfood.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(50) DEFAULT NULL,
  `passWordAdmin` varchar(50) DEFAULT NULL,
  `fullNameAdmin` varchar(50) DEFAULT NULL,
  `phoneAdmin` varchar(50) DEFAULT NULL,
  `emailAdmin` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table orderfood.admin: ~1 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
REPLACE INTO `admin` (`id`, `adminName`, `passWordAdmin`, `fullNameAdmin`, `phoneAdmin`, `emailAdmin`) VALUES
	(1, 'admin', 'T@an1995', 'Nguyễn Tô Thế Toàn', '0902438743', 'robocon87@gmail.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table orderfood.order
CREATE TABLE IF NOT EXISTS `order` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(50) DEFAULT NULL,
  `CityCustomer` varchar(50) DEFAULT NULL,
  `phoneCustomer` varchar(50) DEFAULT NULL,
  `addressCustomer` varchar(50) DEFAULT NULL,
  `warCustomer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table orderfood.order: ~0 rows (approximately)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- Dumping structure for table orderfood.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameProduct` varchar(50) DEFAULT NULL,
  `priceProduct` int(11) DEFAULT NULL,
  `quantityProduct` varchar(50) DEFAULT NULL,
  `typeProduct` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table orderfood.product: ~8 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
REPLACE INTO `product` (`id`, `nameProduct`, `priceProduct`, `quantityProduct`, `typeProduct`) VALUES
	(1, 'fried chicken flour dish ', 20, '200', 'chicken dishes'),
	(2, 'fried chicken with fish sauce dish', 15, '200', 'chicken dishes'),
	(4, 'orange drink', 10, '200', 'water dishes'),
	(5, '7 up drink', 10, '200', 'water dishes'),
	(6, 'pepsi drink', 10, '200', 'water dishes'),
	(7, 'beef hamberger dish', 10, '200', 'hamberger dishes'),
	(8, 'Shrimp hamberger dish', 10, '200', 'hamberger dishes'),
	(9, 'Chicken hamberger dish', 10, '200', 'hamberger dishes');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table orderfood.store
CREATE TABLE IF NOT EXISTS `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameStore` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Dumping data for table orderfood.store: ~3 rows (approximately)
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
REPLACE INTO `store` (`id`, `nameStore`) VALUES
	(1, 'Kentucky fried chicken store'),
	(4, 'Lotteria chicken store'),
	(8, 'otoke chicken store');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;

-- Dumping structure for table orderfood.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `passWordUser` varchar(50) DEFAULT NULL,
  `emailUser` varchar(50) DEFAULT NULL,
  `phoneUser` varchar(50) DEFAULT NULL,
  `fullNameUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- Dumping data for table orderfood.user: ~7 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `userName`, `passWordUser`, `emailUser`, `phoneUser`, `fullNameUser`) VALUES
	(24, 'thetoan1995', 'T@an1995', 'robocon87@gmail.com', '0898987536', 'Nguyen To The Toan'),
	(25, 'thetoan1995', 'T@an1995', 'robocon87@gmail.com', '0893534252', 'Nguyen To The Toan'),
	(26, 'thetoan1995', 'T@an1995', 'Robocon87@gmail.com', '0898987732525', 'Nguyen To The Toan'),
	(27, 'thetoan1995', 'T@an1995', 'roboocon87@gmail.com', '0898352323', 'Nguyen To The Toan'),
	(28, 'thetoan1995', 'T@an1995', 'robocon87@gmail.com', '0898987536', 'Nguyen To The Toan'),
	(29, 'thetoan1995', 'T@an1995', 'robocon87', '0352', 'NGUYEN TO THE TOAN'),
	(30, 'thetoan1995', 'T@an1995', 'Robocon87@gmail.com', '23', 'toan');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
