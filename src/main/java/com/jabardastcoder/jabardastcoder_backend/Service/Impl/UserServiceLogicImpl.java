package com.jabardastcoder.jabardastcoder_backend.Service.Impl;

import com.jabardastcoder.jabardastcoder_backend.DTO.Request.JabardastRequest;
import com.jabardastcoder.jabardastcoder_backend.DTO.Response.JabardastResponse;
import com.jabardastcoder.jabardastcoder_backend.Entity.UserEntity;
import com.jabardastcoder.jabardastcoder_backend.Repository.UserRepository;
import com.jabardastcoder.jabardastcoder_backend.Service.UserLogic;
import com.jabardastcoder.jabardastcoder_backend.Util.CFUtility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceLogicImpl implements UserLogic {


    @Autowired
    UserRepository userRepository;

    @Autowired
    CFUtility  cfutility;

    @Override
    public Optional<UserEntity> checkUserExist(String email){
        Optional<UserEntity> userEntityOp = userRepository.findByEmail(email);
        return userEntityOp;
    }

    @Override
    public Optional<UserEntity> checkUserExist(Long userId){
        Optional<UserEntity> userEntityOp = userRepository.findById(userId);
        return userEntityOp;
    }

    @Override
    public List<JabardastResponse> getAllUsers() {
        List<UserEntity> list = userRepository.findAll();
        List<JabardastResponse> jabardastResponses = new ArrayList<>();

        list.forEach(userEntity -> {
            JabardastResponse jabardastResponse = new JabardastResponse();
            jabardastResponse.setName(userEntity.getUsername());
            jabardastResponse.setEmail(userEntity.getEmail());
            jabardastResponses.add(jabardastResponse);
        });
        return jabardastResponses;
    }

    @Override
    public void fetchAndUpdateProblems(JabardastRequest request) {
        try {
            cfutility.fetchAndUpdateProblems();
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
