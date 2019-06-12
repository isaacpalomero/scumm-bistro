package com.scumm.api.mapping;

import com.scumm.api.builders.ModelMapperBuilder;
import com.scumm.api.contracts.CategoryContract;
import com.scumm.api.factories.CategoryFactory;
import com.scumm.core.domain.entities.Category;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.mock;

public class CategoryMapperTest {

    private CategoryContract categoryContract;
    private ModelMapper mapper;

    @Before
    public void setUp() throws Exception {
        ModelMapperBuilder modelMapperBuilder = new ModelMapperBuilder();
        mapper = modelMapperBuilder.build();
        categoryContract = new CategoryContract();
        categoryContract.setId(new ObjectId().toString());
        categoryContract.setName("Categoria1");
    }

    @Test
    public void map(){
        Category category = mapper.map(categoryContract, Category.class);
        Assert.assertEquals(categoryContract.getId(), category.getId().toString());
        Assert.assertEquals(categoryContract.getName(), category.getName());

    }
}
