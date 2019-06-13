package com.scumm.api.controllers;

import com.scumm.api.contracts.IngredientContract;
import com.scumm.api.factories.IIngredientFactory;
import com.scumm.core.domain.entities.Ingredient;
import com.scumm.core.domain.repositories.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientController extends AbstractCrudController<IngredientRepository, IIngredientFactory, Ingredient, IngredientContract>{

    @Autowired
    public IngredientController(IngredientRepository repository, ModelMapper modelMapper, IIngredientFactory factory) {
        super(repository, modelMapper, factory, IngredientContract.class);
    }

}
