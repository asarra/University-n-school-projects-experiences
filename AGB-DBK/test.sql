create database test;
use test;
create table auto(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, hash varchar(10) NOT NULL UNIQUE, name varchar(20), description text);
create table fahrer(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(10), auto INTEGER, FOREIGN KEY(auto) REFERENCES auto(id));
insert into auto(name) values ("BMW");
insert into auto(hash, name, description) values ("3B2JK:;S$D", "Mercedes","ein nice car");
insert into fahrer(name, auto) values ("James", 1);
insert into fahrer(name, auto) values ("Max", 2);
delete from fahrer where id = 1;
select * from fahrer;
alter table fahrer update
#WHERE-Having