CREATE TABLE item(
                     code VARCHAR(10) PRIMARY KEY ,
                     title VARCHAR(255) NOT NULL,
                     image VARCHAR(500) NOT NULL,
                     rating ENUM('1','2','3','4','5') NOT NULL,
                     qty INT NOT NULL,
                     unit_price DECIMAL(5,2) NOT NULL,
                     description VARCHAR(1000) NOT NULL
);

INSERT INTO item VALUES ('I001', 'PlayStation 5',
                         'https://m.media-amazon.com/images/I/31C4szfCc-L._AC_UY218_.jpg',
                         5,
                         10,
                         400,
                         '<div>The <b>PlayStation 5</b> (PS5) is a home video game console
                            developed by Sony Interactive Entertainment. " +
                            "The Digital Edition lacks this drive, " +
                            "allowing it to serve as a lower-cost model for those who prefer
                            to buy games through digital download. " +
                            "The two variants were launched simultaneously.</div>`');

