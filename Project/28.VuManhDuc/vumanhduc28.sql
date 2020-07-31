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


-- Dumping database structure for moviedb
CREATE DATABASE IF NOT EXISTS `moviedb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `moviedb`;

-- Dumping structure for table moviedb.acc
CREATE TABLE IF NOT EXISTS `acc` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `pass_word` varchar(20) DEFAULT NULL,
  `role` varchar(5) DEFAULT NULL,
  `name_of_user` varchar(50) CHARACTER SET utf16 COLLATE utf16_vietnamese_ci DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table moviedb.acc: ~9 rows (approximately)
/*!40000 ALTER TABLE `acc` DISABLE KEYS */;
INSERT INTO `acc` (`id_user`, `user_name`, `pass_word`, `role`, `name_of_user`, `age`) VALUES
	(1, 'admin', 'admin', 'admin', NULL, NULL),
	(2, 'mduc2110', 'mduc2110', 'user', 'Andres', 18),
	(3, 'ducmanh', 'ducmanh', 'user', 'Roberto', 20),
	(4, 'loip', '123123', 'user', 'Loi', 22),
	(6, 'tiendung', '123123', 'user', 'AchoShi', 30),
	(7, 'batchim', 'batchim', 'user', 'Hoa', 25),
	(8, 'thai', '123', 'user', 'Thai', 18),
	(9, 'mduc11', '123456', 'user', 'Duc', 23),
	(10, 'lienle', 'luonleo', 'user', 'Lien', 17);
/*!40000 ALTER TABLE `acc` ENABLE KEYS */;

-- Dumping structure for table moviedb.booking
CREATE TABLE IF NOT EXISTS `booking` (
  `id_booking` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_movie` int(11) DEFAULT NULL,
  `id_price` int(11) DEFAULT NULL,
  `seat_position` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id_booking`),
  KEY `id_user` (`id_user`),
  KEY `id_movie` (`id_movie`),
  KEY `id_price` (`id_price`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `acc` (`id_user`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`id_movie`) REFERENCES `movie` (`id_movie`),
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`id_price`) REFERENCES `price` (`id_price`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

-- Dumping data for table moviedb.booking: ~26 rows (approximately)
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` (`id_booking`, `id_user`, `id_movie`, `id_price`, `seat_position`) VALUES
	(18, 2, 4, 1, 'G5'),
	(19, 6, 5, 2, 'A1'),
	(20, 4, 4, 2, 'G6'),
	(22, 4, 3, 2, 'E1'),
	(23, 4, 3, 2, 'E2'),
	(24, 4, 3, 2, 'E3'),
	(25, 2, 3, 1, 'E4'),
	(26, 2, 3, 1, 'E5'),
	(27, 2, 4, 1, 'G4'),
	(28, 2, 4, 1, 'G1'),
	(29, 2, 4, 1, 'G3'),
	(30, 2, 3, 1, 'E6'),
	(38, 2, 5, 1, 'B2'),
	(39, 2, 4, 1, 'G7'),
	(40, 2, 4, 1, 'G8'),
	(41, 2, 5, 1, 'C3'),
	(42, 2, 3, 1, 'G6'),
	(43, 2, 3, 1, 'H5'),
	(46, 2, 12, 1, 'J5'),
	(47, 4, 12, 2, 'J6'),
	(48, 6, 12, 2, 'J4'),
	(49, 2, 12, 1, 'J3'),
	(54, 7, 7, 2, 'A1'),
	(55, 8, 12, 1, 'H5'),
	(56, 9, 3, 2, 'H6'),
	(57, 10, 12, 1, 'A5');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;

-- Dumping structure for table moviedb.movie
CREATE TABLE IF NOT EXISTS `movie` (
  `id_movie` int(11) NOT NULL AUTO_INCREMENT,
  `movie_day` date DEFAULT NULL,
  `id_theater` int(11) DEFAULT NULL,
  `movie_name` varchar(100) DEFAULT NULL,
  `id_movtime` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_movie`),
  KEY `id_movtime` (`id_movtime`),
  KEY `movie_ibfk_1` (`id_theater`),
  CONSTRAINT `movie_ibfk_1` FOREIGN KEY (`id_theater`) REFERENCES `theater` (`id_theater`),
  CONSTRAINT `movie_ibfk_2` FOREIGN KEY (`id_movtime`) REFERENCES `movtime` (`id_movtime`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Dumping data for table moviedb.movie: ~9 rows (approximately)
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` (`id_movie`, `movie_day`, `id_theater`, `movie_name`, `id_movtime`) VALUES
	(1, '2020-07-30', 1, 'The Avengers4: End game', 1),
	(2, '2020-07-30', 1, 'Captain: Winter Soldier', 2),
	(3, '2020-07-30', 1, 'Thor4: Ragnarok', 3),
	(4, '2020-07-30', 1, 'Ant Man and the Wasp', 4),
	(5, '2020-07-30', 2, 'Mission Impossible 4', 1),
	(7, '2020-08-01', 2, 'The Baby shark doo doo doo', 3),
	(12, '2020-08-01', 1, 'Thor 2:The Dark World', 1),
	(15, '2020-08-01', 1, 'Anabelle', 3),
	(17, '2020-08-30', 2, 'Madagascar', 3);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;

-- Dumping structure for table moviedb.movtime
CREATE TABLE IF NOT EXISTS `movtime` (
  `id_movtime` int(11) NOT NULL AUTO_INCREMENT,
  `time_start` time DEFAULT NULL,
  `time_end` time DEFAULT NULL,
  `name_movtime` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_movtime`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table moviedb.movtime: ~4 rows (approximately)
/*!40000 ALTER TABLE `movtime` DISABLE KEYS */;
INSERT INTO `movtime` (`id_movtime`, `time_start`, `time_end`, `name_movtime`) VALUES
	(1, '08:00:00', '11:00:00', 'C1'),
	(2, '12:00:00', '15:00:00', 'C2'),
	(3, '16:00:00', '19:00:00', 'C3'),
	(4, '20:00:00', '23:00:00', 'C4');
/*!40000 ALTER TABLE `movtime` ENABLE KEYS */;

-- Dumping structure for table moviedb.noti
CREATE TABLE IF NOT EXISTS `noti` (
  `id_noti` int(11) NOT NULL AUTO_INCREMENT,
  `noti_day` date DEFAULT NULL,
  `noti_time` time DEFAULT NULL,
  `content` text DEFAULT NULL,
  PRIMARY KEY (`id_noti`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table moviedb.noti: ~4 rows (approximately)
/*!40000 ALTER TABLE `noti` DISABLE KEYS */;
INSERT INTO `noti` (`id_noti`, `noti_day`, `noti_time`, `content`) VALUES
	(4, '2020-07-30', '14:35:36', 'The movie Baby Shark doo doo doo has been change and anyone booking this film will be reseted. Please booking again'),
	(5, '2020-07-30', '17:47:41', 'The movie Captain: Winter Soldier has been change and anyone booking this film will be reseted. Please booking again'),
	(7, '2020-07-30', '20:06:12', 'The movie Madagascar has been change and anyone booking this film will be reseted. Please booking again'),
	(8, '2020-07-31', '08:33:17', 'The movie Phim con heo has been change and anyone booking this film will be reseted. Please booking again');
/*!40000 ALTER TABLE `noti` ENABLE KEYS */;

-- Dumping structure for table moviedb.price
CREATE TABLE IF NOT EXISTS `price` (
  `id_price` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_price`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table moviedb.price: ~3 rows (approximately)
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` (`id_price`, `price`, `description`) VALUES
	(1, 50000, 'Under 18'),
	(2, 75000, '18+'),
	(3, 125000, 'Specials day');
/*!40000 ALTER TABLE `price` ENABLE KEYS */;

-- Dumping structure for procedure moviedb.proc_delete_movie
DELIMITER //
CREATE PROCEDURE `proc_delete_movie`(IN idMovie INT(11))
BEGIN
	DELETE FROM booking WHERE booking.id_movie = idMovie;
	DELETE FROM seat_state WHERE id_movie = idMovie;
	DELETE FROM movie WHERE id_movie = idMovie;
END//
DELIMITER ;

-- Dumping structure for procedure moviedb.proc_get_booking_by_id
DELIMITER //
CREATE PROCEDURE `proc_get_booking_by_id`(IN idBooking INT(11))
BEGIN
	SELECT name_of_user, movie_name, seat_position, price.price, movie.movie_day, theater.theater_name, time_start, time_end
	FROM booking, acc, movie, movtime, price, theater
	WHERE booking.id_booking = idBooking
	AND acc.id_user = booking.id_user 
	AND booking.id_movie = movie.id_movie 
	and movie.id_movtime = movtime.id_movtime 
	AND booking.id_price = price.id_price
	AND theater.id_theater = movie.id_theater;
END//
DELIMITER ;

-- Dumping structure for procedure moviedb.proc_get_list_booking_by_id
DELIMITER //
CREATE PROCEDURE `proc_get_list_booking_by_id`(IN idUser INT(11))
BEGIN
	SELECT name_of_user, movie_name, seat_position, price.price, movie.movie_day, theater.theater_name, time_start, time_end
	FROM booking, acc, movie, movtime, price, theater
	WHERE acc.id_user = idUser
	AND acc.id_user = booking.id_user 
	AND booking.id_movie = movie.id_movie 
	and movie.id_movtime = movtime.id_movtime 
	AND booking.id_price = price.id_price
	AND theater.id_theater = movie.id_theater
	ORDER BY movie.movie_day desc;
END//
DELIMITER ;

-- Dumping structure for procedure moviedb.proc_get_position_by_id_movie
DELIMITER //
CREATE PROCEDURE `proc_get_position_by_id_movie`(IN idMovie INT(11))
BEGIN
	
SELECT seat_position FROM movie, theater, seat_state, booking
	WHERE movie.id_theater = theater.id_theater 
	AND movie.id_movie = seat_state.id_movie 
	AND booking.id_movie = idMovie 
	AND booking.id_movie = movie.id_movie;
END//
DELIMITER ;

-- Dumping structure for procedure moviedb.proc_get_seat_quantity_by_id_movie
DELIMITER //
CREATE PROCEDURE `proc_get_seat_quantity_by_id_movie`(IN idMovie INT(11))
BEGIN
	SELECT row_quant, col_quant, empty
	FROM seat_state, theater
	WHERE seat_state.id_theater = theater.id_theater AND seat_state.id_movie = idMovie;
END//
DELIMITER ;

-- Dumping structure for procedure moviedb.proc_get_theater_by_date
DELIMITER //
CREATE PROCEDURE `proc_get_theater_by_date`(IN d DATE)
BEGIN
	
	SELECT  theater_name, movtime.name_movtime, theater.id_theater, movtime.id_movtime, time_start, time_end
	FROM movie, movtime, theater
	WHERE movie.id_theater = theater.id_theater 
	AND movie.id_movtime = movtime.id_movtime
	AND movie.movie_day = d;

END//
DELIMITER ;

-- Dumping structure for procedure moviedb.proc_insert_booking
DELIMITER //
CREATE PROCEDURE `proc_insert_booking`(IN idUser INT(11), IN idMovie INT(11), IN idPrice INT(11), IN seatPosition VARCHAR(3))
BEGIN
	INSERT INTO booking(id_user, id_movie, id_price, seat_position) VALUES (idUser, idMovie, idPrice, seatPosition);
	UPDATE seat_state SET empty = empty - 1 WHERE seat_state.id_movie = idMovie;
	
END//
DELIMITER ;

-- Dumping structure for procedure moviedb.proc_insert_seatstate
DELIMITER //
CREATE PROCEDURE `proc_insert_seatstate`(IN idMovie INT(11), IN idTheater INT(11))
BEGIN
DECLARE seatRow INT DEFAULT 0;
DECLARE seatCol INT DEFAULT 0;
	SELECT row_quant INTO seatRow FROM theater WHERE id_theater = idTheater ;
	SELECT col_quant  INTO seatCol FROM theater WHERE id_theater = idTheater;
	INSERT INTO seat_state(id_theater, empty, id_movie) VALUES (idTheater, seatRow*seatCol, idMovie);

	
END//
DELIMITER ;

-- Dumping structure for procedure moviedb.proc_search_movie
DELIMITER //
CREATE PROCEDURE `proc_search_movie`(IN mov_day DATE)
BEGIN
	SELECT movie.id_movie, movie_day, time_start, time_end, movie_name , theater.theater_name, seat_state.empty,  theater.row_quant * theater.col_quant AS seat  
	FROM movie, theater, movtime, seat_state
	WHERE movie.id_theater = theater.id_theater 
	AND movtime.id_movtime = movie.id_movtime 
	AND seat_state.id_theater = theater.id_theater
	AND movie.movie_day = mov_day
	AND movie.id_movie = seat_state.id_movie;
END//
DELIMITER ;

-- Dumping structure for procedure moviedb.proc_update_movie
DELIMITER //
CREATE PROCEDURE `proc_update_movie`(IN idMovie INT(11),IN movieDay DATE, IN idTheater INT(11), IN movieName VARCHAR(100), IN idMovTime INT(11))
BEGIN
DECLARE seatRow INT DEFAULT 0;
DECLARE seatCol INT DEFAULT 0;
DECLARE movName VARCHAR(100);
	SELECT row_quant INTO seatRow FROM theater WHERE id_theater = idTheater ;
	SELECT col_quant  INTO seatCol FROM theater WHERE id_theater = idTheater;
	SELECT movie_name INTO movName FROM movie WHERE id_movie = idMovie;
	UPDATE movie SET movie_day = movieDay, id_theater = idTheater, movie_name = movieName, id_movtime = idMovtime
	WHERE id_movie = idMovie;
	UPDATE seat_state SET id_theater = idTheater, empty = seatRow*seatCol
	WHERE id_movie = idMovie;
	DELETE FROM booking WHERE id_movie = idMovie;
	INSERT INTO noti(noti_day, noti_time, content) VALUES (CURDATE(), CURTIME(), CONCAT("The movie ",movName," has been change and anyone booking this film will be reseted. Please booking again"));
END//
DELIMITER ;

-- Dumping structure for table moviedb.seat_state
CREATE TABLE IF NOT EXISTS `seat_state` (
  `id_seatstate` int(11) NOT NULL AUTO_INCREMENT,
  `id_theater` int(11) DEFAULT NULL,
  `empty` int(11) DEFAULT NULL,
  `id_movie` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_seatstate`),
  KEY `id_theater` (`id_theater`),
  KEY `FK_seat_state_movie` (`id_movie`),
  CONSTRAINT `FK_seat_state_movie` FOREIGN KEY (`id_movie`) REFERENCES `movie` (`id_movie`),
  CONSTRAINT `seat_state_ibfk_1` FOREIGN KEY (`id_theater`) REFERENCES `theater` (`id_theater`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Dumping data for table moviedb.seat_state: ~9 rows (approximately)
/*!40000 ALTER TABLE `seat_state` DISABLE KEYS */;
INSERT INTO `seat_state` (`id_seatstate`, `id_theater`, `empty`, `id_movie`) VALUES
	(1, 1, 100, 1),
	(2, 1, 100, 2),
	(3, 1, 91, 3),
	(4, 1, 93, 4),
	(5, 2, 67, 5),
	(9, 2, 69, 7),
	(11, 1, 94, 12),
	(13, 1, 0, 15),
	(15, 2, 70, 17);
/*!40000 ALTER TABLE `seat_state` ENABLE KEYS */;

-- Dumping structure for table moviedb.theater
CREATE TABLE IF NOT EXISTS `theater` (
  `id_theater` int(11) NOT NULL AUTO_INCREMENT,
  `theater_name` varchar(5) DEFAULT NULL,
  `row_quant` int(11) DEFAULT NULL,
  `col_quant` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_theater`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table moviedb.theater: ~3 rows (approximately)
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` (`id_theater`, `theater_name`, `row_quant`, `col_quant`, `state`) VALUES
	(1, 'A', 10, 10, NULL),
	(2, 'B', 7, 10, NULL),
	(3, 'C', 8, 10, NULL);
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
