package com.scumm.micros.dish.creator.domain.services;

import com.scumm.micros.contracts.dishes.DishContract;
import com.scumm.micros.dish.creator.domain.entities.Dish;

public interface IDishCreatorService {
    Dish createDish(DishContract contract);
}
