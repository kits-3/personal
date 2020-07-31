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


-- Dumping database structure for db_atm
DROP DATABASE IF EXISTS `db_atm`;
CREATE DATABASE IF NOT EXISTS `db_atm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_atm`;

-- Dumping structure for table db_atm.account
DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `id_card` varchar(20) NOT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `contact` varchar(20) NOT NULL,
  `status` int(11) DEFAULT 0 COMMENT '0. Block  1.Active',
  `create_at` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- Dumping data for table db_atm.account: ~10 rows (approximately)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
REPLACE INTO `account` (`id`, `name`, `username`, `password`, `id_card`, `money`, `contact`, `status`, `create_at`) VALUES
	(11, 'Maritza Schiller', 'account01', '1234567', '5247854126', 114159.10, '0142875639', 1, '2019-04-24 09:59:15'),
	(12, 'Gudrun Prohaska', 'account02', '123456', '4785411587', 13108.20, '0365874521', 1, '2019-06-24 10:00:07'),
	(13, 'John', 'account03', '123456', '4758214592', 6538.00, '04754218593', 1, '2019-06-24 10:00:46'),
	(14, 'Mckenna Mitchell', 'account04', '123456', '7569824563', 5038.70, '03658247156', 1, '2019-06-24 10:02:08'),
	(16, 'John', 'ID2569089O', 'b8o65w', '4521784569', 9523.00, '2354875412', 0, '2020-07-28 10:32:05'),
	(17, 'Tommy', 'IDQC50GR7Q', '532123', '1122334455', 11000.00, '3548754628', 1, '2020-07-28 10:54:41'),
	(19, 'Tom', 'IDQWLAGH4Q', 'xmj97r', '5474521486', 10021.00, '3254784521', 1, '2020-07-28 11:00:44'),
	(20, 'Rin', 'IDC9S1H231', 'xda165', '5421578456', 3505.00, '3254784521', 1, '2020-07-30 09:57:43'),
	(22, 'Deny', 'ID02H34219', '123456', '1245789563', 36802.70, '2154784526', 1, '2020-07-30 11:42:22'),
	(24, 'Maria', 'IDC9S1H235', '6l18u3', '1245754856', 3005.00, '1245265328', 0, '2020-07-31 08:32:16');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Dumping structure for table db_atm.history
DROP TABLE IF EXISTS `history`;
CREATE TABLE IF NOT EXISTS `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL DEFAULT 0,
  `type` int(11) NOT NULL DEFAULT 0 COMMENT '1.Withdraw  2.Transfer 3.Deposit 4.ChangePassword',
  `money` double NOT NULL DEFAULT 5,
  `transfer_id` int(11) NOT NULL DEFAULT 0,
  `create_at` datetime DEFAULT current_timestamp(),
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '1.Success  2.Error',
  PRIMARY KEY (`id`,`account_id`),
  KEY `FK_history_account` (`account_id`),
  CONSTRAINT `FK_history_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- Dumping data for table db_atm.history: ~64 rows (approximately)
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
REPLACE INTO `history` (`id`, `account_id`, `type`, `money`, `transfer_id`, `create_at`, `status`) VALUES
	(7, 11, 4, 0, 0, '2020-05-24 16:40:34', 1),
	(8, 11, 1, 10, 0, '2020-05-27 11:07:12', 1),
	(9, 11, 1, 2050.5, 0, '2020-05-27 11:07:40', 1),
	(10, 11, 4, 0, 0, '2020-05-27 11:38:00', 1),
	(43, 11, 2, 150, 12, '2020-05-27 16:37:59', 1),
	(44, 11, 2, 750, 12, '2020-05-27 16:38:46', 1),
	(45, 11, 2, 1500, 12, '2020-06-27 16:38:56', 1),
	(46, 11, 2, 15, 12, '2020-06-27 16:39:33', 1),
	(47, 11, 1, 50, 0, '2020-06-27 16:57:24', 1),
	(48, 11, 1, 100, 0, '2020-06-27 16:58:13', 1),
	(49, 11, 1, 200, 0, '2020-07-27 16:58:45', 1),
	(50, 11, 3, 500, 0, '2020-07-27 17:01:09', 1),
	(51, 11, 3, 500, 0, '2020-07-27 17:27:46', 1),
	(52, 11, 1, 500, 0, '2020-07-27 17:31:00', 1),
	(53, 11, 1, 500, 0, '2020-07-27 17:31:30', 1),
	(54, 11, 1, 1000, 0, '2020-05-27 17:31:55', 1),
	(55, 11, 1, 1000, 0, '2020-07-27 17:32:45', 1),
	(56, 11, 3, 5000, 0, '2020-05-26 17:33:13', 1),
	(57, 11, 1, 35, 0, '2020-07-28 07:55:42', 1),
	(58, 11, 4, 0, 0, '2020-07-28 15:04:49', 1),
	(59, 11, 1, 700, 0, '2020-07-28 15:06:03', 1),
	(60, 11, 3, 100, 0, '2020-07-28 15:06:44', 1),
	(61, 11, 3, 50, 0, '2020-07-28 15:07:14', 1),
	(62, 11, 2, 1300, 17, '2020-07-28 15:08:46', 1),
	(63, 12, 1, 200, 0, '2020-07-28 15:40:03', 1),
	(64, 12, 1, 200, 0, '2020-07-28 15:40:36', 1),
	(65, 12, 3, 20050, 0, '2020-07-28 15:40:51', 1),
	(66, 12, 2, 9700, 17, '2020-07-28 15:41:16', 1),
	(67, 11, 1, 2300, 0, '2020-07-30 10:07:16', 1),
	(68, 11, 3, 500, 0, '2020-07-30 10:10:28', 1),
	(69, 11, 1, 1500, 0, '2020-07-30 10:11:17', 1),
	(70, 11, 1, 100, 0, '2020-07-30 11:09:00', 1),
	(71, 11, 1, 200, 0, '2020-07-30 11:09:09', 1),
	(72, 11, 2, 1550, 19, '2020-07-30 11:13:26', 1),
	(73, 14, 4, 0, 0, '2020-07-30 11:26:46', 1),
	(74, 14, 4, 0, 0, '2020-07-30 11:27:03', 1),
	(75, 14, 1, 50, 0, '2020-07-30 11:29:15', 1),
	(76, 14, 3, 2000, 0, '2020-07-30 11:29:28', 1),
	(77, 14, 3, 3500, 0, '2020-06-30 11:29:42', 1),
	(78, 14, 2, 500, 20, '2020-07-30 11:30:39', 1),
	(79, 11, 2, 200, 12, '2020-07-30 15:19:13', 1),
	(80, 11, 1, 2500, 0, '2020-07-30 15:33:37', 1),
	(81, 11, 4, 0, 0, '2020-07-30 15:52:01', 1),
	(82, 11, 1, 3000, 0, '2020-06-30 15:55:40', 1),
	(83, 11, 3, 100, 0, '2020-07-30 15:57:27', 1),
	(84, 11, 2, 6000, 13, '2020-07-30 15:58:53', 1),
	(85, 22, 4, 0, 0, '2020-07-30 16:24:56', 1),
	(86, 22, 3, 45000, 0, '2020-07-30 16:25:37', 1),
	(87, 22, 1, 4500, 0, '2020-07-30 16:27:25', 1),
	(88, 22, 1, 300, 0, '2020-07-30 16:27:36', 1),
	(89, 22, 1, 400, 0, '2020-07-30 16:27:42', 1),
	(90, 22, 2, 3000, 20, '2020-07-30 16:28:44', 1),
	(91, 11, 1, 500, 0, '2020-07-30 16:47:54', 1),
	(92, 11, 4, 0, 0, '2020-07-31 08:22:30', 1),
	(93, 11, 1, 3, 0, '2020-07-31 08:22:54', 1),
	(94, 11, 3, 3000, 0, '2020-07-31 08:23:40', 1),
	(95, 11, 4, 0, 0, '2020-07-31 08:25:26', 1),
	(96, 11, 1, 500, 0, '2020-07-31 08:25:48', 1),
	(97, 11, 3, 2000, 0, '2020-07-31 08:26:25', 1),
	(98, 11, 2, 3000, 19, '2020-07-31 08:27:11', 1),
	(99, 11, 4, 0, 0, '2020-07-31 08:41:47', 1),
	(100, 11, 1, 5000, 0, '2020-07-31 08:42:12', 1),
	(101, 11, 3, 50000, 0, '2020-07-31 08:42:57', 1),
	(102, 11, 2, 3000, 24, '2020-07-31 08:43:25', 1);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;

-- Dumping structure for table db_atm.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `role` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_role_user` (`user_id`),
  CONSTRAINT `FK_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table db_atm.role: ~10 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
REPLACE INTO `role` (`id`, `user_id`, `role`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(5, 1, 4),
	(6, 2, 2),
	(14, 8, 3),
	(17, 15, 2),
	(18, 15, 4),
	(19, 18, 2),
	(20, 18, 4);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table db_atm.setting
DROP TABLE IF EXISTS `setting`;
CREATE TABLE IF NOT EXISTS `setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_money` double DEFAULT NULL,
  `bank_withdraw` double DEFAULT NULL,
  `bank_transfer` double DEFAULT NULL,
  `bank_invoice` double DEFAULT NULL,
  `bank_min` double DEFAULT 5,
  `min_withdraw` double DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table db_atm.setting: ~1 rows (approximately)
/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
REPLACE INTO `setting` (`id`, `bank_money`, `bank_withdraw`, `bank_transfer`, `bank_invoice`, `bank_min`, `min_withdraw`) VALUES
	(1, 724491576, 0.9, 0.8, 0.7, 5, 1);
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;

-- Dumping structure for table db_atm.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` int(11) DEFAULT 1,
  `create_at` datetime DEFAULT current_timestamp(),
  `role` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table db_atm.user: ~7 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `name`, `username`, `password`, `status`, `create_at`, `role`) VALUES
	(1, 'Admin', 'admin', '123456', 1, '2020-07-29 09:13:29', '1,2,3,4'),
	(2, 'Piter', 'user01', '123456', 1, '2020-07-29 11:19:18', '0'),
	(4, 'Ken', 'user02', '123456', 0, '2020-07-29 11:32:45', '0'),
	(8, 'Lavi', 'user03', '123456', 1, '2020-07-30 08:33:56', '0'),
	(15, 'Maria', 'user04', '123456', 1, '2020-07-30 17:52:33', '0'),
	(16, 'David', 'user05', '123456', 0, '2020-07-30 17:53:26', '0'),
	(18, 'Maria', 'user09', '123456', 1, '2020-07-31 08:44:18', '0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
