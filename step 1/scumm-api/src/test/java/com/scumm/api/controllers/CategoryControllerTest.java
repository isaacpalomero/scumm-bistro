package com.scumm.api.controllers;


import com.scumm.api.contracts.CategoryContract;
import com.scumm.core.domain.entities.Category;
import com.scumm.core.domain.repositories.CategoryRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CategoryControllerTest {

    @Test
    public void testGet() {
        //mocks
        String id = "5cff81cf7ae84c269cc8d6d4";
        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        ModelMapper modelMapper = mock(ModelMapper.class);

        Category category = new Category();

        Optional<Category> optionalCategory = Optional.of(category);

        CategoryContract contract = new CategoryContract();

        //expectatives
        when(categoryRepository.findById(eq(new ObjectId(id)))).thenReturn(optionalCategory);
        when(modelMapper.map(category, CategoryContract.class)).thenReturn(contract);

        //test
        CategoryController controllerTest = new CategoryController(categoryRepository,modelMapper);
        ResponseEntity<CategoryContract> response = controllerTest.getById(id);

        //verify
        verify(categoryRepository).findById(any(ObjectId.class));
        verify(modelMapper).map(category, CategoryContract.class);
        Assert.assertEquals(contract,response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}
