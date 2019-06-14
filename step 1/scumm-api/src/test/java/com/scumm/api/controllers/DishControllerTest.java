package com.scumm.api.controllers;

import com.scumm.api.contracts.DishContract;
import com.scumm.api.contracts.DishIngredientContract;
import com.scumm.api.contracts.IngredientContract;
import com.scumm.api.exceptions.ModelNotFoundException;
import com.scumm.api.factories.IDishFactory;
import com.scumm.api.factories.IDishIngredientFactory;
import com.scumm.api.factories.IIngredientFactory;
import com.scumm.api.services.IDishService;
import com.scumm.api.validators.IContractValidator;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.entities.Model;
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
    private final List<DishIngredientContract> ingredientList = new ArrayList<>();
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
    private final Dish dish = new Dish();


    @Before
    public void setup() {
        dishId = new ObjectId().toString();
        repository = mock(DishRepository.class);
        modelMapper = mock(ModelMapper.class);
        dishFactory = mock(IDishFactory.class);
        dishIngredientFactory = mock(IDishIngredientFactory.class);
        contractValidator = (IContractValidator<DishContract>) mock(IContractValidator.class);
        dishService = mock(IDishService.class);
        controller = new DishController(repository, modelMapper, dishFactory, contractValidator, dishIngredientFactory, dishService);

        String ingredientId = "quinoa123455";
        dishIngredientContract.setIngredientId(ingredientId);
        dishIngredientContract.setQuantity(1);
        ingredientList.add(dishIngredientContract);


    }


    //TODO => do we want to validate duplicate ingredients in list?

    @Test
    public void addIngredientsSuccess() throws ModelNotFoundException {

        when(dishFactory.getById(dishId)).thenReturn(dish);

        // test
        ResponseEntity response = controller.addIngredients(dishId, ingredientList);

        // verifications
        verify(dishFactory, times(1)).getById(dishId);
        verify(dishIngredientFactory, times(1)).createDishIngredientsFromContracts(ingredientList);
        verify(dishService, times(1)).addIngredients(any(Dish.class), any(List.class));
        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void addIngredientsFailDishDoesNotExist() throws ModelNotFoundException {

        // test
        ResponseEntity response = controller.addIngredients(dishId, ingredientList);

        verify(dishFactory, times(1)).getById(dishId);
        verify(dishIngredientFactory, never()).createDishIngredientsFromContracts(ingredientList);
        verify(dishService, never()).addIngredients(any(Dish.class), any(List.class));
        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

   //@Test
    public void addIngredientsFailIngredientDoesNotExist() throws ModelNotFoundException {

        when(dishFactory.getById(dishId)).thenReturn(dish);

        // test
        ResponseEntity response = controller.addIngredients(dishId, ingredientList);

        // verifications
        verify(dishFactory, times(1)).getById(dishId);
        verify(dishIngredientFactory, times(1)).createDishIngredientsFromContracts(ingredientList);
        verify(dishService, times(1)).addIngredients(any(Dish.class), any(List.class));
        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
