package com.scumm.api.validators;

import com.scumm.api.contracts.Contract;

public interface IContractValidator<TContract extends Contract> {

    boolean validate(TContract contract);
}
