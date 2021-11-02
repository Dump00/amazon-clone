CREATE TABLE item(
                     code VARCHAR(10) PRIMARY KEY ,
                     title VARCHAR(255) NOT NULL,
                     image VARCHAR(500) NOT NULL,
                     rating ENUM('1','2','3','4','5') NOT NULL,
                     qty INT NOT NULL,
                     unit_price DECIMAL(5,2) NOT NULL,
                     description VARCHAR(1000) NOT NULL
);