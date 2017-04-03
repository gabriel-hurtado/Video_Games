CREATE TABLE client (
	username CHAR(10) NOT NULL, #required for identification - pkey
	password  CHAR(10) NOT NULL, #required for identification
    primary key (username)
);