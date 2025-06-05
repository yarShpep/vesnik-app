--liquibase formatted sql
-- file: 0002_create_table_district

-- changeset dev:2
create table district (
    district_id serial       primary key,
    name        varchar(100) not null,
    region_id   integer      not null,
    constraint fk_district_region
      foreign key (region_id) references region(region_id),
    constraint uq_district_in_region
      unique (region_id, name)
);
