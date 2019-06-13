package com.scumm.api.factories;

import com.scumm.api.contracts.CategoryContract;
import com.scumm.core.domain.entities.Category;


public interface ICategoryFactory {
    Category createFromContract(CategoryContract contract);
}
