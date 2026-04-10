# 📚 Library Backend API

Backend REST para la gestión de una biblioteca (autores y libros), desarrollado con **Java + Spring Boot**. Permite realizar operaciones CRUD completas sobre ambas entidades.

---

## 🚀 Stack Tecnológico

- ☕ Java 17+
- 🌱 Spring Boot 3.3.4
- 🌐 Spring Web
- 🗄️ Spring Data JPA
- 🐬 MySQL
- 📦 Maven

---

## 📁 Estructura del Proyecto

```bash
src/main/java/com/factoriaf5/library
├── controller   # Controladores REST
├── dto          # Objetos de transferencia de datos
├── exception    # Manejo de errores
├── model        # Entidades JPA
├── repository   # Interfaces de acceso a datos
└── service      # Lógica de negocio

```
## 🛠️ Configuración de Base de Datos

1️⃣ Crear la base de datos

CREATE DATABASE IF NOT EXISTS library_db;
USE library_db;

2️⃣ Datos iniciales
---
-- Authors
INSERT INTO authors (name, last_name, nationality, birth_year, is_alive)
VALUES 

('Gabriel', 'García Márquez', 'Colombiano', 1927, 0),

('Miguel', 'de Cervantes', 'Español', 1547, 0),

('Jorge Luis', 'Borges', 'Argentino', 1899, 0),

('Isabel', 'Allende', 'Chilena', 1942, 1),

('Mario', 'Vargas Llosa', 'Peruano', 1936, 0),

('Frank', 'Kafka', 'Checo', 1883, 0),

('Jane', 'Austen', 'Británica', 1775, 0),

('Ernest', 'Hemingway', 'Estadounidense', 1899, 0);

---
-- Books
INSERT INTO books (title, isbn, publication_year, image, author_id)
VALUES 

('Cien años de soledad', '978-0-06-088328-7', 1967, 'https://covers.openlibrary.org/b/isbn/9780060883287-L.jpg', 1),

('El amor en los tiempos del cólera', '978-0-307-38987-8', 1985, 'https://covers.openlibrary.org/b/isbn/9780307389878-L.jpg', 1),

('Crónica de una muerte anunciada', '978-0-307-47896-6', 1981, 'https://covers.openlibrary.org/b/isbn/9780307478962-L.jpg', 1),

('Don Quijote de la Mancha', '978-84-376-0494-7', 1605, 'https://covers.openlibrary.org/b/isbn/9788437604947-L.jpg', 2),

('Novelas ejemplares', '978-84-206-3518-1', 1613, 'https://covers.openlibrary.org/b/isbn/9788420635187-L.jpg', 2),

('Ficciones', '978-84-206-1280-9', 1944, 'https://covers.openlibrary.org/b/isbn/9788420612805-L.jpg', 3),

('El Aleph', '978-84-206-1281-6', 1949, 'https://covers.openlibrary.org/b/isbn/9788420612812-L.jpg', 3),

('El jardín de senderos que se bifurcan', '978-84-206-1282-3', 1941, 'https://covers.openlibrary.org/b/isbn/9788420612829-L.jpg', 3),

('La casa de los espíritus', '978-84-666-3810-9', 1982, 'https://covers.openlibrary.org/b/isbn/9788466638104-L.jpg', 4),

('Eva Luna', '978-84-666-3811-6', 1987, 'https://covers.openlibrary.org/b/isbn/9788466638111-L.jpg', 4),

('Paula', '978-84-666-3812-3', 1994, 'https://covers.openlibrary.org/b/isbn/9788466638128-L.jpg', 4),

('De amor y de sombra', '978-84-666-3813-0', 1984, 'https://covers.openlibrary.org/b/isbn/9788466638135-L.jpg', 4),

('La ciudad y los perros', '978-84-322-0597-1', 1963, 'https://covers.openlibrary.org/b/isbn/9788432205972-L.jpg', 5),

('La fiesta del chivo', '978-84-204-6131-2', 2000, 'https://covers.openlibrary.org/b/isbn/9788420461311-L.jpg', 5),

('Conversación en La Catedral', '978-84-322-0598-8', 1969, 'https://covers.openlibrary.org/b/isbn/9788432205989-L.jpg', 5),

('Pantaleón y las visitadoras', '978-84-322-0599-5', 1973, 'https://covers.openlibrary.org/b/isbn/9788432205996-L.jpg', 5),

('Orgullo y prejuicio', '978-84-376-0495-4', 1813, 'https://covers.openlibrary.org/b/isbn/9788437604954-L.jpg', 7),

('Sentido y sensibilidad', '978-84-376-0496-1', 1811, 'https://covers.openlibrary.org/b/isbn/9788437604961-L.jpg', 7),

('Emma', '978-84-376-0497-8', 1815, 'https://covers.openlibrary.org/b/isbn/9788437604978-L.jpg', 7),

('El viejo y el mar', '978-84-206-1286-1', 1952, 'https://covers.openlibrary.org/b/isbn/9788420612867-L.jpg', 8),

('Por quién doblan las campanas', '978-84-206-1287-8', 1940, 'https://covers.openlibrary.org/b/isbn/9788420612874-L.jpg', 8),

('Fiesta', '978-84-206-1288-5', 1926, 'https://covers.openlibrary.org/b/isbn/9788420612881-L.jpg', 8);

---

## ⚙️ Configuración de la Aplicación

spring.datasource.url=jdbc:mysql://localhost:3306/library_db

spring.datasource.username=${DB_USERNAME:root}

spring.datasource.password=${DB_PASSWORD:}

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.open-in-view=false

---

▶️ Cómo Ejecutar el Proyecto
IntelliJ IDEA

Abrir el proyecto desde pom.xml

Configurar SDK en Java 17+

Ejecutar LibraryApplication

Terminal

mvn spring-boot:run

---

## 📡 API Endpoints

| Método | Endpoint        | Descripción               |
| ------ | --------------- | ------------------------- |
| GET    | `/authors`      | Obtener todos los autores |
| GET    | `/authors/{id}` | Obtener autor por ID      |
| POST   | `/authors`      | Crear autor               |
| PUT    | `/authors/{id}` | Actualizar autor          |
| DELETE | `/authors/{id}` | Eliminar autor            |

---
## Request Body

{

  "name": "Gabriel",
  
  "lastName": "García Márquez",
  
  "nationality": "Colombiano",
  
  "birthYear": 1927,
  
  "isAlive": false
  
}

---

## 📖 Books

| Método | Endpoint      | Descripción              |
| ------ | ------------- | ------------------------ |
| GET    | `/books`      | Obtener todos los libros |
| GET    | `/books/{id}` | Obtener libro por ID     |
| POST   | `/books`      | Crear libro              |
| PUT    | `/books/{id}` | Actualizar libro         |
| DELETE | `/books/{id}` | Eliminar libro           |

---

## Request Body

{

  "title": "Cien años de soledad",
  
  "isbn": "978-0-06-088328-7",
  
  "publicationYear": 1967,
  
  "image": "https://covers.openlibrary.org/b/isbn/9780060883287-L.jpg",
  
  "authorId": 1
  
}

---

## Response

{

  "id": 1,
  
  "title": "Cien años de soledad",
  
  "isbn": "978-0-06-088328-7",
  
  "publicationYear": 1967,
  
  "image": "https://covers.openlibrary.org/b/isbn/9780060883287-L.jpg",
  
  "authorName": "Gabriel",
  
  "authorLastName": "García Márquez"
  
}

---

## ⚠️ Manejo de Errores
400 Bad Request → Datos inválidos
404 Not Found → Recurso no encontrado

---

## 🌐 Repositorio

https://github.com/Capitulo-Cero/capitulocero-backend

---

## ✨ Mejoras Futuras

🔐 Autenticación (Spring Security)

📄 Paginación y filtros

🧪 Tests unitarios

📚 Swagger / OpenAPI

🐳 Docker

----

---

---

## 👨‍💻 Equipo de Desarrollo

<div align="center">

| 👤 | Nombre | Rol | GitHub |
|----|--------|-----|--------|
| 🧑‍💻 | **Adrián Baeza** | Developer | [@Adrian-1986](https://github.com/Adrian-1986) |
| 👩‍💻 | **Alba Ganduxé** | Product Owner | [@AlbaGG95](https://github.com/AlbaGG95) |
| 👩‍💻 | **Ana Morandeira** | Developer | [@ana-morandeira](https://github.com/ana-morandeira) |
| 🧑‍💻 | **Xabier Piñeiro** | Developer | [@gzifoto-spec](https://github.com/gzifoto-spec) |
| 👩‍💻 | **María Regueiro** | Scrum Master | [@Mariaregue-spec](https://github.com/Mariaregue-spec) |

</div>

---
