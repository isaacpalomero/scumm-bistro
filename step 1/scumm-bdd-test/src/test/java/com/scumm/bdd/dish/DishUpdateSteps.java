package com.scumm.bdd.dish;

import com.scumm.bdd.CategoryScenario;
import com.scumm.bdd.DishScenario;
import com.scumm.bdd.ScummApi;
import com.scumm.bdd.contracts.api.Category;
import com.scumm.bdd.contracts.api.Dish;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class DishUpdateSteps {

    private String newDishName;
    private Category newCategory;

    public DishUpdateSteps() {
    }

    @Given("Un nuevo nombre de plato {string}")
    public void un_nuevo_plato_de_nombre_x(String nuevoNombrePlato) {
        newDishName = nuevoNombrePlato;
    }

    @When("Actualizo el plato")
    public void actualiza_el_plato() throws IOException {
        newCategory = CategoryScenario.getInstance().getCategory();

        Dish plato = DishScenario.getInstance().getDish();
        plato.setName(newDishName);
        plato.setCategoryId(CategoryScenario.getInstance().getCategory().getId());

        Call<Dish> call = ScummApi.getInstance().getService().updateDish(plato.getId(), plato);
        Response<Dish> response = call.execute();
        Assert.assertTrue(response.isSuccessful());
        DishScenario.getInstance().setDish(response.body());
    }

    @Then("El plato sale actualizado en la carta")
    public void el_plato_esta_en_la_carta() throws IOException {
        Call<Dish> call = ScummApi.getInstance().getService().getDish(DishScenario.getInstance().getDish().getId());
        Response<Dish> response = call.execute();
        Assert.assertTrue(response.isSuccessful());

        Assert.assertEquals(newDishName, response.body().getName());
        Assert.assertEquals(newCategory.getId(), response.body().getCategoryId());
    }
}
