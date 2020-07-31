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


-- Dumping database structure for test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;

-- Dumping structure for table test.book
CREATE TABLE IF NOT EXISTS `book` (
  `idBook` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `idRoom` int(11) NOT NULL,
  `dateIn` date DEFAULT NULL,
  `dateOut` date DEFAULT NULL,
  PRIMARY KEY (`idBook`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

-- Dumping data for table test.book: ~27 rows (approximately)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`idBook`, `idUser`, `idRoom`, `dateIn`, `dateOut`) VALUES
	(20, 1, 1, '2020-07-28', '2020-07-29'),
	(21, 2, 1, '2020-08-04', '2020-08-08'),
	(22, 3, 1, '2020-08-12', '2020-08-15'),
	(30, 2, 1, '2020-02-10', '2020-02-12'),
	(32, 2, 5, '2020-02-10', '2020-02-12'),
	(33, 2, 5, '2020-08-04', '2020-08-06'),
	(34, 2, 2, '2020-08-06', '2020-08-10'),
	(35, 27, 2, '2020-08-04', '2020-08-06'),
	(36, 2, 2, '2020-11-02', '2020-11-03'),
	(37, 2, 1, '2020-10-12', '2020-10-14'),
	(38, 34, 1, '2020-02-02', '2020-02-08'),
	(39, 2, 2, '2020-02-02', '2020-02-12'),
	(40, 2, 6, '2020-01-19', '2020-01-25'),
	(41, 2, 7, '2020-12-18', '2020-12-19'),
	(42, 2, 8, '2020-09-26', '2020-09-27'),
	(43, 2, 7, '2020-10-28', '2020-10-29'),
	(44, 2, 10, '2020-01-01', '2020-01-04'),
	(45, 2, 6, '2020-03-23', '2020-03-24'),
	(46, 2, 6, '2020-10-28', '2020-10-30'),
	(47, 2, 7, '2020-09-22', '2020-09-26'),
	(59, 2, 3, '2020-02-12', '2020-02-15'),
	(60, 36, 8, '2020-02-12', '2020-02-14'),
	(61, 39, 8, '2020-02-15', '2020-02-17'),
	(62, 40, 7, '2020-02-18', '2020-02-20'),
	(63, 40, 6, '2020-02-16', '2020-02-19'),
	(64, 40, 8, '2020-02-19', '2020-02-25'),
	(65, 43, 17, '2020-02-17', '2020-02-19');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- Dumping structure for table test.rooms
CREATE TABLE IF NOT EXISTS `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(3) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `status` tinyint(4) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- Dumping data for table test.rooms: ~20 rows (approximately)
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` (`id`, `number`, `price`, `type`, `status`) VALUES
	(1, '101', 300, 'king', 0),
	(2, '102', 300, 'king', 0),
	(3, '103', 500, 'queen', 0),
	(4, '201', 300, 'king', 0),
	(5, '202', 300, 'king', 0),
	(6, '203', 500, 'queen', 0),
	(7, '301', 500, 'queen', 0),
	(8, '302', 500, 'queen', 0),
	(10, '401', 1000, 'suite', 0),
	(11, NULL, 0, NULL, 0),
	(15, '402', 1000, 'suite', 0),
	(16, '403', 1000, 'suite', 0),
	(17, '303', 500, 'queen', 0),
	(18, '204', 300, 'king', 0),
	(19, '404', 1000, 'suite', 0),
	(20, '405', 1000, 'suite', 0),
	(21, '406', 1000, 'suite', 0),
	(22, '407', 1000, 'suite', 0),
	(23, '408', 1000, 'suite', 0),
	(24, '408', 1000, 'suite', 0);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;

-- Dumping structure for table test.users
CREATE TABLE IF NOT EXISTS `users` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `fullname` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

-- Dumping data for table test.users: ~24 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`idUser`, `username`, `password`, `email`, `fullname`, `role`) VALUES
	(1, 'admin', 'admin', 'admin@gmail.com', 'Ng Van Min', 'Admin'),
	(2, 'abc', '123', 'abc@gmail.com', 'Anh Bang Cong', 'customer'),
	(3, 'hung', '123', 'hung@gmail.com', 'Nguyen Hung', 'Admin'),
	(15, 'noo', 'dfd', 'dfd', '2344', 'customer'),
	(22, 'chan ', '123', 'chan', 'chan', 'customer'),
	(24, 'huyhoang', '123', 'huyhoang@gmail.com', 'huy hoang hang', 'customer'),
	(25, 'ngocduy', '123', 'ngocduy', 'ngocduy', 'customer'),
	(27, 'engpro', '123', 'engpro123', 'engpro', 'customer'),
	(28, 'ngocanh', '123', 'ngocanh', 'ngoc anh linh', 'customer'),
	(29, 'minhkhai', '123', 'minhkhai@gmail.com', 'minhkhai', 'customer'),
	(30, 'ngoclinh', '123', 'ngoclinh@gmail.com', 'ngoclinh', 'customer'),
	(31, 'ngoctrinh', '123', 'ngoctrinh@gmail.com', 'ngoc trinh', 'customer'),
	(32, 'minhminh', '123', 'minhminh', 'minhminh', 'customer'),
	(33, 'minhhang', '123', 'minhkd', 'dsa', 'customer'),
	(34, 'ngochuyen', '123', 'ngochuyen@gmail.com', 'ngoc huyen', 'customer'),
	(35, 'abick', '123', 'abick', 'abick', 'customer'),
	(36, 'oanhoanh', '123', 'oanh@gmail.com', 'dang hoang oanh', 'customer'),
	(37, 'tranthanh', '123', 'tranthanh@gmail.com', 'tran thanh', 'customer'),
	(38, 'tranxi', '123', 'tranxi@gmail.com', 'tran xi', 'customer'),
	(39, 'hoangoanh', '123', 'hoangoanh@gmail.com', 'dang hoang oanh ', 'customer'),
	(40, 'huuduy', '123', 'huuduy@gmail.com', 'huynh huu duy', 'customer'),
	(41, 'duyduy', '123', 'duy@gmail.com', 'duy duy', 'Admin'),
	(42, 'huynh lam', '123', 'huynhlam@gmail.com', 'huynh lam', 'customer'),
	(43, 'quangquang', '123', 'quang@gmail.com', 'quang quang', 'customer');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
