--liquibase formatted sql
-- file: 0003_create_table_city

-- changeset dev:3
create table city (
    city_id     serial       primary key,
    name        varchar(100) not null,
    district_id integer       not null,
    constraint fk_city_district
      foreign key (district_id) references district(district_id),
    constraint uq_city_in_district
      unique (district_id, name)
);
