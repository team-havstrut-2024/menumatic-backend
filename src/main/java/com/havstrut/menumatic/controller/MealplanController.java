package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.service.MealplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealplanController {

    private final MealplanService mealplanService;


    @Autowired
    public MealplanController(MealplanService mealplanService) {
        this.mealplanService = mealplanService;
    }
}
