package com.scumm.micros.dish.ingredients.handlers;

import com.clitellum.annotations.MessageHandler;
import com.clitellum.services.handlers.BaseHandler;
import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.exceptions.ModelNotFoundException;
import com.scumm.micros.contracts.DishIngredientsAddContract;
import com.scumm.micros.contracts.DishIngredientsEventAddedContract;
import com.scumm.micros.dish.ingredients.domain.IDishService;
import com.scumm.micros.dish.ingredients.listeners.IListener;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@MessageHandler(key = "Dish.Ingredients.Add", contractType = DishIngredientsAddContract.class)
public class DishIngredientAddHandler extends BaseHandler<DishIngredientsAddContract> implements IListener<Dish> {

    private final IDishService service;
    private final ModelMapper mapper;
    private final String routingEventKey = "Dish.Ingredients.Event.Added";

    @Autowired
    public DishIngredientAddHandler(IDishService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public void handle() throws HandlerMessageException {
        try {
            service.addIngredients(this.getContract(), this);
        } catch (Exception e) {
            throw new HandlerMessageException(e);
        }
    }

    @Override
    public void success(Dish item) throws Exception {
        DishIngredientsEventAddedContract routingContract = mapper.map(item, DishIngredientsEventAddedContract.class);
        send(this.routingEventKey, routingContract);
    }
}
