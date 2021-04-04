CREATE DATABASE gestorjuegos;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON gestorjuegos.* TO 'spq'@'localhost';