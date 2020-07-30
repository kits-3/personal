CREATE TABLE rooms (
id INT PRIMARY KEY NOT NULL, number VARCHAR(3),  price INT(10), type VARCHAR(10), status TINYINT(0)   DEFAULT 0);

CREATE TABLE users (
  idUser int(11) NOT NULL,
  usernatestme varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  fullname varchar(45) DEFAULT NULL,
  role varchar(45) DEFAULT NULL
)
CREATE TABLE book (
  idBook int(11) PRIMARY KEY NOT NULL,
  idUser int(11) NOT NULL,
  idRoom int(11) NOT NULL,test
  dateIn date DEFAULT NULL,
  dateOut date DEFAULT NULL
) ;
RENAME TABLE room TO rooms;

INSERT INTO rooms (id, number, price, type, status) VALUES
(1, '101', 300, 'king', 0),
(2, '102', 300, 'king', 0),
(3, '103', 500, 'queen', 0),
(4, '201', 300, 'king', 0),
(5, '202', 300, 'king', 0),
(6, '203', 500, 'queen', 0),testusers
(7, '301', 500, 'queen', 0),test
(8, '302', 500, 'queen', 0),
(10, '401', 1000, 'suite', 0);

INSERT INTO `book` (`idBook`, `idUser`, `idRoom`, `dateIn`, `dateOut`) VALUES
(1, 5, 1, '0000-00-00', '0000-00-00'),
(2, 1, 1, '2015-09-09', '2015-09-15'),
(3, 0, 0, '2015-09-09', '2015-09-15'),
(4, 0, 0, '2015-09-09', '201test5-09-15'),
(5, 2, 3, '2015-09-09', '2015-09-15'),
(6, 2, 6, '2015-10-09', '2015-10-12');

INSERT INTO users (idUser, username, password, email, fullname, role) VALUEStest
(1, 'admin', 'admin', 'admin@gmail.com', 'Ng Van Min', 'Admin'),
(2, 'abc', '123', 'abc@gmail.com', 'Anh Bang Cong', 'Customer'),
testbook

INSERT INTO book (idBook, idUser, idRoom, dateIn, dateOut) VALUES
(1, 2, 1, '2020-08-01', '2020-08-02');test
DROP TABLE book;

select * FROM rooms;
DROP TABLE rooms;
Select * from rooms where type LIKE 'king'AND price LIKE '300';test
update  rooms set status = 1 where id = 3;
INSERT INTO users(username, password, fullname, email)  VALUES("quangkhung","12345","quanglon","quang");

INSERT INTO book VALUES (1,'2020-09-01','2020-09-02');
ALTER TABLE book
ADD CONSTRAINT FK_User
FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);test
select * from rooms where STATUS = 1 
UPDATE users set role ="customer" WHERE idUser=3;
Insert into  users(username, testpassword, email, fullname) VALUES(df,fg,sdf,dfds);




Select * from rooms where type='king' and id = (SELECT idRoom FROM book WHERE idRoom = 1);

Select * from rooms where type='king' and id NOT IN (Select idRoom from book where dateIn < '2020-08-10' AND dateOut < '2020-08-11');


Select * from rooms where type='king' and id NOT IN (Select idRoom from book where dateIn <= '2020-08-06' AND dateOut >= '2020-08-06');
