package com.scumm.api.controllers;

import com.scumm.api.contracts.DishContract;
import com.scumm.api.factories.DishFactory;
import com.scumm.api.validators.IContractValidator;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.repositories.CategoryRepository;
import com.scumm.core.domain.repositories.DishRepository;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/dish")
public class DishController extends AbstractCrudController<DishRepository, DishFactory, Dish, DishContract> {

    @Autowired
    protected DishController(DishRepository repository, ModelMapper modelMapper, DishFactory factory, IContractValidator<DishContract> validator) {
        super(repository, modelMapper, factory, validator, DishContract.class);
    }

}
