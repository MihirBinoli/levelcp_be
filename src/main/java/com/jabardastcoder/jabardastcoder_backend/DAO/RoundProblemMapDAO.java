package com.jabardastcoder.jabardastcoder_backend.DAO;

import com.jabardastcoder.jabardastcoder_backend.Entity.RoundProblemMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoundProblemMapDAO extends JpaRepository<RoundProblemMapEntity, Long>, JpaSpecificationExecutor<RoundProblemMapEntity> {

}
