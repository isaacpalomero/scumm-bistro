package com.scumm.api.factories;

import com.scumm.api.contracts.DishContract;
import com.scumm.api.exceptions.ModelNotFoundException;
import com.scumm.core.domain.entities.Dish;

public interface IDishFactory extends IFactory<Dish, DishContract> {
    /**
     * Devuelve el plato en base al identificador
     * @param id Identificador del palto
     * @return
     */
    Dish getById(String id) throws ModelNotFoundException;
}
