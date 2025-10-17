CREATE DATABASE my_new_database;

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    nickname VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARBINARY(512) UNIQUE,
    phone VARBINARY(512),
    type VARCHAR(50) NOT NULL,
    date_of_birth VARBINARY(512),
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    code VARCHAR(50)
);