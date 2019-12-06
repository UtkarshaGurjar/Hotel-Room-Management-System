DROP schema IF EXISTS bookandgo;
CREATE DATABASE bookandgo;

CREATE TABLE users
(
 users_id INT (4) PRIMARY KEY,
 users_nameFirst VARCHAR (25),
 users_nameLast VARCHAR(25),
 users_email VARCHAR(50),
 users_type varchar(20),
 users_password VARCHAR (20)
);

INSERT INTO users 
VALUES
(1000, 'Sam', 'Smith', 'ssmith@gmail.com', 'customer', '1234'),
(1001, 'Max', 'Why', 'ssmith@gmail.com', 'customer', '5678'),
(1002, 'Dasiy', 'Wonder', 'dwonderh@gmail.com', 'customer', '0987');

CREATE TABLE hotel
(
 hotel_name VARCHAR (25),
 hotel_id INT (4) PRIMARY KEY,
 hotel_address VARCHAR(25),
 Event_id int(25),
 Room_id int(25)
 );

INSERT INTO hotel 
VALUES
( 'Hilton', 2001, '123 UNCC BLD Charlotte NC', 0006, 01),
( 'Days Inn', 2002, '124 UNCC BLD Charlotte NC', 0001, 02),
('Stay In', 2003, '123 UNCC BLD Charlotte NC', 0007, 03);

CREATE TABLE event_table
(
 event_name VARCHAR (25),
 event_id INT (4) PRIMARY KEY,
 event_times VARCHAR(25),
 Romm_id int(25)
 );
 


