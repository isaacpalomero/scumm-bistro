package com.scumm.micros.dish.creator.domain.factories;

import com.scumm.micros.contracts.dishes.DishContract;
import com.scumm.micros.dish.creator.domain.entities.Dish;

public interface IDishFactory {
    Dish createFromContract(DishContract contract);
}
