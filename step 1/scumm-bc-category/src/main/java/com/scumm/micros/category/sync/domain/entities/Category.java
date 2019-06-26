package com.scumm.micros.category.sync.domain.entities;

import com.scumm.core.domain.entities.Entity;
import com.scumm.micros.category.sync.domain.repositories.CategoryRepository;

public class Category extends Entity<CategoryRepository> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
