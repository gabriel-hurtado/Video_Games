CREATE TABLE videogame (
	id INTEGER UNIQUE NOT NULL, #pkey 
	title VARCHAR(255),
	price FLOAT(7,2), # up to 4 decimal and total of 7 digits
	PRIMARY KEY(id)
);
