package com.scumm.micros.contracts;

import java.util.List;

public class DishIngredientsAdd {

    private String id;
    private List<DishIngredient> ingredients;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DishIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<DishIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
