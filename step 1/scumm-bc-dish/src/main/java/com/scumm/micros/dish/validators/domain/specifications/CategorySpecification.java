package com.scumm.micros.dish.validators.domain.specifications;

public class CategorySpecification<TCandidate> implements ICategorySpecification<TCandidate> {


    @Override
    public boolean exists(TCandidate tCandidate) {
        return false;
    }
}
