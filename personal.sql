insert into personal(name, age, birthday, married, gender) values('Ivan', 35, '1/8/1999', true, 'M');
select * from personal;
update personal set name = 'Oleg';
update personal set age = 28;
update personal set birthday = '17/09/1992';
select * from personal;
delete from personal;
select * from personal;