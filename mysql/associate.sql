CREATE TABLE orderline (
	id INTEGER NOT NULL UNIQUE AUTO_INCREMENT, # pkey
	order_id INTEGER NOT NULL references orders(id), #fkey order
	videogame INTEGER NOT NULL references videogame(id), #fkey videogame
	quantity INTEGER
);

CREATE TABLE gametyping (
	videogame INTEGER NOT NULL references videogame(id), #fkey order
	gametype VARCHAR(255) NOT NULL references gametype(name) #fkey gametype
);


CREATE TABLE consolebelonging (
	videogame INTEGER NOT NULL references videogame(id), #fkey order
	console VARCHAR(255) NOT NULL references console(name) #fkey console
);
