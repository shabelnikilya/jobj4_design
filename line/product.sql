create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key,
	name text,
	type_id int references type(id),
	expired_date timestamp,
	price float
);
insert into type(name) values ('Сыр');
insert into type(name) values ('Мороженное');
insert into type(name) values ('Алкогольный напиток');
insert into type(name) values ('Чай и кофе');
insert into type(name) values ('Фрукты');
insert into type(name) values ('Овощи');
insert into type(name) values ('Колбасы');
insert into type(name) values ('Мясо');

insert into product(name, type_id, expired_date, price)
values ('Пармезан', 1, date '2021-10-27', 289.1);
insert into product(name, type_id, expired_date, price)
values ('мороженое бодрая коровка', 2, date '2021-11-04', 77.7);
insert into product(name, type_id, expired_date, price)
values ('Старый мельник', 3, date '2022-01-15',48.51);
insert into product(name, type_id, expired_date, price)
values ('Гринфилд', 4, date '2022-05-21', 76.9);
insert into product(name, type_id, expired_date, price)
values ('Бананы', 5, date '2021-10-22', 53.4);
insert into product(name, type_id, expired_date, price)
values ('Помидоры', 6, date '2021-10-29', 188);
insert into product(name, type_id, expired_date, price)
values ('Охотничья', 7, date '2021-10-17', 377.99);
insert into product(name, type_id, expired_date, price)
values ('Свинина', 8, date '2021-10-27', 289.1);
insert into product(name, type_id, expired_date, price)
values ('Хокланд', 1, date '2021-10-12', 122.1);
insert into product(name, type_id, expired_date, price)
values ('Яблоки', 5, date '2021-10-29', 88.1);

select t.name as Тип, p.name as Название_продукта
from product p inner join type t on p.type_id = t.id where t.name = 'Сыр';

select * from product where name like '%мороженое%';

select p.name as Тип, t.name as Название_проукта, p.expired_date as Дата
from product p inner join type t on p.type_id = t.id where expired_date < current_date;

select p.name as Название, p.price as Цена from product p where price = (select max(price) from product);

select t.name as Имя_типа, count(t.name) as Количество from product p join type t on p.type_id = t.id
group by t.name;

select t.name, p.name from product p join type t on p.type_id = t.id
where t.name like '%Сыр%' or t.name like '%Мясо%';

select t.name as Имя_типа, count(t.name) as Количество from product p join type t on p.type_id = t.id
group by t.name
having count(t.name) > 1;

select p.name as Название_продукта, t.name as Тип from product p join type t on p.type_id = t.id;