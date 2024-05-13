package com.havstrut.menumatic.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table
public class ApiLimit {
    @Id
    @Column(name = "interval")
    private LocalDateTime lastResetTime;

    @Column(name = "counter_limit")
    private int countLimit;

    public ApiLimit() {
    }

    public ApiLimit(LocalDateTime lastResetTime, int countLimit) {
        this.lastResetTime = lastResetTime;
        this.countLimit = countLimit;
    }

    public LocalDateTime getLastResetTime() {
        return lastResetTime;
    }

    public void setLastResetTime(LocalDateTime lastResetTime) {
        this.lastResetTime = lastResetTime;
    }

    public int getCountLimit() {
        return countLimit;
    }

    public void setCountLimit(int countLimit) {
        this.countLimit = countLimit;
    }
}
