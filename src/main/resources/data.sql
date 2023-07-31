INSERT INTO team (name, location, foundation_date, coach, captain_id, league_name)
VALUES ('Real Madrid FC', 'Madrid, Spain', '1902-03-06', 'Carlo Ancelotti', 1, 'La Liga');

insert into team(name, location, foundation_date, coach, captain_id, league_name)
values('Barcelona FC', 'Barcelona, Catalonia, Spain', '1899-11-29', 'Xavi Hernandez', 3, 'La Liga');

INSERT INTO footballer (id_team, firstname, lastname, birthday, salary, field_position)
VALUES (1, 'Sergio', 'Ramos', '1986-3-30', 40000, 'DF');

INSERT INTO footballer (id_team, firstname, lastname, birthday, salary, field_position)
VALUES (1, 'Karim', 'Benzema', '1987-12-19', 35000, 'FW');

INSERT INTO footballer (id_team, firstname, lastname, birthday, salary, field_position)
VALUES (2, 'Sergio', 'Busquets', '1988-7-16', 42000, 'MF');

INSERT INTO footballer (id_team, firstname, lastname, birthday, salary, field_position)
VALUES (2, 'Frenkie', 'De Jong', '1997-5-12', 37000, 'MF');

INSERT INTO T_ROLE (id, name)
VALUES (1, 'ADMIN');

INSERT INTO T_ROLE(id, name)
VALUES(2,'USER');

INSERT INTO T_USER (id,firstname, lastname, email, password)
VALUES (100, 'Ionel', 'Andrei', 'practicaibm2023@yahoo.com', '$2a$10$uGfMQ7.1vl9z4LaMiF8RxuQufWfx9.EHOT8D5VwJ5ahTtP0J.z0GO');





