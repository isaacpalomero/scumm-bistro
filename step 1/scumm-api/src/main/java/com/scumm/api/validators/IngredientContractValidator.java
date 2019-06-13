package com.scumm.api.validators;

import com.scumm.api.contracts.IngredientContract;

public class IngredientContractValidator implements IContractValidator<IngredientContract>  {


    @Override
    public boolean validate(IngredientContract contract) { return true; }
}
