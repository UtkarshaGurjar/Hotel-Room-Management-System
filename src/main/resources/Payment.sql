create table Billing_details (
user_id int primary key auto_increment,
add_line1 varchar(25),
add_line2 varchar(25),
city varchar(25),
pincode int,
state varchar(25)
);

create table Payment_details(
user_id INT primary key auto_increment,
user_name varchar(25),
card_no double NOT NULL,
ccv int NOT NULL
)