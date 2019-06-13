package com.scumm.api.factories;

import com.scumm.api.contracts.Contract;
import com.scumm.core.domain.entities.Model;
import org.modelmapper.ModelMapper;

public class AbstractModelFactory<TModel extends Model, TContract extends Contract> implements IFactory<TModel, TContract> {
    protected ModelMapper mapper;
    private final Class<TModel> typeTModel;

    public AbstractModelFactory(ModelMapper mapper, Class<TModel> typeTModel) {
        this.mapper = mapper;
        this.typeTModel = typeTModel;
    }

    @Override
    public TModel createFromContract(TContract contract) {
        TModel model = mapper.map(contract, typeTModel);
        return model;
    }
}
