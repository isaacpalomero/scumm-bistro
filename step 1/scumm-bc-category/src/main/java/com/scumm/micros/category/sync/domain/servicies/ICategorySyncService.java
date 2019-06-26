package com.scumm.micros.category.sync.domain.servicies;

import com.scumm.core.domain.exceptions.ModelNotFoundException;
import com.scumm.micros.category.sync.domain.entities.Category;
import com.scumm.micros.contracts.categories.CategoryRequestContract;

public interface ICategorySyncService {
    Category getCategory(CategoryRequestContract contract) throws ModelNotFoundException;
}
