create table type(
	id serial primary key,
	name varchar(250)
);

create table product(
	id serial primary key,
	name varchar(250), 
	expired_date date,
	price float,
	type_id int references type(id)
);

insert into type(name) values('СЫР');
insert into type(name) values('мороженое');
insert into type(name) values('масло');

insert into product(name, expired_date, price, type_id) values ('Российский', '23.04.2021', 150.90, 1);
insert into product(name, expired_date, price, type_id) values ('Маасдам', '05.05.2021', 250.99, 1);
insert into product(name, expired_date, price, type_id) values ('Моцарелла', '28.03.2021', 352.20, 1);
insert into product(name, expired_date, price, type_id) values ('Мраморный', '10.05.2021', 273.35, 1);

insert into product(name, expired_date, price, type_id) values ('Сливочное', '01.05.2021', 26.70, 2);
insert into product(name, expired_date, price, type_id) values ('Шоколадное', '25.05.2021', 30.90, 2);
insert into product(name, expired_date, price, type_id) values ('Фисташковое', '06.06.2021', 75.20, 2);
insert into product(name, expired_date, price, type_id) values ('Крем-брюле', '27.06.2021', 54.80, 2);

insert into product(name, expired_date, price, type_id) values ('Просто сливочное масло', '01.05.2021', 26.70, 3);
insert into product(name, expired_date, price, type_id) values ('Ленинградское', '01.05.2021', 26.70, 3);

select * from product p join type t on t.id = p.type_id where t.name = 'СЫР';
select * from product where name like '%мороженое%';
select * from product where date_part('month', expired_date) = date_part('month', current_date) + 1;
select * from product where price = (select max(price) from product);

select t.name, count(t.id) from type t join product p on t.id = p.type_id
group by t.name;

select * from product p join type t on t.id = p.type_id
where t.name in ('СЫР', 'масло');

select t.name, count(t.id) from type t join product p on t.id = p.type_id
group by t.name
having count(t.id) < 10;

select * from product p join type t on p.type_id = t.id