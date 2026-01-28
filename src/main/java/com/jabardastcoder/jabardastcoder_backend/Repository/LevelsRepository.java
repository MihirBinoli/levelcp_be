package com.jabardastcoder.jabardastcoder_backend.Repository;

import com.jabardastcoder.jabardastcoder_backend.Entity.LevelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelsRepository extends JpaRepository<LevelsEntity, Long> {

    Optional<LevelsEntity> findByLevelNumber(Integer levelNumber);
}
