package com.scumm.micros.dish;

import com.clitellum.MicroServiceBase;
import com.scumm.core.microservices.MicroBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DishMicroBean extends MicroBean {
    public DishMicroBean() {
        super();
    }

    @Override
    public String getName() {
        return "Bc Dish";
    }

    @Override
    public List<MicroServiceBase> getServices() {

        List<MicroServiceBase> services = new ArrayList<>();
        services.add(new IngredientsMicro(this.rabbitServer));
        return services;
    }
}
