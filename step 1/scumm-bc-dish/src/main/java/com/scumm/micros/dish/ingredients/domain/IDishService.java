package com.scumm.micros.dish.ingredients.domain;

import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.exceptions.ModelNotFoundException;
import com.scumm.micros.contracts.DishIngredientsAddContract;
import com.scumm.micros.dish.ingredients.listeners.IListener;

public interface IDishService {
    void addIngredients(DishIngredientsAddContract contract, IListener<Dish> delegate) throws ModelNotFoundException, Exception;
}
