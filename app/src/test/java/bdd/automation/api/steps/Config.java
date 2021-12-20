package bdd.automation.api.steps;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Config {

    @Before
    public void setup() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "http://localhost:12345";
        basePath = "/api/v3";

        requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization", getToken()).
                setContentType(ContentType.JSON).
                setRelaxedHTTPSValidation().build();

        responseSpecification = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).build();
    }

    private String getToken() {
        return "grant acess";
    }

}
