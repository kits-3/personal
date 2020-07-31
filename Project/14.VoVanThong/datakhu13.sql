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


-- Dumping database structure for khu13
CREATE DATABASE IF NOT EXISTS `khu13` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `khu13`;

-- Dumping structure for table khu13.account
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `typeofaccess` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table khu13.account: ~4 rows (approximately)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`id`, `access`, `name`, `password`, `money`, `phone`, `typeofaccess`) VALUES
	(1, 'admin', 'admin', 'admin', 9999999, '0339653319', 0),
	(2, 'user', 'thong', 'vo', 3000, '0904504285', 1),
	(3, 'user', 'satan', 'crying', 1500, '0346343639', 1),
	(4, 'user', 'binz', 'chou', 1000, '096154645', 1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Dumping structure for table khu13.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table khu13.menu: ~3 rows (approximately)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `name`, `price`) VALUES
	(1, 'combo1', 100),
	(2, 'combo2', 200),
	(3, 'combo3', 300);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Dumping structure for table khu13.site
CREATE TABLE IF NOT EXISTS `site` (
  `id` int(11) NOT NULL,
  `site` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table khu13.site: ~4 rows (approximately)
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` (`id`, `site`, `status`) VALUES
	(1, 'SITE1', 'empty'),
	(2, 'SITE2', 'empty'),
	(3, 'SITE3', 'empty'),
	(4, 'SITE4', 'empty');
/*!40000 ALTER TABLE `site` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
