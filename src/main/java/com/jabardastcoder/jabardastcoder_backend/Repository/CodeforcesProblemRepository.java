package com.jabardastcoder.jabardastcoder_backend.Repository;

import com.jabardastcoder.jabardastcoder_backend.Entity.CodeforcesProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeforcesProblemRepository extends JpaRepository<CodeforcesProblemEntity, Long> {
}
