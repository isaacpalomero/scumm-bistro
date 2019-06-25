package com.scumm.micros.dish.creator.handlers;

import com.clitellum.annotations.MessageHandler;
import com.clitellum.services.handlers.BaseHandler;
import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.micros.contracts.dishes.DishContract;
import com.scumm.micros.dish.creator.domain.entities.Dish;
import com.scumm.micros.dish.creator.domain.services.IDishCreatorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@MessageHandler(key = "Dish.Create.Validated", contractType = DishContract.class)
public class DishCreatorHandler extends BaseHandler<DishContract> {

    private IDishCreatorService service;
    private ModelMapper mapper;

    @Autowired
    public DishCreatorHandler(IDishCreatorService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public void handle() throws HandlerMessageException {
        Dish dish = service.createDish(getContract());

        DishContract dishContract = mapper.map(dish, DishContract.class);
        send("Dish.Event.Created", dishContract);
    }
}
