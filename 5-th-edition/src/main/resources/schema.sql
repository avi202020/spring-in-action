DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id VARCHAR(250) PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  permissions VARCHAR(250) NOT NULL
);