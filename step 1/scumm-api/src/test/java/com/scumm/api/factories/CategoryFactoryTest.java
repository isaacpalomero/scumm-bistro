package com.scumm.api.factories;

import com.scumm.api.contracts.CategoryContract;
import com.scumm.core.domain.entities.Category;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.*;

public class CategoryFactoryTest {

    private CategoryFactory factory;
    private CategoryContract categoryContract;
    private Category category;
    private ModelMapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = mock(ModelMapper.class);
        category = new Category();
        categoryContract = new CategoryContract();
        categoryContract.setId(new ObjectId().toString());
        categoryContract.setName("Categoria1");
        factory = new CategoryFactory(mapper);
    }

    @Test
    public void createFromContract() {
        when(mapper.map(categoryContract, Category.class)).thenReturn(category);
        Category fromContract = factory.createFromContract(categoryContract);
        Assert.assertNotNull(fromContract);

        verify(mapper).map(categoryContract, Category.class);
    }
}