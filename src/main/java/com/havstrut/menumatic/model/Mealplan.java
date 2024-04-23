package com.havstrut.menumatic.model;


import jakarta.persistence.*;

import java.sql.Timestamp;

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
    private int userId;

    public Mealplan(int mealplanId, Timestamp timeOfMealplan, String nameOfMealplan, int userId) {
        this.mealplanId = mealplanId;
        this.timeOfMealplan = timeOfMealplan;
        this.nameOfMealplan = nameOfMealplan;
        this.userId = userId;
    }

    public Mealplan() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
