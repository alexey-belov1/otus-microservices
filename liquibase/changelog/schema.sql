-- liquibase formatted sql

-- changeset abelov:create_table_user
create table user (
    id          int auto_increment primary key,
    username    varchar(255) null,
    first_name  varchar(255) null,
    last_name   varchar(255) null,
    email       varchar(255) null,
    phone       varchar(255) null
);
-- rollback drop table user;
