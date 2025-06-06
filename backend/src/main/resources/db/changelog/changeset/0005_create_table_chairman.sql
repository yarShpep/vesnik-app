--liquibase formatted sql
-- file: 0005_create_table_chairman

-- changeset dev:5
create table chairman (
    chairman_id serial       primary key,
    full_name   varchar(100) not null unique
);
