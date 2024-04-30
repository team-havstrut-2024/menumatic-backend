package com.havstrut.menumatic.model;

import jakarta.persistence.*;


@Embeddable
public class FoodPreferenceId {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "preference")
    private String preference;
    
    public FoodPreferenceId() {
    }

    public FoodPreferenceId(String userId, String preference) {
        this.userId = userId;
        this.preference = preference;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
