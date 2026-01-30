package com.jabardastcoder.jabardastcoder_backend.Service.Impl;

import com.jabardastcoder.jabardastcoder_backend.DTO.UserRoundDTO;
import com.jabardastcoder.jabardastcoder_backend.Entity.*;
import com.jabardastcoder.jabardastcoder_backend.DAO.LevelsDAO;
import com.jabardastcoder.jabardastcoder_backend.DAO.RoundDAO;
import com.jabardastcoder.jabardastcoder_backend.Service.RoundLogic;
import com.jabardastcoder.jabardastcoder_backend.Service.UserLogic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@Transactional
public class RoundLogicImpl implements RoundLogic {


    @Autowired
    UserLogic userLogic;

    @Autowired
    RoundDAO roundDAO;

    @Autowired
    LevelsDAO levelsDAO;

    @Autowired
    RoundSubLogicImpl roundSubLogic;



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
                    Optional<LevelsEntity> levelsEntityOp = levelsDAO.findByLevelNumber(levelId);

                    Integer minRating = levelsEntityOp.get().getMinRating(),
                            maxRating = levelsEntityOp.get().getMaxRating();

                    // fetch the problems in range of rating
                    Iterable<CodeforcesProblemEntity> cfProblems = roundSubLogic.getContestProblems(minRating, maxRating);
                    // fetch and filter the problems which are already mapped with user to avoid that
                    Iterable<UserProblemMapEntity> userProblemMapEntities = userLogic.getExistingProblem(userEntity.getId());
                    Set<String> userExistingProblems = StreamSupport.stream(userProblemMapEntities.spliterator(), false)
                            .map( ent ->
                                    {
                                        return ent.getContestId() + "~" + ent.getProblemId();
                                    }
                            ).collect(Collectors.toSet());

                    Map<String, CodeforcesProblemEntity> codeforcesProblemEntityMap = StreamSupport.stream(cfProblems.spliterator(), false)
                            .filter(ent -> !userExistingProblems.contains(ent.getCfContestId()+"~"+ent.getCfProblemId()))
                            .collect(Collectors.toMap(
                                    ent -> {
                                        String key = ent.getCfContestId() + "~" + ent.getCfProblemId();
                                        return key;
                                    }, Function.identity(), (a , b) ->
                                            a.getCfProblemSolvedCount() >= b.getCfProblemSolvedCount() ?
                                                    a : b
                            ));
                    List<CodeforcesProblemEntity> newContestProblems = new ArrayList<>();
                    // get 4 problems 3 easy and 1 medium according to solve count

                    Integer totalSolveCount = codeforcesProblemEntityMap.values().stream()
                            .mapToInt(CodeforcesProblemEntity::getCfProblemSolvedCount).sum();




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
