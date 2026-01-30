package com.jabardastcoder.jabardastcoder_backend.DAO;

import com.jabardastcoder.jabardastcoder_backend.Entity.UserProblemMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserProblemMapDAO extends JpaRepository<UserProblemMapEntity, Long>, JpaSpecificationExecutor<UserProblemMapEntity> {
}
