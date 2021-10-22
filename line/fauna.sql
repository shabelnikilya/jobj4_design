create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);
insert into fauna(name, avg_age, discovery_date)
values('cats', 7300, date '21.09.1099');
insert into fauna(name, avg_age, discovery_date)
values('rhinoceroses', 14600, date '02.03.765');
insert into fauna(name, avg_age, discovery_date)
values('elephant', 25550, date '02.07.986');
insert into fauna(name, avg_age, discovery_date)
values('giraffes', 12800, date '14.11.633');
insert into fauna(name, avg_age, discovery_date)
values('polorogie', 6570, date '04.04.1233');
insert into fauna(name, avg_age, discovery_date)
values('fish', 4300, date '04.04.245');
select * from fauna where name = 'fish';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';