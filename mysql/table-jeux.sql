CREATE TABLE jeux (
	id CHAR(15) NOT NULL, #pkey uuid
	title VARCHAR(255),
	price FLOAT(7,4), # up to 4 decimal and total of 7 digits
	buyer CHAR(15) references client(username), #fkey for junction with client table
	console_type ENUM('PC', 'MAC', 'XBOX', 'XBOX360', 'PS3', 'PS4'),
	PRIMARY KEY(id)
);
