package com.scumm.api.contracts;

import javax.validation.constraints.Positive;

public class DishIngredientContract {

    private String ingredientId;

    @Positive(message = "Quantity cannot be negative or zero")
    private int quantity;

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
