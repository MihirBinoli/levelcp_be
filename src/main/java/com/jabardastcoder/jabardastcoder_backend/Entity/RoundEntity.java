package com.jabardastcoder.jabardastcoder_backend.Entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "user_rounds")
public class RoundEntity implements Serializable {

    private static final long serialVersionUID = -2632996101239071748L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "level_id")
    private Long levelId;

    @Column(name = "start_time")
    private OffsetDateTime startTime;

    @Column(name = "end_time")
    private OffsetDateTime endTime;

    @Column(name = "status")
    private OffsetDateTime status;

    @Column(name = "active")
    private OffsetDateTime active;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "version")
    private Integer version;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public OffsetDateTime getStatus() {
        return status;
    }

    public void setStatus(OffsetDateTime status) {
        this.status = status;
    }

    public OffsetDateTime getActive() {
        return active;
    }

    public void setActive(OffsetDateTime active) {
        this.active = active;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
