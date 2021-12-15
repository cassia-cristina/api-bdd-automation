package bdd.automation.api.steps;

import bdd.automation.api.support.domain.User;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class UserStepsDefinitions {

    private static final String CREATE_USER_ENDPOINT = "/user";
    private Map<String, String> expectedUser = new HashMap<>();
    private User user;

    @Quando("faco um POST para {string} com os seguintes valores")
    public void facoUmPOSTParaComOsSeguintesValores(String endpoint, Map<String, String> user) {
        expectedUser = user;
        given().
                body(user).
        when().
                post(endpoint).
        then().
                statusCode(200);
    }

    @Entao("ao fazer um GET para {string} deve retornar o usuario criado")
    public void aoFazerUmGETParaUserCassiaDeveRetornarOUsuarioDeUsername(String endpoint) {
        when().
                get(endpoint).
        then().
                log().all().
                statusCode(200).
                body("username", is(expectedUser.get("username")));
    }


    @Quando("realizo o cadastro de um usuario")
    public void realizoOCadastroDeUmUsuario() {
        user = User.builder().build();
        given().
                body(user).
                when().
                post(CREATE_USER_ENDPOINT).
        then().
                statusCode(200);

    }
}
