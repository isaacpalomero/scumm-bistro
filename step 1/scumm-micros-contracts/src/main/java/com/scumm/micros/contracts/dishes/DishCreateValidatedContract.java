package com.scumm.micros.contracts.dishes;

public class DishCreateValidatedContract {

    private String name;
    private String categoryName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
