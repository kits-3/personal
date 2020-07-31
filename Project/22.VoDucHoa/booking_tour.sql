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


-- Dumping database structure for mysql_tour
CREATE DATABASE IF NOT EXISTS `mysql_tour` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mysql_tour`;

-- Dumping structure for table mysql_tour.booking_tour
CREATE TABLE IF NOT EXISTS `booking_tour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `tour_id` int(11) DEFAULT NULL,
  `time_booking` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_booking_tour_user` (`user_id`),
  KEY `FK_booking_tour_tour` (`tour_id`),
  CONSTRAINT `FK_booking_tour_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_booking_tour_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='information booking tour';

-- Dumping data for table mysql_tour.booking_tour: ~5 rows (approximately)
/*!40000 ALTER TABLE `booking_tour` DISABLE KEYS */;
INSERT INTO `booking_tour` (`id`, `user_id`, `tour_id`, `time_booking`) VALUES
	(1, 1, 1, '11:47:51'),
	(2, 2, 2, '11:47:53'),
	(3, 3, 3, '15:23:57'),
	(4, 4, 4, '15:24:10'),
	(5, 5, 5, '15:24:17');
/*!40000 ALTER TABLE `booking_tour` ENABLE KEYS */;

-- Dumping structure for table mysql_tour.payment
CREATE TABLE IF NOT EXISTS `payment` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `money_number` int(11) NOT NULL DEFAULT 0,
  `tour_id` int(11) DEFAULT 0,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pay_id`),
  KEY `FK_payment_tour` (`tour_id`),
  KEY `FK_payment_user` (`user_id`),
  CONSTRAINT `FK_payment_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_payment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COMMENT='payment';

-- Dumping data for table mysql_tour.payment: ~5 rows (approximately)
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`pay_id`, `money_number`, `tour_id`, `user_id`) VALUES
	(1, 0, 1, 1),
	(2, 2500, 2, 2),
	(3, 300, 3, 3),
	(4, 2000, 4, 4),
	(5, 1000, 5, 5);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- Dumping structure for table mysql_tour.tour
CREATE TABLE IF NOT EXISTS `tour` (
  `tour_id` int(11) NOT NULL AUTO_INCREMENT,
  `name_tour` varchar(50) DEFAULT NULL,
  `location_start` varchar(50) DEFAULT NULL,
  `time_start` time DEFAULT NULL,
  `date_start` date DEFAULT NULL,
  `day_number` int(11) DEFAULT NULL,
  `mem_number` int(50) DEFAULT NULL,
  `price_tour` int(11) DEFAULT NULL,
  PRIMARY KEY (`tour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COMMENT='infomation Tour ';

-- Dumping data for table mysql_tour.tour: ~6 rows (approximately)
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` (`tour_id`, `name_tour`, `location_start`, `time_start`, `date_start`, `day_number`, `mem_number`, `price_tour`) VALUES
	(1, 'danang_bana', 'danang', '10:54:07', '2020-07-28', 3, 11, 200),
	(2, 'danang_hoian', 'danang', '08:08:08', '2020-07-07', 3, 3, 150),
	(3, 'vungtau_longhai', 'vungtau', '07:28:01', '2020-07-29', 2, 18, 100),
	(4, 'vungtau_baisau', 'vungtau', '10:20:20', '2020-10-23', 2, 7, 100),
	(5, 'hochiminh_quan1', 'hochiminh', '06:20:20', '2020-02-01', 2, 2, 80),
	(11, 'dalat-langbiang', 'dalat', '08:00:00', '2020-02-20', NULL, 0, NULL);
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;

-- Dumping structure for table mysql_tour.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gmail` varchar(50) DEFAULT NULL,
  `Ex` varchar(50) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `id_ac` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_user_account` (`id_ac`),
  CONSTRAINT `FK_user_user_account` FOREIGN KEY (`id_ac`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1 COMMENT='information for user\r\n';

-- Dumping data for table mysql_tour.user: ~6 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `gmail`, `Ex`, `Birthday`, `phonenumber`, `address`, `id_ac`) VALUES
	(1, 'nguyenvanhung', 'hung@gmail.com', 'nam', '1998-07-24', 125478548, '13 dienbienphu, phuong15, quan binhthanh', 1),
	(2, 'votuanminh', 'tuanminh@gmail.com', 'nam', '2020-07-30', 398564789, 'binhtan', 2),
	(3, 'tranthihoa', 'hoa@gmail.com', 'nu', '2020-07-30', 987654321, NULL, 3),
	(4, 'trantrunghieu', 'trunghieu@gmail.com', 'nam', '2020-07-30', 365498765, 'binhthanh', 4),
	(5, 'vovanpho', 'pho@gmail.com', 'nam', '2020-07-30', 165894780, 'tanbinh', 5);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table mysql_tour.user_account
CREATE TABLE IF NOT EXISTS `user_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username_ac` varchar(50) DEFAULT '',
  `access_right` varchar(50) DEFAULT '',
  `date` date DEFAULT NULL,
  `password_ac` varchar(50) DEFAULT '',
  `nameaccount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=latin1 COMMENT='information account user';

-- Dumping data for table mysql_tour.user_account: ~16 rows (approximately)
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` (`id`, `username_ac`, `access_right`, `date`, `password_ac`, `nameaccount`) VALUES
	(1, 'hoa', 'admin', '2020-07-28', '123456', 'duchoa'),
	(2, 'nghia', 'user', '2020-07-28', '123456', 'VanNghia'),
	(3, 'minh', 'user', '2020-07-28', '123456', 'minhcui'),
	(4, 'thien', 'admin', '2020-07-30', '123456', 'thienthan'),
	(5, 'pho', 'user', '2020-07-30', '123456', 'phovo');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
