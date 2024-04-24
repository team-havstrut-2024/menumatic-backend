package com.havstrut.menumatic.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity //For hibernate
@Table  //For table in our database
public class RegisteredUser {


    @Id
    private String userId;

    private String email;

    @OneToMany(mappedBy = "registeredUser")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<FoodPreference> foodPreferenceList = new ArrayList<FoodPreference>();
    //private Set<FoodPreference> foodPreferences = new HashSet<>();

    @OneToMany(mappedBy = "registeredUser")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Mealplan> mealplanList = new ArrayList<Mealplan>();



    public RegisteredUser(String email) {
        this.email = email;
    }

    public RegisteredUser() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
