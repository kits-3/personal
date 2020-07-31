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


-- Dumping database structure for book
CREATE DATABASE IF NOT EXISTS `book` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `book`;

-- Dumping structure for table book.account
CREATE TABLE IF NOT EXISTS `account` (
  `Id_role` int(11) NOT NULL AUTO_INCREMENT,
  `Role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id_role`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table book.account: ~2 rows (approximately)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`Id_role`, `Role_name`) VALUES
	(1, 'admin'),
	(2, 'customer');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Dumping structure for table book.bill
CREATE TABLE IF NOT EXISTS `bill` (
  `Bill_id` int(11) NOT NULL AUTO_INCREMENT,
  `Gmail` varchar(50) DEFAULT NULL,
  `Total` int(11) DEFAULT NULL,
  PRIMARY KEY (`Bill_id`),
  KEY `FK_bill_user` (`Gmail`),
  CONSTRAINT `FK_bill_user` FOREIGN KEY (`Gmail`) REFERENCES `user` (`Gmail`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- Dumping data for table book.bill: ~27 rows (approximately)
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` (`Bill_id`, `Gmail`, `Total`) VALUES
	(9, 'nam@nam.nam', 1000),
	(10, 'nam@nam.nam', 1000),
	(11, 'nam@nam.nam', 1000),
	(12, 'nam@nam.nam', 1000),
	(13, 'nam@nam.nam', 3000),
	(14, 'nhan', 2000),
	(15, 'nam@nam.nam', 1000),
	(16, 'nam@nam.nam', 1000),
	(17, 'nam@nam.nam', 1000),
	(18, 'nam@nam.nam', 1000),
	(19, 'nam@nam.nam', 1000),
	(20, 'nam@nam.nam', 1000),
	(21, 'nam@nam.nam', 1000),
	(22, 'nam@nam.nam', 1000),
	(23, 'nam@nam.nam', 1000),
	(24, 'nam@nam.nam', 1000),
	(25, 'nam@nam.nam', 1000),
	(26, 'nam@nam.nam', 1000),
	(27, 'nam@nam.nam', 2000),
	(28, 'nam@nam.nam', 1000),
	(29, 'nam@nam.nam', 4000),
	(30, 'nam@nam.nam', 1000),
	(31, 'nam@nam.nam', 1000),
	(32, 'nam@nam.nam', 2000),
	(33, 'nam@nam.nam', 1000),
	(34, 'nam@nam.nam', 2000),
	(35, 'nam@nam.nam', 3000);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;

-- Dumping structure for table book.bill_detail
CREATE TABLE IF NOT EXISTS `bill_detail` (
  `Billdetail_id` int(11) NOT NULL AUTO_INCREMENT,
  `Book_id` int(11) NOT NULL DEFAULT 0,
  `Number` int(11) DEFAULT NULL,
  `Time` date DEFAULT current_timestamp(),
  `Bill_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Billdetail_id`),
  KEY `FK_bill_detail_books` (`Book_id`) USING BTREE,
  KEY `FK_bill_detail_bill` (`Bill_id`),
  CONSTRAINT `FK_bill_detail_bill` FOREIGN KEY (`Bill_id`) REFERENCES `bill` (`Bill_id`),
  CONSTRAINT `FK_bill_detail_books` FOREIGN KEY (`Book_id`) REFERENCES `books` (`Book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- Dumping data for table book.bill_detail: ~30 rows (approximately)
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
INSERT INTO `bill_detail` (`Billdetail_id`, `Book_id`, `Number`, `Time`, `Bill_id`) VALUES
	(3, 1, 9, '2020-07-29', 9),
	(4, 1, 10, '2020-07-29', 10),
	(5, 1, 11, '2020-07-29', 11),
	(6, 1, 12, '2020-07-29', 12),
	(7, 1, 13, '2020-07-29', 13),
	(8, 2, 13, '2020-07-29', 13),
	(9, 2, 14, '2020-07-29', 14),
	(11, 1, 3, '2020-07-29', 18),
	(12, 1, 1, '2020-07-29', 20),
	(13, 1, 1, '2020-07-30', 21),
	(14, 1, 1, '2020-07-30', 22),
	(15, 1, 1, '2020-07-30', 23),
	(16, 1, 1, '2020-07-30', 24),
	(17, 1, 1, '2020-07-30', 25),
	(18, 1, 1, '2020-07-30', 26),
	(19, 1, 1, '2020-07-30', 27),
	(20, 1, 1, '2020-07-30', 27),
	(21, 1, 1, '2020-07-30', 28),
	(22, 1, 1, '2020-07-30', 29),
	(23, 1, 2, '2020-07-30', 29),
	(24, 2, 3, '2020-07-30', 29),
	(25, 1, 1, '2020-07-30', 30),
	(26, 1, 1, '2020-07-30', 31),
	(27, 1, 2, '2020-07-30', 32),
	(28, 1, 2, '2020-07-30', 32),
	(29, 1, 1, '2020-07-30', 33),
	(30, 1, 2, '2020-07-30', 34),
	(31, 1, 2, '2020-07-30', 34),
	(32, 2, 1, '2020-07-30', 35),
	(33, 2, 1, '2020-07-30', 35);
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;

-- Dumping structure for table book.books
CREATE TABLE IF NOT EXISTS `books` (
  `Book_id` int(11) NOT NULL AUTO_INCREMENT,
  `Book_name` varchar(50) DEFAULT NULL,
  `Athor` varchar(50) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Category_id` int(11) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  PRIMARY KEY (`Book_id`),
  KEY `FK_books_book_category` (`Category_id`),
  CONSTRAINT `FK_books_book_category` FOREIGN KEY (`Category_id`) REFERENCES `book_category` (`Category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table book.books: ~4 rows (approximately)
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` (`Book_id`, `Book_name`, `Athor`, `Price`, `Amount`, `Category_id`, `Status`) VALUES
	(1, 'Eclipse', 'Clare', 1000, 100, 1, 1),
	(2, 'TheNight', 'Meyer', 2000, 40, 1, 1),
	(3, 'Harry Potter', 'J.K', 449, 50, 3, 1),
	(4, 'Hatchet', 'Gary', 600, 120, 2, 1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;

-- Dumping structure for table book.book_category
CREATE TABLE IF NOT EXISTS `book_category` (
  `Category_id` int(11) NOT NULL AUTO_INCREMENT,
  `Name_category` varchar(50) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  PRIMARY KEY (`Category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table book.book_category: ~4 rows (approximately)
/*!40000 ALTER TABLE `book_category` DISABLE KEYS */;
INSERT INTO `book_category` (`Category_id`, `Name_category`, `Status`) VALUES
	(1, 'Romance', 1),
	(2, 'Tien<3', 1),
	(3, 'Kids', 1),
	(8, 'nam', 1);
/*!40000 ALTER TABLE `book_category` ENABLE KEYS */;

-- Dumping structure for table book.user
CREATE TABLE IF NOT EXISTS `user` (
  `Gmail` varchar(50) NOT NULL,
  `Password` int(11) DEFAULT NULL,
  `Id_role` int(11) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  `Money` int(11) DEFAULT NULL,
  PRIMARY KEY (`Gmail`),
  KEY `FK_user_account` (`Id_role`),
  CONSTRAINT `FK_user_account` FOREIGN KEY (`Id_role`) REFERENCES `account` (`Id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table book.user: ~6 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`Gmail`, `Password`, `Id_role`, `Status`, `Money`) VALUES
	('minh', 111, 2, 1, 10000),
	('nam', 123, 1, 1, NULL),
	('nam@nam.nam', 333, 2, 1, 5000),
	('nhan', 321, 2, 1, 1000),
	('nhan@gmail.com', 333, 2, 1, NULL),
	('nhann', 3333, 2, 0, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
