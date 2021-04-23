DROP DATABASE IF EXISTS cupcake1;
CREATE DATABASE IF NOT EXISTS cupcake1;

use cupcake1;

CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(45) NOT NULL,
    user_role VARCHAR(12) NOT NULL DEFAULT 'user',
    user_password VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    balance INT NOT NULL DEFAULT 0,
    PRIMARY KEY (user_id));

CREATE TABLE IF NOT EXISTS orders (
    order_id INT NOT NULL AUTO_INCREMENT,
    order_time TIMESTAMP NOT NULL,
    order_status VARCHAR(45) NOT NULL DEFAULT 'pending',
    fk_user_id int NOT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (fk_user_id) REFERENCES users(user_id)
    );

CREATE TABLE IF NOT EXISTS topping (
    topping_id INT NOT NULL AUTO_INCREMENT,
    topping_name VARCHAR(45) NOT NULL,
    topping_price DECIMAL(8,2) NOT NULL DEFAULT 0,
    PRIMARY KEY (topping_id)
    );

CREATE TABLE IF NOT EXISTS bottom (
    bottom_id INT NOT NULL AUTO_INCREMENT,
    bottom_name VARCHAR(45) NOT NULL,
    bottom_price DECIMAL(8,2) NOT NULL DEFAULT 0,
    PRIMARY KEY (bottom_id)
    );

CREATE TABLE IF NOT EXISTS order_details (
    detail_id INT NOT NULL AUTO_INCREMENT,
    fk_topping_id int NOT NULL,
    fk_bottom_id int NOT NULL,
    detail_qty INT NOT NULL DEFAULT 0,
    detail_price DECIMAL(8,2) NOT NULL DEFAULT 0,
    fk_order_id int NOT NULL,
    PRIMARY KEY (detail_id),
    FOREIGN KEY (fk_topping_id) REFERENCES topping(topping_id),
    FOREIGN KEY (fk_bottom_id) REFERENCES bottom(bottom_id),
    FOREIGN KEY (fk_order_id) REFERENCES orders(order_id)
    );


