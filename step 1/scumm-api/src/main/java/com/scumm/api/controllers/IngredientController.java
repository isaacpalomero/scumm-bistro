package com.scumm.api.controllers;

import com.scumm.core.domain.repositories.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private IngredientRepository repository;

    private ModelMapper mapper;

    @Autowired
    public IngredientController(IngredientRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.mapper = modelMapper;

    }

}
