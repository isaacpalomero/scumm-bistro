package com.scumm.core.domain.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Ingredient {

    @Id
    private ObjectId id;
    private String name;
    private double quantity;
    private String unit;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() { return quantity; }

    public void setQuantity(double quantity) { this.quantity = quantity; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }


}
