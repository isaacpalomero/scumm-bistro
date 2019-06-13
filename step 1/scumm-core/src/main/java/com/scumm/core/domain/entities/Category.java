package com.scumm.core.domain.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Category extends Model {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
