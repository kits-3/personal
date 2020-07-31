-- create database
CREATE DATABASE taskmanagement;

-- use database_name
USE taskmanagement;

-- create table
CREATE TABLE role(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	name VARCHARACTER(255) NOT NULL UNIQUE,
	display INT NOT NULL DEFAULT 1,
	description VARCHARACTER(255) NOT NULL DEFAULT 'Not Description'
);

CREATE TABLE user(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	username VARCHARACTER(255) NOT NULL UNIQUE,
	password VARCHARACTER(255) NOT NULL,
	email VARCHARACTER(255) NOT NULL UNIQUE,
	role_id INT NOT NULL DEFAULT 2,
	lname VARCHARACTER(255) NOT NULL,
	fname VARCHARACTER(255) NOT NULL,
	birthday DATETIME DEFAULT NOW(),
	create_date DATETIME DEFAULT NOW(),
	update_date DATETIME DEFAULT NOW(),
	delete_date DATETIME DEFAULT NULL,
	status INT NOT NULL DEFAULT 1, -- 1: unlock, 0: lock
	display INT NOT NULL DEFAULT 1, -- 1: display, 0: hidden
	description VARCHARACTER(255) NOT NULL DEFAULT 'Not Description'
);

CREATE TABLE task(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	header VARCHARACTER(255) NOT NULL,
	owner INT NOT NULL,
	create_date DATETIME DEFAULT NOW(),
	update_date DATETIME DEFAULT NOW(),
	delete_date DATETIME DEFAULT NULL,
	deadline DATETIME NOT NULL DEFAULT ADDDATE(NOW(),INTERVAL 31 DAY),
	status INT NOT NULL DEFAULT 0, -- 1: complete, 0:incomplete
	display INT NOT NULL DEFAULT 1, -- 1: display, 0: hidden
	description VARCHARACTER(255) NOT NULL DEFAULT 'Not Description'
);

CREATE TABLE taskdetail(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	content VARCHARACTER(255) NOT NULL,
	task_id INT NOT NULL,
	create_date DATETIME DEFAULT NOW(),
	update_date DATETIME DEFAULT NOW(),
	delete_date DATETIME DEFAULT NULL,
	status INT NOT NULL DEFAULT 0, -- 1: complete, 0:incomplete
	display INT NOT NULL DEFAULT 1, -- 1: display, 0: hidden
	description VARCHARACTER(255) NOT NULL DEFAULT 'Not Description'
);

-- alter table
-- foreign key
ALTER TABLE user ADD FOREIGN KEY (role_id) REFERENCES role(id);
ALTER TABLE task ADD FOREIGN KEY (owner) REFERENCES user(id);
ALTER TABLE taskdetail ADD FOREIGN KEY (task_id) REFERENCES task(id);

ALTER TABLE user ADD phone VARCHARACTER(255) NOT NULL DEFAULT '0123456789';

-- data instance
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('USER');

INSERT INTO user (username, password, email, role_id, lname, fname) VALUES ('admin', '123456', 'admin@gmail.com', 1, 'admin', 'admin');
INSERT INTO user (username, password, email, lname, fname) VALUES ('quangnguyen', '123456', 'quangnguyen@gmail.com', 'quang', 'nguyen');

INSERT INTO task (header, owner) VALUES ('go coffee', 2);
INSERT INTO task (header, owner) VALUES ('shopping', 2);
INSERT INTO task (header, owner) VALUES ('cooking', 2);
INSERT INTO task (header, owner) VALUES ('go home', 2);

INSERT INTO task (header, owner) VALUES ('go coffee', 1);
INSERT INTO task (header, owner) VALUES ('go home', 1);
INSERT INTO task (header, owner) VALUES ('swimming', 1);

INSERT INTO taskdetail (content, task_id) VALUES ('call john', 1);
INSERT INTO taskdetail (content, task_id) VALUES ('call mary', 1);
INSERT INTO taskdetail (content, task_id) VALUES ('book table', 1);

INSERT INTO taskdetail (content, task_id) VALUES ('buy T-shirt', 2);
INSERT INTO taskdetail (content, task_id) VALUES ('buy clothes', 2);
INSERT INTO taskdetail (content, task_id) VALUES ('call taxi', 2);

INSERT INTO taskdetail (content, task_id) VALUES ('bacon', 3);
INSERT INTO taskdetail (content, task_id) VALUES ('fish', 3);
INSERT INTO taskdetail (content, task_id) VALUES ('rice', 3);

INSERT INTO taskdetail (content, task_id) VALUES ('bus', 4);
INSERT INTO taskdetail (content, task_id) VALUES ('walk', 4);
INSERT INTO taskdetail (content, task_id) VALUES ('do homework', 4);

INSERT INTO taskdetail (content, task_id) VALUES ('call john', 8);
INSERT INTO taskdetail (content, task_id) VALUES ('call mary', 8);
INSERT INTO taskdetail (content, task_id) VALUES ('book table', 8);

INSERT INTO taskdetail (content, task_id) VALUES ('bus', 6);
INSERT INTO taskdetail (content, task_id) VALUES ('walk', 6);
INSERT INTO taskdetail (content, task_id) VALUES ('do homework', 6);


INSERT INTO taskdetail (content, task_id) VALUES ('do homework', 7);
INSERT INTO taskdetail (content, task_id) VALUES ('get money', 7);
INSERT INTO taskdetail (content, task_id) VALUES ('call due', 7);

-- query instance
SELECT * FROM user;
SELECT * FROM user WHERE username = 'admin' AND PASSWORD = '123456';

SELECT * FROM role WHERE id = (SELECT role_id FROM user WHERE user.id = 1);
SELECT * FROM task WHERE OWNER = 1;
SELECT * FROM task WHERE OWNER = 1 AND task.id = 6;

UPDATE task SET header = 'shopping', update_date = NOW() WHERE id = 9;

SELECT * FROM taskdetail WHERE task_id = 1