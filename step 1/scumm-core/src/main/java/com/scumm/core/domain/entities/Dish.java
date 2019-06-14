package com.scumm.core.domain.entities;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Dish extends Model {

    private String name;
    private ObjectId categoryId;
    private List<DishIngredient> ingredients;

    public Dish() {
        ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(ObjectId categoryId) {
        this.categoryId = categoryId;
    }

    public List<DishIngredient> getIngredients() {
        return ingredients;
    }

    public void addIngredients(List<DishIngredient> dishIngredients) {
        this.ingredients.addAll(dishIngredients);
    }
}
