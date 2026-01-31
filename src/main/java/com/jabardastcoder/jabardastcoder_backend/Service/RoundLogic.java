package com.jabardastcoder.jabardastcoder_backend.Service;

import com.jabardastcoder.jabardastcoder_backend.DTO.UserRoundDTO;

import java.util.List;

public interface RoundLogic {
    UserRoundDTO createRound(UserRoundDTO userRoundDTO);

    List<UserRoundDTO> getPreviousRound(Long userId);
}
