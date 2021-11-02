CREATE TABLE item(
                     code VARCHAR(10) PRIMARY KEY ,
                     title VARCHAR(255) NOT NULL,
                     image VARCHAR(500) NOT NULL,
                     rating ENUM('1','2','3','4','5') NOT NULL,
                     qty INT NOT NULL,
                     unit_price DECIMAL(5,2) NOT NULL,
                     description MEDIUMTEXT NOT NULL
);


INSERT INTO item VALUES ('I002', 'PlayStation 5',
                         'https://m.media-amazon.com/images/I/71NTi82uBEL._AC_UL320_.jpg',
                         4,
                         25,
                         50,
                         '<div>An Apple-designed dynamic driver, powered by a custom amplifier, " +
    "renders music in exceptionally detailed sound quality — " +
    "so you revel in every tone, from deep, rich bass to crisp, clean highs.</div>');

