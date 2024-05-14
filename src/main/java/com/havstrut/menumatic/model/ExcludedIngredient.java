package com.havstrut.menumatic.model;


import jakarta.persistence.*;


@Entity
@Table
public class ExcludedIngredient {

    @EmbeddedId
    private ExcludedIngredientId excludedIngredientId;

    // Default constructor needed by JPA. Avoid using this, however.
    public ExcludedIngredient() {
    }

    public ExcludedIngredient(ExcludedIngredientId excludedIngredientId) {
        this.excludedIngredientId = excludedIngredientId;
    }

    public ExcludedIngredientId getExcludedIngredientId() {
        return excludedIngredientId;
    }

    public void setExcludedIngredientId(ExcludedIngredientId excludedIngredientId) {
        this.excludedIngredientId = excludedIngredientId;
    }
}
