CREATE SEQUENCE people_people_id_seq
    INCREMENT 1
    START 1;

CREATE TABLE people
(
    people_id bigint DEFAULT nextval('people_people_id_seq') NOT NULL,
    name character varying(255),
    surname character varying(255),
    patronymic character varying(255),
    CONSTRAINT people_pkey PRIMARY KEY (people_id)
);

insert into people (name, surname) values('Alexey', 'Ivanov');
insert into people (name, surname) values('Ivan', 'Petrov');
insert into people (name, surname) values('Alexey', 'Sidorov');
