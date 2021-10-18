create table account(
	id serial primary key,
	name varchar(255)
);
create table passwordAcc(
	id serial primary key,
	pass int
);
create table passwordAcc_account(
	id serial primary key,
	passwordAcc_id int references passwordAcc(id) unique,
	account_id int references account(id) unique
);
insert into passwordAcc(pass) values (12345);
insert into account(name) values ('ilyaSh');
insert into passwordAcc_account(passwordAcc_id, account_id) values (1, 1);