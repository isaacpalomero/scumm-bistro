package com.scumm.micros.category;

import com.scumm.core.microservices.MicroBean;
import com.scumm.core.microservices.MicroRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryRunner extends MicroRunner {

    @Autowired
    private CategoryMicroBean categoryMicroBean;

    @Override
    public MicroBean getMicroBean() {
        return categoryMicroBean;
    }
}
