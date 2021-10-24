create table departments(
	id serial primary key,
	name text
);
create table emploers(
	id serial primary key,
	name text,
	departments_id int references departments(id)
);

insert into departments(name) values ('Бухгалтерия');
insert into departments(name) values ('Технический');
insert into departments(name) values ('Продуктовый');
insert into departments(name) values ('Управленческий');

insert into emploers(name, departments_id) values ('Дарья', 1);
insert into emploers(name, departments_id) values ('Александр', 4);
insert into emploers(name, departments_id) values ('Роман', 2);
insert into emploers(name, departments_id) values ('Анастасия', 4);

select * from departments d left join emploers e on e.departments_id = d.id;
select * from departments d right join emploers e on e.departments_id = d.id;
select * from departments d full join emploers e on e.departments_id = d.id;

select d.name as Пустой_отдел from departments d left join emploers e
on e.departments_id = d.id where e.id is null;

select * from departments d left join emploers e on e.departments_id = d.id;
select * from emploers e right join departments d on e.departments_id = d.id;
select * from emploers e left join departments d on e.departments_id = d.id;
select * from departments d right join emploers e on e.departments_id = d.id;

create table teens(
	id serial primary key,
	name text,
	gender text
);

insert into teens(name, gender) values ('Ilya', 'M');
insert into teens(name, gender) values ('Roma', 'M');
insert into teens(name, gender) values ('Yulya', 'W');
insert into teens(name, gender) values ('Anastasiya', 'W');
insert into teens(name, gender) values ('Konstantin', 'M');
insert into teens(name, gender) values ('Nikolai', 'M');

select t1.name as Имя_M, t2.name as Имя_W from teens t1 cross join teens t2
where t1.gender = 'M' and t2.gender = 'W' and t1.gender != t2.gender;