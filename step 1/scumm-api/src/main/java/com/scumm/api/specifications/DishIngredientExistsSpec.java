package com.scumm.api.specifications;

import com.scumm.core.domain.entities.DishIngredient;
import com.scumm.core.domain.repositories.IngredientRepository;
import com.scumm.core.domain.specifications.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishIngredientExistsSpec extends Specification<DishIngredient> {


    private IngredientRepository repository;

    @Autowired
    public DishIngredientExistsSpec(IngredientRepository repository) {

        this.repository = repository;
    }

    @Override
    public boolean isSatisfyBy(DishIngredient dishIngredient) {
        return repository.existsById(dishIngredient.getIngredientId());
    }
}
