package com.havstrut.menumatic.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Recipe {
    private int recipe_id;
    private String name;

}
