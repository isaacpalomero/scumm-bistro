package com.scumm.micros.dish.validators.handlers;

import com.clitellum.annotations.MessageHandler;
import com.clitellum.services.handlers.BaseHandler;
import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.micros.contracts.categories.CategoryReplyContract;
import com.scumm.micros.contracts.categories.CategoryReplyErrorContract;
import com.scumm.micros.contracts.dishes.DishEventCreateErrorContract;
import org.springframework.stereotype.Component;

@Component
@MessageHandler(key = "Category.Reply.Error", contractType = CategoryReplyContract.class)
public class CategoryValidatorReplyErrorHandler extends BaseHandler<CategoryReplyErrorContract> {

    @Override
    public void handle() throws HandlerMessageException {
        DishEventCreateErrorContract errorContract = new DishEventCreateErrorContract();
        errorContract.setCode(400);
        errorContract.setMessage("Bad request: invalid category id or invalid dish name");
        send("Dish.Event.Create.Error", errorContract);
    }
}
