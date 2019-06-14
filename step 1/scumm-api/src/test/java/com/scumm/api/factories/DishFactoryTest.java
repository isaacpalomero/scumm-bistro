package com.scumm.api.factories;

import com.scumm.api.exceptions.ModelNotFoundException;
import com.scumm.core.domain.entities.Dish;
import com.scumm.core.domain.repositories.DishRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DishFactoryTest {

    private DishRepository dishRepository;
    private DishFactory subject;
    private ModelMapper mapper;
    private Dish dish;


    @Before
    public void setUp() {
        dishRepository = mock(DishRepository.class);
        mapper = mock(ModelMapper.class);

        subject = new DishFactory(mapper, dishRepository);
    }

    @Test
    public void getByIdSuccess() throws ModelNotFoundException {
        dish = new Dish();
        dish.setId(new ObjectId());

        when(dishRepository.findById(dish.getId())).thenReturn(Optional.of(dish));

        Dish resultDish = subject.getById(dish.getId().toString());

        verify(dishRepository, times(1)).findById(eq(dish.getId()));
        Assert.assertNotNull(resultDish);
        Assert.assertEquals(dish.getId(), resultDish.getId());
    }

    @Test(expected = ModelNotFoundException.class)
    public void getByIdError() throws ModelNotFoundException {
        dish = new Dish();
        dish.setId(new ObjectId());

        when(dishRepository.findById(dish.getId())).thenReturn(Optional.empty());

        try {
            subject.getById(dish.getId().toString());
        } catch (ModelNotFoundException e) {
            throw e;
        }

    }
}
