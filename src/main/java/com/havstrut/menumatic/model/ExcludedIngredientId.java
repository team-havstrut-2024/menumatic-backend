package com.havstrut.menumatic.model;

import jakarta.persistence.*;


import java.io.Serializable;

@Embeddable
public class ExcludedIngredientId implements Serializable {

    @Column(name = "mealplan_id")
    private int mealplanId;
    @Column(name = "name_of_excluded_ingredient")
    private String nameOfExcludedIngredient;

    public ExcludedIngredientId(int mealplanId, String nameOfExcludedIngredient) {
        this.mealplanId = mealplanId;
        this.nameOfExcludedIngredient = nameOfExcludedIngredient;
    }
    // Default constructor needed by JPA. Avoid using this, however.
    public ExcludedIngredientId() {
    }

    public int getMealplanId() {
        return mealplanId;
    }

    public void setMealplanId(int mealplanId) {
        this.mealplanId = mealplanId;
    }

    public String getNameOfExcludedIngredient() {
        return nameOfExcludedIngredient;
    }

    public void setNameOfExcludedIngredient(String nameOfExcludedIngredient) {
        this.nameOfExcludedIngredient = nameOfExcludedIngredient;
    }

}
