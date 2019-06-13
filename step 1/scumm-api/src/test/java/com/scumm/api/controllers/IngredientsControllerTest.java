package com.scumm.api.controllers;

import com.scumm.api.contracts.IngredientContract;
import com.scumm.core.domain.entities.Ingredient;
import com.scumm.core.domain.repositories.IngredientRepository;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.*;

public class IngredientsControllerTest {

    private IngredientContract contract;
    private IngredientRepository repository;
    private IngredientController controller;
    private ModelMapper modelMapper;
    private Ingredient ingredient;
    private String id;
    private String name;

    @Before
    public void setup() {
        contract = new IngredientContract();
        repository = mock(IngredientRepository.class);
        modelMapper = mock(ModelMapper.class);
        controller = new IngredientController(repository, modelMapper);
        ingredient = new Ingredient();

        id = "5cff81cf7ae84c269cc8d6d4";
        name = "Quinoa";
        ingredient.setId(new ObjectId(id));
    }

    @Test
    public void createIngredientSuccess() {

        // Pa'l MAPPER: verify(Ingredient, times(1)).setName(name);

        // que se crea el objeto ingredient
        // que el objeto no es nulo?
        // que se llama al create del repositorio
        // que se llama al mapper
        // que devuelve el nuevo objeto ingredient
        // que los campos del ingrediente sean correctos

        verify(repository, times(1)).save(any(Ingredient.class));
        verify(modelMapper, times(1)).map(any(Ingredient.class), eq(IngredientContract.class))


    }

    @Test
    public void createIngredientFail() {
        // que se crea el objeto ingredient
        // que se llama al create del repositorio
        // que devuelve el nuevo objeto ingredient

    }

    @Test
    public void deleteIngredient() {

    }

    @Test
    public void updateIngredient() {

    }

    @Test
    public void getIngredientById() {

    }



    @Test
    public void getAllIngredients() {

    }

}
