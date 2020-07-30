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


-- Dumping database structure for vocabulary
CREATE DATABASE IF NOT EXISTS `vocabulary` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vocabulary`;

-- Dumping structure for table vocabulary.connectword
CREATE TABLE IF NOT EXISTS `connectword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `lang_id` int(11) DEFAULT NULL,
  `vn_id` int(11) DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lang_id` (`lang_id`),
  KEY `FK_word_lang_word_vn` (`vn_id`),
  KEY `FK_word_lang_topic` (`topic_id`),
  CONSTRAINT `FK_word_lang_language` FOREIGN KEY (`lang_id`) REFERENCES `language` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_word_lang_topic` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_word_lang_word_vn` FOREIGN KEY (`vn_id`) REFERENCES `word_vn` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- Dumping data for table vocabulary.connectword: ~45 rows (approximately)
/*!40000 ALTER TABLE `connectword` DISABLE KEYS */;
REPLACE INTO `connectword` (`id`, `name`, `lang_id`, `vn_id`, `topic_id`) VALUES
	(1, 'apple', 2, 1, 1),
	(2, 'grape', 2, 2, 1),
	(3, 'orange', 2, 3, 1),
	(4, 'lemon', 2, 4, 1),
	(5, 'one', 2, 5, 2),
	(6, 'two', 2, 6, 2),
	(7, 'three', 2, 7, 2),
	(8, 'four', 2, 8, 2),
	(9, 'five', 2, 9, 2),
	(10, 'waiter', 2, 10, 3),
	(11, 'waitress', 2, 11, 3),
	(12, 'knife', 2, 12, 3),
	(13, 'straw', 2, 13, 3),
	(14, 'operating system', 2, 14, 4),
	(15, 'memory', 2, 15, 4),
	(16, 'storage', 2, 16, 4),
	(17, 'graphics', 2, 17, 4),
	(18, '사과', 3, 1, 1),
	(19, '포도', 3, 2, 1),
	(20, '주황색', 3, 3, 1),
	(21, '레몬', 3, 4, 1),
	(22, '일', 3, 5, 2),
	(23, '이', 3, 6, 2),
	(24, '삼', 3, 7, 2),
	(25, '사', 3, 8, 2),
	(26, '오', 3, 9, 2),
	(27, '웨이터', 3, 10, 3),
	(28, '웨이트리스', 3, 11, 3),
	(29, '칼', 3, 12, 3),
	(30, '빨대', 3, 13, 3),
	(31, '운영 체제', 3, 14, 4),
	(32, '기억', 3, 15, 4),
	(33, '창고 보관', 3, 16, 4),
	(34, '제도법', 3, 17, 4),
	(35, 'manzana', 4, 1, 1),
	(36, '맛있게 드세요', 3, 18, 5),
	(37, '아니요', 3, 19, 5),
	(38, '만나서 반가워', 3, 20, 5),
	(39, 'いち', 5, 5, 2),
	(40, ' 네', 3, 21, 5),
	(41, 'に', 5, 6, 2),
	(42, 'さん', 5, 7, 2),
	(45, 'ご', 5, 8, 2),
	(46, 'ごく', 5, 9, 2),
	(47, 'こんにちは', 5, 22, 5);
/*!40000 ALTER TABLE `connectword` ENABLE KEYS */;

-- Dumping structure for table vocabulary.language
CREATE TABLE IF NOT EXISTS `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lang` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table vocabulary.language: ~10 rows (approximately)
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
REPLACE INTO `language` (`id`, `lang`) VALUES
	(1, 'vietnam'),
	(2, 'english'),
	(3, 'korean'),
	(4, 'spanish'),
	(5, 'japanese'),
	(7, 'test4'),
	(8, 'test5'),
	(9, 'test6'),
	(17, 'test7'),
	(18, 'test9');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;

-- Dumping structure for table vocabulary.topic
CREATE TABLE IF NOT EXISTS `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Dumping data for table vocabulary.topic: ~6 rows (approximately)
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
REPLACE INTO `topic` (`id`, `name`) VALUES
	(1, 'trái cây'),
	(2, 'số đếm'),
	(3, 'nhà hàng'),
	(4, 'công nghệ'),
	(5, 'chào hỏi'),
	(12, 'gfg');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;

-- Dumping structure for table vocabulary.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table vocabulary.user: ~8 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `username`, `password`, `role`) VALUES
	(1, 'user1', '123', b'1'),
	(2, 'user2', '1234', b'0'),
	(3, 'admin', 'admin', b'1'),
	(5, 'a', 'a', b'0'),
	(7, 'admin1111', '999', b'0'),
	(8, 'admin888', '999', b'0'),
	(9, 'b', 'b', b'0'),
	(10, 'sd', 'as', b'0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table vocabulary.word_vn
CREATE TABLE IF NOT EXISTS `word_vn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_id` (`topic_id`),
  CONSTRAINT `FK_word_vn_topic` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- Dumping data for table vocabulary.word_vn: ~23 rows (approximately)
/*!40000 ALTER TABLE `word_vn` DISABLE KEYS */;
REPLACE INTO `word_vn` (`id`, `name`, `topic_id`) VALUES
	(1, 'táo', 1),
	(2, 'nho', 1),
	(3, 'cam', 1),
	(4, 'chanh', 1),
	(5, 'một', 2),
	(6, 'hai', 2),
	(7, 'ba', 2),
	(8, 'bốn', 2),
	(9, 'năm', 2),
	(10, 'Phục vụ nam', 3),
	(11, 'Nữ phục vụ', 3),
	(12, 'fsdfsd', 3),
	(13, 'ống hút', 3),
	(14, 'hệ điều hành', 4),
	(15, 'bộ nhớ', 4),
	(16, 'lưu trữ', 4),
	(17, 'đồ họa', 4),
	(18, 'chúc ngon miệng', 5),
	(19, 'Không', 5),
	(20, 'Rất vui được gặp bạn', 5),
	(21, 'có', 5),
	(22, 'xin chào', 1),
	(27, 'gggggggggggg', 1);
/*!40000 ALTER TABLE `word_vn` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
