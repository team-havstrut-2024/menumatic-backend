package com.havstrut.menumatic.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Embeddable
public class FavoriteDishId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "recipe_id")
    private int recipe_id;


    public FavoriteDishId() {
    }

    public FavoriteDishId(String userId, int recipe_id) {
        this.userId = userId;
        this.recipe_id = recipe_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }
}
