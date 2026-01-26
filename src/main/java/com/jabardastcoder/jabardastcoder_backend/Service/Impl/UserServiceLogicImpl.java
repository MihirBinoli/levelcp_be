package com.jabardastcoder.jabardastcoder_backend.Service.Impl;

import com.jabardastcoder.jabardastcoder_backend.DTO.Request.LoginRequest;
import com.jabardastcoder.jabardastcoder_backend.DTO.Response.JabardastResponse;
import com.jabardastcoder.jabardastcoder_backend.DTO.Response.LoginResponse;
import com.jabardastcoder.jabardastcoder_backend.Entity.UserEntity;
import com.jabardastcoder.jabardastcoder_backend.Repository.UserRepository;
import com.jabardastcoder.jabardastcoder_backend.Service.UserServiceLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceLogicImpl implements UserServiceLogic {


    @Autowired
    UserRepository userRepository;

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



}
