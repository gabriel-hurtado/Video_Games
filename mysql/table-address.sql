CREATE TABLE address (
	id INTEGER UNIQUE NOT NULL,
	address_line VARCHAR(255) NOT NULL,
	city VARCHAR(255),
	country VARCHAR(255),
	PRIMARY KEY(id)
);