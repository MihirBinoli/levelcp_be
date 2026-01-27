package com.jabardastcoder.jabardastcoder_backend.DTO;

import java.util.List;

public class UserRoundDTO {

    private Integer id;
    private Long userId;
    private String userName;
    private Long roundId;
    private String roundName;
    private Long levelId;
    private List<ProblemsDTO> userProblems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public List<ProblemsDTO> getUserProblems() {
        return userProblems;
    }

    public void setUserProblems(List<ProblemsDTO> userProblems) {
        this.userProblems = userProblems;
    }
}
