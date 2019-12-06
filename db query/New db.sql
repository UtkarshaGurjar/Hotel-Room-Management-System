create database ssdi_bookandgo;
use ssdi_bookandgo;
CREATE TABLE users
(
 users_id INT (4) PRIMARY KEY auto_increment,
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
values(2001, 'G1', 0, 'Kings Bed', '1','$300', 2),
(2001, 'F4', 1, 'Double Bed', '1','$200', 1),
(2003, 'S23', 2, 'Kings Bed', '1','$400', 2),
(2002, 'S2', 2, 'Kings Bed', '1','$400', 2),
(2002, 'G9', 0, 'Double Bed', '1','$150', 1),
(2003, 'S4', 2, 'Deluxe suite', '1','$300', 2),
(2003, 'G4', 0, 'Double Bed', '1','$200', 1);



create table Billing_details (
user_id int primary key auto_increment,
user_name varchar(100),
add_line1 varchar(100),
add_line2 varchar(100),
city varchar(100),
pincode int,
state varchar(100), 
country varchar(100),
phone_no varchar(100),
email varchar(100)
);

create table Payment_details(
user_id INT primary key auto_increment,
user_name varchar(25),
card_no double NOT NULL,
ccv int NOT NULL
);

create table book(
booking_id INT primary key auto_increment,
hotel_id int(25),
room_id varchar(25),
FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)

);

CREATE TABLE payment(
booking_id int(25),
payment_id int(25) primary key  auto_increment,
payment_date DATETIME,
FOREIGN KEY (booking_id) REFERENCES book(booking_id)
);