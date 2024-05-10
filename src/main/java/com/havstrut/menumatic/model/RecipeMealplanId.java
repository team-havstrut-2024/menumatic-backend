package com.havstrut.menumatic.model;

import jakarta.persistence.*;


import java.io.Serializable;

@Embeddable
public class RecipeMealplanId implements Serializable{

    @Column(name = "recipe_id")
    private int recipeId;
    @Column(name = "mealplan_id")
    private int mealplanId;

    // Default constructor needed by JPA. Avoid using this, however.
    public RecipeMealplanId() {
    }

    public RecipeMealplanId(int recipeId, int mealplanId) {
        this.recipeId = recipeId;
        this.mealplanId = mealplanId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getMealplanId() {
        return mealplanId;
    }

    public void setMealplanId(int mealplanId) {
        this.mealplanId = mealplanId;
    }

}
