package com.deavensoft.restapi.openapi.personapi.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

/**
 * ASSIGNMENT:
 * 1. Extend "src/main/resource/openapi/person-api.yml" OpenAPI specification with
 *    a new endpoint that allows to delete a person.
 * 2. Re-generate the OpenAPI server code by running the maven goal "clean compile".
 * 3. Add "target/generated-sources/openapi/src/main/java" to the source folders of the project.
 * 4. Run again maven goal "clean compile" and make sure that the project compiles successfully.
 * 5. Remove @Disabled annotation from the method void shouldAddAndDeleteAPerson().
 *    Run the test - it should fail. Test can be run directly in IDE or by running the maven goal "clean test".
 * 6. Implement the new endpoint in the PersonApiController for deleting a person.
 * 7. Run the test - it should pass.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Assignment2ControllerTest {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    @Disabled
    void shouldAddAndDeleteAPerson(){
        RestAssuredHelper.validatePersonCreation(1, "Petar Peric", 31);
        RestAssuredHelper.validatePersonExists(1, "Petar Peric", 31);
        RestAssuredHelper.validatePersonDeleted(1);
        RestAssuredHelper.validatePersonNotFound(1);
    }


}