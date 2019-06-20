package com.scumm.micros.dish.ingredients.handlers;

import com.clitellum.annotations.MessageHandler;
import com.clitellum.services.handlers.BaseHandler;
import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.micros.contracts.DishIngredientsAddContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@MessageHandler(key = "Dish.Ingredients.Add", contractType = DishIngredientsAddContract.class)
public class DishIngredientAddHandler extends BaseHandler<DishIngredientsAddContract> {

    @Autowired
    public DishIngredientAddHandler() {
    }

    @Override
    public void handle() throws HandlerMessageException {
        System.out.println(this.getContract().getId());
    }
}
