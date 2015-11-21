# alter script from previous version.

alter table contactos add observaciones varchar(255);
alter table contactos add destacado bit(1) default 0;
alter table contactos add fotografo bit(1) default 0;
