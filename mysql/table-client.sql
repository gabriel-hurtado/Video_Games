CREATE TABLE client (
	id INTEGER NOT NULL UNIQUE, #pkey
	username CHAR(15) NOT NULL, #required for identification
	password  CHAR(15) NOT NULL, #required for identification
	address INTEGER NOT NULL references address(id),
    primary key (username)
);