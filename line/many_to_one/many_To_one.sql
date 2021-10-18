create table car(
	id serial primary key,
	nameCar varchar(255)
);
create table peoples(
	id serial primary key,
	name varchar(255),
	position_id int references car(id)
);
insert into car(namecar) values ('BMW X5');
insert into car(namecar) values ('Mercedez sl600');
insert into car(namecar) values ('Mercedez sl600');
select * from car;
insert into peoples(name, position_id) values ('Alexander', 2);
insert into peoples(name, position_id) values ('Ilya', 1);
insert into peoples(name, position_id) values ('Alexey', 3);
insert into peoples(name, position_id) values ('Elena', 3);
insert into peoples(name, position_id) values ('Ilya', 2);
select * from peoples;
select * from car where id in (select id from peoples);