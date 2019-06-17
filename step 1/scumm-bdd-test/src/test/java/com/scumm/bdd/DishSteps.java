package com.scumm.bdd;

import com.scumm.bdd.contracts.api.Dish;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class DishSteps {
    private String nombrePlato;
    private Dish plato;
    private Dish platoResponse;
    private String categoria;

    public DishSteps() {
    }

    @Given("^Un plato de nombre \"([^\"]*)\"$")
    public void un_plato_de_nombre_x(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    @Given("^Una categoria de id \"([^\"]*)\"$")
    public void una_categoria_de_id_x(String categoria) {
        this.categoria = categoria;
    }

    @When("Doy de alta el plato")
    public void doy_de_alta_el_plato() throws IOException {
        this.plato = new Dish();
        this.plato.setName(this.nombrePlato);
        this.plato.setCategoryId(this.categoria);
        Call<Dish> call = ScummApi.getInstance().getService().createDish(this.plato);
        Response<Dish> response = call.execute();
        platoResponse = response.body();
        Assert.assertTrue(response.isSuccessful());
    }

    @Then("El plato esta en la carta")
    public void el_plato_esta_en_la_carta() throws IOException {
        Call<Dish> call = ScummApi.getInstance().getService().getDish(this.platoResponse.getId());
        Response<Dish> response = call.execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(this.nombrePlato, response.body().getName());
    }
}
