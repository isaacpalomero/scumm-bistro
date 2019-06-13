package com.scumm.api.mapping;

import com.scumm.api.builders.ModelMapperBuilder;
import com.scumm.api.contracts.IngredientContract;
import com.scumm.core.domain.entities.Ingredient;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

public class IngredientMapperTest {

    private IngredientContract contract;
    private ModelMapper mapper;

    @Before
    public void setUp() throws Exception {
        ModelMapperBuilder modelMapperBuilder = new ModelMapperBuilder();
        mapper = modelMapperBuilder.build();
        contract = new IngredientContract();
        contract.setId(new ObjectId().toString());
        contract.setName("Quinoa");
    }

    @Test
    public void map(){
        Ingredient category = mapper.map(contract, Ingredient.class);
        Assert.assertNotNull(category.getId());
        Assert.assertEquals(contract.getId(), category.getId().toString());
        Assert.assertEquals(contract.getName(), category.getName());

    }
}
