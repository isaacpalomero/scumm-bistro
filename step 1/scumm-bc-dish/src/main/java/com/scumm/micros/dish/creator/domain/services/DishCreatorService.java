package com.scumm.micros.dish.creator.domain.services;

import com.scumm.micros.contracts.dishes.DishContract;
import com.scumm.micros.dish.creator.domain.entities.Dish;
import com.scumm.micros.dish.creator.domain.factories.IDishFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishCreatorService implements IDishCreatorService {

    private IDishFactory dishFactory;

    @Autowired
    public DishCreatorService(IDishFactory dishFactory) {
        this.dishFactory = dishFactory;
    }

    @Override
    public Dish createDish(DishContract contract){
        Dish dish = this.dishFactory.createFromContract(contract);
        dish.save();

        return dish;
    }
}
