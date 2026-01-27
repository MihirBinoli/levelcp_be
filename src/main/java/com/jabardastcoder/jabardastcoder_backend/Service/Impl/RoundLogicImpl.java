package com.jabardastcoder.jabardastcoder_backend.Service.Impl;

import com.jabardastcoder.jabardastcoder_backend.DTO.UserRoundDTO;
import com.jabardastcoder.jabardastcoder_backend.Entity.UserEntity;
import com.jabardastcoder.jabardastcoder_backend.Service.RoundLogic;
import com.jabardastcoder.jabardastcoder_backend.Service.UserLogic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class RoundLogicImpl implements RoundLogic {


    @Autowired
    UserLogic userLogic;

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

            }
        }catch (Exception e){
            // user not registered and userid is null
            throw e;
        }
    }
}
