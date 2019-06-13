package com.scumm.api.contracts;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class IngredientContract extends Contract {

    private String name;
    private double quantity;
    private String unit;

    @NotEmpty(message = "name can not be empty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PositiveOrZero(message = "Quantity cannot be negative")
    public double getQuantity() { return quantity; }

    public void setQuantity(double quantity) { this.quantity = quantity; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

}
