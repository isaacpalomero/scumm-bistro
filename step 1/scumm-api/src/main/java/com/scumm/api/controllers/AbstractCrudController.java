package com.scumm.api.controllers;

import com.scumm.api.contracts.Contract;
import com.scumm.api.factories.ICategoryFactory;
import com.scumm.api.factories.IFactory;
import com.scumm.core.domain.entities.Model;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractCrudController<TRepository extends MongoRepository<TModel, ObjectId>,
        TFactory extends IFactory<TModel, TContract>,TModel extends Model,TContract extends Contract> {
    protected TRepository repository;
    protected ModelMapper mapper;
    protected TFactory factory;
    private final Class<TContract> typeTContract;

    protected AbstractCrudController(TRepository repository, ModelMapper modelMapper, TFactory factory, Class<TContract> typeTContract) {
        this.repository = repository;
        mapper = modelMapper;
        this.factory = factory;
        this.typeTContract = typeTContract;
    }

    @GetMapping
    public List<TContract> getAll() {
        List<TModel> list = repository.findAll();
        return  list.stream()
                .map(entity -> mapper.map(entity, typeTContract))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<TContract> getById(@PathVariable String id) {
        Optional<TModel> byId = repository.findById(new ObjectId(id));
        if (byId.isPresent())
        {
            TContract contract = mapper.map(byId.get(), typeTContract);
            return new ResponseEntity<>(contract, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TContract> createCategory(@Valid @RequestBody TContract contract) {

        TModel model = factory.createFromContract(contract);
        repository.save(model);
        return new ResponseEntity<>(mapper.map(model, typeTContract), HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<TContract> updateById(@PathVariable String id, @Valid @RequestBody TContract TContract) {
        Optional<TModel> byId = repository.findById(new ObjectId(id));
        if (byId.isPresent())
        {
            mapper.map(TContract, byId.get());
            repository.save(byId.get());
            TContract contract = mapper.map(byId.get(), typeTContract);
            return new ResponseEntity<>(contract, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<TContract> deleteById(@PathVariable String id) {
        Optional<TModel> byId = repository.findById(new ObjectId(id));
        if (byId.isPresent())
        {
            repository.deleteById(byId.get().getId());
            TContract contract = mapper.map(byId.get(), typeTContract);
            return new ResponseEntity<>(contract, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
