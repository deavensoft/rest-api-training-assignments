# **Assignment 1: Implement REST Controller Methods in a Spring Boot Application**

## **Project Overview**
You are provided with a Spring Boot 3 application that manages countries and their corresponding cities. The project uses the following technologies:
- **Spring Boot 3** for the application framework.
- **Spring Data JPA** for database interaction.
- **H2 Database** as the in-memory database for persistence.
- **RESTful APIs** are exposed using Spring's `@RestController`.

The project consists of two main entities:
- **Country**: Represents a country with fields like `UUID id`, `String code`, `String name`, and a list of associated `City` objects.
- **City**: Represents a city with fields like `UUID id`, `String zip`, and `String name`.

## **What’s Already Implemented**
1. **Entities**: `Country` and `City` classes are defined and annotated with JPA annotations.
2. **Repositories**: `CountryRepository` and `CityRepository` interfaces extend `JpaRepository`, providing basic CRUD operations.
3. **Service Layer**: The `CountryService` class contains methods to:
    - Retrieve all countries.
    - Retrieve a specific country by its ID.
    - Create, update, and delete a country.
    - Add a city to a country.
    - Remove a city from a country.
4. **Controller Layer**: The `CountryController` class exposes RESTful endpoints to:
    - Retrieve all countries.
    - Retrieve a specific country by its ID.
    - Create, update, and delete a country.

However, **two methods have been intentionally removed** from the controller class:
- `addCityToCountry()`
- `removeCityFromCountry()`

## **Your Task**
You need to implement the following two methods in the `CountryController` class:

1. **`addCityToCountry()`**:
    - **Endpoint**: `/countries/{countryId}/cities`
    - **HTTP Method**: Use the proper HTTP method for adding a new resource.
    - **Description**: This method should add a new city to an existing country. It should accept the `UUID` of the country as a path variable and the `City` object in the request body.
    - **Service Method to Use**: `countryService.addCityToCountry(UUID countryId, City city)`

2. **`removeCityFromCountry()`**:
    - **Endpoint**: `/countries/{countryId}/cities/{cityId}`
    - **HTTP Method**: Use the proper HTTP method for deleting a resource.
    - **Description**: This method should remove an existing city from a country. It should accept the `UUID` of the country and the `UUID` of the city as path variables.
    - **Service Method to Use**: `countryService.removeCityFromCountry(UUID countryId, UUID cityId)`

3. Run `CountryControllerTest` to verify if the implemented methods are working as expected.

# Other Hints
You can also run the application and test the endpoints using Swagger UI. The Swagger UI,
as well as the H2 database console, to see the data in the in-memory database.

However, note that the database is in-memory, so the data will be lost once the application is stopped.

## Running the application
The Spring Boot application can be run using the main method in the main class 
annotated with `@SpringBootApplication`. That class is `Assignment1RestapiApplication`.

## Accessing Swagger UI
You can access the Swagger UI at http://localhost:8080/swagger-ui.html after running the application.

## Accessing the in-memory database
You can access the H2 console at http://localhost:8080/h2-console/ after running the application. 
Use the connection settings as defined in application.yml (username: `sa`; password: `password`).