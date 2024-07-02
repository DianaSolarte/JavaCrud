# API de Gestión de Clientes

Este proyecto es una API de gestión de clientes desarrollada con Java y Spring Boot como parte de una prueba técnica para el proceso de selección de instructor/a líder del programa Full Stack Java. La API permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre una entidad Cliente.

# Descripción

La API proporciona los siguientes endpoints:

- GET /api/v1/clients: Obtiene una lista de todos los clientes.
- GET /api/v1/clients/{clientId}: Obtiene un cliente específico por su ID.
- POST /api/v1/clients: Agrega un nuevo cliente.
- DELETE /api/v1/clients/{clientId}: Elimina un cliente por su ID.

# Características

1. *Creación de API*: Desarrollada usando Java, Spring Boot y una base de datos MySQL.
2. *Almacenamiento en Base de Datos*: Utiliza MySQL para almacenar toda la información necesaria.
3. *Definición de la entidad Cliente*: Utiliza JPA para definir la entidad Cliente con sus atributos y configuraciones de persistencia.
4. *Repositorio de Cliente*: Implementa un repositorio de Spring Data JPA para realizar operaciones básicas de persistencia.
5. *Servicio de Cliente*: Maneja las operaciones CRUD encapsulando la lógica de negocio y gestionando excepciones.
6. *Controlador REST para Cliente*: Expone endpoints para las operaciones CRUD del servicio de Cliente.
7. *Documentación*: La API está documentada utilizando Swagger.
8. *Scripts SQL*: El proyecto incluye la configuración para la creación automática de tablas al ejecutar el proyecto.
9. *Scripts de Base de Datos*: Incluye datos iniciales necesarios para ejecutar las APIs en su primer uso.
10. *Pruebas Unitarias*: Incluye pruebas unitarias para confirmar el correcto funcionamiento del API.
11. *Repositorio Público*: El proyecto está subido a un repositorio público en GitHub para su evaluación.

# Documentación de Swagger

La API está documentada con Swagger. Puedes acceder a la documentación completa de la API en:
bash
http://localhost:8080/swagger-ui.html

# Scripts SQL
Incluye los siguientes scripts de base de datos para inicializar la información:
bash
sql
CREATE TABLE tbl_clients (
    client_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(255)
);

INSERT INTO tbl_clients (name, email, phone, address, city) VALUES
('Sofia Arroyos', 'sofiaarroyos@bit.com', '3215673499', 'Calle 123 #12-43', 'Argentina'),
('Deissy Johanna Católico Garzón', 'coordinacion.proyectos@bit.institute', '3114418656', 'cra 13 #54-55 ofi. 420', 'Colombia'),
('Diana Solarte', 'dianasolartem@gmail.com', '312345656', 'calle 123', 'Bogotá');

# Configuración del Proyecto CRUD con Spring Boot
Este proyecto utiliza Maven para gestionar las dependencias y construir el proyecto.

# Dependencias Principales
El archivo pom.xml especifica las siguientes dependencias:
1. *spring-boot-starter-parent:*  Define la configuración base para aplicaciones Spring Boot, facilitando la gestión de versiones compatibles con Spring Boot.
 
2. *spring-boot-starter-data-jpa:* Proporciona soporte para integración de datos usando JPA (Java Persistence API) con Spring Boot, simplificando las operaciones CRUD y la persistencia de datos.

3. *spring-boot-starter-web:* Habilita el desarrollo de aplicaciones web utilizando Spring MVC y otros componentes web de Spring Boot.

### Dependencias para Documentación y API
1. *springdoc-openapi-starter-webmvc-ui:* Facilita la generación de documentación de API utilizando OpenAPI 3 con Spring Web MVC, incluyendo una interfaz de usuario para interactuar con la documentación generada.
### Dependencias de Base de Datos
1. *mysql-connector-j:* Conector JDBC para MySQL, necesario para integrar la base de datos MySQL con la aplicación Spring Boot.
### Dependencias de Testing
1. *spring-boot-starter-test:* Proporciona soporte para pruebas unitarias y de integración en aplicaciones Spring Boot.
### Dependencias Opcionales
1. *lombok:* Biblioteca que simplifica la escritura de código eliminando la necesidad de escribir métodos getters, setters y constructores estándar.
### Configuración del Build
El plugin *spring-boot-maven-plugin* se utiliza para empaquetar la aplicación como un JAR ejecutable e incluir configuraciones adicionales, como la exclusión de dependencias específicas durante el empaquetado.


# Requisitos
*Java 17 (o superior)* debe estar instalado y configurado en tu entorno de desarrollo.
## Construcción y Ejecución
Para construir el proyecto, ejecuta el siguiente comando:

bash
mvn clean install

Esto compilará el proyecto y empaquetará la aplicación. Luego, para ejecutar la aplicación Spring Boot, utiliza:

bash
java -jar target/crud-0.0.1-SNAPSHOT.jar

Asegúrate de tener una instancia de MySQL en ejecución con la base de datos configurada según los parámetros especificados en la aplicación.
