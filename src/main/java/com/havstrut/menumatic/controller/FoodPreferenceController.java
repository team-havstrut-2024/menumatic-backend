package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.service.FoodPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodPreferenceController {

    private FoodPreferenceService foodPreferenceService;

    @Autowired
    public FoodPreferenceController(FoodPreferenceService foodPreferenceService) {
        this.foodPreferenceService = foodPreferenceService;
    }



}
