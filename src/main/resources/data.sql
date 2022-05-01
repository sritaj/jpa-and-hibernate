--CREATE TABLE PERSON(
--     id integer not null,
--     name varchar(255) not null,
--     location varchar(255) not null,
--     birth_date timestamp,
--     primary key(id)
--);

Insert into PERSON(id, name, location, birth_date)
values(10001, 'sritaj', 'odisha', sysdate());
Insert into PERSON(id, name, location, birth_date)
values(10002, 'anusha', 'karnataka', sysdate());

Insert into COURSE(id, course_name, created_date, last_updated_date)
values(40999, 'Geography', sysdate(), sysdate());

Insert into PASSPORT(id, passport_id)
values(40000, 'E23SDK902');
Insert into PASSPORT(id, passport_id)
values(40001, 'E23SDK903');

Insert into STUDENT(id, name, passport_id)
values(20021, 'sritaj', 40000);
Insert into STUDENT(id, name, passport_id)
values(20022, 'anusha', 40001);

Insert into REVIEW(id, rating, description, course_id)
values(50001, 5, 'Wonderful Course', 40999);



