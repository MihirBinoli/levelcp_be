package com.jabardastcoder.jabardastcoder_backend.Service;

import com.jabardastcoder.jabardastcoder_backend.Entity.CodeforcesProblemEntity;

public interface RoundSubLogic {
    Iterable<CodeforcesProblemEntity> getContestProblems(Integer minRating, Integer maxRating);
}
