create database if not exists carreras;
use carreras;
create table if not exists carrera(id int not null auto_increment primary key,
    nombreCarrera varchar(100) not null,
    duracion int not null
);

insert into carrera (nombreCarrera, duracion) values ('Ingenieria en Sistemas Computacionales', 4);
insert into carrera (nombreCarrera, duracion) values ('Licenciatura en Ciencia de Datos', 4);
insert into carrera (nombreCarrera, duracion) values ('Ingenieria en Inteligencia Artificial', 3);