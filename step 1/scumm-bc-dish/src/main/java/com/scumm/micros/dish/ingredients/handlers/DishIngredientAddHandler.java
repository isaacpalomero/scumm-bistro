package com.scumm.micros.dish.ingredients.handlers;

import com.clitellum.annotations.MessageHandler;
import com.clitellum.services.handlers.BaseHandler;
import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.micros.contracts.DishIngredientsAdd;
import org.springframework.stereotype.Component;

@Component
@MessageHandler(key = "Dish.Ingredients.Add", contractType = DishIngredientsAdd.class)
public class DishIngredientAddHandler extends BaseHandler<DishIngredientsAdd> {

    @Override
    public void handle() throws HandlerMessageException {

    }
}
