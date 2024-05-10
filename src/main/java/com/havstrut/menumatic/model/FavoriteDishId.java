package com.havstrut.menumatic.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Embeddable
public class FavoriteDishId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "recipe_id")
    private int recipeId;

    // Default constructor needed by JPA. Avoid using this, however.
    public FavoriteDishId() {
    }


    public FavoriteDishId(String userId, int recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
