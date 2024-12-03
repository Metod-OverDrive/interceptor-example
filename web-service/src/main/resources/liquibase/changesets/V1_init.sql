-- liquibase formatted sql
-- changeset eve:1

-- Table: employees
create table if not exists users
(
    id       bigserial,
    username varchar(255) not null unique,
    is_active boolean not null,
    primary key (id)
);
