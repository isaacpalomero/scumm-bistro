package com.scumm.micros.dish.validators.handlers;

import com.clitellum.annotations.MessageHandler;
import com.clitellum.services.handlers.BaseHandler;
import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.micros.contracts.dishes.DishCreateContract;
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
        // Recibimos un dish contract
        // Queremos obtener
        this.validator.validate(getContract());
        // build category request to call category sync

        send("Category.Request", getContract().getCategoryId());
    }

}
