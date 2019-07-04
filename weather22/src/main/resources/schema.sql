create table province (
    id int primary key, 
    name varchar(100) not null
);

create table city (
    code varchar(100) primary key,
    pid int REFERENCES province(id),
    name varchar(100) not null
);