create sequence hibernate_sequence start 1 increment 1;

create table client_contact (
    id int8 not null,
    name varchar(255),
    primary key (id)
);
create table tb_appli (
    id_appli int8 not null,
    dt_appli timestamp,
    product_name varchar(255),
    contact_id int8,
    primary key (id_appli)
);

 alter table if exists tb_appli add
 constraint FKjyn4o6h2meve9at10lf8g1q8q
 foreign key (contact_id) references client_contact;