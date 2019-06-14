package com.scumm.api.controllers;

import com.scumm.api.contracts.DishContract;
import com.scumm.api.contracts.DishIngredientContract;
import com.scumm.api.exceptions.ModelNotFoundException;
import com.scumm.api.factories.IDishFactory;
import com.scumm.api.factories.IDishIngredientFactory;
import com.scumm.api.services.IDishService;
import com.scumm.api.validators.IContractValidator;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.entities.DishIngredient;
import com.scumm.core.domain.entities.Ingredient;
import com.scumm.core.domain.entities.Model;
import com.scumm.core.domain.repositories.DishRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PutMapping(path = "/{dishId}/addingredients/")
    public ResponseEntity addIngredients(@PathVariable String dishId, @Valid @RequestBody List<DishIngredientContract> ingredientsContractList) {
        Dish dish;
        try {
            dish = super.factory.getById(dishId);
            if (dish != null) {
                List<DishIngredient> ingredientList = dishIngredientsFactory.createDishIngredientsFromContracts(ingredientsContractList);
                dishService.addIngredients(dish, ingredientList);
                return new ResponseEntity<>(HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(ModelNotFoundException ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}