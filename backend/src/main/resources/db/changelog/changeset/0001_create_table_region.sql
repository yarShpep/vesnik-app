--liquibase formatted sql
-- file: 0001_create_table_region

-- changeset dev:1
create table region (
    region_id   serial       primary key,
    name        text         not null
);
