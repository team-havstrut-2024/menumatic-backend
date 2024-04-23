package com.havstrut.menumatic.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table
public class RecipeMealplan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealplan_id") // Specify the column name
    private int mealplanId;

    @Column(name = "time_of_meal_plan")
    private Timestamp timeOfMealplan;

    @Column(name = "name_of_mealplan")
    private String nameOfMealplan;

    public RecipeMealplan(int mealplanId, Timestamp timeOfMealplan, String nameOfMealplan) {
        this.mealplanId = mealplanId;
        this.timeOfMealplan = timeOfMealplan;
        this.nameOfMealplan = nameOfMealplan;
    }

    public RecipeMealplan() {

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
}
