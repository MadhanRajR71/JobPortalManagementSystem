create database job_portal;
use job_portal;
CREATE TABLE users(

    user_id INT PRIMARY KEY,

    name VARCHAR(100),

    email VARCHAR(100),

    password VARCHAR(100),

    phone VARCHAR(15)

);
drop database job_portal;
create database if not exists job_portal;
use job_portal;
show tables;
describe users;
INSERT INTO users
VALUES (101, 'Madhan', 'madhan@gmail.com', '12345', '8500143981');
SELECT * FROM users;
CREATE TABLE jobs (
    job_id INT PRIMARY KEY,
    job_title VARCHAR(100),
    company_name VARCHAR(100),
    location VARCHAR(100),
    salary DOUBLE,
    description VARCHAR(255)
);
SELECT * FROM jobs;
