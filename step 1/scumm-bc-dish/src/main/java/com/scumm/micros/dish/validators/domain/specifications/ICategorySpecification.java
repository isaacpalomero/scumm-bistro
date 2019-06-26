package com.scumm.micros.dish.validators.domain.specifications;

public interface ICategorySpecification<TCandidate> {
    boolean exists(TCandidate candidate);
}
