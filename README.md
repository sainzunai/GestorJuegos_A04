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

**Lanzar los tests unitarios**

Estos son los test unitarios de las clases con funcionalidad lógica, se expluyen ventanas, servidor y BD

    mvn test

**Jacoco**
  
Para comprobar Jacoco hay que ir a la carpeta correspondiente de descarga y seguir este path:
	
	..\GestorJuegos_A04\target\site\jacoco

Una vez en esa carpeta abrir el archivo con nombre index.
    
**Enhance de las clases para JDO**

    mvn datanucleus:enhance   

**Creación de las tablas**

    mvn datanucleus:schema-create

**Datos de prueba**

Se pueden introducir datos de prueba en la aplicación utilizando el comando de maven

    mvn exec:java -Pdatos
    
**Lanzar los tests de ventanas**

Una vez creado el server e introducidos los datos en BD, podemos lanzar los test de ventanas

    mvn verify -Pventanas

**Lanzar los tests de integración**

Estos son los test de integración y de performance para probar el servidor y la BD

    mvn verify -Pintegracion

**Contiperf**

Para acceder a los resultados de los test seguir el siguiente path:

	..\GestorJuegos_A04\target\contiperf-report

**Maven Site**

Se puede generar el site del proyecto con un resumen de todos los tests con

	mvn site

Luego se accederá a la carpeta ubicada en:

	..\GestorJuegos_A04\target\site

Una vez en esa carpeta abrir el archivo con nombre index.

**Inicio del servidor**

El servidor REST de la aplicación se lanza utilizando el comando

    mvn exec:java -Pserver

Si el servidor ha sido iniciado correctamente se pueden obtener los datos de prueba accediendo con el navegador a la URL http://localhost:8080/gestorJuegos/serverResources.

**Inicio de la aplicación cliente**

    mvn exec:java -Pcliente

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sainzunai_GestorJuegos_A04&metric=alert_status)](https://sonarcloud.io/dashboard?id=sainzunai_GestorJuegos_A04)
