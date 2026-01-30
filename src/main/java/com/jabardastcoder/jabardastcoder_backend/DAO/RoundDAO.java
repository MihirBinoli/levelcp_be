package com.jabardastcoder.jabardastcoder_backend.DAO;

import com.jabardastcoder.jabardastcoder_backend.Entity.RoundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundDAO extends JpaRepository<RoundEntity, Long> {
}
