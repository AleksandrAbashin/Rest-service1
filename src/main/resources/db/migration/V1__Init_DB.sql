create sequence hibernate_sequence start 1 increment 1;

create table client (
    id int8 not null,
    name varchar(255),
    primary key (id)
);
create table application (
    id int8 not null,
    created_at timestamp,
    product_name varchar(255),
    client_id int8,
    primary key (id)
);

 alter table if exists application add
 constraint FKjyn4o6h2meve9at10lf8g1q8q
 foreign key (client_id) references client;