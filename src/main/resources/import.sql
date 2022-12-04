-- This file allow to write SQL commands that will be emitted in test and dev.

-- The commands are commented as their support depends of the database

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

-- Active: 1669911383194@@127.0.0.1@53967@quarkus

drop table if exists hibernate_sequence;

drop table if exists MyEntity;

drop table if exists Orders;

drop table if exists order_id_seq;

drop table if exists Ships;

drop table if exists ship_id_seq;

create table
    hibernate_sequence (next_val bigint) engine = InnoDB;

insert into hibernate_sequence values ( 1 );

create table
    MyEntity (
        id bigint not null,
        field varchar(255),
        primary key (id)
    ) engine = InnoDB;

create table
    Orders (
        id integer not null,
        description varchar(255),
        receiptDate date,
        url varchar(255),
        primary key (id)
    ) engine = InnoDB;

create table order_id_seq (next_val bigint) engine = InnoDB;

insert into order_id_seq values ( 1 );

create table
    Ships (
        id integer not null,
        isFree bit not null,
        name varchar(255),
        primary key (id)
    ) engine = InnoDB;

create table ship_id_seq (next_val bigint) engine = InnoDB;

insert into ship_id_seq values ( 1 );