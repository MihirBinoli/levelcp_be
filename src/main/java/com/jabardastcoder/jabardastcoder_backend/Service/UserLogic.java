package com.jabardastcoder.jabardastcoder_backend.Service;


import com.jabardastcoder.jabardastcoder_backend.DTO.Request.JabardastRequest;
import com.jabardastcoder.jabardastcoder_backend.DTO.Response.JabardastResponse;
import com.jabardastcoder.jabardastcoder_backend.DTO.UserRoundDTO;
import com.jabardastcoder.jabardastcoder_backend.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserLogic {


    Optional<UserEntity> checkUserExist(String email);

    Optional<UserEntity> checkUserExist(Long userId);

    List<JabardastResponse> getAllUsers();

    void fetchAndUpdateProblems(JabardastRequest request);
}
