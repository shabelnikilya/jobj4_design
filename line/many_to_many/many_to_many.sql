create table shops(
	id serial primary key,
	name varchar(255)
);
create table peoples(
	id serial primary key,
	name varchar(255)
);
create table peoples_shops(
	id serial primary key,
	peoples_id int references peoples(id),
	shops_id int references shops(id)
);
insert into shops(name) values ('H&M');
insert into shops(name) values ('Nike');
insert into shops(name) values ('Puma');
insert into shops(name) values ('Adidas');
select * from shops;
insert into peoples(name) values ('Roma');
insert into peoples(name) values ('Sasha');
insert into peoples(name) values ('Egor');
insert into peoples(name) values ('Olga');
select * from peoples;
insert into peoples_shops(peoples_id, shops_id) values (1, 3);
insert into peoples_shops(peoples_id, shops_id) values (1, 2);
insert into peoples_shops(peoples_id, shops_id) values (2, 1);
insert into peoples_shops(peoples_id, shops_id) values (2, 3);
insert into peoples_shops(peoples_id, shops_id) values (2, 4);
insert into peoples_shops(peoples_id, shops_id) values (3, 1);
insert into peoples_shops(peoples_id, shops_id) values (4, 2);
insert into peoples_shops(peoples_id, shops_id) values (4, 4);
select * from peoples_shops;