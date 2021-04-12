Gestor Juegos Grupo A04
===============================

Configuración
------------- 

**Base de datos**

Crear la base de datos y dar permisos al usuario por defecto

    CREATE DATABASE gestorjuegos;
    CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
    GRANT ALL ON gestorjuegos.* TO 'spq'@'localhost';

**Limpiar y compilar**

    mvn clean compile

**Creación de las tablas**

    mvn datanucleus:schema-create

**Lanzar los tests**

    mvn test

**Datos de prueba**

Se pueden introducir datos de prueba en la aplicación utilizando el comando de maven

    mvn exec:java -Pdatos

**Inicio del servidor**

El servidor REST de la aplicación se lanza utilizando el comando

    mvn exec:java -Pserver

Si el servidor ha sido iniciado correctamente se pueden obtener los datos de prueba accediendo con el navegador a la URL http://localhost:8080/gestorJuegos/serverResources.

**Inicio de la aplicación cliente**

    mvn exec:java -Pcliente
