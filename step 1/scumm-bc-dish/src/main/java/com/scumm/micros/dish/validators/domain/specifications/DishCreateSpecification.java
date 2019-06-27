package com.scumm.micros.dish.validators.domain.specifications;

import com.scumm.core.domain.specifications.Specification;
import com.scumm.micros.contracts.dishes.DishCreateContract;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class DishCreateSpecification extends Specification<DishCreateContract> implements IDishCreateSpecification {

    @Override
    public boolean isSatisfyBy(DishCreateContract dishCreateContract) {
        if ( (dishCreateContract.getCategoryId() == null) && !ObjectId.isValid(dishCreateContract.getCategoryId()))
            return false;

        if ( (dishCreateContract.getName() == null) || dishCreateContract.getName().isEmpty())
            return false;

        return true;
    }


}
