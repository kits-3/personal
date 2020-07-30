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


-- Dumping database structure for parkingsystem
CREATE DATABASE IF NOT EXISTS `parkingsystem` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `parkingsystem`;

-- Dumping structure for table parkingsystem.car
CREATE TABLE IF NOT EXISTS `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__user` (`id_user`),
  CONSTRAINT `FK__user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table parkingsystem.park
CREATE TABLE IF NOT EXISTS `park` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table parkingsystem.parking
CREATE TABLE IF NOT EXISTS `parking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_car` int(11) DEFAULT NULL,
  `id_park` int(11) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `date_in` varchar(50) DEFAULT NULL,
  `date_out` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__car` (`id_car`),
  KEY `FK_parking_park` (`id_park`),
  CONSTRAINT `FK__car` FOREIGN KEY (`id_car`) REFERENCES `car` (`id`),
  CONSTRAINT `FK_parking_park` FOREIGN KEY (`id_park`) REFERENCES `park` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table parkingsystem.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
