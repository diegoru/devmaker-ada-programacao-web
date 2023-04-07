insert into role (authority) VALUES ('ROLE_OPERATOR');
insert into role (authority) VALUES ('ROLE_ADMIN');

insert into user (first_name, last_name, email, password) VALUES ('Diego', 'Ruescas', 'diego@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
insert into user (first_name, last_name, email, password) VALUES ('Charlene', 'Morais', 'charlene@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');



insert into user_role (user_id, role_id) VALUES (1, 1);
insert into user_role (user_id, role_id) VALUES (2, 1);
insert into user_role (user_id, role_id) VALUES (2, 2);