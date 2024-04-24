package com.havstrut.menumatic.model;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Mealplan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealplan_id") // Specify the column name
    private int mealplanId;

    @Column(name = "time_of_mealplan")
    private Timestamp timeOfMealplan;

    @Column(name = "name_of_mealplan")
    private String nameOfMealplan;

    @Column(name = "user_id")
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private RegisteredUser registeredUser;

    @ManyToMany
    @JoinTable(
            name = "recipe_mealplan", // Name of the bridge table
            joinColumns = @JoinColumn(name = "mealplan_id"), // Column in the bridge table that references Mealplan
            inverseJoinColumns = @JoinColumn(name = "recipe_id") // Column in the bridge table that references Recipe
    )
    private List<Recipe> recipeList = new ArrayList<Recipe>();
    //private Set<Recipe> recipes = new HashSet<>();


    @OneToMany(mappedBy = "mealplan")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ExcludedIngredient> excludedIngredientList = new ArrayList<ExcludedIngredient>();

    public Mealplan() {
    }

    public Mealplan(int mealplanId, Timestamp timeOfMealplan, String nameOfMealplan, String userId, RegisteredUser registeredUser, List<Recipe> recipeList, List<ExcludedIngredient> excludedIngredientList) {
        this.mealplanId = mealplanId;
        this.timeOfMealplan = timeOfMealplan;
        this.nameOfMealplan = nameOfMealplan;
        this.userId = userId;
        this.registeredUser = registeredUser;
        this.recipeList = recipeList;
        this.excludedIngredientList = excludedIngredientList;
    }

    public int getMealplanId() {
        return mealplanId;
    }

    public void setMealplanId(int mealplanId) {
        this.mealplanId = mealplanId;
    }

    public Timestamp getTimeOfMealplan() {
        return timeOfMealplan;
    }

    public void setTimeOfMealplan(Timestamp timeOfMealplan) {
        this.timeOfMealplan = timeOfMealplan;
    }

    public String getNameOfMealplan() {
        return nameOfMealplan;
    }

    public void setNameOfMealplan(String nameOfMealplan) {
        this.nameOfMealplan = nameOfMealplan;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public List<ExcludedIngredient> getExcludedIngredientList() {
        return excludedIngredientList;
    }

    public void setExcludedIngredientList(List<ExcludedIngredient> excludedIngredientList) {
        this.excludedIngredientList = excludedIngredientList;
    }
}
