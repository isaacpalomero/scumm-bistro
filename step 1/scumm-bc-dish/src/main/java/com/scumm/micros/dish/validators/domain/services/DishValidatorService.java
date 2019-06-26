package com.scumm.micros.dish.validators.domain.services;



import com.scumm.micros.contracts.dishes.DishCreateContract;
import com.scumm.micros.dish.validators.domain.specifications.DishCreateSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishValidatorService {
    DishCreateSpecification specification;

    @Autowired
    public DishValidatorService(DishCreateSpecification specification) {
        this.specification = specification;
    }

    public boolean validate(DishCreateContract dishContract) {
        return specification.isSatisfyBy(dishContract);
    }

}
