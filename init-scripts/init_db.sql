-- Terminate connections to the 'people_db' database
SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'people_db'
  AND pid <> pg_backend_pid();

-- Drop the database if it already exists
DROP DATABASE IF EXISTS people_db;

-- Create the new database
CREATE DATABASE people_db;

-- Connect to the people_db database
\c people_db;

-- Create the people table
CREATE TABLE people (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    email VARCHAR
);

insert into people(id, name, email) values(1, 'John Smith', 'john.smith@gmail.com');
insert into people(id, name, email) values(2, 'Jane Smith', 'jane.smith@gmail.com');