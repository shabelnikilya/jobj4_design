create table club(
	id serial primary key,
	name varchar(255),
	year int,
	RedColor bool
);
insert into club(name, year, redcolor) values('Manchester United', 1914, true);
select * from club;
update club set year = 1920;
delete from club;
select * from club;