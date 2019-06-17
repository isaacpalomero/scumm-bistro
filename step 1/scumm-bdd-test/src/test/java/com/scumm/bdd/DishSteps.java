package com.scumm.bdd;

import com.scumm.bdd.category.CategoryScenario;
import com.scumm.bdd.contracts.api.Dish;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class DishSteps {

    public DishSteps() {
    }

    @Given("^Un plato de nombre \"([^\"]*)\"$")
    public void un_plato_de_nombre_x(String nombrePlato) {
        DishScenario.getInstance().setDishName(nombrePlato);
    }

    @When("Doy de alta el plato")
    public void doy_de_alta_el_plato() throws IOException {
        Dish plato = new Dish();
        plato.setName(DishScenario.getInstance().getDishName());
        plato.setCategoryId(CategoryScenario.getInstance().getCategory().getId());
        Call<Dish> call = ScummApi.getInstance().getService().createDish(plato);
        Response<Dish> response = call.execute();
        Assert.assertTrue(response.isSuccessful());
        DishScenario.getInstance().setDish(response.body());
    }

    @Then("El plato esta en la carta")
    public void el_plato_esta_en_la_carta() throws IOException {
        Call<Dish> call = ScummApi.getInstance().getService().getDish(DishScenario.getInstance().getDish().getId());
        Response<Dish> response = call.execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(DishScenario.getInstance().getDishName(), response.body().getName());
        Assert.assertEquals(DishScenario.getInstance().getDish().getCategoryId(), response.body().getCategoryId());
    }
}
