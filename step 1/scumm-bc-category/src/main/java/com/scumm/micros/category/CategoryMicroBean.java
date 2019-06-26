package com.scumm.micros.category;

import com.clitellum.MicroServiceBase;
import com.scumm.core.microservices.MicroBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMicroBean extends MicroBean {
    public CategoryMicroBean() {
        super();
    }

    @Override
    public String getName() {
        return "Bc Category";
    }

    @Override
    public List<MicroServiceBase> getServices() {

        List<MicroServiceBase> services = new ArrayList<>();
        services.add(new CategorySyncMicro(this.rabbitServer));
        return services;
    }
}
