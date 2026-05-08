# QuantityMeasurementSpring
QUANTITY MEASUREMENT APPLICATION


OVERVIEW

The Quantity Measurement Application is a Spring Boot REST API service designed to handle various unit conversions and quantity measurements. This application provides endpoints to convert between different measurement units, perform calculations, and manage measurement data efficiently.

FEATURES

- RESTful API endpoints for unit conversions
- Support for multiple measurement units (length, weight, volume, temperature)
- Data validation and error handling
- JPA/Hibernate ORM for database operations
- H2 database support for development
- Comprehensive exception handling
- DTO-based request/response handling
- Service layer architecture

TECHNOLOGY STACK

- Java 17 or higher
- Spring Boot 3.0+
- Spring Data JPA
- Hibernate ORM
- H2 Database
- Maven
- Springdoc OpenAPI for API documentation
- JUnit for testing
- Spring Test

PREREQUISITES

Before running this application, ensure you have the following installed:

- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6 or higher
- Git

INSTALLATION

Step 1: Clone the Repository

Navigate to the project directory and clone the repository using Git.

Step 2: Install Dependencies

Open a command prompt or terminal in the project directory and run:

mvn clean install

This command will download all required dependencies and build the project.

RUNNING THE APPLICATION

To start the application, use one of the following methods:

Method 1: Using Maven

mvn spring-boot:run

Method 2: Running the JAR File

First, build the project:

mvn clean package

Then run the JAR file:

java -jar quantitymeasurement/target/quantitymeasurement-0.0.1-SNAPSHOT.jar

The application will start on http://localhost:8080 by default.

PROJECT STRUCTURE

quantitymeasurement/
- src/main/java/com/example/quantitymeasurement/
  - QuantitymeasurementApplication.java: Main Spring Boot application class
  - controller/: REST API controllers
  - service/: Business logic and service layer
  - repository/: Data access layer using Spring Data JPA
  - entity/: JPA entity classes
  - dto/: Data Transfer Objects
  - model/: Model classes
  - payload/: Request and response payload classes
  - exception/: Custom exception classes
  - handler/: Global exception handler
  - enums/: Enumeration classes
  
- src/main/resources/
  - application.properties: Application configuration
  
- src/test/: Unit and integration tests

CONFIGURATION

The application can be configured via the application.properties file located in src/main/resources/. Key configurations include:

- server.port: Port on which the application runs (default: 8080)
- spring.datasource.url: Database connection URL
- spring.datasource.username: Database username
- spring.datasource.password: Database password
- spring.jpa.hibernate.ddl-auto: Hibernate DDL strategy (create, update, validate)

RUNNING TESTS

To run the test suite, execute:

mvn test

All unit tests and integration tests will be executed, and a test report will be generated.

API ENDPOINTS

The application exposes various REST endpoints for unit conversions and quantity measurements. Use tools like Postman or cURL to interact with the API.

For API documentation, visit: http://localhost:8080/swagger-ui/api-docs when the application is running.

DATABASE

The application uses H2 database by default for development and testing. The H2 console can be accessed at http://localhost:8080/h2-console.

H2 Console Login Credentials

- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: (leave blank)

BUILD AND DEPLOYMENT

To build the application for production:

mvn clean package

This generates a JAR file in the target directory that can be deployed to any server with Java installed.

TROUBLESHOOTING

Port Already in Use:
If port 8080 is already in use, change it in application.properties:
server.port=8081

Database Connection Issues:
Verify that the database configuration in application.properties is correct.

Maven Dependencies Not Downloaded:
Run mvn clean install -U to force update of all dependencies.

BUILD INFORMATION

- Maven Group ID: com.example
- Maven Artifact ID: quantitymeasurement
- Java Version: 17+
- Spring Boot Version: 3.0+

CONTRIBUTING

Contributions are welcome. Please follow these guidelines:

1. Fork the repository
2. Create a feature branch for your changes
3. Commit your changes with clear messages
4. Push your branch and create a pull request

CODE STYLE

Follow standard Java coding conventions:
- Use camelCase for variable and method names
- Use PascalCase for class names
- Add comments for complex logic
- Keep methods focused and single-responsibility



Version 1.0.0 (Initial Release)
- Initial project setup
- Core REST API endpoints
- Unit conversion functionality
- Database integration
- API documentation
