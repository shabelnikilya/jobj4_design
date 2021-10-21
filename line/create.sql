create table users(
	id serial primary key,
	name text,
	secondName text,
	age int
);
create table role(
	id serial primary key,
	name text,
	users_id int references users(id)
);
create table privelege(
	id serial primary key,
	namePrivelege text
);
create table privelege_role(
	id serial primary key,
	role_id int references role(id),
	privelege_id int references privelege(id)
);
create table item(
	id serial primary key,
	textItem text
);
ALTER TABLE users ADD COLUMN item_id int references item(id)
create table comments(
	id serial primary key,
	textComments text
);
ALTER TABLE item ADD COLUMN comments_id int references comments(id)
create table attachs(
	id serial primary key,
	nameFile text,
	size int
);
ALTER TABLE item ADD COLUMN attachs_id int references attachs(id)
create table category(
	id serial primary key,
	name text,
	item_id int references item(id)
);
create table state(
	id serial primary key,
	status text,
	item_id int references item(id)
);
