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


-- Dumping database structure for beer_sale
CREATE DATABASE IF NOT EXISTS `beer_sale` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `beer_sale`;

-- Dumping structure for table beer_sale.beer
CREATE TABLE IF NOT EXISTS `beer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `origin_brand` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `ingredient` text DEFAULT NULL,
  `capacity` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `reg_id` int(11) DEFAULT NULL,
  `reg_date` datetime DEFAULT NULL,
  `updt_id` int(11) DEFAULT NULL,
  `updt_date` datetime DEFAULT NULL,
  `del_id` int(11) DEFAULT NULL,
  `del_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table beer_sale.beer: ~10 rows (approximately)
/*!40000 ALTER TABLE `beer` DISABLE KEYS */;
REPLACE INTO `beer` (`id`, `name`, `brand`, `origin_brand`, `origin`, `ingredient`, `capacity`, `count`, `cost`, `reg_id`, `reg_date`, `updt_id`, `updt_date`, `del_id`, `del_date`) VALUES
	(1, 'Strongbow vị dâu đỏ', 'Strongbow Cider', 'Hà Lan', 'Việt Nam', 'Cider (nước ép táo lên men với sucrose), nước, si-rô, màu caramel (E150a), chất điều chỉnh độ acid (E296), khí carbonate, chất bảo quản Kali Metabisulfit (E224), hương táo tự nhiên', '330ml/Lon', 11, 10000, 1, '2020-07-29 10:32:23', 1, '2020-07-29 15:31:11', NULL, NULL),
	(2, 'Tiger', 'Tiger', 'Hà Lan', 'Việt Nam', 'Unknown', '330 ml/lon', 1, 13000, 1, '2020-07-29 10:32:23', 1, '2020-07-30 09:36:15', NULL, NULL),
	(3, 'Tiger Crystal', 'Tiger', 'Việt Nam', 'Việt Nam', 'Nước, hoa bia, đại mạch', '8L', 7, 12000, 1, '2020-07-29 10:32:23', 1, '2020-07-30 16:29:23', NULL, NULL),
	(4, 'Heineken', 'Heineken', 'Hà Lan', 'Singapore', 'Nước, đại mạch, chiết xuất hoa bia, hương tự nhiên. Nồng độ cồn: 0.0%', '330ml/Lon', 7, 9000, 1, '2020-07-29 10:32:23', 1, '2020-07-29 14:11:53', NULL, NULL),
	(5, 'Beck\'s Ice', 'Beck\'s', 'Đức', 'Việt Nam', 'Unknown', '330 ml/lon', 10, 14000, 1, '2020-07-29 10:32:23', 1, '2020-07-29 10:32:23', NULL, NULL),
	(6, 'Budweiser', 'Budweiser', 'Mỹ', 'Việt Nam', 'Nước, mạch nha, gạo, hoa bia', '330 ml/lon', 10, 15000, 1, '2020-07-29 10:32:23', 1, '2020-07-29 10:32:23', NULL, NULL),
	(7, 'SAGOTA không cồn', 'SAGOTA', 'Việt Nam', 'Việt Nam', 'Nước, lúa mạch, gạo, hoa bia', '330 ml', 10, 7000, 1, '2020-07-29 10:32:23', 1, '2020-07-29 10:32:23', NULL, NULL),
	(8, 'Tuborg', 'Tuborg', 'Đan Mạch', 'Việt Nam', 'Unknown', '330 ml/lon', 10, 6000, 1, '2020-07-29 10:32:23', 1, '2020-07-29 10:32:23', NULL, NULL),
	(9, 'Larue Special', 'Larue Special', 'Việt Nam', 'Unknown', 'Nước, Đại mạch, Ngũ cốc, Hoa bia, Hương trái cây tổng hợp', '330 ml/lon', 10, 10000, 1, '2020-07-29 10:32:23', 1, '2020-07-29 10:32:23', NULL, NULL),
	(10, 'Hoegaarden', 'Hoegaarden', 'Bỉ', 'Unknown', 'Unknown', '500ml', 10, 22000, 1, '2020-07-29 10:32:23', 1, '2020-07-29 10:32:23', NULL, NULL);
/*!40000 ALTER TABLE `beer` ENABLE KEYS */;

-- Dumping structure for table beer_sale.receipt
CREATE TABLE IF NOT EXISTS `receipt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `reg_id` int(11) DEFAULT NULL,
  `reg_date` datetime DEFAULT NULL,
  `updt_id` int(11) DEFAULT NULL,
  `updt_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_receipt_user` (`user_id`),
  CONSTRAINT `FK_receipt_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- Dumping data for table beer_sale.receipt: ~24 rows (approximately)
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
REPLACE INTO `receipt` (`id`, `user_id`, `total`, `status`, `reg_id`, `reg_date`, `updt_id`, `updt_date`) VALUES
	(1, 2, 35000, 0, 2, '2020-07-27 09:44:13', 1, '2020-07-27 10:51:39'),
	(2, 3, 59000, 1, 3, '2020-07-27 09:44:13', 1, '2020-07-27 11:55:11'),
	(3, 4, 42000, 1, 4, '2020-07-27 09:44:13', 1, '2020-07-27 09:44:13'),
	(8, 4, 13000, 0, 4, '2020-07-28 08:57:08', 4, '2020-07-28 08:57:08'),
	(9, 4, 30000, 0, 4, '2020-07-28 11:20:04', 4, '2020-07-28 11:20:04'),
	(10, 4, 44000, 0, 4, '2020-07-28 11:21:07', 4, '2020-07-28 11:21:18'),
	(11, 4, 44000, 0, 4, '2020-07-28 11:25:06', 4, '2020-07-28 11:25:13'),
	(12, 4, 10000, 0, 4, '2020-07-28 11:26:04', 4, '2020-07-28 11:26:04'),
	(13, 4, 42000, 0, 4, '2020-07-28 11:27:24', 4, '2020-07-28 11:28:50'),
	(14, 4, 32000, 0, 4, '2020-07-28 11:30:28', 4, '2020-07-28 11:30:42'),
	(15, 4, 74000, 0, 4, '2020-07-28 11:31:47', 4, '2020-07-28 11:31:57'),
	(16, 4, 18000, 0, 4, '2020-07-28 11:36:26', 4, '2020-07-28 11:36:26'),
	(17, 4, 54000, 0, 4, '2020-07-28 11:41:38', 4, '2020-07-28 11:42:17'),
	(18, 4, 24000, 0, 4, '2020-07-28 15:12:55', 4, '2020-07-28 15:12:55'),
	(19, 5, 26000, 0, 5, '2020-07-28 15:48:43', 5, '2020-07-28 15:48:43'),
	(20, 5, 10000, 0, 5, '2020-07-28 15:51:12', 5, '2020-07-28 15:51:12'),
	(21, 4, 26000, 0, 4, '2020-07-29 13:23:54', 4, '2020-07-29 13:23:54'),
	(22, 4, 33000, 0, 4, '2020-07-29 13:31:13', 4, '2020-07-29 13:31:19'),
	(23, 4, 29000, 0, 4, '2020-07-29 13:33:56', 4, '2020-07-29 13:34:14'),
	(24, 4, 44000, 0, 4, '2020-07-29 14:11:34', 4, '2020-07-29 14:11:53'),
	(25, 2, 26000, 0, 2, '2020-07-30 08:52:37', 2, '2020-07-30 08:52:37'),
	(26, 2, 26000, 0, 2, '2020-07-30 09:36:15', 2, '2020-07-30 09:36:15'),
	(27, 2, 24000, 0, 2, '2020-07-30 16:25:09', 2, '2020-07-30 16:25:09'),
	(28, 2, 12000, 0, 2, '2020-07-30 16:29:23', 2, '2020-07-30 16:29:23');
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;

-- Dumping structure for table beer_sale.receipt_detail
CREATE TABLE IF NOT EXISTS `receipt_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beer_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `receipt_id` int(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `reg_id` int(11) DEFAULT NULL,
  `reg_date` datetime DEFAULT NULL,
  `updt_id` int(11) DEFAULT NULL,
  `updt_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_receipt_detail_beer` (`beer_id`),
  KEY `FK_receipt_detail_user` (`user_id`),
  KEY `FK_receipt_detail_receipt` (`receipt_id`),
  CONSTRAINT `FK_receipt_detail_beer` FOREIGN KEY (`beer_id`) REFERENCES `beer` (`id`),
  CONSTRAINT `FK_receipt_detail_receipt` FOREIGN KEY (`receipt_id`) REFERENCES `receipt` (`id`),
  CONSTRAINT `FK_receipt_detail_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- Dumping data for table beer_sale.receipt_detail: ~39 rows (approximately)
/*!40000 ALTER TABLE `receipt_detail` DISABLE KEYS */;
REPLACE INTO `receipt_detail` (`id`, `beer_id`, `user_id`, `receipt_id`, `count`, `cost`, `reg_id`, `reg_date`, `updt_id`, `updt_date`) VALUES
	(1, 1, 2, 1, 1, 10000, 2, '2020-07-27 09:44:13', 2, '2020-07-27 09:44:13'),
	(2, 2, 2, 1, 1, 13000, 2, '2020-07-27 09:44:13', 2, '2020-07-27 09:44:13'),
	(3, 3, 2, 1, 1, 12000, 2, '2020-07-27 09:44:13', 2, '2020-07-27 09:44:13'),
	(4, 4, 3, 2, 1, 9000, 3, '2020-07-27 09:44:13', 3, '2020-07-27 09:44:13'),
	(5, 5, 3, 2, 2, 14000, 3, '2020-07-27 09:44:13', 3, '2020-07-27 09:44:13'),
	(6, 6, 3, 2, 1, 15000, 3, '2020-07-27 09:44:13', 3, '2020-07-27 09:44:13'),
	(7, 7, 4, 2, 1, 7000, 4, '2020-07-27 09:44:13', 4, '2020-07-27 09:44:13'),
	(8, 8, 4, 3, 2, 6000, 4, '2020-07-27 09:44:13', 4, '2020-07-27 09:44:13'),
	(9, 9, 4, 3, 1, 10000, 4, '2020-07-27 09:44:13', 4, '2020-07-27 09:44:13'),
	(10, 10, 4, 3, 1, 22000, 4, '2020-07-27 09:44:13', 4, '2020-07-27 09:44:13'),
	(15, 2, 4, 8, 1, 13000, 0, '2020-07-28 08:57:08', 0, '2020-07-28 08:57:08'),
	(16, 1, 4, 9, 3, 30000, 0, '2020-07-28 11:20:04', 0, '2020-07-28 11:20:04'),
	(17, 1, 4, 10, 3, 30000, 0, '2020-07-28 11:21:07', 0, '2020-07-28 11:21:07'),
	(18, 7, 4, 10, 2, 14000, 0, '2020-07-28 11:21:18', 0, '2020-07-28 11:21:18'),
	(19, 1, 4, 11, 2, 20000, 0, '2020-07-28 11:25:06', 0, '2020-07-28 11:25:06'),
	(20, 3, 4, 11, 2, 24000, 0, '2020-07-28 11:25:13', 0, '2020-07-28 11:25:13'),
	(21, 1, 4, 12, 1, 10000, 0, '2020-07-28 11:26:04', 0, '2020-07-28 11:26:04'),
	(22, 9, 4, 13, 3, 30000, 0, '2020-07-28 11:27:24', 0, '2020-07-28 11:28:50'),
	(23, 8, 4, 13, 2, 12000, 0, '2020-07-28 11:27:49', 0, '2020-07-28 11:27:49'),
	(24, 9, 4, 14, 2, 20000, 0, '2020-07-28 11:30:28', 0, '2020-07-28 11:30:28'),
	(25, 8, 4, 14, 2, 12000, 0, '2020-07-28 11:30:42', 0, '2020-07-28 11:30:42'),
	(26, 10, 4, 15, 2, 44000, 0, '2020-07-28 11:31:47', 0, '2020-07-28 11:31:47'),
	(27, 6, 4, 15, 2, 30000, 0, '2020-07-28 11:31:57', 0, '2020-07-28 11:31:57'),
	(28, 4, 4, 16, 2, 18000, 0, '2020-07-28 11:36:26', 0, '2020-07-28 11:36:26'),
	(29, 4, 4, 17, 6, 54000, 0, '2020-07-28 11:41:38', 0, '2020-07-28 11:42:17'),
	(30, 3, 4, 18, 2, 24000, 0, '2020-07-28 15:12:55', 0, '2020-07-28 15:12:55'),
	(31, 2, 5, 19, 2, 26000, 0, '2020-07-28 15:48:43', 0, '2020-07-28 15:48:43'),
	(32, 1, 5, 20, 1, 10000, 0, '2020-07-28 15:51:12', 0, '2020-07-28 15:51:12'),
	(33, 2, 4, 21, 2, 26000, 0, '2020-07-29 13:23:54', 0, '2020-07-29 13:23:54'),
	(34, 1, 4, 22, 2, 20000, 0, '2020-07-29 13:31:13', 0, '2020-07-29 13:31:13'),
	(35, 2, 4, 22, 1, 13000, 0, '2020-07-29 13:31:19', 0, '2020-07-29 13:31:19'),
	(36, 1, 4, 23, 2, 20000, 0, '2020-07-29 13:33:56', 0, '2020-07-29 13:33:56'),
	(37, 4, 4, 23, 1, 9000, 0, '2020-07-29 13:34:14', 0, '2020-07-29 13:34:14'),
	(38, 2, 4, 24, 2, 26000, 0, '2020-07-29 14:11:34', 0, '2020-07-29 14:11:34'),
	(39, 4, 4, 24, 2, 18000, 0, '2020-07-29 14:11:53', 0, '2020-07-29 14:11:53'),
	(40, 2, 2, 25, 2, 26000, 0, '2020-07-30 08:52:37', 0, '2020-07-30 08:52:37'),
	(41, 2, 2, 26, 2, 26000, 0, '2020-07-30 09:36:15', 0, '2020-07-30 09:36:15'),
	(42, 3, 2, 27, 2, 24000, 0, '2020-07-30 16:25:09', 0, '2020-07-30 16:25:09'),
	(43, 3, 2, 28, 1, 12000, 0, '2020-07-30 16:29:23', 0, '2020-07-30 16:29:23');
/*!40000 ALTER TABLE `receipt_detail` ENABLE KEYS */;

-- Dumping structure for table beer_sale.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `reg_id` int(11) DEFAULT NULL,
  `reg_date` datetime DEFAULT NULL,
  `updt_id` int(11) DEFAULT NULL,
  `updt_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table beer_sale.role: ~2 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
REPLACE INTO `role` (`id`, `role_code`, `role_name`, `reg_id`, `reg_date`, `updt_id`, `updt_date`) VALUES
	(1, 'admin', 'Administer', NULL, NULL, NULL, NULL),
	(2, 'client', 'Customer', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table beer_sale.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `reg_id` int(11) DEFAULT NULL,
  `reg_date` datetime DEFAULT NULL,
  `updt_id` int(11) DEFAULT NULL,
  `updt_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_user_account` (`user_account_id`),
  CONSTRAINT `FK_user_user_account` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Dumping data for table beer_sale.user: ~5 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `user_account_id`, `name`, `email`, `phone_number`, `reg_id`, `reg_date`, `updt_id`, `updt_date`) VALUES
	(1, 1, 'Hồ Tấn Giang', 'example@gmail.com', '0123456789', NULL, '2020-07-27 17:48:33', NULL, '2020-07-27 17:48:33'),
	(2, 2, 'Clien A', 'asdasd@sdasd', '123123123', NULL, '2020-07-27 17:48:33', 0, '2020-07-28 18:55:50'),
	(3, 3, 'Client B', 'example@gmail.com', '0123456789', NULL, '2020-07-27 17:48:33', NULL, '2020-07-27 17:48:33'),
	(4, 4, 'Client C', 'example@gmail.com', '0123456789', NULL, '2020-07-27 17:48:33', NULL, '2020-07-27 17:48:33'),
	(5, 6, 'client f', 'clientf', '123123123', 6, '2020-07-28 13:47:37', 6, '2020-07-28 13:47:37');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table beer_sale.user_account
CREATE TABLE IF NOT EXISTS `user_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `money` int(11) NOT NULL,
  `reg_id` int(11) DEFAULT NULL,
  `reg_date` datetime DEFAULT NULL,
  `updt_id` int(11) DEFAULT NULL,
  `updt_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_account_role` (`role_id`),
  CONSTRAINT `FK_user_account_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Dumping data for table beer_sale.user_account: ~5 rows (approximately)
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
REPLACE INTO `user_account` (`id`, `username`, `password`, `role_id`, `status`, `money`, `reg_id`, `reg_date`, `updt_id`, `updt_date`) VALUES
	(1, 'sneakyg', '123bon', 1, 1, 0, NULL, '2020-07-27 17:48:33', NULL, '2020-07-27 17:48:33'),
	(2, 'clienta', '123bon', 2, 1, 12000, NULL, '2020-07-27 17:48:33', 0, '2020-07-30 16:29:23'),
	(3, 'clientb', 'asdasd', 2, 0, 50000, NULL, '2020-07-27 17:48:33', 1, '2020-07-29 15:10:25'),
	(4, 'clientc', '123bon', 2, 1, 10000, NULL, '2020-07-27 17:48:33', 0, '2020-07-29 14:11:53'),
	(6, 'clientf', '123bon', 2, 1, 11000, NULL, '2020-07-28 13:47:37', 0, '2020-07-28 15:51:12');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
