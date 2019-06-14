package com.scumm.core.domain.entities;

import org.bson.types.ObjectId;

public class DishIngredient {

    private ObjectId ingredientId;
    private int quantity;

    public ObjectId getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(ObjectId ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
