INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'lia@gmail.com', '$2a$10$bQlcTQMonQeONkqI4DrDcuW.VDCVH64K3q5yL6B0LG3n4DeirMqda');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'bob@gmail.com', '$2a$10$bQlcTQMonQeONkqI4DrDcuW.VDCVH64K3q5yL6B0LG3n4DeirMqda');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);