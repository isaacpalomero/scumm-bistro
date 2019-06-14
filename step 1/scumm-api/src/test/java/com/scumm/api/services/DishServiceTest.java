package com.scumm.api.services;

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

    @Before
    public void setUp(){
        subject = new DishService(repository);
        dish = new Dish();
        dishIngredients = new ArrayList<>();
        dishIngredients.add(new DishIngredient());
        dishIngredients.add(new DishIngredient());
    }

    @Test
    public void addIngredients() {
        subject.addIngredients(dish, dishIngredients);

        verify(repository, times(1)).save(dish);
        Assert.assertArrayEquals(dishIngredients.toArray(), dish.getIngredients().toArray());
    }
}