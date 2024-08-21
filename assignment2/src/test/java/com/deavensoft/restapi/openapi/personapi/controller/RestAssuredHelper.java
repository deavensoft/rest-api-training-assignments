package com.deavensoft.restapi.openapi.personapi.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.http.ContentType;

public class RestAssuredHelper {

    private static final String REST_API_URI = "/v1/persons";

    static void validatePersonExists(Integer id, String name, Integer age) {
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .get(REST_API_URI + "/{id}")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("name", equalTo(name))
                .body("age", equalTo(age));
    }

    static void validatePersonNotFound(Integer id) {
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .get(REST_API_URI + "/{id}")
                .then()
                .statusCode(404);
    }

    static void validatePersonDeleted(Integer id) {
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .delete(REST_API_URI + "/{id}")
                .then()
                .statusCode(204)
                .body(is(emptyString()));
    }

    static void validatePersonCreation(Integer id, String name, Integer age) {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("\"id\": ").append(id).append(",")
                .append("\"name\": \"").append(name).append("\",")
                .append("\"age\": ").append(age)
                .append("}");
        given()
                .contentType(ContentType.JSON)
                .body(sb.toString())
                .when()
                .post(REST_API_URI)
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", equalTo(name))
                .body("age", equalTo(age));
    }
}
