package com.scumm.api.factories;

import com.scumm.api.contracts.DishContract;
import com.scumm.api.exceptions.ModelNotFoundException;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.repositories.DishRepository;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public class DishFactory extends AbstractModelFactory<Dish, DishContract> implements IDishFactory {

    protected DishRepository dishRepository;

    @Autowired
    public DishFactory(ModelMapper mapper, DishRepository dishRepository) {
        super(mapper, Dish.class);
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish getById(String id) throws ModelNotFoundException {
        ObjectId objectId = new ObjectId(id);
        Optional<Dish> optionalDish = dishRepository.findById(objectId);

        if(optionalDish.isPresent()) {
            return optionalDish.get();
        }
        throw new ModelNotFoundException();
    }
}
