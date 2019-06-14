package com.scumm.api.factories;

import com.scumm.api.contracts.DishIngredientContract;
import com.scumm.core.domain.entities.DishIngredient;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class DishIngredientFactoryTest {

    private DishIngredientFactory factory;
    private List<DishIngredientContract> contracts;
    private List<DishIngredient> models;
    private ModelMapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = mock(ModelMapper.class);

        DishIngredient model = new DishIngredient();
        models = Collections.singletonList(model);

        DishIngredientContract contract = new DishIngredientContract();
        contract.setIngredientId(new ObjectId().toString());
        contract.setQuantity(1);
        contracts = Collections.singletonList(contract);
        factory = new DishIngredientFactory(mapper);
    }

    @Test
    public void createFromContract() {
        Type listType = new TypeToken<List<DishIngredient>>() {}.getType();
        when(mapper.map(contracts, listType)).thenReturn(Collections.singletonList(models));

        List<DishIngredient> dishIngredients = factory.createDishIngredientsFromContracts(contracts);
        Assert.assertNotNull(dishIngredients);

        verify(mapper, times(1)).map(contracts, listType);
    }
}