package com.scumm.api.specifications;

import com.scumm.core.domain.entities.DishIngredient;
import com.scumm.core.domain.repositories.IngredientRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DishIngredientExistsSpecTest {

    private DishIngredientExistsSpec subject;
    private IngredientRepository repository;
    private DishIngredient dishIngredient;

    @Before
    public void setUp(){
        repository = mock(IngredientRepository.class);
        subject = new DishIngredientExistsSpec(repository);
        dishIngredient = new DishIngredient();
        dishIngredient.setIngredientId(new ObjectId());
    }

    @Test
    public void isSatisfyBySuccess() {
        when(repository.existsById(dishIngredient.getIngredientId())).thenReturn(true);
        boolean satisfyBy = subject.isSatisfyBy(dishIngredient);
        verify(repository).existsById(dishIngredient.getIngredientId());
        Assert.assertTrue(satisfyBy);
    }
}