-- liquibase formatted sql

-- changeset abelov:insert_data_user
insert into user(id, username, first_name, last_name, email, phone)
values (1, 'abelov', 'Alexey', 'Belov', 'test@test.com', '+7(999)999-99-99');
