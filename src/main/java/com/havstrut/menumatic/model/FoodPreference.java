package com.havstrut.menumatic.model;

import jakarta.persistence.*;

@Entity
@Table
public class FoodPreference {


    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "preference")
    private String preference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private RegisteredUser registeredUser;

    public FoodPreference(String userId, String preference, RegisteredUser registeredUser) {
        this.userId = userId;
        this.preference = preference;
        this.registeredUser = registeredUser;
    }

    public FoodPreference() {
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

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }
}
