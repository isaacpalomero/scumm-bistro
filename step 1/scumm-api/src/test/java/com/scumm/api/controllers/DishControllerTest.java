package com.scumm.api.controllers;

import com.scumm.api.contracts.DishContract;
import com.scumm.api.contracts.DishIngredientContract;
import com.scumm.api.contracts.IngredientContract;
import com.scumm.api.factories.IDishFactory;
import com.scumm.api.factories.IDishIngredientFactory;
import com.scumm.api.factories.IIngredientFactory;
import com.scumm.api.services.IDishService;
import com.scumm.api.validators.IContractValidator;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.entities.Ingredient;
import com.scumm.core.domain.repositories.DishRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DishControllerTest {

    private DishController controller;
    private final List<IngredientContract> ingredientList = new ArrayList<>();
    private DishRepository repository;
    private ModelMapper modelMapper;
    private IDishFactory dishFactory;
    private IDishIngredientFactory dishIngredientFactory;
    private IContractValidator<DishContract> contractValidator;
    private IIngredientFactory ingredientFactory;
    private DishIngredientContract dishIngredientContract = new DishIngredientContract();
    private final IngredientContract ingredientContract = new IngredientContract();
    private String dishId;

    private IDishService dishService;


    @Before
    public void setup() {
        repository = mock(DishRepository.class);
        modelMapper = mock(ModelMapper.class);
        dishFactory = mock(IDishFactory.class);
        dishIngredientFactory = mock(IDishIngredientFactory.class);
        contractValidator = (IContractValidator<DishContract>) mock(IContractValidator.class);
        dishService = mock(IDishService.class);
        controller = new DishController(repository, modelMapper, dishFactory, contractValidator, dishIngredientFactory, dishService);

        //TODO: change ingredientContract por dishIngredientContract
        ingredientContract.setId("alksjdflajfi3322212m1k12k2");
        ingredientContract.setName("Quinoa");
        ingredientFactory = mock(IIngredientFactory.class);
        ingredientFactory.createFromContract(ingredientContract);
        ingredientList.add(ingredientContract);

        dishId = "lkasl231lkadsjlka5454dsjlkads";

    }


    //TODO => do we want to validate duplicate ingredients in list?

    @Test
    public void addIngredientsSuccess() {
        //expectations

        // verifications
        verify(controller, times(1)).addIngredients(any(String.class), List<DishIngredientContract>.class);

        //test
        ResponseEntity response = controller.addIngredients(dishId, ingredientList);
        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

        //TODO:
        // NO - Verify dish exists in repository
        // NO - Verify each ingredient exists in repository
        // NO - Verify repository.save() is called
        // Assert HTTP_CODE is CREATED/MODIFIED/TO_BE_DECIDED
        // RESULT: Create in controller => controller.addIngredients(ingredientList)
    }

    @Test
    public void addIngredientsFailDishDoesNotExist() {
        //TODO:
        // Assert dish does not exist
        // Assert HTTP_CODE == NOT_FOUND
    }

    @Test
    public void addIngredientsFailIngredientDoesNotExist() {
        //TODO:
        // Verify dish exists in repository
        // Assert ingredient does not exist
        // Assert HTTP_CODE == NOT_FOUND
    }

}
