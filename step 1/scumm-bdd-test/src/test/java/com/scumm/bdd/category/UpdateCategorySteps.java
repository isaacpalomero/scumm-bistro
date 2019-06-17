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

public class UpdateCategorySteps {

    private String newName;

    @Given("Una categoria de id {string}")
    public void dada_una_categoria_de_id_x(String id) {
        CategoryScenario.getInstance().setCategoryId(id);
    }

    @Given("Un nombre nuevo de categoria {string}")
    public void un_nombre_nuevo_de_categoria_x(String newName) {
        this.newName = newName;
    }

    @When("Modifico una categoria")
    public void modifico_una_categoria() throws IOException {
        Call<Category> call = ScummApi.getInstance().getService().getCategory(CategoryScenario.getInstance().getCategoryId());
        Response<Category> getResponse = call.execute();
        Category categoryToBeModified = getResponse.body();
        categoryToBeModified.setName(this.newName);

        Call<Category> updateCall = ScummApi.getInstance().getService().updateCategory(categoryToBeModified.getId(), categoryToBeModified);
        updateCall.execute();
    }

    @Then("Aparece la categoria modificada en el listado")
    public void  aparece_la_categoria_modificada_en_el_listado() throws IOException {
        Call<Category> call = ScummApi.getInstance().getService().getCategory(CategoryScenario.getInstance().getCategoryId());
        Response<Category> response = call.execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(this.newName, response.body().getName());
    }

}
