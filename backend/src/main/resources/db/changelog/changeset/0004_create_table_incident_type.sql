--liquibase formatted sql
-- file: 0004_create_table_incident_type

-- changeset dev:4
create table incident_type (
    incident_type_id serial       primary key,
    name              varchar(100) not null
);
