package com.scumm.api.factories;

import com.scumm.api.contracts.DishIngredientContract;
import com.scumm.core.domain.entities.DishIngredient;

import java.util.List;

public interface IDishIngredientFactory {

    List<DishIngredient> createDishIngredientsFromContracts(List<DishIngredientContract> contracts);
}
