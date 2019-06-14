package com.scumm.api.factories;

import com.scumm.api.contracts.DishIngredientContract;
import com.scumm.core.domain.entities.DishIngredient;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class DishIngredientFactory implements IDishIngredientFactory {

    private final ModelMapper mapper;

    @Autowired
    public DishIngredientFactory(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<DishIngredient> createDishIngredientsFromContracts(List<DishIngredientContract> contracts) {
        Type listType = new TypeToken<List<DishIngredient>>() {}.getType();
        return mapper.map(contracts, listType);
    }
}
