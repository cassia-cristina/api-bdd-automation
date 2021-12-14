package bdd.automation.api.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserStepsDefinitions {
    String uri;

    @Dado("que estou utilizando o servico {word}")
    public void queEstouUtilizandoOServicoHttpLocalhostApi(String uri) {
        this.uri = uri;
    }

    @Quando("faco um POST para {string} com os seguintes valores")
    public void facoUmPOSTParaComOsSeguintesValores(String endpoint, Map<String, String> user) {
        given()
            .contentType(ContentType.JSON)
            .body(user)
        .when()
            .post(uri + endpoint)
        .then()
            .contentType(ContentType.JSON)
            .statusCode(200);
    }

    @Entao("ao fazer um GET para \\/user\\/cassia deve retornar o usuario criado")
    public void aoFazerUmGETParaUserCassiaDeveRetornarOUsuarioCriado() {
    }
}
