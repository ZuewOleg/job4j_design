create table departaments(
	id serial primary key,
	names varchar(250)
);

create table emploees(
	id serial primary key,
	names varchar(250),
	departaments_id int references departaments(id)
);

insert into departments(names) values ('Отдел снабжения');
insert into departments(names) values ('Отдел строительства');
insert into departments(names) values ('Отдел механизации');
insert into departments(names) values ('Отдел проектирования');

insert into emploees(names, departaments_id) values ('Иванов', 1);
insert into emploees(names, departaments_id) values ('Петров', 1);
insert into emploees(names, departaments_id) values ('Сидоров', 2);
insert into emploees(names, departaments_id) values ('Романов', 2);
insert into emploees(names, departaments_id) values ('Ленин', 3);
insert into emploees(names, departaments_id) values ('Сталин', 3);

--Выполнить запросы с left, rigth, full, cross соединениями
select * from emploees e left join departaments d on e.departament_id = d.id;
select * from emploees e right join departaments d on e.departament_id = d.id;
select * from departaments d full join emploees e on d.id = e.departament_id;

--Используя left join найти департаменты, у которых нет работников
select d.name from departaments d left join emploees e on d.id = e.departaments_id
where e.departaments_id = null;

--Используя left и right join написать запросы, которые давали бы одинаковый результат
select * from departaments d right join emploees e on d.id = e.departament_id;
select * from emploees e left join departaments d on e.departament_id = d.id;

--Создать таблицу teens с атрибутами name, gender и заполнить ее.
--Используя cross join составить все возможные разнополые пары
create table teens(
	id serial primary key,
	names varchar(250),
	gender varchar(1)
);

insert into teens(names, gender) values ('Иван', 'М');
insert into teens(names, gender) values ('Мария', 'Ж');
insert into teens(names, gender) values ('Аня', 'Ж');
insert into teens(names, gender) values ('Олег', 'М');
insert into teens(names, gender) values ('Саша', 'М');

select m.names as man, w.names as woman from teens m cross join teens w
where m.gender != w.gender;