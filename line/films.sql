create table films(
	id serial primary key,
	name text
);
create table kinoman(
	id serial primary key,
	name text,
	films_id int references films(id)
);
insert into films(name) values ('Мир юрского периода');
insert into films(name) values ('12 стульев');
insert into films(name) values ('Начало');
insert into films(name) values ('Любовь и голуби');

insert into kinoman(name, films_id) values ('Ilya', 1);
insert into kinoman(name, films_id) values ('Roma', 3);
insert into kinoman(name, films_id) values ('Jenya', 4);
insert into kinoman(name, films_id) values ('Anastasiya', 2);
insert into kinoman(name) values ('Leonid');

select * from kinoman join films f on kinoman.films_id = f.id;
select k.name, f.name from kinoman as k join films  as  f on k.films_id = f.id;
select k.name as Имя, f.name as Название_Фильма
from kinoman as k join films as f on k.films_id = f.id;