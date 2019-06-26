package com.scumm.micros.dish.validators.handlers;

import com.clitellum.annotations.MessageHandler;

import com.clitellum.services.handlers.BaseHandler;
import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.micros.contracts.categories.CategoryReplyContract;
import com.scumm.micros.contracts.dishes.DishCreateContract;
import com.scumm.micros.contracts.dishes.DishCreateValidatedContract;
import org.springframework.stereotype.Component;

@Component
@MessageHandler(key = "Category.Reply", contractType = CategoryReplyContract.class)
public class DishValidatorReplySuccessHandler extends BaseHandler<CategoryReplyContract> {

    @Override
    public void handle() throws HandlerMessageException {

        DishCreateValidatedContract createContract = new DishCreateValidatedContract();
        createContract.setCategoryName(getContract().getName());
        createContract.setName(getContext().get("dishName"));

        send("Dish.Create.Validated", createContract);
    }

}
