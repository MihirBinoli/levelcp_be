package com.jabardastcoder.jabardastcoder_backend.Service.Impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.jabardastcoder.jabardastcoder_backend.DTO.UserRoundDTO;
import com.jabardastcoder.jabardastcoder_backend.Entity.LevelsEntity;
import com.jabardastcoder.jabardastcoder_backend.Entity.RoundEntity;
import com.jabardastcoder.jabardastcoder_backend.Entity.UserEntity;
import com.jabardastcoder.jabardastcoder_backend.Repository.CodeforcesProblemRepository;
import com.jabardastcoder.jabardastcoder_backend.Repository.LevelsRepository;
import com.jabardastcoder.jabardastcoder_backend.Repository.RoundRepository;
import com.jabardastcoder.jabardastcoder_backend.Service.RoundLogic;
import com.jabardastcoder.jabardastcoder_backend.Service.UserLogic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
public class RoundLogicImpl implements RoundLogic {


    @Autowired
    UserLogic userLogic;

    @Autowired
    RoundRepository roundRepository;

    @Autowired
    LevelsRepository levelsRepository;

    @Autowired
    CodeforcesProblemRepository codeforcesProblemRepository;



    @Override
    public UserRoundDTO createRound(UserRoundDTO userRoundDTO) {
        /*
User
 → Start Round
 → Problems assigned
 → Solve on Codeforces
 → Fetch submissions
 → Evaluate round
 → Update level
        * */
        try {
            Optional<UserEntity> userEntityOp = userLogic.checkUserExist(userRoundDTO.getUserId());

            if(userEntityOp.isPresent()){
                // user registered
                UserEntity userEntity = userEntityOp.get();
                String cfHandle = userEntity.getCodeforcesHandle();
                if(Objects.nonNull(cfHandle)){
                    // fetch current rating and maxrating from level id
                    Integer levelId = userEntity.getCurrentLevelId();
                    // fetch min - max rating on the basis of user current level
                    Optional<LevelsEntity> levelsEntityOp = levelsRepository.findByLevelNumber(levelId);

                    Integer minRating = levelsEntityOp.get().getMinRating(),
                            maxRating = levelsEntityOp.get().getMaxRating();




                }else{
                    // prompt user to sync codeforces id and then try again
                }

            }
            return null;
        }catch (Exception e){
            // user not registered and userid is null
            throw e;
        }
    }
}
