package com.scumm.api;

import com.scumm.SharedConfiguration;
import com.scumm.api.builders.IModelMapperBuilder;
import org.bson.types.ObjectId;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@Import(SharedConfiguration.class)
public class App {

    @Autowired
    private IModelMapperBuilder modelMapperBuilder;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return modelMapperBuilder.build();
    }
}
