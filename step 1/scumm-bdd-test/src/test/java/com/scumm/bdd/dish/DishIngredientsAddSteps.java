package com.scumm.bdd.dish;

import com.scumm.bdd.BddMicroPublisher;
import com.scumm.micros.contracts.DishIngredientContract;
import com.scumm.micros.contracts.DishIngredientsAddContract;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class DishIngredientsAddSteps {

    private String dishId;
    private List<DishIngredientContract> dishIngredientContracts;

    @Given("Un plato creado con id {string}")
    public void un_plato_con_id(String dishId) {
        this.dishId = dishId;
    }

    @Given("Una lista de ingredientes existentes")
    public void una_lista_de_ingredientes(){
        dishIngredientContracts = new ArrayList<>();
        DishIngredientContract dishIngredientContract = new DishIngredientContract();
        dishIngredientContract.setQuantity(20);
        dishIngredientContract.setIngredientId("5d0b5f6d2ab79c00014c048d");
        dishIngredientContracts.add(dishIngredientContract);
    }

    @When("Envio un mensaje de añadir ingredientes")
    public void envio_mensaje(){
        DishIngredientsAddContract message = new DishIngredientsAddContract();
        message.setId(this.dishId);
        message.setIngredients(dishIngredientContracts);
        BddMicroPublisher.getInstance().send("Dish.Ingredients.Add", message);
    }

    @Then("Los ingredientes se han añadido al plato")
    public void se_añaden_los_ingredientes(){

    }

}
