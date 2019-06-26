package com.scumm.micros.dish.validators.handlers;

import com.clitellum.annotations.MessageHandler;
import com.clitellum.services.handlers.BaseHandler;
import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.micros.contracts.categories.CategoryRequestContract;
import com.scumm.micros.contracts.dishes.DishCreateContract;
import com.scumm.micros.contracts.dishes.DishEventCreateErrorContract;
import com.scumm.micros.dish.validators.domain.services.DishValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@MessageHandler(key = "Dish.Create", contractType = DishCreateContract.class)
public class DishValidatorHandler extends BaseHandler<DishCreateContract> {

    private DishValidatorService validator;


    @Autowired
    public DishValidatorHandler(DishValidatorService validator) {
        this.validator = validator;
    }

    @Override
    public void handle() throws HandlerMessageException {

        if (this.validator.validate(this.getContract())) {
            CategoryRequestContract categoryRequestContract = new CategoryRequestContract();
            categoryRequestContract.setId( getContract().getCategoryId());
            send("Category.Request", categoryRequestContract);
        } else {
            DishEventCreateErrorContract errorContract = new DishEventCreateErrorContract();
            errorContract.setCode(400);
            errorContract.setMessage("Bad request: invalid category id or invalid dish name");
            send("Dish.Event.Create.Error", errorContract);
        }
    }

}
