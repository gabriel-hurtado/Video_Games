CREATE TABLE address (
	id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
	address_line VARCHAR(255) NOT NULL,
	city VARCHAR(255),
	country VARCHAR(255),
	owner INTEGER NOT NULL references client(id), #fkey
	PRIMARY KEY(id)
);