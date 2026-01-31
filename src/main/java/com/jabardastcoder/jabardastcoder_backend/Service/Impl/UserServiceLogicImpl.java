package com.jabardastcoder.jabardastcoder_backend.Service.Impl;

import com.jabardastcoder.jabardastcoder_backend.DAO.UserProblemMapDAO;
import com.jabardastcoder.jabardastcoder_backend.DTO.Request.JabardastRequest;
import com.jabardastcoder.jabardastcoder_backend.DTO.Response.JabardastResponse;
import com.jabardastcoder.jabardastcoder_backend.Entity.CodeforcesProblemEntity;
import com.jabardastcoder.jabardastcoder_backend.Entity.UserEntity;
import com.jabardastcoder.jabardastcoder_backend.DAO.UserDAO;
import com.jabardastcoder.jabardastcoder_backend.Entity.UserProblemMapEntity;
import com.jabardastcoder.jabardastcoder_backend.Service.UserLogic;
import com.jabardastcoder.jabardastcoder_backend.Util.CFUtility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceLogicImpl implements UserLogic {


    @Autowired
    UserDAO userDAO;

    @Autowired
    CFUtility  cfutility;

    @Autowired
    UserProblemMapDAO userProblemMapDAO;

    @Override
    public Optional<UserEntity> checkUserExist(String email){
        Optional<UserEntity> userEntityOp = userDAO.findByEmail(email);
        return userEntityOp;
    }

    @Override
    public Optional<UserEntity> checkUserExist(Long userId){
        Optional<UserEntity> userEntityOp = userDAO.findById(userId);
        return userEntityOp;
    }

    @Override
    public List<JabardastResponse> getAllUsers() {
        List<UserEntity> list = userDAO.findAll();
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

    @Override
    public Iterable<UserProblemMapEntity> getExistingProblem(Long userId) {
        Specification<UserProblemMapEntity> specification = problemMapEntitySpecification(userId).and(isActive());
        return userProblemMapDAO.findAll(specification);
    }

    @Override
    public void saveUserProblems(List<UserProblemMapEntity> userProblemMapEntityLs) {
        userProblemMapDAO.saveAll(userProblemMapEntityLs);
    }

    private static Specification<UserProblemMapEntity> isActive() {
        return (root, query, cb) ->
                cb.isTrue(root.get("active"));
    }

    private static Specification<UserProblemMapEntity> problemMapEntitySpecification(Long userId) {
        return (root, query, cb) ->
                cb.equal(root.get("userId"), userId);
    }
}
