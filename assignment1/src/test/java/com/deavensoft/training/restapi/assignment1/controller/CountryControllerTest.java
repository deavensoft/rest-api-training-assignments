package com.deavensoft.training.restapi.assignment1.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CountryControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    void testCreateCountryAndFetch() {
        String countryId = createCountry("FR", "France");

        given()
                .get("/countries/{id}", countryId)
                .then()
                .statusCode(200)
                .body("name", equalTo("France"))
                .body("cities", hasSize(0));
    }

    @Test
    void testDeleteCountry() {
        String countryId = createCountry("DE", "Germany");

        given()
                .delete("/countries/{id}", countryId)
                .then()
                .statusCode(200);

        given()
                .get("/countries")
                .then()
                .statusCode(200)
                .body("$", not(hasItem(hasEntry("name", "Germany"))));
    }

    @Test
    void testAddCityToCountry() {
        String countryId = createCountry("IT", "Italy");

        String cityJson = """
            {
                "zip": "00100",
                "name": "Rome"
            }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(cityJson)
                .post("/countries/{countryId}/cities", countryId)
                .then()
                .statusCode(200)
                .body("name", equalTo("Rome"));

        given()
                .get("/countries/{id}", countryId)
                .then()
                .statusCode(200)
                .body("name", equalTo("Italy"))
                .body("cities", hasSize(1))
                .body("cities[0].name", equalTo("Rome"));
    }

    @Test
    void testRemoveCityFromCountry() {
        String countryJson = """
            {
                "code": "ES",
                "name": "Spain",
                "cities": [
                    {
                        "zip": "28001",
                        "name": "Madrid"
                    },
                    {
                        "zip": "08001",
                        "name": "Barcelona"
                    }
                ]
            }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(countryJson)
                .post("/countries")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String countryId = response.jsonPath().getString("id");
        String cityId = response.jsonPath().getString("cities[0].id");

        given()
                .delete("/countries/{countryId}/cities/{cityId}", countryId, cityId)
                .then()
                .statusCode(200);

        given()
                .get("/countries/{id}", countryId)
                .then()
                .statusCode(200)
                .body("cities", hasSize(1))
                .body("cities[0].name", equalTo("Barcelona"));
    }

    private String createCountry(String code, String name) {
        String countryJson = String.format("""
            {
                "code": "%s",
                "name": "%s"
            }
        """, code, name);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(countryJson)
                .post("/countries")
                .then()
                .statusCode(200)
                .extract()
                .response();

        return response.jsonPath().getString("id");
    }
}