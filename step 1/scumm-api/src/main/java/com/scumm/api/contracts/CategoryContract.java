package com.scumm.api.contracts;

import javax.validation.constraints.NotEmpty;

public class CategoryContract extends Contract {


    @NotEmpty(message = "first_name can not be empty")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
