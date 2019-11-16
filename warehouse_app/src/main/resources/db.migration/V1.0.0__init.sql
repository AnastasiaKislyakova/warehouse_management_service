CREATE SCHEMA IF NOT EXISTS warehouse_management;

CREATE TABLE  IF NOT EXISTS warehouse_management.items
(
  id           SERIAL NOT NULL PRIMARY KEY,
  name         VARCHAR(100) NOT NULL,
  amount       INTEGER check (amount >= 0) NOT NULL,
  price        BIGINT check (amount >= 0) NOT NULL
);