package com.scumm.micros.contracts.dishes;

public class DishCreateContract {

    private String name;
    private String categoryId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() { return categoryId; }

    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
}
