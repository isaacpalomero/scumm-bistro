package com.scumm.api.controllers;

import com.scumm.api.contracts.CategoryContract;
import com.scumm.api.factories.CategoryFactory;
import com.scumm.api.validators.IContractValidator;
import com.scumm.core.domain.entities.Category;
import com.scumm.api.factories.ICategoryFactory;
import com.scumm.core.domain.repositories.CategoryRepository;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractCrudController<CategoryRepository, ICategoryFactory, Category, CategoryContract> {

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, ModelMapper modelMapper, ICategoryFactory categoryFactory, IContractValidator<CategoryContract> validator) {
        super(categoryRepository, modelMapper, categoryFactory, validator, CategoryContract.class);
    }


}
