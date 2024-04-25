package com.havstrut.menumatic.model;


import jakarta.persistence.*;
import jdk.jfr.ContentType;

@Entity
@Table
public class ExcludedIngredient {

    @EmbeddedId
    private ExcludedIngredientId excludedIngredientId;

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
