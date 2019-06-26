package com.scumm.micros.category.sync.domain.servicies;

import com.scumm.core.domain.exceptions.ModelNotFoundException;
import com.scumm.micros.category.sync.domain.entities.Category;
import com.scumm.micros.category.sync.domain.factories.CategoryFactory;
import com.scumm.micros.contracts.categories.CategoryRequestContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorySyncService implements ICategorySyncService {

    private CategoryFactory factory;

    @Autowired
    public CategorySyncService(CategoryFactory factory) {
        this.factory = factory;
    }

    @Override
    public Category getCategory(CategoryRequestContract contract) throws ModelNotFoundException {
        return factory.createFromCategoryRequest(contract);
    }
}
