DROP TABLE IF EXISTS person;

--CREATE TABLE person  (
--    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
--    first_name VARCHAR(50),
--    last_name VARCHAR(50),
--    age INTEGER,
--    is_active BOOLEAN
--);


CREATE TABLE person  (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    uuid VARCHAR(255) DEFAULT NULL,
    first_name VARCHAR(255) DEFAULT NULL,
    last_name VARCHAR(255) DEFAULT NULL,
    age INT NOT NULL,
    is_active BOOLEAN DEFAULT NULL,
    date_created TIMESTAMP DEFAULT NULL,
    last_modified TIMESTAMP DEFAULT NULL
);