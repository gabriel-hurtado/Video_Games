CREATE TABLE client (
	id INTEGER NOT NULL UNIQUE AUTO_INCREMENT, #pkey
	username CHAR(15) NOT NULL, #required for identification
	password  CHAR(64) NOT NULL, #required for identification
    name CHAR(15),
    surname CHAR(15),
    description VARCHAR(255),
    picture VARCHAR(255),
    background_picture VARCHAR(255),
    primary key (id)
);