package com.scumm.api.services;

import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.entities.DishIngredient;
import com.scumm.core.domain.repositories.DishRepository;

import java.util.List;

public class DishService implements IDishService {

    private DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addIngredients(Dish dish, List<DishIngredient> dishIngredients) {
        dish.addIngredients(dishIngredients);
        repository.save(dish);

    }
}
