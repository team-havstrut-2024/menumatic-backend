package com.havstrut.menumatic.model;

import jakarta.persistence.*;

@Entity
@Table
public class FoodPreference {

   @EmbeddedId
   FoodPreferenceId foodPreferenceId;

    // Default constructor needed by JPA. Avoid using this, however.
    public FoodPreference() {
    }

    public FoodPreference(FoodPreferenceId foodPreferenceId) {
        this.foodPreferenceId = foodPreferenceId;
    }

    public FoodPreferenceId getFoodPreferenceId() {
        return foodPreferenceId;
    }

    public void setFoodPreferenceId(FoodPreferenceId foodPreferenceId) {
        this.foodPreferenceId = foodPreferenceId;
    }



}
