package com.havstrut.menumatic.model;

import jakarta.persistence.*;

@Entity
@Table
public class FoodPreference {


    @Id
    private String userId;

    private String preference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private RegisteredUser registeredUser;

}
