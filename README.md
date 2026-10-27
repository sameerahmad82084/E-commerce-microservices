# E-commerce-microservices
A Microservices-Based E-Commerce Backend built with Java and Spring Boot, featuring RESTful APIs, pagination, Redis caching, product and order management, and payment service integration. Designed for scalability, performance, and maintainability.
##  Features

- **Product Management:** Manages product information using the Product model.
- **Category Management:** Organizes products using the Category model.
- **Spring MVC Architecture:** Separates application logic into Controller, Service, and Repository layers.
- **Spring Security Integration:** Protects APIs using Spring Security.
- **OAuth 2.0 Integration:** Integrates with a separate Authentication and Authorization Service.
- **JWT Authentication:** Validates JWT access tokens issued by the Authentication Service.
- **Role-Based Authorization:** Controls access to protected endpoints based on user roles.
- **Issuer URI Configuration:** Uses the configured `issuer-uri` to identify the token issuer and configure JWT validation.
- **Database Integration:** Stores product and category data in MySQL.
- **Spring Data JPA and Hibernate:** Handles database operations and object-relational mapping.

##  Tech Stack

| Technology | Purpose |
|---|---|
| Java | Backend development |
| Spring Boot | Application development |
| Spring MVC | Application architecture |
| Spring Security | API security and authorization |
| OAuth 2.0 | Authorization framework integration |
| JWT | Access token format |
| Spring Data JPA | Database access |
| Hibernate | Object-relational mapping |
| MySQL | Relational database |
| Maven | Dependency management |
| Git & GitHub | Version control |

##  Architecture

The Product Service follows the MVC architecture and is responsible for product and category management. Authentication and authorization are handled by a separate service.

The application is organized into the following layers:

- **Controller Layer:** Handles incoming HTTP requests and API responses.
- **Service Layer:** Contains business logic for products and categories.
- **Repository Layer:** Performs database operations using Spring Data JPA.
- **Model Layer:** Defines product and category entities.
- **Security Layer:** Validates JWT access tokens and enforces access-control rules.

##  Authentication and Authorization Flow

1. The client authenticates with the separate Authentication and Authorization Service.
2. After successful authentication, the client obtains a JWT access token.
3. The client sends the token in the `Authorization` header when requesting protected Product Service APIs.
4. Spring Security validates the JWT using the configured `issuer-uri`.
5. Spring Security applies role-based authorization to determine whether the request is permitted.
6. If the token is valid and the user has the required permissions, the request proceeds to the appropriate controller.

**Note:** The Product Service acts as an OAuth 2.0 Resource Server when configured to validate JWT access tokens issued by the separate Authentication Service.

##  Database

The application uses **MySQL** as its relational database and **Spring Data JPA with Hibernate** to manage persistence.

The core domain models are:

- **Product:** Represents product information.
- **Category:** Represents product categories.

##  Author

Developed as a backend engineering project to practice REST API development, Spring Boot, database integration, and secure API access using Spring Security and OAuth 2.0.

