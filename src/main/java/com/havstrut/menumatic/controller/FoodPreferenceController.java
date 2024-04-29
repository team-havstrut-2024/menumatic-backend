package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.service.FoodPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/food-preferences/")
@RestController
public class FoodPreferenceController {

    private FoodPreferenceService foodPreferenceService;

    @Autowired
    public FoodPreferenceController(FoodPreferenceService foodPreferenceService) {
        this.foodPreferenceService = foodPreferenceService;
    }

    @CrossOrigin
    @GetMapping("get/")
    public List<String> getUserPreference(@RequestHeader("User-id") String uid) {
        return foodPreferenceService.getAllFoodPreferencesForUser(uid);
    }
    @CrossOrigin
    @PostMapping("set/")
    public void setUserPreference(@RequestHeader("User-id") String uid, @RequestBody List<String> parameters) {
        foodPreferenceService.nuke(uid);
        for (String s : parameters) {
            try {
            foodPreferenceService.CreateFoodPreference(uid, s);
            }
            catch(Exception e) {

            }
        }
    }
}
