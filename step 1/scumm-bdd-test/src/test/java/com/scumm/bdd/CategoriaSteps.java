package com.scumm.bdd;

import com.scumm.bdd.contracts.api.Category;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class CategoriaSteps {

    private String categoryName;
    private Category category;
    private String categoryId;

    @Given("Una categoria de nombre {string}")
    public void dada_una_categoria(String categoryName){
        this.categoryName = categoryName;
    }

    @Given("Una categoria de id {id}")
    public void dada_una_categoria_de_id_x(String categoryId) {
        this.categoryId = categoryId;
    }


    @When("Cuando doy de alta la categoria")
    public void cuando_doy_de_alta_la_categoria() throws IOException {
        category = new Category();
        category.setName(categoryName);
        Call<Category> result = ScummApi.getInstance().getService().createCategory(category);
        Response<Category> response = result.execute();
        category.setId(response.body().getId());
    }

    @When("Modifico una categoria")
    public void modifico_una_categoria() throws IOException {
        Call<Category> call = ScummApi.getInstance().getService().getCategory(this.categoryId);
        Response<Category> getResponse = call.execute();
        Category categoryToBeModified = getResponse.body();
        categoryToBeModified.setName("Tortilla de alcachofas");
        ScummApi.getInstance().getService().updateCategory(categoryToBeModified);
        Response<Category> modifyResponse = call.execute();

    }

    @When("Borro una categoria")
    public void borro_una_cateogria() throws IOException {
        Call<Category> call = ScummApi.getInstance().getService().deleteCategory(this.categoryId);
        Response<Category> deleteResponse = call.execute();
    }


    @Then("Aparece la categoria en el listado")
    public void aparece_en_el_listado() throws IOException {
        Call<Category> call = ScummApi.getInstance().getService().getCategory(this.category.getId());
        Response<Category> response = call.execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(categoryName, response.body().getName());
    }

    @Then("Aparece la categoria modificada en el listado")
    public void  aparece_la_categoria_modificada_en_el_listado() {

    }

    @Then("Desaparece la categoria del listado")
    public void desaparece_la_categoria_del_listado() {

    }

}
