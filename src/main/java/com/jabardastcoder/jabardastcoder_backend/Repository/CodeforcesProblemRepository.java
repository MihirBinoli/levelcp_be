package com.jabardastcoder.jabardastcoder_backend.Repository;

import com.jabardastcoder.jabardastcoder_backend.Entity.CodeforcesProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeforcesProblemRepository extends JpaRepository<CodeforcesProblemEntity, Long> {

    Optional<CodeforcesProblemEntity> findByCfContestIdAndCfProblemId(Integer contestId, String index);
}
