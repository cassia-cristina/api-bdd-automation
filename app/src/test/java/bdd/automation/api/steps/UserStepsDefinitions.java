package bdd.automation.api.steps;

import bdd.automation.api.support.api.UserApi;
import bdd.automation.api.support.domain.User;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserStepsDefinitions {

    private User expectedUser;
    private final UserApi userApi;

    public UserStepsDefinitions() {
        userApi = new UserApi();
    }

    @Quando("realizo o cadastro de um usuario")
    public void realizoOCadastroDeUmUsuario() {
        expectedUser = User.builder().build();
        userApi.createUser(expectedUser);
    }

    @Entao("o usuario deve ser salvo")
    public void oUsuarioDeveSerSalvo() {
        String actualUsername = userApi.getUserName(expectedUser);
        assertThat(actualUsername, is(expectedUser.getUsername()));
    }

}