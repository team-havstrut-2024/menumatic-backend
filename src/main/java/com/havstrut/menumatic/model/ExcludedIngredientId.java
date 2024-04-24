package com.havstrut.menumatic.model;

import jakarta.persistence.*;
import java.util.Objects;


import java.io.Serializable;

@Embeddable
public class ExcludedIngredientId implements Serializable {

    @Column(name = "mealplan_id")
    //@Column(name = "mealplan_id", insertable=false, updatable=false)
    private int mealplanId;
    @Column(name = "name_of_excluded_ingredient")
    private String nameOfExcludedIngredient;

    public ExcludedIngredientId(int mealplanId, String nameOfExcludedIngredient) {
        this.mealplanId = mealplanId;
        this.nameOfExcludedIngredient = nameOfExcludedIngredient;
    }

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

    /**
     * May be deleted later if not needed. Java has built-in methods..
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcludedIngredientId that = (ExcludedIngredientId) o;
        return mealplanId == that.mealplanId &&
                Objects.equals(nameOfExcludedIngredient, that.nameOfExcludedIngredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealplanId, nameOfExcludedIngredient);
    }
}
