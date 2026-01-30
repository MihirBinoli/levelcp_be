package com.jabardastcoder.jabardastcoder_backend.Service.Impl;

import com.jabardastcoder.jabardastcoder_backend.Entity.CodeforcesProblemEntity;
import com.jabardastcoder.jabardastcoder_backend.DAO.CodeforcesProblemDAO;
import com.jabardastcoder.jabardastcoder_backend.Service.RoundSubLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RoundSubLogicImpl implements RoundSubLogic {


    @Autowired
    CodeforcesProblemDAO codeforcesProblemDAO;

    @Override
    public Iterable<CodeforcesProblemEntity> getContestProblems(Integer minRating, Integer maxRating) {
        Specification<CodeforcesProblemEntity> specification = hasRatingBetween(minRating, maxRating).and(isActive());
        return codeforcesProblemDAO.findAll(specification);
    }

    private static Specification<CodeforcesProblemEntity> hasRatingBetween(Integer min, Integer max) {

        return (root, query, cb) -> {
            if (min == null || max == null) return null;
            return cb.between(root.get("problemRating"), min, max);
        };
    }

    private static Specification<CodeforcesProblemEntity> isActive() {
        return (root, query, cb) ->
                cb.isTrue(root.get("active"));
    }

    private static Specification<CodeforcesProblemEntity> hasTag(String tag) {
        return (root, query, cb) ->
                cb.like(root.get("problemTags"), "%" + tag + "%");
    }
}
