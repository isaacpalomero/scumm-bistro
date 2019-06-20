package com.scumm.micros.contracts;

import java.util.List;

public class DishIngredientsAddContract {

    private String id;
    private List<DishIngredientContract> ingredients;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DishIngredientContract> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<DishIngredientContract> ingredients) {
        this.ingredients = ingredients;
    }
}
