CREATE TABLE jeux (
	CHAR(15) id NOT NULL, #pkey uuid
	VARCHAR(255) title,
	FLOAT(7,4) price, # up to 4 decimal and total of 7 digits.
	CHAR(15) buyer, #fkey for junction with client table
	console_type ENUM('PC', 'MAC', 'xbox', 'xbox360', 'ps3', 'ps4'),
);
