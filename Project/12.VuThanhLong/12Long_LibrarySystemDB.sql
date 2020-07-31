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


-- Dumping database structure for personal
CREATE DATABASE IF NOT EXISTS `personal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `personal`;

-- Dumping structure for table personal.authors
CREATE TABLE IF NOT EXISTS `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table personal.authors: ~6 rows (approximately)
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
REPLACE INTO `authors` (`id`, `name`) VALUES
	(1, 'Alex North'),
	(2, 'Silvia Moreno-Garcia'),
	(4, 'Eric Carle'),
	(5, 'Eric Hill'),
	(6, 'Adam Tony'),
	(7, 'Emily Henry');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;

-- Dumping structure for table personal.books
CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `author_id` int(11) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `available` int(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `FK_books_authors` (`author_id`),
  KEY `FK_books_publishers` (`publisher_id`),
  CONSTRAINT `FK_books_authors` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`),
  CONSTRAINT `FK_books_publishers` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Dumping data for table personal.books: ~12 rows (approximately)
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
REPLACE INTO `books` (`id`, `name`, `author_id`, `publisher_id`, `available`) VALUES
	(1, 'The Shadows', 1, 1, 1),
	(2, 'Whisper Women', 1, 1, 1),
	(3, 'Schattenmörder', 1, 2, 1),
	(4, 'Mexican Gothic', 2, 3, 1),
	(6, 'Very Hungry ', 4, 4, 1),
	(7, 'Where\'s Spot?', 5, 5, 1),
	(8, 'Spot Goes to the Farm', 5, 5, 1),
	(9, 'Spot\'s First Walk', 5, 5, 0),
	(10, 'Big Summer: A Novel', 7, 6, 1),
	(11, 'Beach Read', 7, 7, 1),
	(12, 'Spot Goes to the Park', 5, 5, 1),
	(13, 'test', 5, 5, 1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;

-- Dumping structure for table personal.fees
CREATE TABLE IF NOT EXISTS `fees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mount` float DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `transaction_date` datetime DEFAULT curtime(),
  PRIMARY KEY (`id`),
  KEY `FK_fee_users` (`user_id`),
  CONSTRAINT `FK_fee_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- Dumping data for table personal.fees: ~30 rows (approximately)
/*!40000 ALTER TABLE `fees` DISABLE KEYS */;
REPLACE INTO `fees` (`id`, `mount`, `name`, `user_id`, `transaction_date`) VALUES
	(1, 20, 'Extend Fee', 4, '2020-07-29 11:34:22'),
	(2, 20, 'Extend Fee', 4, '2020-07-29 11:36:14'),
	(3, 20, 'Extend Fee', 4, '2020-07-29 11:36:58'),
	(4, 7.75, 'Late Fee', 4, '2020-07-29 11:39:53'),
	(5, 7.75, 'Late Fee', 4, '2020-07-29 11:41:31'),
	(6, 7.75, 'Late Fee', 4, '2020-07-29 11:59:10'),
	(7, 8, 'Late Fee', 4, '2020-07-30 08:36:48'),
	(8, 8, 'Late Fee', 4, '2020-07-30 11:26:37'),
	(9, 7.75, 'Late Fee', 4, '2020-07-30 12:28:13'),
	(10, 7.75, 'Late Fee', 4, '2020-07-30 12:28:33'),
	(11, 7.75, 'Late Fee', 4, '2020-07-30 12:32:44'),
	(12, 7.75, 'Late Fee', 4, '2020-07-30 12:32:58'),
	(13, 7.75, 'Late Fee', 4, '2020-07-30 12:45:38'),
	(14, 7.75, 'Late Fee', 4, '2020-07-30 12:48:39'),
	(15, 7.75, 'Late Fee', 4, '2020-07-30 12:50:14'),
	(16, 7.75, 'Late Fee', 4, '2020-07-30 12:50:52'),
	(17, 7.75, 'Late Fee', 4, '2020-07-30 12:51:51'),
	(18, 7.75, 'Late Fee', 4, '2020-07-30 12:52:05'),
	(19, 7.75, 'Late Fee', 4, '2020-07-30 12:52:35'),
	(20, 7.75, 'Late Fee', 4, '2020-07-30 12:53:58'),
	(21, 7.75, 'Late Fee', 4, '2020-07-30 12:54:12'),
	(22, 7.75, 'Late Fee', 4, '2020-07-30 12:54:49'),
	(23, 7.75, 'Late Fee', 4, '2020-07-30 12:55:43'),
	(24, 7.75, 'Late Fee', 4, '2020-07-30 12:55:53'),
	(25, 7.75, 'Late Fee', 4, '2020-07-30 12:56:26'),
	(26, 7.75, 'Late Fee', 4, '2020-07-30 13:26:54'),
	(27, 7.75, 'Late Fee', 4, '2020-07-30 13:32:04'),
	(28, 8, 'Late Fee', 4, '2020-07-31 08:08:12'),
	(29, 20, 'Extend Fee', 4, '2020-07-31 08:23:45'),
	(30, 8, 'Late Fee', 4, '2020-07-31 08:24:59');
/*!40000 ALTER TABLE `fees` ENABLE KEYS */;

-- Dumping structure for table personal.loans
CREATE TABLE IF NOT EXISTS `loans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loan_date` date NOT NULL DEFAULT curdate(),
  `isactive` int(11) NOT NULL DEFAULT 1,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `return_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_loans_users` (`user_id`),
  KEY `FK_loans_books` (`book_id`),
  CONSTRAINT `FK_loans_books` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `FK_loans_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- Dumping data for table personal.loans: ~29 rows (approximately)
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
REPLACE INTO `loans` (`id`, `loan_date`, `isactive`, `user_id`, `book_id`, `return_date`) VALUES
	(5, '2020-07-24', 0, 4, 3, '2020-07-27'),
	(7, '2020-06-24', 0, 4, 3, '2020-07-27'),
	(9, '2020-07-27', 0, 4, 6, '2020-07-27'),
	(10, '2020-07-27', 0, 4, 1, '2020-07-27'),
	(13, '2020-07-27', 0, 4, 1, '2020-07-27'),
	(14, '2020-07-27', 0, 4, 2, '2020-07-27'),
	(15, '2020-07-27', 0, 4, 2, '2020-07-27'),
	(16, '2020-07-27', 0, 4, 1, '2020-07-27'),
	(19, '2020-07-27', 0, 4, 3, '2020-07-27'),
	(20, '2020-07-28', 0, 4, 10, '2020-07-30'),
	(21, '2020-04-28', 0, 4, 10, '2020-07-30'),
	(22, '2020-05-27', 0, 4, 10, '2020-07-30'),
	(23, '2020-05-28', 0, 4, 10, '2020-07-30'),
	(24, '2020-05-29', 0, 4, 11, '2020-07-30'),
	(25, '2020-05-29', 0, 4, 11, '2020-07-30'),
	(26, '2020-07-30', 0, 4, 10, '2020-07-30'),
	(27, '2020-07-30', 0, 4, 10, '2020-07-30'),
	(28, '2020-07-30', 0, 4, 11, '2020-07-30'),
	(29, '2020-07-30', 0, 4, 1, '2020-07-30'),
	(30, '2020-07-30', 0, 4, 2, '2020-07-30'),
	(31, '2020-07-30', 0, 4, 11, '2020-07-30'),
	(32, '2020-07-30', 0, 4, 1, '2020-07-30'),
	(33, '2020-07-30', 0, 4, 2, '2020-07-30'),
	(34, '2020-07-30', 0, 4, 10, '2020-07-30'),
	(35, '2020-07-30', 0, 4, 1, '2020-07-30'),
	(36, '2020-07-30', 0, 4, 1, '2020-07-30'),
	(37, '2020-07-31', 0, 4, 1, '2020-07-31'),
	(38, '2020-07-31', 1, 20, 9, NULL),
	(39, '2020-07-31', 0, 4, 6, '2020-07-31');
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;

-- Dumping structure for table personal.publishers
CREATE TABLE IF NOT EXISTS `publishers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table personal.publishers: ~7 rows (approximately)
/*!40000 ALTER TABLE `publishers` DISABLE KEYS */;
REPLACE INTO `publishers` (`id`, `name`) VALUES
	(1, 'Celadon Books'),
	(2, 'Blanvalet Verlag'),
	(3, 'Del Rey'),
	(4, 'Philomel Books'),
	(5, 'Warne'),
	(6, 'Atria Books'),
	(7, 'Berkley ');
/*!40000 ALTER TABLE `publishers` ENABLE KEYS */;

-- Dumping structure for table personal.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table personal.roles: ~2 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
REPLACE INTO `roles` (`id`, `name`) VALUES
	(1, 'Member'),
	(2, 'Librarian');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table personal.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL DEFAULT '',
  `idnum` varchar(50) NOT NULL,
  `role_id` int(11) NOT NULL DEFAULT 1,
  `reg_date` date DEFAULT curdate(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK_users_roles` (`role_id`),
  CONSTRAINT `FK_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table personal.users: ~6 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`id`, `name`, `password`, `phone`, `idnum`, `role_id`, `reg_date`) VALUES
	(2, 'theiik', '123456', '987654321', '123456789', 1, '2020-05-28'),
	(3, 'admin', 'admin', '545535456', '145354694', 2, '2020-07-28'),
	(4, 'tlong', '1234', '2394366946', '1234556789', 1, '2020-07-31'),
	(5, 'abcd', '123', '98796079', '897069586', 1, '2020-07-28'),
	(19, 'testt', '123', '21582195515', '21589021521', 1, '2020-07-30'),
	(20, 'tlonggg', '1234', '0968574856', '105485694067', 1, '2020-07-31');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
