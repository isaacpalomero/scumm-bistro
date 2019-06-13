package com.scumm.api.factories;

import com.scumm.api.contracts.CategoryContract;
import com.scumm.core.domain.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory implements ICategoryFactory {

    private ModelMapper mapper;

    @Autowired
    public CategoryFactory(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Category createFromContract(CategoryContract contract) {
        Category category = mapper.map(contract, Category.class);
        return category;
    }
}
