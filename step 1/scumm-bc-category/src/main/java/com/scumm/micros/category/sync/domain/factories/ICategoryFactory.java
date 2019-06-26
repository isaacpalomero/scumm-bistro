package com.scumm.micros.category.sync.domain.factories;

import com.scumm.core.domain.exceptions.ModelNotFoundException;
import com.scumm.micros.category.sync.domain.entities.Category;
import com.scumm.micros.contracts.categories.CategoryRequestContract;

public interface ICategoryFactory {
    Category createFromCategoryRequest(CategoryRequestContract contract) throws ModelNotFoundException;
}
