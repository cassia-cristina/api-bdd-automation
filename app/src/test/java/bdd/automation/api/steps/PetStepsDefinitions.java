package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import bdd.automation.api.support.domain.Pet;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetStepsDefinitions {
    private final PetApi petApi;
    private List<Pet> actualPets;
    private Response actualPetsResponse;

    public PetStepsDefinitions() {
        petApi = new PetApi();
    }

    @Dado("que eu possua animais {word}")
    public void queEuPossuaAnimaisAvailable(String status) {
    }

    @Quando("eu pesquiso por todos os animais {word}")
    public void euPesquisoPorTodosOsAnimaisAvailable(String status) {
        actualPets = petApi.getPetsByStatus(status);
        actualPetsResponse = petApi.getPetsResponseByStatus(status);

        boolean statusEsperado = true;
        for(Pet pets : actualPets) {
            if(!pets.getStatus().equals(status)) {
                statusEsperado = false;
            }
        }
        assertThat(statusEsperado,is(true));
    }

    @Entao("eu recebo a lista de animais available")
    public void euReceboAListaDeAnimaisAvailable() {
        assertThat(actualPets, is(not(empty())));
    }

    @Entao("eu recebo a lista com {} animal/animais")
    public void euReceboAListaComAnimais(int petsQuant) {
        assertThat(actualPets.size(), is(petsQuant));
    }

    @Dado("que eu nao possua animais {word}")
    public void queEuNaoPossuaAnimaisSold(String status) {
        petApi.deletePetsByStatus(status);
    }

    @E("{int} animais possuem o nome {word}")
    public void animaisPossuemONomeCats(int petsQuant, String petsName) {
        actualPetsResponse.
                then().
                    body(
                        "findAll { it.name.contains('" + petsName + "') }.size()", is(petsQuant)
                    );
    }
}
