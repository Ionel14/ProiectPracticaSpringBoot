CREATE TABLE team (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64),
    location VARCHAR(128),
    foundation_date DATE,
    coach VARCHAR(128),
    captain_id INT,
    league_name VARCHAR(40)
);

CREATE TABLE footballer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_team integer,
    firstname VARCHAR(64),
    lastname VARCHAR(64),
    birthday DATE,
    salary INT,
    field_position VARCHAR(2),
    FOREIGN KEY(id_team) REFERENCES team(id)

);

CREATE TABLE T_ROLE (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE T_USER (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);



