package com.scumm.bdd.category;

import com.scumm.bdd.ScummApi;
import com.scumm.bdd.contracts.api.Category;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class DeleteCategorySteps {

    @When("Borro una categoria")
    public void borro_una_categoria() throws IOException {
        Call<Category> call = ScummApi.getInstance().getService().deleteCategory(CategoryScenario.getInstance().getCategory().getId());
        Response<Category> getResponse = call.execute();
        getResponse.body();
    }

    @Then("Desaparece la categoria del listado")
    public void  desaparece_la_categoria_del_listado() throws IOException {
        Call<Category> call = ScummApi.getInstance().getService().getCategory(CategoryScenario.getInstance().getCategory().getId());
        Response<Category> response = call.execute();
        Assert.assertFalse(response.isSuccessful());
        Assert.assertNull(response.body());
    }

}
