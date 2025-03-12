package com.havstrut.menumatic.model;

import jakarta.persistence.*;

@Entity
@Table
public class Recipe {

    @Id
    @Column(name = "recipe_id") // Specify the column name
    private int recipeId;

    @Column(name = "name_of_recipe")
    private String nameOfRecipe;

    @Column(name = "portions")
    private int portions;

    // Default constructor needed by JPA. Avoid using this, however.
    public Recipe() {
    }

    public Recipe(int recipeId, String nameOfRecipe, int portions) {
        this.recipeId = recipeId;
        this.nameOfRecipe = nameOfRecipe;
        this.portions = portions;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getNameOfRecipe() {
        return nameOfRecipe;
    }

    public void setNameOfRecipe(String nameOfRecipe) {
        this.nameOfRecipe = nameOfRecipe;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }
}
