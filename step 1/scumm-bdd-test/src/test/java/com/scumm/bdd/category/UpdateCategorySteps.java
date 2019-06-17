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

    @Given("Un nombre nuevo de categoria {string}")
    public void un_nombre_nuevo_de_categoria_x(String newName) {
        this.newName = newName;
    }

    @When("Modifico una categoria")
    public void modifico_una_categoria() throws IOException {
        Category category = CategoryScenario.getInstance().getCategory();
        category.setName(newName);

        Call<Category> updateCall = ScummApi.getInstance().getService().updateCategory(category.getId(), category);
        Response<Category> response = updateCall.execute();
        Assert.assertTrue(response.isSuccessful());
    }

    @Then("Aparece la categoria modificada en el listado")
    public void  aparece_la_categoria_modificada_en_el_listado() throws IOException {
        Call<Category> call = ScummApi.getInstance().getService().getCategory(CategoryScenario.getInstance().getCategory().getId());
        Response<Category> response = call.execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(this.newName, response.body().getName());
    }

}
