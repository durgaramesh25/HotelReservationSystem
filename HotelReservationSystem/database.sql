CREATE DATABASE hotel_db;

USE hotel_db;

CREATE TABLE reservations (
id INT AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(50),
room_number INT,
room_type VARCHAR(20),
payment_method VARCHAR(20)
);