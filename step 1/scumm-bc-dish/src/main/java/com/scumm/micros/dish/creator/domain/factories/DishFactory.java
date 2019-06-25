package com.scumm.micros.dish.creator.domain.factories;

import com.scumm.micros.contracts.dishes.DishContract;
import com.scumm.micros.dish.creator.domain.entities.Dish;
import com.scumm.micros.dish.creator.domain.repositories.DishRepository;
import com.scumm.micros.dish.creator.domain.valueobjects.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishFactory implements IDishFactory {

    private DishRepository repository;

    @Autowired
    public DishFactory(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dish createFromContract(DishContract contract){
        Dish dish = new Dish();
        dish.setRepository(this.repository);
        dish.setName(contract.getName());

        Category category = new Category();
        category.setName(contract.getCategoryName());
        dish.setCategory(category);

        return dish;
    }
}
