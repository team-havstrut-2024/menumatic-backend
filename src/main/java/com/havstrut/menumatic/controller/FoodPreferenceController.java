package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.service.FoodPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/food-preferences/")
@RestController
public class FoodPreferenceController {

    private FoodPreferenceService foodPreferenceService;

    @Autowired
    public FoodPreferenceController(FoodPreferenceService foodPreferenceService) {
        this.foodPreferenceService = foodPreferenceService;
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
            foodPreferenceService.CreateFoodPreference(uid, s);

            }
            catch(Exception e) {
                // Log or handle the exception appropriately
                System.out.println("Error creating preference for user: " + uid + ", item: " + s + ", error: " + e.getMessage());
            }
        }
    }
}
