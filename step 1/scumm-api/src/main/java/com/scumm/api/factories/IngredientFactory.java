package com.scumm.api.factories;

import com.scumm.api.contracts.CategoryContract;
import com.scumm.api.contracts.IngredientContract;
import com.scumm.core.domain.entities.Category;
import com.scumm.core.domain.entities.Ingredient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientFactory extends AbstractModelFactory<Ingredient, IngredientContract>  implements IIngredientFactory {

    @Autowired
    public IngredientFactory(ModelMapper mapper) {
        super(mapper, Ingredient.class);
    }
}
