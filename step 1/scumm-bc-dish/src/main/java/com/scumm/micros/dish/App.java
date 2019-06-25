package com.scumm.micros.dish;

import com.scumm.SharedConfiguration;
import com.scumm.core.microservices.MicroApp;
import org.bson.types.ObjectId;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(SharedConfiguration.class)
public class App  extends MicroApp {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper = new ModelMapper();
        mapper.addConverter(new Converter<String, ObjectId>() {
            @Override
            public ObjectId convert(MappingContext<String, ObjectId> applicationContext) {
                return new ObjectId(applicationContext.getSource());
            }
        });

        return mapper;
    }
}
