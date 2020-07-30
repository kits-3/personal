/* Connecting to 127.0.0.1 via MariaDB (TCP/IP), username root, using password: Yes ... */
SELECT CONNECTION_ID();
/* Connected. Thread-ID: 47 */
/* Characterset: utf8mb4 */
SHOW STATUS;
SELECT NOW();
SHOW VARIABLES;
SHOW DATABASES;
/* Entering session "Unnamed" */
SHOW COLLATION;
CREATE DATABASE `vatlieu` /*!40100 COLLATE 'utf8_unicode_ci' */;
SHOW DATABASES;
/* Entering session "Unnamed" */
USE `vatlieu`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='information_schema';
SHOW TABLE STATUS FROM `information_schema`;
SHOW FUNCTION STATUS WHERE `Db`='information_schema';
SHOW PROCEDURE STATUS WHERE `Db`='information_schema';
SHOW TRIGGERS FROM `information_schema`;
SHOW EVENTS FROM `information_schema`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SHOW ENGINES;
CREATE TABLE `role` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL,
	PRIMARY KEY (`id`),
	INDEX `name` (`name`)
)
COLLATE='utf8_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='role' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `role` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='role'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='role'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`role`;
CREATE TABLE `product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL,
	`price_in` DOUBLE NULL DEFAULT '0',
	`price_out` DOUBLE NULL DEFAULT '0',
	`quantity` INT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='product' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `product` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='product'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='product'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`product`;
CREATE TABLE `status` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL,
	PRIMARY KEY (`id`),
	INDEX `name` (`name`)
)
COLLATE='utf8_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='status' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `status` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='status'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='status'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`status`;
SELECT 1 FROM `role` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='role' ORDER BY ORDINAL_POSITION;
CREATE TABLE `users` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user` VARCHAR(50) NULL,
	`passwrod` VARCHAR(50) NULL,
	`role_name` VARCHAR(50) NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `FK__role` FOREIGN KEY (`role_name`) REFERENCES `role` (`name`) ON UPDATE CASCADE
)
COLLATE='utf8_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='users' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `users` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`users`;
SELECT 1 FROM `users` LIMIT 1;
CREATE TABLE `info` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`users_id` INT NULL,
	`money` DOUBLE NULL DEFAULT '0',
	`name` VARCHAR(50) NULL DEFAULT NULL,
	`address` VARCHAR(50) NULL DEFAULT NULL,
	`phone` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `FK__users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE
)
COLLATE='utf8_general_ci'
;

/* Connecting to 127.0.0.1 via MariaDB (TCP/IP), username root, using password: Yes ... */
SELECT CONNECTION_ID();
/* Connected. Thread-ID: 53 */
/* Characterset: utf8mb4 */
SHOW STATUS;
SELECT NOW();
SHOW VARIABLES;
SHOW DATABASES;
/* Entering session "Unnamed" */
/* Loading file "C:\Users\hoang\AppData\Roaming\HeidiSQL\Backups\query-tab-2020-07-26_09-44-27-852.sql" (6.2 KiB) into query tab #1 ... */
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='information_schema';
SHOW TABLE STATUS FROM `information_schema`;
SHOW FUNCTION STATUS WHERE `Db`='information_schema';
SHOW PROCEDURE STATUS WHERE `Db`='information_schema';
SHOW TRIGGERS FROM `information_schema`;
SHOW EVENTS FROM `information_schema`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
USE `vatlieu`;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='info' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `info` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='info'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='info'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW ENGINES;
SHOW COLLATION;
SHOW CREATE TABLE `vatlieu`.`info`;
CREATE TABLE `input` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`users_id` INT NULL,
	`pro_id` INT NULL,
	`quantity` INT NULL DEFAULT '0',
	`money` DOUBLE NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='input' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `input` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='input'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='input'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`input`;
SELECT 1 FROM `users` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='users' ORDER BY ORDINAL_POSITION;
SELECT 1 FROM `product` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='product' ORDER BY ORDINAL_POSITION;
ALTER TABLE `input`
	ADD CONSTRAINT `FK_input_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE,
	ADD CONSTRAINT `FK_input_product` FOREIGN KEY (`pro_id`) REFERENCES `product` (`id`) ON UPDATE CASCADE;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='input' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `input` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='input'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='input'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`input`;
CREATE TABLE `order` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`info_id` INT NULL,
	`users_id` INT NULL,
	`pro_id` INT NULL,
	`quantity` INT NULL DEFAULT '0',
	`mount` DOUBLE NULL DEFAULT '0',
	`status_name` VARCHAR(50) NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='order' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `order` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='order'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='order'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`order`;
SELECT 1 FROM `info` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='info' ORDER BY ORDINAL_POSITION;
SELECT 1 FROM `users` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='users' ORDER BY ORDINAL_POSITION;
SELECT 1 FROM `product` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='product' ORDER BY ORDINAL_POSITION;
SELECT 1 FROM `status` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='status' ORDER BY ORDINAL_POSITION;
ALTER TABLE `order`
	ADD CONSTRAINT `FK_order_info` FOREIGN KEY (`info_id`) REFERENCES `info` (`id`) ON UPDATE CASCADE,
	ADD CONSTRAINT `FK_order_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE,
	ADD CONSTRAINT `FK_order_product` FOREIGN KEY (`pro_id`) REFERENCES `product` (`id`) ON UPDATE CASCADE,
	ADD CONSTRAINT `FK_order_status` FOREIGN KEY (`status_name`) REFERENCES `status` (`name`) ON UPDATE CASCADE;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='order' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `order` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='order'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='order'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`order`;
CREATE TABLE `output` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`or_id` INT NULL,
	`users_id` INT NULL,
	`status_name` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='output' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `output` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='output'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='output'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`output`;
SELECT 1 FROM `order` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='order' ORDER BY ORDINAL_POSITION;
SELECT 1 FROM `users` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='users' ORDER BY ORDINAL_POSITION;
SELECT 1 FROM `status` LIMIT 1;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='status' ORDER BY ORDINAL_POSITION;
ALTER TABLE `output`
	ADD CONSTRAINT `FK_output_order` FOREIGN KEY (`or_id`) REFERENCES `order` (`id`) ON UPDATE CASCADE,
	ADD CONSTRAINT `FK_output_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE,
	ADD CONSTRAINT `FK_output_status` FOREIGN KEY (`status_name`) REFERENCES `status` (`name`) ON UPDATE CASCADE;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='output' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `output` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='output'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='output'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`output`;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='role' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `role` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='role'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='role'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`role`;
SELECT * FROM `vatlieu`.`role` LIMIT 1000;
INSERT INTO `vatlieu`.`role` (`id`, `name`) VALUES ('1', 'admin');
SELECT `id`, `name` FROM `vatlieu`.`role` WHERE  `id`=1;
INSERT INTO `vatlieu`.`role` (`id`, `name`) VALUES ('2', 'client');
SELECT `id`, `name` FROM `vatlieu`.`role` WHERE  `id`=2;
INSERT INTO `vatlieu`.`role` (`id`, `name`) VALUES ('3', 'person');
SELECT `id`, `name` FROM `vatlieu`.`role` WHERE  `id`=3;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='product' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `product` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='product'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='product'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`product`;
SELECT * FROM `vatlieu`.`product` LIMIT 1000;
INSERT INTO `vatlieu`.`product` (`id`, `name`, `price_in`, `price_out`, `quantity`) VALUES ('1', 'rock', '10000', '20000', '50');
SELECT `id`, `name`, `price_in`, `price_out`, `quantity` FROM `vatlieu`.`product` WHERE  `id`=1;
SELECT * FROM `vatlieu`.`product` ORDER BY `id` ASC LIMIT 1000;
SELECT * FROM `vatlieu`.`product` ORDER BY `id` DESC LIMIT 1000;
SELECT * FROM `vatlieu`.`product` LIMIT 1000;
INSERT INTO `vatlieu`.`product` (`id`, `name`, `price_in`, `price_out`, `quantity`) VALUES ('2', 'sand', '8000', '15000', '50');
SELECT `id`, `name`, `price_in`, `price_out`, `quantity` FROM `vatlieu`.`product` WHERE  `id`=2;
INSERT INTO `vatlieu`.`product` (`id`, `name`, `price_in`, `price_out`, `quantity`) VALUES ('3', 'cement', '20000', '30000', '50');
SELECT `id`, `name`, `price_in`, `price_out`, `quantity` FROM `vatlieu`.`product` WHERE  `id`=3;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='status' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `status` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='status'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='status'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`status`;
SELECT * FROM `vatlieu`.`status` LIMIT 1000;
INSERT INTO `vatlieu`.`status` (`id`, `name`) VALUES ('1', 'none-check');
SELECT `id`, `name` FROM `vatlieu`.`status` WHERE  `id`=1;
INSERT INTO `vatlieu`.`status` (`id`, `name`) VALUES ('2', 'checked');
SELECT `id`, `name` FROM `vatlieu`.`status` WHERE  `id`=2;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='users' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `users` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`users`;
SELECT * FROM `vatlieu`.`users` LIMIT 1000;
SELECT `name` FROM `vatlieu`.`role` GROUP BY `name` ORDER BY `name` LIMIT 10000;
SELECT `name` FROM `vatlieu`.`role` GROUP BY `name` ORDER BY `name` LIMIT 10000;
INSERT INTO `vatlieu`.`users` (`id`, `user`, `passwrod`, `role_name`) VALUES ('1', 'dung', '123456', 'admin');
SELECT `id`, `user`, `passwrod`, `role_name` FROM `vatlieu`.`users` WHERE  `id`=1;
SELECT `name` FROM `vatlieu`.`role` GROUP BY `name` ORDER BY `name` LIMIT 10000;
INSERT INTO `vatlieu`.`users` (`id`, `user`, `passwrod`, `role_name`) VALUES ('2', 'loi', '123456', 'client');
SELECT `id`, `user`, `passwrod`, `role_name` FROM `vatlieu`.`users` WHERE  `id`=2;
SELECT `name` FROM `vatlieu`.`role` GROUP BY `name` ORDER BY `name` LIMIT 10000;
INSERT INTO `vatlieu`.`users` (`id`, `user`, `passwrod`, `role_name`) VALUES ('3', 'duc', '123456', 'person');
SELECT `id`, `user`, `passwrod`, `role_name` FROM `vatlieu`.`users` WHERE  `id`=3;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='info' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `info` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='info'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='info'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`info`;
SELECT * FROM `vatlieu`.`info` LIMIT 1000;
SELECT `id`, LEFT(`user`, 256) FROM `vatlieu`.`users` GROUP BY `id`, `user` ORDER BY `user` LIMIT 10000;
INSERT INTO `vatlieu`.`info` (`id`, `users_id`, `name`, `address`, `phone`) VALUES ('1', '1', 'dung', 'q12', '0909');
SELECT `id`, `users_id`, `money`, `name`, `address`, `phone` FROM `vatlieu`.`info` WHERE  `id`=1;
SELECT `id`, LEFT(`user`, 256) FROM `vatlieu`.`users` GROUP BY `id`, `user` ORDER BY `user` LIMIT 10000;
INSERT INTO `vatlieu`.`info` (`id`, `users_id`, `name`, `address`, `phone`) VALUES ('2', '2', 'loi', 'q12', '0707');
SELECT `id`, `users_id`, `money`, `name`, `address`, `phone` FROM `vatlieu`.`info` WHERE  `id`=2;
SELECT `id`, LEFT(`user`, 256) FROM `vatlieu`.`users` GROUP BY `id`, `user` ORDER BY `user` LIMIT 10000;
INSERT INTO `vatlieu`.`info` (`id`, `users_id`, `name`, `address`, `phone`) VALUES ('3', '3', 'duc', 'q12', '0808');
SELECT `id`, `users_id`, `money`, `name`, `address`, `phone` FROM `vatlieu`.`info` WHERE  `id`=3;

/* Connecting to 127.0.0.1 via MariaDB (TCP/IP), username root, using password: Yes ... */
SELECT CONNECTION_ID();
/* Connected. Thread-ID: 65 */
/* Characterset: utf8mb4 */
SHOW STATUS;
SELECT NOW();
SHOW VARIABLES;
SHOW DATABASES;
SHOW OPEN TABLES FROM vatlieu WHERE `in_use`!=0;
USE `vatlieu`;
/* Entering session "Unnamed" */
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='information_schema';
SHOW TABLE STATUS FROM `information_schema`;
SHOW FUNCTION STATUS WHERE `Db`='information_schema';
SHOW PROCEDURE STATUS WHERE `Db`='information_schema';
SHOW TRIGGERS FROM `information_schema`;
SHOW EVENTS FROM `information_schema`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
/* Loading file "C:\Users\hoang\AppData\Roaming\HeidiSQL\Backups\query-tab-2020-07-26_19-35-00-105.sql" (22.5 KiB) into query tab #1 ... */
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='users' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `users` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW ENGINES;
SHOW COLLATION;
SHOW CREATE TABLE `vatlieu`.`users`;
ALTER TABLE `users`
	CHANGE COLUMN `passwrod` `password` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci' AFTER `user`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='users' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `users` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`users`;

/* Connecting to 127.0.0.1 via MariaDB (TCP/IP), username root, using password: Yes ... */
SELECT CONNECTION_ID();
/* Connected. Thread-ID: 945 */
/* Characterset: utf8mb4 */
SHOW STATUS;
SELECT NOW();
SHOW VARIABLES;
SHOW DATABASES;
SHOW OPEN TABLES FROM vatlieu WHERE `in_use`!=0;
USE `vatlieu`;
/* Entering session "Unnamed" */
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='information_schema';
SHOW TABLE STATUS FROM `information_schema`;
SHOW FUNCTION STATUS WHERE `Db`='information_schema';
SHOW PROCEDURE STATUS WHERE `Db`='information_schema';
SHOW TRIGGERS FROM `information_schema`;
SHOW EVENTS FROM `information_schema`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
/* Loading file "C:\Users\PC30\AppData\Roaming\HeidiSQL\Backups\query-tab-2020-07-21_15-06-19-902.sql" (25.2 KiB) into query tab #1 ... */
/* Loading file "C:\Users\PC30\AppData\Roaming\HeidiSQL\Backups\query-tab-2020-07-27_16-18-38-146.sql" (231 B) into query tab #2 ... */
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='info' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `info` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='info'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='info'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW ENGINES;
SHOW COLLATION;
SHOW CREATE TABLE `vatlieu`.`info`;
ALTER TABLE `info`
	DROP FOREIGN KEY `FK__users`;
ALTER TABLE `info`
	ADD CONSTRAINT `FK__users` FOREIGN KEY (`users_id`) REFERENCES `vatlieu`.`users` (`id`) ON UPDATE CASCADE ON DELETE SET NULL;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='info' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `info` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='info'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='info'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`info`;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='input' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `input` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='input'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='input'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`input`;
ALTER TABLE `input`
	DROP FOREIGN KEY `FK_input_product`,
	DROP FOREIGN KEY `FK_input_users`;
ALTER TABLE `input`
	ADD CONSTRAINT `FK_input_product` FOREIGN KEY (`pro_id`) REFERENCES `vatlieu`.`product` (`id`) ON UPDATE CASCADE ON DELETE SET NULL,
	ADD CONSTRAINT `FK_input_users` FOREIGN KEY (`users_id`) REFERENCES `vatlieu`.`users` (`id`) ON UPDATE CASCADE ON DELETE SET NULL;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='input' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `input` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='input'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='input'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`input`;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='order' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `order` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='order'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='order'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`order`;
ALTER TABLE `order`
	DROP FOREIGN KEY `FK_order_info`,
	DROP FOREIGN KEY `FK_order_product`,
	DROP FOREIGN KEY `FK_order_status`,
	DROP FOREIGN KEY `FK_order_users`;
ALTER TABLE `order`
	ADD CONSTRAINT `FK_order_info` FOREIGN KEY (`info_id`) REFERENCES `vatlieu`.`info` (`id`) ON UPDATE CASCADE ON DELETE SET NULL,
	ADD CONSTRAINT `FK_order_product` FOREIGN KEY (`pro_id`) REFERENCES `vatlieu`.`product` (`id`) ON UPDATE CASCADE ON DELETE SET NULL,
	ADD CONSTRAINT `FK_order_status` FOREIGN KEY (`status_name`) REFERENCES `vatlieu`.`status` (`name`) ON UPDATE CASCADE ON DELETE SET NULL,
	ADD CONSTRAINT `FK_order_users` FOREIGN KEY (`users_id`) REFERENCES `vatlieu`.`users` (`id`) ON UPDATE CASCADE ON DELETE SET NULL;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='order' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `order` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='order'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='order'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`order`;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='output' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `output` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='output'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='output'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`output`;
ALTER TABLE `output`
	DROP FOREIGN KEY `FK_output_order`,
	DROP FOREIGN KEY `FK_output_status`,
	DROP FOREIGN KEY `FK_output_users`;
ALTER TABLE `output`
	ADD CONSTRAINT `FK_output_order` FOREIGN KEY (`or_id`) REFERENCES `vatlieu`.`order` (`id`) ON UPDATE CASCADE ON DELETE SET NULL,
	ADD CONSTRAINT `FK_output_status` FOREIGN KEY (`status_name`) REFERENCES `vatlieu`.`status` (`name`) ON UPDATE CASCADE ON DELETE SET NULL,
	ADD CONSTRAINT `FK_output_users` FOREIGN KEY (`users_id`) REFERENCES `vatlieu`.`users` (`id`) ON UPDATE CASCADE ON DELETE SET NULL;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='output' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `output` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='output'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='output'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`output`;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='product' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `product` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='product'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='product'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`product`;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='role' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `role` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='role'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='role'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`role`;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='status' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `status` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='status'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='status'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`status`;
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='users' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `users` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `vatlieu`.`users`;
ALTER TABLE `users`
	DROP FOREIGN KEY `FK__role`;
ALTER TABLE `users`
	ADD CONSTRAINT `FK__role` FOREIGN KEY (`role_name`) REFERENCES `vatlieu`.`role` (`name`) ON UPDATE CASCADE ON DELETE SET NULL;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='users' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `users` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='users'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entering session "Unnamed" */
SHOW CREATE TABLE `vatlieu`.`users`;

/* Connecting to 127.0.0.1 via MariaDB (TCP/IP), username root, using password: Yes ... */
SELECT CONNECTION_ID();
/* Connected. Thread-ID: 972 */
/* Characterset: utf8mb4 */
SHOW STATUS;
SELECT NOW();
SHOW VARIABLES;
SHOW DATABASES;
SHOW OPEN TABLES FROM vatlieu WHERE `in_use`!=0;
USE `vatlieu`;
/* Entering session "Unnamed" */
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='vatlieu';
SHOW TABLE STATUS FROM `vatlieu`;
SHOW FUNCTION STATUS WHERE `Db`='vatlieu';
SHOW PROCEDURE STATUS WHERE `Db`='vatlieu';
SHOW TRIGGERS FROM `vatlieu`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='information_schema';
SHOW TABLE STATUS FROM `information_schema`;
SHOW FUNCTION STATUS WHERE `Db`='information_schema';
SHOW PROCEDURE STATUS WHERE `Db`='information_schema';
SHOW TRIGGERS FROM `information_schema`;
SHOW EVENTS FROM `information_schema`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='vatlieu';
/* Loading file "C:\Users\PC30\AppData\Roaming\HeidiSQL\Backups\query-tab-2020-07-21_15-06-19-902.sql" (37.2 KiB) into query tab #1 ... */
/* Loading file "C:\Users\PC30\AppData\Roaming\HeidiSQL\Backups\query-tab-2020-07-27_16-18-38-146.sql" (231 B) into query tab #2 ... */
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='vatlieu' AND TABLE_NAME='product' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `product` FROM `vatlieu`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='product'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='vatlieu'   AND TABLE_NAME='product'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW ENGINES;
SHOW COLLATION;
SHOW CREATE TABLE `vatlieu`.`product`;
SELECT * FROM `vatlieu`.`product` LIMIT 1000;
UPDATE `vatlieu`.`product` SET `quantity`='1' WHERE  `id`=3;
SELECT `id`, `name`, `price_in`, `price_out`, `quantity` FROM `vatlieu`.`product` WHERE  `id`=3;
UPDATE `vatlieu`.`product` SET `quantity`='1' WHERE  `id`=2;
SELECT `id`, `name`, `price_in`, `price_out`, `quantity` FROM `vatlieu`.`product` WHERE  `id`=2;
UPDATE `vatlieu`.`product` SET `quantity`='1' WHERE  `id`=1;
SELECT `id`, `name`, `price_in`, `price_out`, `quantity` FROM `vatlieu`.`product` WHERE  `id`=1;