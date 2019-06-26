package com.scumm.micros.dish.validators.domain.services;


import com.scumm.micros.contracts.dishes.DishContract;
import com.scumm.micros.dish.validators.domain.specifications.CategorySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishValidatorService {
    CategorySpecification categorySpecification;

    @Autowired
    public DishValidatorService(CategorySpecification categorySpecification) {
        this.categorySpecification = categorySpecification;
    }

    public void validate(DishContract dishContract) {
        //TOOD validate category exists

    }

}
