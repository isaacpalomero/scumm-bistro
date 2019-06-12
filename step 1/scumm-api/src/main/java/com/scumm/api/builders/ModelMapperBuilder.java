package com.scumm.api.builders;

import org.bson.types.ObjectId;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperBuilder implements IModelMapperBuilder {
    @Override
    public ModelMapper build() {
        ModelMapper mapper = new ModelMapper();
        mapper.addConverter((Converter<String, ObjectId>) applicationContext -> {
            return new ObjectId(applicationContext.getSource());
        });

        return mapper;
    }
}
