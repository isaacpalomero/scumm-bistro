package com.scumm.micros.dish;

import com.scumm.core.microservices.MicroBean;
import com.scumm.core.microservices.MicroRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishRunner extends MicroRunner {

    @Autowired
    private DishMicroBean dishMicroBean;

    @Override
    public MicroBean getMicroBean() {
        return dishMicroBean;
    }
}
