package com.scumm.bdd.dish;

import com.scumm.bdd.BddMicroPublisher;
import com.scumm.micros.contracts.DishIngredient;
import com.scumm.micros.contracts.DishIngredientsAdd;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class DishIngredientsAddSteps {

    private String dishId;
    private List<DishIngredient> dishIngredients;

    @Given("Un plato creado con id {string}")
    public void un_plato_con_id(String dishId) {
        this.dishId = dishId;
    }

    @Given("Una lista de ingredientes existentes")
    public void una_lista_de_ingredientes(){
        dishIngredients = new ArrayList<>();
        DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setQuantity(20);
        dishIngredient.setIngredientId("2349182347978123");
        dishIngredients.add(dishIngredient);
    }

    @When("Envio un mensaje de añadir ingredientes")
    public void envio_mensaje(){
        DishIngredientsAdd message = new DishIngredientsAdd();
        message.setId(this.dishId);
        message.setIngredients(dishIngredients);
        BddMicroPublisher.getInstance().send("Dish.Ingredients.Add", message);
    }

    @Then("Los ingredientes se han añadido al plato")
    public void se_añaden_los_ingredientes(){

    }

}
