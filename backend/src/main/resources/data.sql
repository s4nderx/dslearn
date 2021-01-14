INSERT INTO tb_user (name, email, password) VALUES ('Alex Sander', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Singer', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Helena', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_notification (text, moment, read, route, user_fk) VALUES ('Módulo 1 concluído com sucesso!', TIMESTAMP WITH TIME ZONE '2021-01-12T03:00:00Z', false, 'nao sei oq botar auqi', 1);

INSERT INTO tb_course (name, img_Uri, img_Gray_Uri) VALUES ('Bootcamp HTML', 'https://image.freepik.com/vetores-gratis/jovem-professor-dos-desenhos-animados-homem-professor-na-lousa-ensinando-as-criancas-na-ilustracao-em-vetor-escola-sala-de-aula_53562-7922.jpg', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Encyclopedia_icon.svg/1200px-Encyclopedia_icon.svg.png');
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_fk) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-11-20T03:00:00Z', 1);
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_fk) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2020-12-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-12-20T03:00:00Z', 1);

INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_fk) VALUES ('Trilha HTML', 'Trilha principal do curso', 1, 'https://image.freepik.com/vetores-gratis/jovem-professor-dos-desenhos-animados-homem-professor-na-lousa-ensinando-as-criancas-na-ilustracao-em-vetor-escola-sala-de-aula_53562-7922.jpg', 1, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_fk) VALUES ('Fórum', 'Tire suas dúvidas', 2, 'https://image.freepik.com/vetores-gratis/jovem-professor-dos-desenhos-animados-homem-professor-na-lousa-ensinando-as-criancas-na-ilustracao-em-vetor-escola-sala-de-aula_53562-7922.jpg', 2, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_fk) VALUES ('Lives', 'Lives exclusivas para a turma', 3, 'https://image.freepik.com/vetores-gratis/jovem-professor-dos-desenhos-animados-homem-professor-na-lousa-ensinando-as-criancas-na-ilustracao-em-vetor-escola-sala-de-aula_53562-7922.jpg', 0, 1);

INSERT INTO tb_section (title, description, position, img_Uri, resource_fk, prerequisite_fk) VALUES ('Capítulo 1', 'Neste capítulo vamos começar.', 1, 'https://image.freepik.com/vetores-gratis/jovem-professor-dos-desenhos-animados-homem-professor-na-lousa-ensinando-as-criancas-na-ilustracao-em-vetor-escola-sala-de-aula_53562-7922.jpg', 1, null);
INSERT INTO tb_section (title, description, position, img_Uri, resource_fk, prerequisite_fk) VALUES ('Capítulo 2', 'Neste capítulo vamos continuar.', 2, 'https://image.freepik.com/vetores-gratis/jovem-professor-dos-desenhos-animados-homem-professor-na-lousa-ensinando-as-criancas-na-ilustracao-em-vetor-escola-sala-de-aula_53562-7922.jpg', 1, 1);
INSERT INTO tb_section (title, description, position, img_Uri, resource_fk, prerequisite_fk) VALUES ('Capítulo 3', 'Neste capítulo vamos finalizar.', 3, 'https://image.freepik.com/vetores-gratis/jovem-professor-dos-desenhos-animados-homem-professor-na-lousa-ensinando-as-criancas-na-ilustracao-em-vetor-escola-sala-de-aula_53562-7922.jpg', 1, 2);

INSERT INTO tb_enrollment (user_id, offer_id, enroll_Moment, refund_Moment, avaliable, only_Update) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2020-11-20T13:00:00Z', null, true, false);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_Moment, refund_Moment, avaliable, only_Update) VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2020-11-20T13:00:00Z', null, true, false);