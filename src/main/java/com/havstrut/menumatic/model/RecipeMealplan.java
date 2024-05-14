package com.havstrut.menumatic.model;

import jakarta.persistence.*;


@Entity
@Table
public class RecipeMealplan {
    /**
     * Behöver en @Embedded
     */
    @EmbeddedId
    private RecipeMealplanId recipeMealplanId;

    // Default constructor needed by JPA. Avoid using this, however.
    public RecipeMealplan() {
    }

    public RecipeMealplan(RecipeMealplanId recipeMealplanId)
    {
        this.recipeMealplanId = recipeMealplanId;
    }

    public RecipeMealplanId getRecipeMealplanId() {
        return recipeMealplanId;
    }

    public void setRecipeMealplanId(RecipeMealplanId recipeMealplanId) {
        this.recipeMealplanId = recipeMealplanId;
    }

}
