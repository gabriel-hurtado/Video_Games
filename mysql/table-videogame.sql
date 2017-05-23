CREATE TABLE videogame (
	id INTEGER UNIQUE NOT NULL AUTO_INCREMENT, #pkey 
	title VARCHAR(255),
    picture VARCHAR(255),
	price FLOAT(7,3), # up to 3 decimal and total of 7 digits
	PRIMARY KEY(id)
);
