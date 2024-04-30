package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.FoodPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-preferences/") //byta till "/registeredUsers" ?

public class FoodPreferenceController {

    private FoodPreferenceService foodPreferenceService;
    private final ObjectMapper objectMapper;

    @Autowired
    public FoodPreferenceController(FoodPreferenceService foodPreferenceService, ObjectMapper objectMapper) {
        this.foodPreferenceService = foodPreferenceService;
        this.objectMapper = objectMapper;
    }

    /*
    * Get a list of user preferences in a json array
    * */
    @CrossOrigin
    @GetMapping("get/")
    public List<String> getUserPreference(@RequestHeader("User-id") String uid) {
        return foodPreferenceService.getAllFoodPreferencesForUser(uid);
    }


    /*
    *  Set user preference
    *  Will write over current preferences with the new list
    * */

    @CrossOrigin
    @PostMapping("set/")
    public void setUserPreference(@RequestHeader("User-id") String uid, @RequestBody List<String> parameters) {
        foodPreferenceService.nuke(uid);
        for (String s : parameters) {
            System.out.println("s");
            try {
            foodPreferenceService.createFoodPreference(uid, s);
            }
            catch(Exception e) {
                // Log or handle the exception appropriately
                System.out.println("Error creating preference for user: " + uid + ", item: " + s + ", error: " + e.getMessage());
            }
        }
    }
}
