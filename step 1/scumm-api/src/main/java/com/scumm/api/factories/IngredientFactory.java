package com.scumm.api.factories;

import com.scumm.api.contracts.IngredientContract;
import com.scumm.core.domain.entities.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientFactory implements IIngredientFactory {
    @Override
    public Ingredient createFromContract(IngredientContract contract) {
        return null;
    }
}
