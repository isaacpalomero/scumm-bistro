package com.scumm.api.builders;

import org.bson.types.ObjectId;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperBuilder implements IModelMapperBuilder {

    @Override
    public ModelMapper build() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        //No convertr a Lambda Expression, el ModelMapper no se lleva muy bien con eso
        // y las conversiones no funcionan
        mapper.addConverter(new Converter<String, ObjectId>() {
            @Override
            public ObjectId convert(MappingContext<String, ObjectId> applicationContext) {
                if(applicationContext.getSource() == null) {
                    return null;
                }
                return new ObjectId(applicationContext.getSource());
            }
        });
        return mapper;
    }
}
