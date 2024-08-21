# Assignment 2: OpenAPI

The goal of this assignment is to try working with OpenAPI specifications, extend it and building server and client stubs based on the OpenAPI specification.

## Part 1
Extend the existing OpenAPI specification file `person-api.yml` with the additonal method.

 * Extend "src/main/resource/openapi/person-api.yml" OpenAPI specification with a new endpoint that allows to delete a person.
 * Re-generate the OpenAPI server code by running the maven goal "clean compile".
 * Add "target/generated-sources/openapi/src/main/java" to the source folders of the project.
 * Run again maven goal "clean compile" and make sure that the project compiles successfully.
 * Remove @Disabled annotation from the method void shouldAddAndDeleteAPerson(). Run the test - it should fail. Test can be run directly in IDE (`Assignment2ControllerTest`) or by running the maven goal "clean test".
 * Implement the new endpoint in the PersonApiController for deleting a person.
 * Run the test - it should pass.

## Part 2
From the extended `person-api.yml` OpenAPI specification file, create a Java client stub. There are different ways how to do this but you can use Generator Java JAR to create client files.

Command for generating Java client from the OpenAPI specification:
```shell
java -jar misc\openapi-generator-cli-7.8.0.jar generate -g java -o target\out -i src\main\resources\openapi\person-api.yaml --additional-properties=useJakartaEe=true
```

Open the generated project as a Maven project in IDE and implement a simple Example Java application (with a main() method) 
that will add a person to the REST API Server. 


```java

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PersonApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    PersonApi apiInstance = new PersonApi(defaultClient);
    Person person = new Person(); // Person | 
	// person.setId(...);
	// ...
    try {
      Person result = apiInstance.addPerson(person);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonApi#addPerson");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```


Then verify on the REST API server if the right Person object is added (e.g. via Postman).