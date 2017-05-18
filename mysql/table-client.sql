CREATE TABLE client (
	id INTEGER NOT NULL UNIQUE AUTO_INCREMENT, #pkey
	username CHAR(15) NOT NULL, #required for identification
	password  CHAR(64) NOT NULL, #required for identification
    primary key (username)
);