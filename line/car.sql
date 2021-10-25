create table body(
	id serial primary key,
	type_body text
);
create table engine(
	id serial primary key,
	type_engine text
);
create table transmission(
	id serial primary key,
	type_transmiss text
);
create table car(
	id serial primary key,
	name text,
	color text,
	speedCar bool,
	body_id int references body(id),
	engine_id int references engine(id),
	transmiss_id int references transmission(id)
);

insert into body(type_body) values ('Трехобъемные');
insert into body(type_body) values ('Двухобъемные');
insert into body(type_body) values ('Однообъемные');
insert into body(type_body) values ('Грузовики');

insert into engine(type_engine) values ('Оппозитный двигатель');
insert into engine(type_engine) values ('Рядный двигатель');
insert into engine(type_engine) values ('Двигатель V-типа');
insert into engine(type_engine) values ('Квазитурбинный двигатель');
insert into engine(type_engine) values ('Роторный двигатель');

insert into transmission(type_transmiss) values ('Механическая коробка переключения передач');
insert into transmission(type_transmiss) values ('Автоматическая коробка переключения передач');
insert into transmission(type_transmiss) values ('Роботизированная коробка переключения передач');
insert into transmission(type_transmiss) values ('Вариативная (бесступенчатая) коробка переключения передач');

insert into car(name, color, speedCar, body_id, engine_id, transmiss_id)
values ('BMW X5', 'black', false, 2, 3, 2);
insert into car(name, color, speedCar, body_id, engine_id, transmiss_id)
values ('Mercedez sl600', 'white', false, 1, 2, 2);
insert into car(name, color, speedCar, body_id, engine_id, transmiss_id)
values ('ВАЗ 2110', 'blue', false, 2, 3, 1);
insert into car(name, color, speedCar, body_id, engine_id, transmiss_id)
values ('Mazda 6', 'Red', false, 2, 5, 2);
insert into car(name, color, speedCar, body_id, engine_id, transmiss_id)
values ('Камаз', 'black', false, 4, 3, 2);
insert into car(name, color, speedCar, body_id, engine_id, transmiss_id)
values ('Lamborgini M1', 'Red', true, 2, 4, 1);

select c.name as Название_машины, b.type_body as Тип_кузова, e.type_engine
as Тип_двигателя, t.type_transmiss as Тип_трансмиссии
from car c join body b on c.body_id = b.id join engine e on c.body_id = e.id
join transmission t on c.body_id = t.id;

select t.type_transmiss from transmission t left join car c on c.transmiss_id = t.id
where c.transmiss_id is null;

select e.type_engine from engine e left join car c on c.engine_id = e.id
where c.engine_id is null;

select b.type_body from body b left join car c on c.body_id = b.id
where c.body_id is null;
