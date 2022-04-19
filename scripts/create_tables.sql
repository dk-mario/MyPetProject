CREATE TABLE roles
(
    id        serial PRIMARY KEY,
    name varchar(255) NOT NULL UNIQUE
);

INSERT INTO roles
values (1, 'SPECIALIST');
INSERT INTO roles
values (2, 'CLIENT');


CREATE TABLE users
(
    id         serial PRIMARY KEY,
    age        int4         NOT NULL,
    city       varchar(255) NOT NULL,
    login      varchar(255) NOT NULL UNIQUE,
    "name"     varchar(255) NOT NULL,
    "password" varchar(255) NOT NULL
);



CREATE TABLE users_roles
(
    user_id integer REFERENCES users (id),
    role_id integer REFERENCES roles (id),
    CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, role_id)
);