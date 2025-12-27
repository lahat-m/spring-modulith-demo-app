# Spring Modulith Demo Project

A demonstration project showcasing **Spring Modulith** architecture patterns for building well-structured, modular monolithic applications with Spring Boot.

## Overview

This project implements a simple Employee Management System using Spring Modulith principles to demonstrate modular application architecture, clean boundaries between modules, and proper encapsulation of business logic as well document generation using Spring Modulith Documenter class.

## Technology Stack

- **Java 25** (with `void main` support)
- **Spring Boot 4.0.1**
- **Spring Modulith 2.0.1**
- **Spring Data JPA** with H2 Database
- **Spring Web MVC**
- **SpringDoc OpenAPI 3.0.0** for API documentation
- **Testcontainers** for integration testing
- **Maven** for build management

## Project Structure

```
src/main/java/com/lahat/springmodulith/
├── domain/                          # Domain module (business logic)
│   ├── dtos/                        # Data Transfer Objects
│   │   ├── EmployeeRequest.java
│   │   ├── EmployeeResponse.java
│   │   └── package-info.java        # Named interface for DTO exposure
│   ├── EmployeeEntity.java          # JPA entity
│   ├── EmployeeRepository.java      # Data access layer
│   ├── EmployeeService.java         # Business logic
│   └── EmployeeMapper.java          # Entity-DTO mapping
└── web/                             # Web module (API layer)
    └── EmployeeController.java      # REST controller
```

## Key Features

### Spring Modulith Architecture

- **Modular Structure**: Clear separation between `domain` and `web` modules
- **Named Interfaces**: Uses `@NamedInterface` annotation for explicit API exposure
- **Package-Protected Classes**: Enforces encapsulation (e.g., `EmployeeController` and `EmployeeRepository` are package-private)
- **Module Documentation**: Auto-generated module documentation in `target/spring-modulith-docs/`

### API Endpoints

Base URL: `/employees`
GET `/employees` Retrieve all employees
GET `/employees/{id}` Get employee by ID
POST `/employees` Create new employee

### Database

- **H2 In-Memory Database** for development and testing
- **H2 Console** enabled for database inspection
- **JPA/Hibernate** for ORM

## Getting Started

### Prerequisites

- Java 25 or later
- Maven 3.6+

### Running the Application

```bash
# Clone the repository
git clone git@github.com:lahat-m/spring-modulith-demo-app.git

# Navigate to project directory
cd spring-modulith

# Run the application
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

### Access Points

- **API Endpoints**: `http://localhost:8080/employees`
- **OpenAPI/Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **H2 Console**: `http://localhost:8080/h2-console`

## Testing

The project includes:

- **Unit Tests** with JUnit 5
- **Integration Tests** with Spring Boot Test
- **Testcontainers** support for realistic testing environments
- **Spring Modulith Tests** for module verification


Run tests:
```bash
./mvnw test
```

## Module Documentation

Spring Modulith automatically generates documentation for your modules during the build process. Generated documentation can be found in:

- **[all-docs.html](target/spring-modulith-docs/all-docs.html)** - Complete module documentation (HTML)
- `target/spring-modulith-docs/all-docs.docx` - Complete module documentation (Word)
- `target/spring-modulith-docs/*.adoc` - AsciiDoc format documentation
- `target/spring-modulith-docs/*.svg` - Module architecture diagrams

### Module Architecture Diagrams generated using Spring Modulith builtin documentation
![Component Overview](target/spring-modulith-docs/components.svg)

![Domain Module](target/spring-modulith-docs/module-domain.svg)

![Web Module](target/spring-modulith-docs/module-web.svg)

## Spring Modulith Concepts

### Module Boundaries

Each top-level package under `com.lahat.springmodulith` represents an application module:
- `domain` - Core business logic and data access
- `web` - REST API and presentation layer

### Named Interfaces

The project uses `@NamedInterface` to explicitly define which parts of a module can be accessed by other modules:

```java
@org.springframework.modulith.NamedInterface("domain-dtos")
package com.lahat.springmodulith.domain.dtos;
```

This ensures that only DTOs are exposed to other modules, while internal implementation details remain encapsulated.

### Verification

Spring Modulith automatically verifies:
- Module dependencies follow defined rules
- No cyclic dependencies between modules
- Only public APIs are accessed across module boundaries

## Building for Production

```bash
# Create executable JAR
./mvnw clean package

# Run the JAR
java -jar target/spring-modulith-0.0.1-SNAPSHOT.jar
```

## Development Notes

- **Package Naming**: The original package name `com.lahat.spring-modulith` was invalid (hyphens not allowed), so `com.lahat.springmodulith` is used instead
- **Java 25 Features**: Uses modern Java syntax including `void main` or `static void main` method
- **Code Style**: Follows Spring Boot best practices with constructor injection and immutable configurations

## References

- [Spring Modulith Documentation](https://docs.spring.io/spring-modulith/reference/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/4.0.1/reference/)
- [SpringDoc OpenAPI](https://springdoc.org/)

## Author

**Lahat Mariel**
GitHub: [@lahat-m](https://github.com/lahat-m)
Email: 67752087+lahatm.apach@gmail.com

## License

This project is a demonstration/learning project for Spring Modulith concepts.