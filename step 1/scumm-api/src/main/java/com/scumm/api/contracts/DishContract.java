package com.scumm.api.contracts;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class DishContract extends Contract {

    @NotEmpty(message = "dish name can not be empty")
    private String name;

    @NotEmpty(message = "Dish category can not be empty")
    private String categoryId;

    private List<DishIngredientContract> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<DishIngredientContract> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<DishIngredientContract> ingredients) {
        this.ingredients = ingredients;
    }
}
