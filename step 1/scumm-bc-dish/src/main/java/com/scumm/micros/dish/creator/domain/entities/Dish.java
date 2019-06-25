package com.scumm.micros.dish.creator.domain.entities;

import com.scumm.core.domain.entities.Entity;
import com.scumm.micros.dish.creator.domain.repositories.DishRepository;
import com.scumm.micros.dish.creator.domain.valueobjects.Category;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dishes")
public class Dish extends Entity<DishRepository> {
    private String name;
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
