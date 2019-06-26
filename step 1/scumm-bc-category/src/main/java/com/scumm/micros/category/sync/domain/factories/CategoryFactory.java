package com.scumm.micros.category.sync.domain.factories;

import com.scumm.core.domain.exceptions.ModelNotFoundException;
import com.scumm.micros.category.sync.domain.entities.Category;
import com.scumm.micros.category.sync.domain.repositories.CategoryRepository;
import com.scumm.micros.contracts.categories.CategoryRequestContract;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory implements ICategoryFactory {

    private CategoryRepository repository;

    @Autowired
    public CategoryFactory(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category createFromCategoryRequest(CategoryRequestContract contract) throws ModelNotFoundException {
        return repository
                .findById(new ObjectId(contract.getId()))
                .orElseThrow(ModelNotFoundException::new);
    }
}
