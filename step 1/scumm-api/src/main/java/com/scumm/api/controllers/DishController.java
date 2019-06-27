package com.scumm.api.controllers;

import com.scumm.api.contracts.DishContract;
import com.scumm.api.contracts.DishIngredientContract;
import com.scumm.api.factories.IDishFactory;
import com.scumm.api.factories.IDishIngredientFactory;
import com.scumm.api.micros.MicroPublisher;
import com.scumm.api.services.IDishService;
import com.scumm.api.validators.IContractValidator;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.repositories.DishRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dish")
public class DishController extends AbstractCrudController<DishRepository, IDishFactory, Dish, DishContract> {

    private IDishIngredientFactory dishIngredientsFactory;
    private IDishService dishService;

    @Autowired
    protected DishController(DishRepository repository, ModelMapper modelMapper, IDishFactory factory, IContractValidator<DishContract> validator, IDishIngredientFactory dishIngredientsFactory, IDishService dishService) {
        super(repository, modelMapper, factory, validator, DishContract.class);
        this.dishIngredientsFactory = dishIngredientsFactory;
        this.dishService = dishService;
    }

    @PutMapping(value = "/{dishId}/addingredients")
    public ResponseEntity addIngredients(@PathVariable String dishId, @Valid @RequestBody List<DishIngredientContract> ingredientsContractList) {

        com.scumm.micros.contracts.DishIngredientsAddContract dishIngredientsContractMessage = new com.scumm.micros.contracts.DishIngredientsAddContract();
        dishIngredientsContractMessage.setId(dishId);
        dishIngredientsContractMessage.setIngredients(ingredientsContractList.stream()
                .map(entity -> super.mapper.map(entity, com.scumm.micros.contracts.DishIngredientContract.class))
                .collect(Collectors.toList()));


        MicroPublisher.getInstance().send("Dish.Ingredients.Add", dishIngredientsContractMessage);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @PostMapping
    @Override
    public ResponseEntity create(@Valid @RequestBody DishContract contract) {
        com.scumm.micros.contracts.dishes.DishCreateContract microContract = new com.scumm.micros.contracts.dishes.DishCreateContract();
        microContract.setName(contract.getName());
        microContract.setCategoryId(contract.getCategoryId());
        MicroPublisher.getInstance().send("Dish.Create", microContract);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}