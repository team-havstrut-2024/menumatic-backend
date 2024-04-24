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


    public Recipe() {
    }

    public Recipe(int recipeId, String nameOfRecipe, List<Mealplan> mealplanList) {
        this.recipeId = recipeId;
        this.nameOfRecipe = nameOfRecipe;
        this.mealplanList = mealplanList;
    }

    public List<Mealplan> getMealplanList() {
        return mealplanList;
    }

    public void setMealplanList(List<Mealplan> mealplanList) {
        this.mealplanList = mealplanList;
    }
}
