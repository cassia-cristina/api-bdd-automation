package bdd.automation.api.steps;

import bdd.automation.api.support.api.UserApi;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Config {
    private final UserApi userApi;

    public Config() {
        userApi = new UserApi();
    }

    @Before
    public void setup() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "http://localhost:12345";
        basePath = "/api/v3";

        requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization", getToken()).
                setContentType(ContentType.JSON).
                setRelaxedHTTPSValidation().
                build();
    }

    private String getToken() {
        return "grant acess";
    }

    @After("@deleteAllUsers")
    public void deleteAllUsers() {
        userApi.deleteAllUsers();
    }

}