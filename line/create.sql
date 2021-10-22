create table role(
	id serial primary key,
	name text
);
create table privelege(
	id serial primary key,
	namePrivelege text
);
create table category(
	id serial primary key,
	name text
);
create table state(
	id serial primary key,
	status text
);
create table users(
	id serial primary key,
	name text,
	secondName text,
	age int,
	role_id int references role(id)
);
create table privelege_role(
	id serial primary key,
	role_id int references role(id),
	privelege_id int references privelege(id)
);
create table item(
	id serial primary key,
	textItem text,
	users_id int references users(id),
    category_id int references category(id),
	state_id int references state(id)
);
create table comments(
    id serial primary key,
    textComments text,
    item_id int references item(id)
);
create table attachs(
	id serial primary key,
	nameFile text,
	size int,
	item_id int references item(id)
);