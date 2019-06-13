package com.scumm.api.controllers;

import com.scumm.api.contracts.DishContract;
import com.scumm.api.contracts.IngredientContract;
import com.scumm.api.factories.DishFactory;
import com.scumm.api.factories.IDishFactory;
import com.scumm.api.validators.IContractValidator;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.entities.Ingredient;
import com.scumm.core.domain.repositories.DishRepository;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class DishControllerTest {

    private DishController controller;
    private final Dish dish = new Dish();
    private final Ingredient ingredient = new Ingredient();
    private final List<IngredientContract> ingredientList = new ArrayList<>();
    private DishRepository repository;
    private ModelMapper modelMapper;
    private IDishFactory factory;
    private IContractValidator<DishContract> contractValidator;

    @Before
    public void setup() {
        repository = mock(DishRepository.class);
        modelMapper = mock(ModelMapper.class);
        factory = mock(IDishFactory.class);
        contractValidator = (IContractValidator<DishContract>) mock(IContractValidator.class);
        controller = new DishController(repository, modelMapper, factory, contractValidator);
    }


    //TODO => do we want to validate duplicate ingredients in list?

    @Test
    public void addIngredientToDishSuccess() {
        //TODO:
        // Verify dish exists in repository
        // Verify each ingredient exists in repository
        // Verify repository.save() is called
        // Assert HTTP_CODE is CREATED/MODIFIED/TO_BE_DECIDED
        // RESULT: Create in controller => controller.addIngredients(ingredientList)
    }

    @Test
    public void addIngredientToDishFailIngredientDoesNotExist() {
        //TODO:
        // Verify dish exists in repository
        // Assert ingredient does not exist
        // Assert HTTP_CODE == NOT_FOUND
    }

    @Test
    public void addIngredientToDishFailDishDoesNotExist() {
        //TODO:
        // Assert dish does not exist
        // Assert HTTP_CODE == NOT_FOUND
    }

}
