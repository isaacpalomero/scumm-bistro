package com.scumm.core.domain.specifications;

import java.util.List;

public interface ISpecification<TCandidate> {
    boolean isSatisfyBy(TCandidate candidate);

    boolean isSatisfyByAll(List<TCandidate> candidate);
}
