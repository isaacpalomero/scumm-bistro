package com.scumm.core.domain.specifications;

import java.util.List;

public abstract class Specification<TCandidate> implements ISpecification<TCandidate> {

    @Override
    public boolean isSatisfyByAll(List<TCandidate> candidate) {
        return candidate.stream().allMatch(this::isSatisfyBy);
    }
}
