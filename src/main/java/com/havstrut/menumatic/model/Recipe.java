package com.havstrut.menumatic.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id") // Specify the column name
    private int recipeId;

    @Column(name = "name_of_recipe")
    private String nameOfRecipe;

    @ManyToMany(mappedBy = "recipeList")
    private List<Mealplan> mealplanList = new ArrayList<Mealplan>();

    //private Set<Mealplan> mealplans = new HashSet<>();

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
