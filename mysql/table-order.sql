CREATE TABLE orders (
	id INTEGER NOT NULL, #pkey uuid
	date DATE,
	total FLOAT(10,2), # up to 2 decimal and total of 10 digits
	client INTEGER NOT NULL references client(id) , #fkey
	address INTEGER NOT NULL references address(id), #fkey
	PRIMARY KEY(id)
);