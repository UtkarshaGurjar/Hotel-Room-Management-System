create database ssdi_bookandgo;
use ssdi_bookandgo;
CREATE TABLE users
(
 users_id INT (4) PRIMARY KEY,
 users_nameFirst VARCHAR (25),
 users_nameLast VARCHAR(25),
 users_email VARCHAR(50),
 users_password VARCHAR (20)
);

INSERT INTO users 
VALUES
(1000, 'Sam', 'Smith', 'ssmith@gmail.com', '1234'),
(1001, 'Max', 'Why', 'ssmith@gmail.com', '5678'),
(1002, 'Dasiy', 'Wonder', 'dwonderh@gmail.com', '0987');

CREATE TABLE hotel
(
 hotel_id INT (4) PRIMARY KEY,
hotel_name VARCHAR (25),
 hotel_address VARCHAR(25)
 );

INSERT INTO hotel 
VALUES
( 2001, 'Hilton', '123 UNCC BLD Charlotte NC'),
( 2002, 'Days Inn', '124 UNCC BLD Charlotte NC'),
( 2003, 'Stay In','123 UNCC BLD Charlotte NC');

CREATE TABLE room
 (
 hotel_id int(4),
 room_id VARCHAR(25) PRIMARY KEY,
 room_floor int(25),
 room_type VARCHAR (25),
 roomAvailableFlag VARCHAR (25) NOT NULL,
 roomPrice VARCHAR(25),
 no_of_beds int(25),
FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)
 );

insert into room(hotel_id, room_id, room_floor, room_type, roomAvailableFlag, roomPrice, no_of_beds)
values(2001, 'G1', 0, 'AC', '1','$300', 2),
(2001, 'F4', 1, 'Non-AC', '0','$200', 1),
(2002, 'S2', 2, 'AC', '1','$400', 2),
(2002, 'G9', 0, 'Non-AC', '0','$150', 1),
(2003, 'S4', 2, 'AC', '0','$300', 2),
(2003, 'G4', 0, 'Non-AC', '0','$200', 1);

CREATE TABLE `ssdi_bookandgo`.`book` (
  `booking_id` VARCHAR(25),
  `hotel_id` INT(4),
  `room_id` VARCHAR(25),
  users_id INT (4),
  PRIMARY KEY (`booking_id`),
   CONSTRAINT `hotel_id_chk`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `ssdi_bookandgo`.`hotel` (`hotel_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `room_id_chk`
    FOREIGN KEY (`room_id`)
    REFERENCES `ssdi_bookandgo`.`room` (`room_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `users_id_chk`
    FOREIGN KEY (`users_id`)
    REFERENCES `ssdi_bookandgo`.`users` (`users_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

insert into book(booking_id, hotel_id, room_id, users_id)
values('C11', 2001, 'G1', 1000),
('C12', 2002, 'S2', 1001);

CREATE TABLE Payment(
booking_id varchar(25),
payment_id int(25) PRIMARY KEY,
payment_date DATETIME,
FOREIGN KEY (booking_id) REFERENCES book(booking_id)
);

insert into payment
values('C11', 123, now()),
('C12', 124, now());

