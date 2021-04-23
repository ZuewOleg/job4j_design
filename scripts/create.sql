CREATE DATABASE init;

CREATE TABLE role(
	id serial primary key,
	name varchar(2000)
);

CREATE TABLE rules(
	id serial primary key,
	name varchar(2000)
);

CREATE TABLE role_rules(
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

CREATE TABLE users(
	id serial primary key,
	name varchar(2000)
	role_id int REFERENCES role(id)
);

CREATE TABLE category(
	id serial primary key,
    name varchar(2000)
);

CREATE TABLE state(
	id serial primary key,
    name varchar(2000)
);

CREATE TABLE item(
	id serial primary key,
	name varchar(2000)
	users_id int REFERENCES users(id),
	category_id int REFERENCES category(id),
	state_id int REFERENCES state(id)
);

CREATE TABLE comments(
	id serial primary key,
    name varchar(2000)
    item_id int REFERENCES item(item)
);

CREATE TABLE attachs(
	id serial primary key,
    name varchar(2000)
    item_id int REFERENCES item(item)
);

INSERT INTO users (name) values ('Oleg');
INSERT INTO item (name) values ('first');
INSERT INTO role (name) values ('unknow');
INSERT INTO rules (name) values ('nothing');
INSERT INTO comments (name) values ('nothing');
INSERT INTO attachs (name) values ('Dont');
INSERT INTO catogory (name) values ('Student');
INSERT INTO state (name) values ('Russia');