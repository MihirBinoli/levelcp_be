package com.jabardastcoder.jabardastcoder_backend.DAO;

import com.jabardastcoder.jabardastcoder_backend.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
