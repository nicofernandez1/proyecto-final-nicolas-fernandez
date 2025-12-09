# Proyecto Final - Nicolás Fernández

API RESTful con Spring Boot para gestión de productos de un E-Commerce.

## 🚀 Tecnologías

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## 📋 Funcionalidades

- CRUD completo de productos
- Validación de datos con Bean Validation
- Manejo centralizado de excepciones
- Patrón MVC
- DTOs para transferencia de datos

## 🛠️ Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/productos` | Listar todos los productos |
| GET | `/api/productos/{id}` | Obtener un producto por ID |
| POST | `/api/productos` | Crear un nuevo producto |
| PUT | `/api/productos/{id}` | Actualizar un producto |
| DELETE | `/api/productos/{id}` | Eliminar un producto |

## 📦 Estructura del Proyecto
```
src/main/java/com/techlab/backend/
├── controller/
├── service/
├── repository/
├── mapper/
├── entity/
├── dto/
└── exception/
```

## 👤 Autor

**Nicolás Fernández**

---

*Proyecto final del curso de Spring Boot de Talento Tech*
