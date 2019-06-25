package com.scumm.micros.dish.ingredients.domain;

import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.entities.DishIngredient;
import com.scumm.core.domain.exceptions.ModelNotFoundException;
import com.scumm.core.domain.repositories.DishRepository;
import com.scumm.micros.contracts.DishIngredientsAddContract;
import com.scumm.micros.dish.ingredients.listeners.IListener;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class DishService implements IDishService {

//    private final ModelMapper mapper;
//    private final DishRepository repository;
//
//    @Autowired
//    public DishService(ModelMapper mapper, DishRepository repository) {
//        this.mapper = mapper;
//        this.repository = repository;
//    }


    @Override
    public void addIngredients(DishIngredientsAddContract contract, IListener<Dish> delegate) throws Exception {
//        Dish dish = this.repository.findById(new ObjectId(contract.getId()))
//                .orElseThrow(ModelNotFoundException::new);
//        Type destinationType = new TypeToken<List<DishIngredient>>() {}.getType();
//        List<DishIngredient> dishIngredients = mapper.map(contract.getIngredients(), destinationType);
//
//        dish.addIngredients(dishIngredients);
//        repository.save(dish);
//
//        delegate.success(dish);
    }
}
