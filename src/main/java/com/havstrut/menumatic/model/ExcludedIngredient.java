package com.havstrut.menumatic.model;


import jakarta.persistence.*;
import jdk.jfr.ContentType;

@Entity
@Table
public class ExcludedIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealplan_id") // Specify the column name
    private int mealplanId;
}
