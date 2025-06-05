--liquibase formatted sql
-- file: 0006_create_table_location

-- changeset dev:6
create table location (
    location_id   serial       primary key,
    name          text         not null,
    location_type text         not null,
    city_id       integer      null,
    constraint fk_location_city
      foreign key (city_id) references city(city_id),
    constraint uq_location_name
      unique (name)
);
