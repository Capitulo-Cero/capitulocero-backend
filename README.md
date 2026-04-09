# Library Backend

Backend REST para gestión de biblioteca con autores y libros, desarrollado con Java, Spring Boot, Maven y MySQL.

## Estado del ejercicio

El backend solicitado en el enunciado está completado:
- CRUD completo de `Author`
- CRUD completo de `Book`
- Relación `OneToMany` (`Author`) y `ManyToOne` (`Book`)
- Persistencia en MySQL con Spring Data JPA/Hibernate
- Arquitectura MVC por capas (`model`, `repository`, `service`, `controller`)
- Manejo básico de errores con `404` para recursos inexistentes

## Stack técnico

- Java 17+
- Spring Boot 3.3.4
- Spring Web
- Spring Data JPA
- MySQL Driver
- Maven

## Estructura del proyecto

```text
src/main/java/com/factoriaf5/library
├── controller
├── dto
├── exception
├── model
├── repository
└── service
```

## Configuración de base de datos (MySQL Workbench)

### 1) Crear conexión en Workbench

1. Abrir MySQL Workbench.
2. En `MySQL Connections`, pulsar `+`.
3. Configurar:
   - `Connection Name`: `Local MySQL`
   - `Hostname`: `localhost`
   - `Port`: `3306`
   - `Username`: `root`
4. Guardar contraseña en `Store in Vault...`.
5. Pulsar `Test Connection` y luego `OK`.

### 2) Crear la base de datos `library_db`

Ejecutar en una pestaña SQL:

```sql
CREATE DATABASE IF NOT EXISTS library_db;
USE library_db;
```

### 3) Verificar que existe

```sql
SHOW DATABASES LIKE 'library_db';
```

También puedes refrescar el panel `SCHEMAS` y comprobar que aparece `library_db`.

## Configuración de la aplicación

Archivo: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

No se guarda ninguna contraseña real en el repositorio.  
Define variables de entorno antes de arrancar:

PowerShell:

```powershell
$env:DB_USERNAME="root"
$env:DB_PASSWORD="TU_PASSWORD"
```

## Cómo levantar el proyecto

### IntelliJ IDEA

1. Abrir el proyecto desde `pom.xml`.
2. Asegurar SDK de proyecto en Java 17+.
3. Ejecutar `LibraryApplication`.

### Maven (terminal)

```bash
mvn spring-boot:run
```

## Endpoints

### Authors

- `GET /authors`
- `GET /authors/{id}`
- `POST /authors`
- `PUT /authors/{id}`
- `DELETE /authors/{id}`

Body ejemplo (`POST`/`PUT`):

```json
{
  "name": "Gabriel",
  "lastName": "Garcia Marquez",
  "nationality": "Colombian",
  "birthYear": 1927,
  "isAlive": false
}
```

### Books

- `GET /books`
- `GET /books/{id}`
- `POST /books`
- `PUT /books/{id}`
- `DELETE /books/{id}`

Body ejemplo (`POST`/`PUT`):

```json
{
  "title": "Cien años de soledad",
  "isbn": "9780307474728",
  "publicationYear": 1967,
  "image": "https://example.com/book.jpg",
  "authorId": 1
}
```

## Respuestas de error

- `404 Not Found` cuando el `author` o `book` no existe.
- `400 Bad Request` para errores básicos de integridad de datos.

## Repositorio remoto

Repositorio objetivo:

`https://github.com/Capitulo-Cero/capitulocero-backend`
