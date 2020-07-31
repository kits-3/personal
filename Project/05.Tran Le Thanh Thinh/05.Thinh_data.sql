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


-- Dumping database structure for dictionary
CREATE DATABASE IF NOT EXISTS `dictionary` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_vietnamese_ci */;
USE `dictionary`;

-- Dumping structure for table dictionary.dictionary_client
CREATE TABLE IF NOT EXISTS `dictionary_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `translation` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `example` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `language_id` int(11) DEFAULT NULL,
  `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table dictionary.dictionary_client: ~7 rows (approximately)
/*!40000 ALTER TABLE `dictionary_client` DISABLE KEYS */;
INSERT INTO `dictionary_client` (`id`, `content`, `description`, `translation`, `example`, `language_id`, `create_by`) VALUES
	(1, 'こんにちは', 'verb', 'xin chao', 'こんにちは', 3, 'client'),
	(2, 'ball', 'ball', 'bong', 'football', 1, 'huy'),
	(4, '안녕하세요', 'verb', 'xin chao', '안녕하세요', 2, 'client'),
	(5, '안녕하세요', 'verb', 'xin chao', '안녕하세요', 2, 'huy'),
	(6, 'Hello', 'verb', 'xin chao', 'hello everybody!', 1, 'huy'),
	(7, 'Hallo_Hallo', 'verb', 'xin chao', 'Hallo', 1, 'client'),
	(8, 'morning', '1', '1', '1', 1, 'client');
/*!40000 ALTER TABLE `dictionary_client` ENABLE KEYS */;

-- Dumping structure for table dictionary.language
CREATE TABLE IF NOT EXISTS `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table dictionary.language: ~4 rows (approximately)
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` (`id`, `name`) VALUES
	(1, 'English'),
	(2, 'Korean'),
	(3, 'Japanese'),
	(4, 'China'),
	(5, 'German');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;

-- Dumping structure for table dictionary.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table dictionary.roles: ~2 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'admin'),
	(2, 'client');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table dictionary.user
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `FK_user_roles` (`roleId`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`roleId`) REFERENCES `roles` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dictionary.user: ~27 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`username`, `password`, `roleId`, `email`) VALUES
	('333', '222', 2, '333@gmail.com'),
	('888', '88', 2, '88'),
	('aaa', '123', 2, 'aaa@gmail.com'),
	('admin', '1', 1, 'admin@gmail.com'),
	('admin2', '1', 2, 'admin2@gmail.com'),
	('admin3', '1', 2, '1'),
	('admin4', '2', 2, '2'),
	('admin_test', '1', 2, '1'),
	('admin_test_add', '1', 2, '1'),
	('bbb', '123456', 2, 'bbb@gmail.com'),
	('ccc', '123', 2, 'ccc@gmail.com'),
	('client', '1', 2, 'client@gmail.com'),
	('duy', '123456', 1, 'cuduy3000@gmail.com'),
	('giang ca', '1', 2, 'giangca@gmail.com'),
	('good', '1', 2, '1'),
	('huy', '1', 2, 'huy@gmail.com'),
	('Pc05', '123456', 2, 'pc05@gmail.com'),
	('testAdd', '1', 2, '1'),
	('testAdd_2', '2', 2, '2'),
	('test_add', '1', 2, '1'),
	('Thanh Thinh', '123456', 1, 'tranlethanhthinh@gmail.com'),
	('Thinh1', '123456', 1, 'test@gmail.com'),
	('thinh2', '123456', 1, 'thinh@gmail.com'),
	('thinh3', '123456', 1, 'test@gmail.com'),
	('thinh4', '123456', 1, 'test@gmail.com'),
	('thinh5', '123456', 1, 'test2@gmail.com'),
	('thinh6', '123456', 1, 'test@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table dictionary.words
CREATE TABLE IF NOT EXISTS `words` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `translation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `examples` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `language_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- Dumping data for table dictionary.words: ~7 rows (approximately)
/*!40000 ALTER TABLE `words` DISABLE KEYS */;
INSERT INTO `words` (`id`, `content`, `description`, `translation`, `examples`, `language_id`) VALUES
	(1, 'Hello', 'verb', 'xin chao', 'hello everybody!', 1),
	(2, 'Hallo', 'verb', 'xin chao', 'hallo', 5),
	(9, '안녕하세요', 'verb', 'xin chao', '안녕하세요', 2),
	(10, 'こんにちは', 'verb', 'xin chao', 'こんにちは', 3),
	(15, 'thank you', 'tieng anh', 'cam on', 'thank you so much', 1),
	(16, 'sory', 'tieng anh', 'xin loi', 'i am sory', 1),
	(17, 'mornin_update', 'tieng anh', 'buoi sang', 'good morning', 1);
/*!40000 ALTER TABLE `words` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
