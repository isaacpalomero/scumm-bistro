package com.scumm.api.services;

import com.scumm.api.exceptions.ModelNotFoundException;
import com.scumm.api.specifications.DishIngredientExistsSpec;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.entities.DishIngredient;
import com.scumm.core.domain.repositories.DishRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DishServiceTest {

    private DishService subject;
    private DishRepository repository = mock(DishRepository.class);
    private Dish dish;
    private List<DishIngredient> dishIngredients;
    private DishIngredientExistsSpec spec = mock(DishIngredientExistsSpec.class);

    @Before
    public void setUp(){

        subject = new DishService(repository, spec);
        dish = new Dish();
        dishIngredients = new ArrayList<>();
        dishIngredients.add(new DishIngredient());
        dishIngredients.add(new DishIngredient());
    }

    @Test
    public void addIngredientsSuccess() throws ModelNotFoundException {
        when(spec.isSatisfyByAll(dishIngredients)).thenReturn(true);
        subject.addIngredients(dish, dishIngredients);

        verify(spec).isSatisfyByAll(dishIngredients);
        verify(repository, times(1)).save(dish);
        Assert.assertArrayEquals(dishIngredients.toArray(), dish.getIngredients().toArray());
    }

    @Test(expected = ModelNotFoundException.class)
    public void addIngredientsNotFound() throws ModelNotFoundException {
        when(spec.isSatisfyByAll(dishIngredients)).thenReturn(false);
        subject.addIngredients(dish, dishIngredients);

        verify(spec).isSatisfyByAll(dishIngredients);
        verify(repository, never()).save(dish);
    }

}