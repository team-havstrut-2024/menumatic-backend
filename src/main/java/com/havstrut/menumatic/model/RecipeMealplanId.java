package com.havstrut.menumatic.model;

import jakarta.persistence.*;
import java.util.Objects;


import java.io.Serializable;

@Embeddable
public class RecipeMealplanId implements Serializable{

    @Column(name = "recipe_id")
    private int recipeId;
    @Column(name = "mealplan_id")
    private int mealplanId;

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

    /**
     * May be deleted later if not needed. Java has built-in methods..
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeMealplanId that = (RecipeMealplanId) o;
        return recipeId == that.recipeId &&
                mealplanId == that.mealplanId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, mealplanId);
    }
}
