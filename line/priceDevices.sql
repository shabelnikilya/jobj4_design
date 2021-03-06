 create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);
 create table devices_people(
     id serial primary key,
     device_id int references devices(id),
     people_id int references people(id)
 );

 insert into devices(name, price) values ('keyboard', 1099);
 insert into devices(name, price) values ('mouse', 755);
 insert into devices(name, price) values ('speaker', 3999);
 insert into devices(name, price) values ('monitor', 10099);

 insert into people(name) values ('Roma');
 insert into people(name) values ('Anastasiya');
 insert into people(name) values ('Leonid');
 insert into people(name) values ('Alexander');

 insert into devices_people(device_id, people_id) values (3, 1);
 insert into devices_people(device_id, people_id) values (3, 4);
 insert into devices_people(device_id, people_id) values (1, 2);
 insert into devices_people(device_id, people_id) values (1, 4);
 insert into devices_people(device_id, people_id) values (2, 3);
 insert into devices_people(device_id, people_id) values (2, 1);
 insert into devices_people(device_id, people_id) values (4, 1);
 insert into devices_people(device_id, people_id) values (4, 2);
 insert into devices_people(device_id, people_id) values (4, 3);

 select avg(price) from devices;
 select p.name, avg(d.price) from devices_people as dp join people as p on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name;
select p.name, avg(d.price) from devices_people as dp join people as p on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;
