package com.scumm.api.services;

import com.scumm.api.exceptions.ModelNotFoundException;
import com.scumm.api.specifications.DishIngredientExistsSpec;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.entities.DishIngredient;
import com.scumm.core.domain.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService implements IDishService {

    private DishRepository repository;
    private DishIngredientExistsSpec dishIngredientExistsSpec;

    @Autowired
    public DishService(DishRepository repository, DishIngredientExistsSpec dishIngredientExistsSpec) {
        this.repository = repository;
        this.dishIngredientExistsSpec = dishIngredientExistsSpec;
    }

    @Override
    public void addIngredients(Dish dish, List<DishIngredient> dishIngredients) throws ModelNotFoundException {
        if(dishIngredientExistsSpec.isSatisfyByAll(dishIngredients)){
            dish.addIngredients(dishIngredients);
            repository.save(dish);
        } else {
            throw new ModelNotFoundException();
        }
    }
}
