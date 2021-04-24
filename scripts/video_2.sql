create table departments(
	id serial primary key,
	name varchar(250)
);

create table emploees(
	id serial primary key,
	name varchar(250),
	departaments_id integer references departments(id)
);

insert into departments(name) values ('Отдел снабжения');
insert into departments(name) values ('Отдел строительства');
insert into departments(name) values ('Отдел механизации');
insert into departments(name) values ('Отдел проектирования');

insert into emploees(name, departaments_id) values ('Иванов', 1);
insert into emploees(name, departaments_id) values ('Петров', 1);
insert into emploees(name, departaments_id) values ('Сидоров', 2);
insert into emploees(name, departaments_id) values ('Романов', 2);
insert into emploees(name, departaments_id) values ('Ленин', 3);
insert into emploees(name, departaments_id) values ('Сталин', 3);

select * from emploees e left join departaments d on e.departament_id = d.id;
select * from departaments d right join emploees e on d.id = e.departament_id;
select * from departaments d full join emploees e on d.id = e.departament_id;
select * from emploees e left join departaments d on e.departament_id = d.id
union
select * from emploees e right join departaments d on e.departament_id = d.id;

create table teens(
	id serial primary key,
	name varchar(250),
	gender varchar(1)
);

insert into teens(name, gender) values ('Иван', 'М');
insert into teens(name, gender) values ('Мария', 'Ж');
insert into teens(name, gender) values ('Аня', 'Ж');
insert into teens(name, gender) values ('Олег', 'М');
insert into teens(name, gender) values ('Саша', 'М');

select m.name as man, w.name as woman, (m.name + w.name) as pair from teens m cross join teens w
where m.gender != w.gender;