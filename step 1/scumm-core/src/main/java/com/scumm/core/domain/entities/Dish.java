package com.scumm.core.domain.entities;

import org.bson.types.ObjectId;

public class Dish extends Model {

    private String name;
    private ObjectId categoryId;

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
}
