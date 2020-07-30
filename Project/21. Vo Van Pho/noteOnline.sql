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


-- Dumping database structure for ghichudb
CREATE DATABASE IF NOT EXISTS `ghichudb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ghichudb`;

-- Dumping structure for table ghichudb.tbl_note
CREATE TABLE IF NOT EXISTS `tbl_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `namec` varchar(255) NOT NULL,
  `content` text DEFAULT NULL,
  `date_reg` datetime DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbl_note_user` (`userid`),
  CONSTRAINT `FK_tbl_note_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- Dumping data for table ghichudb.tbl_note: ~13 rows (approximately)
/*!40000 ALTER TABLE `tbl_note` DISABLE KEYS */;
INSERT INTO `tbl_note` (`id`, `namec`, `content`, `date_reg`, `date_upd`, `userid`) VALUES
	(3, 'sss', 'noi dung moi', '2020-07-28 09:18:20', '2020-07-30 16:01:33', 4),
	(4, 'sss', '', '2020-07-28 09:19:19', '2020-07-28 09:19:19', 4),
	(5, 'ssc', 'noi', '2020-07-28 09:21:16', '2020-07-28 09:21:16', 2),
	(6, 'hocjava', '', '2020-07-28 09:22:57', '2020-07-28 09:22:57', 4),
	(7, 'kiem tra', 'fffffff', '2020-07-28 09:28:32', '2020-07-30 15:56:56', 4),
	(8, 'abc', '', '2020-07-28 09:32:11', '2020-07-28 09:32:11', 2),
	(9, 'ten', 'eeeeeee', '2020-07-28 09:33:23', '2020-07-28 09:33:23', 4),
	(10, 'tenw', 'ndkf', '2020-07-28 09:36:15', '2020-07-28 09:36:15', 2),
	(14, 'aaaaa', 'ddddddd', '2020-07-28 19:39:23', '2020-07-28 19:39:23', 9),
	(15, 'end', 'hom nay da ket thuc nhung chuoi ngay met moi', '2020-07-29 09:58:46', '2020-07-29 09:58:46', 8),
	(16, 'ngay 07/29', 'hom nay duo nghi buoi chieu', '2020-07-29 17:08:30', '2020-07-29 17:08:30', 1),
	(18, 'Basic', 'noi dung trung ten', '2020-07-30 11:58:48', '2020-07-30 11:58:48', 1),
	(19, 'tan', 'new kiem tra id note moi', '2020-07-30 15:28:17', '2020-07-30 15:28:17', 1),
	(21, 'new', 'bai viet moi', '2020-07-30 16:22:52', '2020-07-30 16:22:52', 21),
	(26, 'avvc', 'ass', '2020-07-30 19:21:35', '2020-07-30 19:21:35', 28),
	(27, 'ddd', 'fdd', '2020-07-30 19:43:11', '2020-07-30 20:22:15', 23);
/*!40000 ALTER TABLE `tbl_note` ENABLE KEYS */;

-- Dumping structure for table ghichudb.tbl_permission
CREATE TABLE IF NOT EXISTS `tbl_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ghichudb.tbl_permission: ~0 rows (approximately)
/*!40000 ALTER TABLE `tbl_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_permission` ENABLE KEYS */;

-- Dumping structure for table ghichudb.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `date_reg` datetime DEFAULT NULL,
  `role` varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- Dumping data for table ghichudb.user: ~12 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `date_reg`, `role`) VALUES
	(1, 'tan', '123', '2020-07-27 11:26:04', 'user'),
	(2, 'nam', '111', '2020-07-27 11:26:06', 'user'),
	(3, 'account', 'pho', '2020-07-27 11:04:28', 'user'),
	(4, 'cong', '2222', '2020-07-27 11:08:46', 'user'),
	(8, 'pho', '111', '2020-07-28 19:36:13', 'user'),
	(9, 'phuong', '123', '2020-07-28 19:38:28', 'user'),
	(11, 'po', '1234', '2020-07-29 08:10:36', 'admin'),
	(13, 'vo', '121', '2020-07-29 10:58:17', 'user'),
	(14, '2', 'vo', '2020-07-29 10:59:36', 'user'),
	(17, 'wq', 'qw', '2020-07-29 13:56:28', 'user'),
	(18, 'eee', 'eeee', '2020-07-29 15:59:30', 'user'),
	(19, 'hoa', '123', '2020-07-30 08:24:42', 'user'),
	(21, 'phat', '123', '2020-07-30 16:18:14', 'user'),
	(22, '1234', 'tgg', '2020-07-30 16:24:37', 'user'),
	(23, 'ttt', '111', '2020-07-30 16:25:17', 'user'),
	(24, 'you', '123', '2020-07-30 17:25:41', 'user'),
	(28, 'tab', '123', '2020-07-30 18:57:45', 'user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
