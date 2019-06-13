package com.scumm.api.validators;

import com.scumm.api.contracts.DishContract;
import com.scumm.core.domain.repositories.CategoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishContractValidator implements IContractValidator<DishContract> {

    private final CategoryRepository categoryRepository;

    @Autowired
    public DishContractValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean validate(DishContract contract) {
        return categoryRepository.existsById(new ObjectId(contract.getCategoryId()));
    }
}
