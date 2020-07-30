CREATE TABLE `user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`password` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`id`, `username`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB

;
CREATE TABLE `receipt` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name_customer` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`id_customer` INT(11) NULL DEFAULT NULL,
	`phone_customer` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`id_game` INT(11) NULL DEFAULT NULL,
	`name_game` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`price` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`producer` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`total` DOUBLE(22,0) NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;
CREATE TABLE `game` (
	`id_game` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`price` DOUBLE(22,0) NULL DEFAULT NULL,
	`producer` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`key` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`id_game`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=10
;
CREATE TABLE `customer` (
	`id_customer` INT(11) NOT NULL AUTO_INCREMENT,
	`id_user` INT(11) NULL DEFAULT NULL,
	`name_customer` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`numberphone` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`mail` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`money` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id_customer`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;
ALTER TABLE user AUTO_INCREMENT=1;
ALTER TABLE game AUTO_INCREMENT=1;
ALTER TABLE customer AUTO_INCREMENT=1;
ALTER TABLE receipt AUTO_INCREMENT=1;

INSERT INTO user(username,PASSWORD) VALUES('admin','admin')
INSERT INTO user(username,PASSWORD) VALUES('user2','123')
INSERT INTO user(username,PASSWORD) VALUES('user3','123')
INSERT INTO user(username,PASSWORD) VALUES('user4','123')

INSERT INTO game(NAME,price,producer,key_game) VALUES('Maple',500,'nexon','KEY-123123-MAPLE')
INSERT INTO game(NAME,price,producer,key_game) VALUES('Crazy A',300,'nexon','KEY-123123-CRAZY')
INSERT INTO game(NAME,price,producer,key_game) VALUES('CSGO',400,'cs','KEY-123123-CSGO')
INSERT INTO game(NAME,price,producer,key_game) VALUES('OutLast',200,'outlast','KEY-123123-OUTLAST')
INSERT INTO game(NAME,price,producer,key_game) VALUES('FIFA',200,'fifa','KEY-123123-FIFA')
INSERT INTO game(NAME,price,producer,key_game) VALUES('PUBG',300,'bluehole','KEY-123123-PUBG')
INSERT INTO game(NAME,price,producer,key_game) VALUES('Mario',100,'mario','KEY-123123-MARIO')
INSERT INTO game(NAME,price,producer,key_game) VALUES('Dota 2',200,'dota','KEY-123123-DOTA')
INSERT INTO game(NAME,price,producer,key_game) VALUES('LOL',100,'Riot','KEY-123123-LOL')


INSERT INTO customer(name_customer,money,numberphone,mail) VALUES('user1',50,'0123456','123@gmail.com')
INSERT INTO customer(name_customer,money,numberphone,mail) VALUES('user2',50,'0123123','123123@gmail.com')
INSERT INTO customer(name_customer,money,numberphone,mail) VALUES('user3',50,'0123456789','123111@gmail.com')
INSERT INTO customer(name_customer,money,numberphone,mail) VALUES('user4',50,'0123456111','111123@gmail.com')

UPDATE customer SET money=250 WHERE id_customer = 4