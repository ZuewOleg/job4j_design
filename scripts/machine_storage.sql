create table body(
	id serial primary key,
	body_type varchar(50)
);

create table engine(
	id serial primary key,
	engine_type varchar(50)
);

create table transmission(
	id serial primary key,
	transmission_type varchar(50)
);

create table car(
	id serial primary key,
	brand varchar(55),
	model varchar(55),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into body(body_type) values ('Седан');
insert into body(body_type) values ('Хэтчбек');
insert into body(body_type) values ('Универсал');
insert into body(body_type) values ('Купе');

insert into engine(engine_type) values ('Бензин');
insert into engine(engine_type) values ('Дизель');

insert into transmission(transmission_type) values ('Ручная');
insert into transmission(transmission_type) values ('Автомат');
insert into transmission(transmission_type) values ('Робот');

insert into car(brand, model, body_id, engine_id, transmission_id) values ('Lada', '2114', 2, 1, 1);
insert into car(brand, model, body_id, engine_id, transmission_id) values ('BMW', '325', 1, 2, 2);
insert into car(brand, model, body_id, engine_id, transmission_id) values ('AUDI', 'A5', 3, 2, 3);
insert into car(brand, model, body_id, engine_id, transmission_id) values ('Toyota', 'Carolla', 4, 1, 2);
insert into car(brand, model, body_id, engine_id, transmission_id) values ('Ё', 'Мобиль', null, null, null);

select c.brand, c.model, b.body_type, e.engine_type, t.transmission_type from car c
join body b on c.body_id = b.id
join engine e on c.engine_id = e.id
join transmission t on c.transmission_id = t.id;

select c.brand, b.body_type as "Неиспользуемые детали" from car c left join body b on c.body_id != b.id;
select c.brand, e.engine_type as "Неиспользуемые детали" from car c left join engine e on c.engine_id != e.id;
select c.brand, c.model, t.transmission_type as "Неиспользуемые детали" from car c left join transmission t on c.transmission_id != t.id;

select b.body_type as "Кузов", (c.brand, c.model) as "Не используются на авто" from car c left join body b on c.body_id = b.id where c.body_id is null;
select e.engine_type as "Двигатель", (c.brand, c.model) as "Не используются на авто" from car c left join engine e on c.engine_id = e.id
where c.engine_id is null;
select t.transmission_type "Трансмиссия", (c.brand, c.model) as "Не используются на авто" from car c left join transmission t on c.transmission_id = t.id
where c.transmission_id is null;