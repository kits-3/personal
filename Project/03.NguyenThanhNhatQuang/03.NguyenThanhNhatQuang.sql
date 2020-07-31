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


-- Dumping database structure for taskmanagement
CREATE DATABASE IF NOT EXISTS `taskmanagement` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `taskmanagement`;

-- Dumping structure for table taskmanagement.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `display` int(11) NOT NULL DEFAULT 1,
  `description` varchar(255) NOT NULL DEFAULT 'Not Description',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table taskmanagement.role: ~2 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `display`, `description`) VALUES
	(1, 'ADMIN', 1, 'Not Description'),
	(2, 'USER', 1, 'Not Description');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table taskmanagement.task
CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `header` varchar(255) NOT NULL,
  `owner` int(11) NOT NULL,
  `create_date` datetime DEFAULT current_timestamp(),
  `update_date` datetime DEFAULT current_timestamp(),
  `delete_date` datetime DEFAULT NULL,
  `deadline` datetime NOT NULL DEFAULT (current_timestamp() + interval 31 day),
  `status` int(11) NOT NULL DEFAULT 0,
  `display` int(11) NOT NULL DEFAULT 1,
  `description` varchar(255) NOT NULL DEFAULT 'Not Description',
  PRIMARY KEY (`id`),
  KEY `owner` (`owner`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- Dumping data for table taskmanagement.task: ~21 rows (approximately)
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`id`, `header`, `owner`, `create_date`, `update_date`, `delete_date`, `deadline`, `status`, `display`, `description`) VALUES
	(1, 'go coffee', 2, '2020-07-27 08:02:05', '2020-07-27 08:02:05', NULL, '2020-08-27 08:02:05', 0, 1, 'Not Description'),
	(2, 'shopping', 2, '2020-07-27 08:02:05', '2020-07-27 08:02:05', NULL, '2020-08-27 08:02:05', 0, 1, 'Not Description'),
	(3, 'cooking', 2, '2020-07-27 08:02:05', '2020-07-27 08:02:05', NULL, '2020-08-27 08:02:05', 0, 1, 'Not Description'),
	(4, 'go home', 2, '2020-07-27 08:02:05', '2020-07-27 08:02:05', NULL, '2020-08-27 08:02:05', 0, 1, 'Not Description'),
	(6, 'shopping', 1, '2020-07-27 08:02:56', '2020-07-27 14:24:30', NULL, '2020-08-27 08:02:56', 0, 1, 'Not Description'),
	(7, 'go home', 1, '2020-07-27 08:02:56', '2020-07-27 08:02:56', NULL, '2020-08-27 08:02:56', 0, 1, 'Not Description'),
	(8, 'swimming', 1, '2020-07-27 08:02:56', '2020-07-27 08:02:56', NULL, '2020-08-27 08:02:56', 0, 1, 'Not Description'),
	(9, 'go java', 4, '2020-07-27 12:47:06', '2020-07-30 14:57:57', NULL, '2020-08-27 12:47:06', 0, 0, 'Not Description'),
	(10, 'go coffee', 4, '2020-07-27 15:10:39', '2020-07-28 18:38:09', NULL, '2020-08-27 15:10:39', 0, 1, 'Not Description'),
	(11, 'go coffee', 4, '2020-07-27 17:16:04', '2020-07-28 18:38:43', NULL, '2020-08-27 17:16:04', 0, 1, 'Not Description'),
	(12, 'play game', 4, '2020-07-28 16:52:41', '2020-07-29 17:22:21', NULL, '2020-08-28 16:52:41', 0, 0, 'Not Description'),
	(13, 'play game', 4, '2020-07-29 17:13:28', '2020-07-29 17:15:00', NULL, '2020-08-29 17:13:28', 1, 0, 'AOE2'),
	(14, 'hello java', 4, '2020-07-29 17:21:17', '2020-07-29 17:21:53', NULL, '2020-08-29 17:21:17', 1, 1, 'hello java core'),
	(15, 'zalo', 4, '2020-07-29 18:03:08', '2020-07-29 18:03:08', NULL, '2020-08-29 18:03:08', 0, 1, 'Not Description'),
	(16, 'zalo one', 4, '2020-07-29 18:08:09', '2020-07-29 18:08:09', NULL, '2020-08-29 18:08:09', 0, 1, 'Not Description'),
	(17, 'cora', 4, '2020-07-29 18:12:09', '2020-07-29 18:13:08', NULL, '2020-08-29 18:12:09', 1, 0, 'Not Description'),
	(21, 'abc', 1, '2020-07-30 09:20:29', '2020-07-30 09:20:29', NULL, '2020-08-30 09:20:29', 0, 1, 'Not Description'),
	(22, 'learn java', 4, '2020-07-30 11:53:39', '2020-07-30 11:53:39', NULL, '2020-08-30 11:53:39', 0, 1, 'Not Description'),
	(23, 'buy coffee', 1, '2020-07-30 13:47:51', '2020-07-30 13:47:51', NULL, '2020-08-30 13:47:51', 0, 1, 'Not Description'),
	(24, 'java core', 11, '2020-07-30 16:01:47', '2020-07-30 16:03:14', NULL, '2020-08-30 16:01:47', 0, 0, 'zolo'),
	(25, 'play game', 11, '2020-07-30 16:02:01', '2020-07-30 16:02:01', NULL, '2020-08-30 16:02:01', 0, 1, 'Not Description'),
	(30, 'learn java', 20, '2020-07-31 08:18:30', '2020-07-31 08:18:30', NULL, '2020-08-31 08:18:30', 0, 1, 'Not Description'),
	(31, 'learn html', 20, '2020-07-31 08:18:42', '2020-07-31 08:18:42', NULL, '2020-08-31 08:18:42', 0, 1, 'Not Description'),
	(32, 'learn css', 20, '2020-07-31 08:18:47', '2020-07-31 08:18:47', NULL, '2020-08-31 08:18:47', 0, 1, 'Not Description'),
	(33, 'learn js', 20, '2020-07-31 08:18:57', '2020-07-31 08:21:43', NULL, '2020-08-31 08:18:57', 0, 0, 'Not Description'),
	(34, 'play game', 20, '2020-07-31 08:19:19', '2020-07-31 08:20:54', NULL, '2020-08-31 08:19:19', 1, 0, 'LOL'),
	(35, 'learn javaaa', 22, '2020-07-31 08:27:25', '2020-07-31 08:29:03', NULL, '2020-08-31 08:27:25', 1, 0, 'java coreee'),
	(36, 'java core', 22, '2020-07-31 08:27:43', '2020-07-31 08:29:28', NULL, '2020-08-31 08:27:43', 0, 0, 'Not Description'),
	(37, 'learn java', 22, '2020-07-31 08:29:44', '2020-07-31 08:29:44', NULL, '2020-08-31 08:29:44', 0, 1, 'Not Description');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;

-- Dumping structure for table taskmanagement.taskdetail
CREATE TABLE IF NOT EXISTS `taskdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `task_id` int(11) NOT NULL,
  `create_date` datetime DEFAULT current_timestamp(),
  `update_date` datetime DEFAULT current_timestamp(),
  `delete_date` datetime DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `display` int(11) NOT NULL DEFAULT 1,
  `description` varchar(255) NOT NULL DEFAULT 'Not Description',
  PRIMARY KEY (`id`),
  KEY `task_id` (`task_id`),
  CONSTRAINT `taskdetail_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- Dumping data for table taskmanagement.taskdetail: ~33 rows (approximately)
/*!40000 ALTER TABLE `taskdetail` DISABLE KEYS */;
INSERT INTO `taskdetail` (`id`, `content`, `task_id`, `create_date`, `update_date`, `delete_date`, `status`, `display`, `description`) VALUES
	(1, 'call john', 1, '2020-07-27 08:03:34', '2020-07-27 08:03:34', NULL, 0, 1, 'Not Description'),
	(2, 'call mary', 1, '2020-07-27 08:03:34', '2020-07-27 08:03:34', NULL, 0, 1, 'Not Description'),
	(3, 'book table', 1, '2020-07-27 08:03:34', '2020-07-27 08:03:34', NULL, 0, 1, 'Not Description'),
	(4, 'buy T-shirt', 2, '2020-07-27 08:03:37', '2020-07-27 08:03:37', NULL, 0, 1, 'Not Description'),
	(5, 'buy clothes', 2, '2020-07-27 08:03:37', '2020-07-27 08:03:37', NULL, 0, 1, 'Not Description'),
	(6, 'call taxi', 2, '2020-07-27 08:03:37', '2020-07-27 08:03:37', NULL, 0, 1, 'Not Description'),
	(7, 'bacon', 3, '2020-07-27 08:03:41', '2020-07-27 08:03:41', NULL, 0, 1, 'Not Description'),
	(8, 'fish', 3, '2020-07-27 08:03:41', '2020-07-27 08:03:41', NULL, 0, 1, 'Not Description'),
	(9, 'rice', 3, '2020-07-27 08:03:41', '2020-07-27 08:03:41', NULL, 0, 1, 'Not Description'),
	(10, 'bus', 4, '2020-07-27 08:03:44', '2020-07-27 08:03:44', NULL, 0, 1, 'Not Description'),
	(11, 'walk', 4, '2020-07-27 08:03:44', '2020-07-27 08:03:44', NULL, 0, 1, 'Not Description'),
	(12, 'do homework', 4, '2020-07-27 08:03:44', '2020-07-27 08:03:44', NULL, 0, 1, 'Not Description'),
	(14, 'call john', 8, '2020-07-27 08:04:08', '2020-07-27 08:04:08', NULL, 0, 1, 'Not Description'),
	(15, 'call mary', 8, '2020-07-27 08:04:08', '2020-07-27 08:04:08', NULL, 0, 1, 'Not Description'),
	(16, 'book table', 8, '2020-07-27 08:04:08', '2020-07-27 08:04:08', NULL, 0, 1, 'Not Description'),
	(17, 'bus', 6, '2020-07-27 08:04:11', '2020-07-27 08:04:11', NULL, 0, 1, 'Not Description'),
	(18, 'walk', 6, '2020-07-27 08:04:11', '2020-07-27 08:04:11', NULL, 0, 1, 'Not Description'),
	(19, 'do homework', 6, '2020-07-27 08:04:11', '2020-07-27 08:04:11', NULL, 0, 1, 'Not Description'),
	(20, 'do homework', 7, '2020-07-27 08:04:14', '2020-07-27 08:04:14', NULL, 0, 1, 'Not Description'),
	(21, 'get money', 7, '2020-07-27 08:04:14', '2020-07-27 08:04:14', NULL, 0, 1, 'Not Description'),
	(22, 'call due', 7, '2020-07-27 08:04:14', '2020-07-27 08:04:14', NULL, 0, 1, 'Not Description'),
	(23, 'call quang', 9, '2020-07-28 11:24:39', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(24, 'call john', 9, '2020-07-28 11:46:24', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(25, 'buy clothes', 9, '2020-07-28 11:52:14', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(26, 'Buy food', 9, '2020-07-28 11:55:58', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(27, 'Buy Candy', 9, '2020-07-28 11:58:31', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(28, 'buy drink', 9, '2020-07-28 12:43:41', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(29, 'Buy Chicken', 9, '2020-07-28 12:44:15', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(30, 'Buy Coca', 9, '2020-07-28 12:45:12', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(31, 'Buy Noodle', 9, '2020-07-28 12:46:58', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(32, 'mariadb', 9, '2020-07-29 17:15:25', '2020-07-30 14:57:57', NULL, 0, 0, 'Not Description'),
	(43, 'PUBG', 25, '2020-07-30 16:03:37', '2020-07-30 16:05:03', NULL, 0, 1, 'Not Description'),
	(44, 'AOE', 25, '2020-07-30 16:03:58', '2020-07-30 16:05:38', NULL, 0, 0, 'Not Description'),
	(45, 'java core', 30, '2020-07-31 08:22:31', '2020-07-31 08:22:31', NULL, 0, 1, 'Not Description'),
	(46, 'oop', 30, '2020-07-31 08:22:54', '2020-07-31 08:22:54', NULL, 0, 1, 'Not Description'),
	(47, 'play game', 30, '2020-07-31 08:23:31', '2020-07-31 08:25:02', NULL, 0, 0, 'Not Description'),
	(48, 'coreee', 37, '2020-07-31 08:30:10', '2020-07-31 08:32:11', NULL, 1, 0, 'Not Description'),
	(49, 'abc', 37, '2020-07-31 08:30:33', '2020-07-31 08:30:33', NULL, 0, 1, 'Not Description');
/*!40000 ALTER TABLE `taskdetail` ENABLE KEYS */;

-- Dumping structure for table taskmanagement.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL DEFAULT 2,
  `lname` varchar(255) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `birthday` datetime DEFAULT curdate(),
  `create_date` datetime DEFAULT current_timestamp(),
  `update_date` datetime DEFAULT current_timestamp(),
  `delete_date` datetime DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `display` int(11) NOT NULL DEFAULT 1,
  `description` varchar(255) NOT NULL DEFAULT 'Not Description',
  `phone` varchar(255) NOT NULL DEFAULT '0123456789',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- Dumping data for table taskmanagement.user: ~8 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `role_id`, `lname`, `fname`, `birthday`, `create_date`, `update_date`, `delete_date`, `status`, `display`, `description`, `phone`) VALUES
	(1, 'admin', '123456', 'admin@gmail.com', 1, 'admin', 'admin', '2020-07-27 08:01:42', '2020-07-27 08:01:42', '2020-07-27 08:01:42', NULL, 1, 1, 'Not Description', '0123456789'),
	(2, 'quangnguyen', '123456', 'quangnguyen@gmail.com', 2, 'quang', 'nguyen', '2020-07-27 08:01:42', '2020-07-27 08:01:42', '2020-07-27 08:01:42', NULL, 1, 1, 'Not Description', '0123456789'),
	(4, 'quangntn', '123456', 'quangntn@gmail.com', 2, 'Quang123', 'Nguyen123', '2020-07-27 08:42:30', '2020-07-27 08:42:30', '2020-07-27 08:42:30', NULL, 1, 1, 'ABCDEF', '0987654321'),
	(7, 'quangnguyen123', '123456', 'quangnguyen123@gmail.com', 2, 'Quang', 'Nguyen123', '2020-07-27 18:06:29', '2020-07-27 18:06:29', '2020-07-27 18:06:29', NULL, 1, 1, 'Not Description', '1234567890'),
	(10, 'quangabc', '1234567', 'quangabc@gmail.com', 2, 'quang', 'abc', '2020-07-29 18:23:46', '2020-07-29 18:23:46', '2020-07-29 18:23:46', NULL, 1, 1, 'Not Description', '1234567890'),
	(11, 'ntnquang', '1234567', 'ntnquang@gmail.com', 1, 'Quang', 'Nguyen', '2020-07-30 16:01:13', '2020-07-30 16:01:13', '2020-07-30 16:01:13', NULL, 1, 1, 'Not Description', '1234567890'),
	(14, 'quangnguyen1234', '123456', 'quangnguyen1234@gmail.com', 2, 'quang', 'nguyen', '2020-07-30 00:00:00', '2020-07-30 16:41:37', '2020-07-30 16:41:37', NULL, 1, 1, 'Not Description', '0123456789'),
	(20, 'video', '123456', 'video@gmail.com', 2, 'video', 'java', '2020-07-31 00:00:00', '2020-07-31 08:17:06', '2020-07-31 08:17:06', NULL, 1, 1, 'Not Description', '1234567890'),
	(22, 'record', '12345', 'recorddd@gmail.com', 1, 'recorddd', 'videoooo', '2020-07-31 00:00:00', '2020-07-31 08:26:56', '2020-07-31 08:26:56', NULL, 1, 1, 'Not Description', '123456789');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
