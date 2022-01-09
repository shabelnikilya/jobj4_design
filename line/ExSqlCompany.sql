CREATE TABLE company
(
    id INTEGER NOT NULL,
    name CHARACTER VARYING,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE person
(
    id INTEGER NOT NULL,
    name CHARACTER VARYING,
    company_id INTEGER REFERENCES company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
INSERT INTO company(id, name) VALUES (2, 'adidas');
INSERT INTO company(id, name) VALUES (3, 'puma');
INSERT INTO company(id, name) VALUES (4, 'kfc');
INSERT INTO company(id, name) VALUES (5, 'McD');
INSERT INTO company(id, name) VALUES (6, 'пятерочка');
INSERT INTO company(id, name) VALUES (7, 'магнит');
INSERT INTO person(id, name, company_id) VALUES (1, 'Ilya', 1);
INSERT INTO person(id, name, company_id) VALUES (2, 'Roma', 2);
INSERT INTO person(id, name, company_id) VALUES (3, 'Jenya', 3);
INSERT INTO person(id, name, company_id) VALUES (4, 'Nastya', 4);
INSERT INTO person(id, name, company_id) VALUES (5, 'Petr', 5);
INSERT INTO person(id, name, company_id) VALUES (6, 'Oksana', 6);
INSERT INTO person(id, name, company_id) VALUES (7, 'Lenya', 7);
INSERT INTO person(id, name, company_id) VALUES (8, 'Lexa', 2);
INSERT INTO person(id, name, company_id) VALUES (9, 'Jora', 4);
INSERT INTO person(id, name, company_id) VALUES (10, 'Ivanuch', 1);

SELECT p.name, c.name FROM person p LEFT JOIN company c ON (p.company_id = c.id) WHERE c.id != 5;

SELECT c.name AS name_company, COUNT(c.name) AS peoples FROM company c
LEFT JOIN person p ON (p.company_id = c.id) GROUP BY c.name HAVING
COUNT(c.name) = (SELECT COUNT(company_id) FROM person
GROUP BY company_id ORDER BY COUNT(company_id) DESC LIMIT 1)