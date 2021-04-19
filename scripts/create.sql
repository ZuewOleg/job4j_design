CREATE DATABASE init;

CREATE TABLE users(
	id serial primary key,
	name varchar(2000)
);

CREATE TABLE item(
	id serial primary key,
	name varchar(2000)
	comments_id int REFERENCES comments(id),
	attachs_id int REFERENCES attachs(id)
);

CREATE TABLE users_item(
	users_id int REFERENCES users(users_id),
	item_id int REFERENCES item(item)
);

CREATE TABLE role(
	id serial primary key,
	name varchar(2000)
	users_id int REFERENCES users(users_id)
);

CREATE TABLE rules(
	id serial primary key,
	name varchar(2000)
);

CREATE TABLE role_rules(
	id serial primary key,
	role_id int REFERENCES role(id),
	rules_id int REFERENCES rules(id)
);

CREATE TABLE comments(
	id serial primary key,
    name varchar(2000)
);

CREATE TABLE attachs(
	id serial primary key,
    name varchar(2000)
);

CREATE TABLE category(
	id serial primary key,
    name varchar(2000),
	item_id int REFERENCES item(id)
);

CREATE TABLE state(
	id serial primary key,
    name varchar(2000),
	item_id int REFERENCES item(id)
);

INSERT INTO users (name) values ('Oleg');
INSERT INTO item (name) values ('first');
INSERT INTO role (name) values ('unknow');
INSERT INTO rules (name) values ('nothing');
INSERT INTO comments (name) values ('nothing');
INSERT INTO attachs (name) values ('Dont');
INSERT INTO catogory (name) values ('Student');
INSERT INTO state (name) values ('Russia');