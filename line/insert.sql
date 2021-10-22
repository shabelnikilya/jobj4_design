insert into role(name) values ('Роль 1');
insert into role(name) values ('Роль 2');
insert into role(name) values ('Роль 3');
insert into privelege(namePrivelege) values ('Право 1');
insert into privelege(namePrivelege) values ('Право 2');
insert into privelege(namePrivelege) values ('Право 3');
insert into category(name) values ('На исправление');
insert into category(name) values ('Не актуальные заявки');
insert into category(name) values ('В работе');
insert into state(status) values('Активный');
insert into state(status) values('Приостановлен');
insert into state(status) values('В разработке');
insert into users(name, secondName, age, role_id) values ('Ilya', 'Shabelnik', 28, 1);
insert into users(name, secondName, age, role_id) values ('Ivan', 'Ivanov', 22, 2);
insert into users(name, secondName, age, role_id) values ('Roma', 'Shishkin', 33, 3);
insert into privelege_role(role_id, privelege_id) values (1, 3);
insert into privelege_role(role_id, privelege_id) values (2, 1);
insert into privelege_role(role_id, privelege_id) values (3, 2);
insert into item (textItem, users_id, category_id, state_id) values ('first_item', 2, 1, 3);
insert into item (textItem, users_id, category_id, state_id) values ('second_item', 3, 2, 1);
insert into item (textItem, users_id, category_id, state_id) values ('third_item', 1, 3, 2);
insert into comments (textComments, item_id) values ('Заявка с высшим приоритетом', 1);
insert into comments (textComments, item_id) values ('Подправить п.2 в заявке', 2);
insert into comments (textComments, item_id) values ('Отложенная заявка', 2);
insert into comments (textComments, item_id) values ('Недостаточно данных в заявке', 3);
insert into comments (textComments, item_id) values ('Заявка не соответствует действительности', 3);
insert into attachs(nameFile, size, item_id) values ('item_att_first', 34, 2);
insert into attachs(nameFile, size, item_id) values ('item_att_second', 38, 1);
insert into attachs(nameFile, size, item_id) values ('item_att_third', 54, 3);