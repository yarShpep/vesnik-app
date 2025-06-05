--liquibase formatted sql
-- file: 0007_create_table_incident

-- changeset dev:7
create table incident (
    incident_id         serial       primary key,
    incident_date       date         not null,
    incident_time       time         not null,
    location_id         integer      not null,
    track               text,
    km_pk               text,
    incident_type_id    integer      null,
    incident_type_text  text         null,
    description         text         not null,
    chairman_id         integer      not null,
    constraint fk_incident_location
      foreign key (location_id) references location(location_id),
    constraint fk_incident_type
      foreign key (incident_type_id) references incident_type(incident_type_id),
    constraint fk_incident_chairman
      foreign key (chairman_id) references chairman(chairman_id)
);
