CREATE TABLE PUBLIC.MEMBERS
(
    id INT,
    email VARCHAR(50),
    password VARCHAR(50),
    roles VARCHAR(512)
);

INSERT INTO PUBLIC.MEMBERS (id, email, password, roles) VALUES (1, 'kemalbayindir@gmail.com', '123456', 'writer,reader');
INSERT INTO PUBLIC.MEMBERS (id, email, password, roles) VALUES (2, 'testuser1@gmail.com', '123456', 'reader');
INSERT INTO PUBLIC.MEMBERS (id, email, password, roles) VALUES (3, 'testuser2@gmail.com', '123456', 'reader');