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


-- Dumping database structure for study_online
CREATE DATABASE IF NOT EXISTS `study_online` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `study_online`;

-- Dumping structure for table study_online.course
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Dumping data for table study_online.course: ~5 rows (approximately)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
REPLACE INTO `course` (`id`, `name`) VALUES
	(1, 'Java'),
	(2, 'HTML'),
	(3, 'CSS'),
	(24, 'b'),
	(32, 'c');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumping structure for table study_online.lesson
CREATE TABLE IF NOT EXISTS `lesson` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT '0',
  `id_topic` int(5) NOT NULL,
  `body` text DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `FK_lesson_topic` (`id_topic`),
  CONSTRAINT `FK_lesson_topic` FOREIGN KEY (`id_topic`) REFERENCES `topic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table study_online.lesson: ~2 rows (approximately)
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
REPLACE INTO `lesson` (`id`, `name`, `id_topic`, `body`) VALUES
	(1, 'What is Java', 1, 'JAVA was developed by Sun Microsystems Inc in 1991, later acquired by Oracle Corporation. It was developed by James Gosling and Patrick Naughton. It is a simple programming language.  Writing, compiling and debugging a program is easy in java.  It helps to create modular programs and reusable code.'),
	(2, 'Java Virtual Machine', 1, 'Java is a high level programming language. A program written in high level language cannot be run on any machine directly. First, it needs to be translated into that particular machine language. The javac compiler does this thing, it takes java program (.java file containing source code) and translates it into machine code (referred as byte code or .class file).'),
	(3, 'OOPs concepts in Java', 2, 'Object-oriented programming System(OOPs) is a programming paradigm based on the concept of “objects” that contain data and methods. The primary purpose of object-oriented programming is to increase the flexibility and maintainability of programs. Object oriented programming brings together data and its behaviour(methods) in a single location(object) makes it easier to understand how a program works. We will cover each and every feature of OOPs in detail so that you won’t face any difficultly understanding OOPs Concepts.'),
	(5, 'v', 26, NULL),
	(7, 'a', 6, 'a');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;

-- Dumping structure for table study_online.topic
CREATE TABLE IF NOT EXISTS `topic` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT '',
  `id_course` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_topic_course` (`id_course`),
  CONSTRAINT `FK_topic_course` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- Dumping data for table study_online.topic: ~6 rows (approximately)
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
REPLACE INTO `topic` (`id`, `name`, `id_course`) VALUES
	(1, 'Java basic', 1),
	(2, 'Java OPP', 1),
	(5, 'what is html', 2),
	(6, 'bbb', 3),
	(26, 'b', 3),
	(27, 'c', 24),
	(30, 'k', 24);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;

-- Dumping structure for table study_online.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `role` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table study_online.user: ~6 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `name`, `pwd`, `role`) VALUES
	(1, 'user1', '123456', b'0'),
	(2, 'user2', '123', b'0'),
	(3, 'admin', '123', b'1'),
	(12, 'a', 'a', b'0'),
	(15, 'd', 'd', b'1'),
	(17, 'a', 'a', b'0'),
	(18, 'a', 'b', b'0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
