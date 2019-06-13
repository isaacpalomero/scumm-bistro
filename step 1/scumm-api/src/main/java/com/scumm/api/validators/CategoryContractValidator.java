package com.scumm.api.validators;

import com.scumm.api.contracts.CategoryContract;
import org.springframework.stereotype.Component;

@Component
public class CategoryContractValidator implements IContractValidator<CategoryContract> {

    @Override
    public boolean validate(CategoryContract contract) {
        return true;
    }
}
