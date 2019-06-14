package com.scumm.api.services;

import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.entities.DishIngredient;

import java.util.List;

public interface IDishService {
    void addIngredients(Dish dish, List<DishIngredient> dishIngredients);
}
