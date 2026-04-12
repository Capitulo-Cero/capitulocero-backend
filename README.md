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

('Crónica de una muerte anunciada', '978-0-307-47896-6', 1981, 'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSHd-HsdXLhG6ClnQVe0Dh_xa6ZbwG9rZ8amIicNhc9P-j76CPE0UqUNUhbNnVuLE4bSHte5sk_gFZ0z9D1wNbdsvbteYVx1LA61sRSdEUx&usqp=CAc
', 1),

('Don Quijote de la Mancha', '978-84-376-0494-7', 1605, 'https://m.media-amazon.com/images/I/91CIwR3QU1L._UF1000,1000_QL80_.jpg
', 2),

('Novelas ejemplares', '978-84-206-3518-1', 1613, 'https://m.media-amazon.com/images/I/41WKSXuB4US._SY445_SX342_ML2_.jpg
', 2),

('Ficciones', '978-84-206-1280-9', 1944, 'https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcQSrk3x_usS12qDSSPUlgL0ujqF2XtK52jlJq4S9XzYEQQ9ggMw07a8PYvcWWBZicYKmV-yTxym5-YbT3e5Q68no5dsBdnUDp0cu8d04QQf6O7jk7JaK_aK2ogDmtBBPP8ii6u846nb6w&usqp=CAc
', 3),

('El Aleph', '978-84-206-1281-6', 1949, 'https://m.media-amazon.com/images/I/81jFjE9rt6L._SY522_.jpg', 3),

('El jardín de senderos que se bifurcan', '978-84-206-1282-3', 1941, 'https://m.media-amazon.com/images/I/319wTiKxeVL._SY445_SX342_ML2_.jpg

', 3),

('La casa de los espíritus', '978-84-666-3810-9', 1982, 'https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcQHBiJwdNT-dDnAjo-jCMTJO4r02DbaR7g5DLbo2qEEZ6aYZyLO6EG64KkqfxRK26pAKWynhb_3UaMa-ne3V84HOEgn29HmO2DInUhl28rw4NKlfZgpEz-QTg&usqp=CAc
', 4),

('Eva Luna', '978-84-666-3811-6', 1987, 'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSoIt8_JlDl8YuCvcvxLoUe2nRR79GWq3ynklH1rABL6K1kKGA6Z3tHA9MjRmDpLEpmn_LD224sXqMF07_GJz1tAuYVF0LVDCbatPO8Uu4&usqp=CAc
', 4),

('Paula', '978-84-666-3812-3', 1994, 'https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcQsVKN9u53tX1MpP30BEAkkBkkQs3yeCKH9cmK99TItVrODOq3Q2O_z61Z1Vm8H3ungt7y0lzILUIIwdVukgVO-tskGsiv1xuGl5BP_GMOofIHuRyIE-56pFg&usqp=CAc
', 4),

('De amor y de sombra', '978-84-666-3813-0', 1984, 'https://m.media-amazon.com/images/I/81eibx1uOzL.jpg

', 4),

('La ciudad y los perros', '978-84-322-0597-1', 1963, 'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSMwAPoVEX6NFMBebnA0F_rFyZfMXSWxyaAZP2n67Nybja8nRfcxgqTdMsT80uJUPRo8jPseCvufgCPeb3D4Yb2xNGmrprzaye80egWFwK8&usqp=CAc', 5),

('La fiesta del chivo', '978-84-204-6131-2', 2000, 'https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcQqPFckCwh6F99r7nsaTe9vGXfrWSRF7V3-vOSHNb4TwGYsZl4ZnueLCaz1XO9UZnbUH235SJunah6hnkeSmEt2Ybv6IutoA_KyLOAWhKLy3rSAdm819LtbZw&usqp=CAc', 5),

('Conversación en La Catedral', '978-84-322-0598-8', 1969, 'https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcRrESiFZEjPp9IM2rF3wQw4DbV19B9wZ6swqj6vGD9hpavORfoI1X6rk8zKqGXhAPyVjcXavf-7n6M3X0HPvAcEEmdEpwqMU9J5ZRNyhtep&usqp=CAc', 5),

('Pantaleón y las visitadoras', '978-84-322-0599-5', 1973, 'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcTapuzJQEr-cTo-pg5W_X_zBY4OYgZQ6UTGdLUlvlrM3TPmpK08kZXrx0B36PUAKQnYzTe9nuNaC4qHYKVClhJvX3eFU_35xVZ-i2bj_g2BikSgfStExidV&usqp=CAc', 5),

('Orgullo y prejuicio', '978-84-376-0495-4', 1813, 'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQhAtQgoP43TaApcp06oXBux9loMguSsR5nTpEvHaIZ7jMzrCh2-bwbCEKDLjfYZd4w1k6L6i5ZQO3vhUyJfjHQ1J5ZA_zMfR2kVsK6NrQz&usqp=CAc', 7),

('Sentido y sensibilidad', '978-84-376-0496-1', 1811, 'https://m.media-amazon.com/images/I/61YTJ0aZ-WL._AC_UF1000,1000_QL80_.jpg', 7),

('Emma', '978-84-376-0497-8', 1815, 'https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSqlzOW3zR6DczXXFvUxezt68vKj0b4yPeF7X5xR4LA_0oIatlBXaiwT7oqQm4Hd41puNkzdloQpNhEwII4EsCUOyECEqY9RktpJQB2bog&usqp=CAc', 7),

('El viejo y el mar', '978-84-206-1286-1', 1952, 'https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcTi0mTOJV4hAhaAb5TDdkFPeGPKQbjGjoCUL8hqg3yhMU5PCyvHE2Sl5p6EH37ClVQta_CAeDtwoOQ5KX79dsmzSUIG8s4GqBdE_oTOf0fR&usqp=CAc', 8),

('Por quién doblan las campanas', '978-84-206-1287-8', 1940, 'https://m.media-amazon.com/images/I/81mKSI5fvOL._AC_UF1000,1000_QL80_.jpg', 8),

('Fiesta', '978-84-206-1288-5', 1926, 'https://m.media-amazon.com/images/I/61eLqPC3tEL._AC_UF1000,1000_QL80_.jpg', 8);

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
