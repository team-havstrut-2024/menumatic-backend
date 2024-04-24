package com.havstrut.menumatic.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table
public class RecipeMealplan {
    /**
     * Behöver en @Embedded
     */
    @EmbeddedId
    private RecipeMealplanId recipeMealplanId;

    @Column(name = "portions")
    private int portions;




    public RecipeMealplan() {
    }

    public RecipeMealplan(RecipeMealplanId recipeMealplanId) {
        this.recipeMealplanId = recipeMealplanId;
    }

    public RecipeMealplanId getRecipeMealplanId() {
        return recipeMealplanId;
    }

    public void setRecipeMealplanId(RecipeMealplanId recipeMealplanId) {
        this.recipeMealplanId = recipeMealplanId;
    }



}
