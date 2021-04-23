create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('phone', 56999,00);
insert into devices(name, price) values ('watch', 26799,00);
insert into devices(name, price) values ('camera', 24650,00);
insert into devices(name, price) values ('headphones', 13990,00);

insert into people(name) values ('Иван');
insert into people(name) values ('Маша');
insert into people(name) values ('Саша');
insert into people(name) values ('Игорь');

insert into devices_people(device_id, people_id) values (1, 4);
insert into devices_people(device_id, people_id) values (1, 1);

insert into devices_people(device_id, people_id) values (2, 3);
insert into devices_people(device_id, people_id) values (2, 2);

insert into devices_people(device_id, people_id) values (3, 1);
insert into devices_people(device_id, people_id) values (3, 2);

insert into devices_people(device_id, people_id) values (4, 2);
insert into devices_people(device_id, people_id) values (4, 4);

select avg(price) from devices;

select p.name, avg(dd.price) from devices_people as dd join people p on dd.people_id = p.id
group by s.name
having avg(dd.price) > 5000;