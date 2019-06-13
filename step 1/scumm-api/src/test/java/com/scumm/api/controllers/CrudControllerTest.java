package com.scumm.api.controllers;


import com.scumm.api.contracts.CategoryContract;
import com.scumm.core.domain.entities.Category;
import com.scumm.api.factories.ICategoryFactory;
import com.scumm.core.domain.repositories.CategoryRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CrudControllerTest {


    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
    private String id;
    private Category category;
    private Optional<Category> optionalCategory;
    private CategoryContract contract;
    private ICategoryFactory categoryFactory;
    private CategoryController controllerTest;

    @Before
    public void setup() {
        //mocks
        id = "5cff81cf7ae84c269cc8d6d4";
        categoryRepository = mock(CategoryRepository.class);
        modelMapper = mock(ModelMapper.class);
        categoryFactory = mock(ICategoryFactory.class);

        category = new Category();
        category.setId(new ObjectId(id));

        optionalCategory = Optional.of(category);

        contract = new CategoryContract();
        controllerTest = new CategoryController(categoryRepository, modelMapper, categoryFactory);
    }

    @Test
    public void getCategorySuccess() {
        //expectatives
        when(categoryRepository.findById(eq(new ObjectId(id)))).thenReturn(optionalCategory);
        when(modelMapper.map(category, CategoryContract.class)).thenReturn(contract);

        //test
        ResponseEntity<CategoryContract> response = controllerTest.getById(id);

        //verify
        verify(categoryRepository).findById(any(ObjectId.class));
        verify(modelMapper).map(category, CategoryContract.class);
        Assert.assertEquals(contract,response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getCategoryNotFound() {
        //expectatives
        //when(categoryRepository.findById(eq(new ObjectId(id)))).thenReturn(Optional.of(null));
        //when(modelMapper.map(category, CategoryContract.class)).thenReturn(contract);

        //test
        ResponseEntity<CategoryContract> response = controllerTest.getById(id);

        //verify
        verify(categoryRepository).findById(any(ObjectId.class));
        verify(modelMapper, never()).map(any(Category.class), eq(CategoryContract.class));
        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void deleteCategorySuccess() {
        // expectatives
        when(categoryRepository.findById(eq(new ObjectId(id)))).thenReturn(optionalCategory);
        when(modelMapper.map(category, CategoryContract.class)).thenReturn(contract);

        // test
        ResponseEntity<CategoryContract> response = controllerTest.deleteById(id);

        //Verify
        verify(categoryRepository).findById(any(ObjectId.class));
        verify(categoryRepository).deleteById(category.getId());
        verify(modelMapper).map(category, CategoryContract.class);

        Assert.assertEquals(contract, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteCategoryNotFound() {
        ResponseEntity<CategoryContract> response = controllerTest.deleteById(id);

        //Verify
        verify(categoryRepository).findById(any(ObjectId.class));
        verify(categoryRepository, never()).deleteById(new ObjectId(id));
        verify(modelMapper, never()).map(any(Category.class), eq(CategoryContract.class));
        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    
    @Test
    public void createCategory(){

        when(categoryFactory.createFromContract(contract)).thenReturn(category);

        //Test
        ResponseEntity<CategoryContract> contractReturned = controllerTest.createCategory(contract);

        verify(categoryFactory, times(1)).createFromContract(contract);
        verify(categoryRepository, times(1)).save(any(Category.class));
        verify(modelMapper, times(1)).map(any(Category.class), eq(CategoryContract.class));
    }

}
