# 📌 CRUD de Usuarios - Spring Boot + JPA + PostgreSQL

Este proyecto implementa un **CRUD de usuarios** utilizando **Java 21**, **Spring Boot**, **Spring Data JPA** y **PostgreSQL**.  
Forma parte de mi capacitación en **Coppel**, enfocado en el desarrollo backend con buenas prácticas de persistencia de datos.

---

## 🚀 Tecnologías
- ☕ Java 21  
- 🌱 Spring Boot  
- 🗄️ Spring Data JPA  
- 🐘 PostgreSQL  

---

## ⚙️ Requisitos previos
- Java 21  
- Maven 3+  
- PostgreSQL 14+  
- IDE recomendado: IntelliJ IDEA / VS Code / Eclipse  

---

## 📂 Estructura del proyecto

src/main/java/com/example/usuarios ├── controller   # Controladores REST ├── model        # Entidades JPA ├── repository   # Interfaces JPA └── service      # Lógica de negocio

---

## 🔧 Configuración

Editar el archivo `src/main/resources/application.properties` con tus credenciales de PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/usuarios_db
spring.datasource.username=postgres
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


---

▶️ Ejecución

Compilar y ejecutar el proyecto con Maven:

mvn spring-boot:run

La API estará disponible en:
👉 http://localhost:8080/api/usuarios


---

📌 Endpoints principales

Método	Endpoint	Descripción

GET	/api/usuarios	Listar todos los usuarios
GET	/api/usuarios/{id}	Obtener usuario por ID
POST	/api/usuarios	Crear un nuevo usuario
PUT	/api/usuarios/{id}	Actualizar usuario
DELETE	/api/usuarios/{id}	Eliminar usuario

---

📝 Licencia

Este proyecto se distribuye bajo la licencia MIT.

---