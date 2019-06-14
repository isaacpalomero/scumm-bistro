package com.scumm.api.factories;

import com.scumm.api.contracts.DishContract;
import com.scumm.api.exceptions.ModelNotFoundException;
import com.scumm.core.domain.entities.Dish;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishFactory extends AbstractModelFactory<Dish, DishContract> implements IDishFactory {

    @Autowired
    public DishFactory(ModelMapper mapper) {
        super(mapper, Dish.class);
    }

    @Override
    public Dish getById(String id) throws ModelNotFoundException {
        return null;
    }
}
