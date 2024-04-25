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

    public Recipe(int recipeId, String nameOfRecipe) {
        this.recipeId = recipeId;
        this.nameOfRecipe = nameOfRecipe;
    }

    public Recipe() {
    }
}
