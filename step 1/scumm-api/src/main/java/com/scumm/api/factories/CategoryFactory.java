package com.scumm.api.factories;

import com.scumm.api.contracts.CategoryContract;
import com.scumm.core.domain.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory extends AbstractModelFactory<Category, CategoryContract> implements ICategoryFactory{

    @Autowired
    public CategoryFactory(ModelMapper mapper) {
        super(mapper, Category.class);
    }

}
