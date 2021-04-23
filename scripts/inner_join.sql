create table products (
	id serial primary key,
     name varchar(255)
);

create table prise (
	id serial primary key,
	rub int,
	products_id int references products(id)
);

insert into products(name) values ('Milk');
insert into products(name) values ('Bread');
insert into products(name) values ('Cheese');
insert into products(name) values ('Butter');

insert into price(rub, products_id) values (45, 1);
insert into price(rub, products_id) values (25, 2);
insert into price(rub, products_id) values (150, 3);
insert into price(rub, products_id) values (83, 4);
insert into price(rub) values (22);
insert into price(rub) values (33);

select * from price inner join products p on price.products_id = p.id;
select * from price join products p on price.products_id = p.id;
select pp.rub, p.name from price as pp join products as p on pp.products_id = p.id;
select pp.rub as Цена, p.name as Наименование from price as pp join products as p on pp.products_id = p.id;