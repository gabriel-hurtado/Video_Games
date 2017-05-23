#password encrypted with SHA256 and salt
#it gives 64 characters. The salt use is chips and here is an example for potatoes as the password
# fc9fa4cd2a7c9301d1fbaa781d6be577ba1442df97d5c0f6415e27d526b25cb0


insert into client(username, password, name, surname, description, picture, background_picture) values ("billyBob","fc9fa4cd2a7c9301d1fbaa781d6be577ba1442df97d5c0f6415e27d526b25cb0", "Bill", "Boby", "Got some crazy games to end, do not disturb", "https://scontent-cdg2-1.xx.fbcdn.net/v/t1.0-9/936794_505309866196556_1300143175_n.jpg?oh=d7eab21f34b0e06853e9d6a0adeb8516&oe=599DF53D","http://www.cherie-cheri-shop.com/wp-content/uploads/2015/01/Grey-background-for-site11.jpg"); #potatoes
insert into client(username, password,  name, surname, description, picture, background_picture) values ("jonhyJones","45fc7427873603bfa39c57c913a45d16fb81dbb88018ae0c8b4e0bc6fec348c7","John", "Hanthan", "Fan of videogames since my childhood, I am eager to discover what you guys proposes. Don't hesitate to contact me for further information.", "https://scontent-cdg2-1.xx.fbcdn.net/v/t1.0-9/1422473_855767454434294_5295775558401467871_n.jpg?oh=73ea888ab59760a51b70b0d16a032d3a&oe=59BCBDF3", "https://support.activision.com/servlet/servlet.FileDownload?file=00P0B00000fsaOb"); #orange"
insert into client(username, password,  name, surname, description, picture, background_picture) values ("Diablox9","05a39862da72bd82b4e2b07713d76b247043e8c38a296465fe886c4c4af4921a", "Sam", "Diablo", "Got some monster to kick, checkout my youtube channel : www.youtube.com/diabl0x9", "https://scontent-cdg2-1.xx.fbcdn.net/v/t31.0-8/12182760_1083617158317573_4720895815579969664_o.png?oh=4b31885a0b1ba845d181d9cfee47d246&oe=59C0C0F9", "http://wallpapercave.com/wp/gjTGNBu.jpg"); #nems

insert into address(address_line, country,city, owner) values ("11 rue de Paris","Paris","France",1);
insert into address(address_line, country,city, owner) values ("11 rue de Paris","Compiègne","France",1);
insert into address(address_line, country,city, owner) values ("2 rue des bois","Amiens","France",2);
insert into address(address_line, country,city, owner) values ("27 Georges Road","Los Angeles","USA",3);

insert into console values("PS4");
insert into console values("PS3");
insert into console values("PC");

insert into gametype values("FPS");
insert into gametype values("RTPS");
insert into gametype values("RPG");

insert into videogame(title,picture,price) values ("Age of Empires","http://www.boardknight.com/wp-content/uploads/2015/02/knights-1920x1200.jpg",22.000);
insert into videogame(title,picture,price) values ("Call of Duty","https://magazinegk.fr/wp-content/uploads/2016/08/landscape-1456759219-14993-call-of-duty-4-modern-warfare-game-desktop-wallpaper-2560x1600.jpg",70.000);
insert into videogame(title,picture,price) values ("Skyrim","https://www.technobuffalo.com/wp-content/uploads/2016/10/Skyrim.jpg",55.999);
insert into videogame(title,picture,price) values ("Super Mario Bros","https://s-media-cache-ak0.pinimg.com/736x/7c/1a/25/7c1a2581e6369f2961b174e68b3b3351.jpg",32.000);
insert into videogame(title,picture,price) values ("Grand Theft Auto","https://i.ytimg.com/vi/iPAadjNjXT4/maxresdefault.jpg",50.999);
insert into videogame(title,picture,price) values ("The Legend of Zelda","http://img.cwol.fr/2015/03/Zelda-DFT.jpg",88.000);

insert into consolebelonging values(1,"PC");
insert into consolebelonging values(2,"PC");
insert into consolebelonging values(2,"PS3");
insert into consolebelonging values(3,"PC");
insert into consolebelonging values(3,"PS4");
insert into consolebelonging values(4,"PC");
insert into consolebelonging values(5,"PC");
insert into consolebelonging values(5,"PS3");
insert into consolebelonging values(6,"PC");
insert into consolebelonging values(6,"PS4");

insert into gametyping values(1,"RTS");
insert into gametyping values(2,"FPS");
insert into gametyping values(3,"RTS");
insert into gametyping values(3,"FPS");
insert into gametyping values(4,"RTS");
insert into gametyping values(5,"FPS");
insert into gametyping values(6,"RTS");
insert into gametyping values(6,"FPS");

Insert into orders(date,total,client,address) values (CURDATE(),44,1,1);
Insert into orders(date,total,client,address) values (CURDATE(),70,2,3);
Insert into orders(date,total,client,address) values (CURDATE(),135,1,2);

insert into orderline(order_id, videogame, quantity) values (1,1,2);
insert into orderline(order_id, videogame, quantity) values (2,2,1);
insert into orderline(order_id, videogame, quantity) values (3,2,1);
insert into orderline(order_id, videogame, quantity) values (3,3,1);