package com.scumm.api.factories;

import com.scumm.api.contracts.Contract;
import com.scumm.core.domain.entities.Model;

public interface IFactory<TModel extends Model, TContract extends Contract> {
    TModel createFromContract(TContract contract);
}
