package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.FoodPreferenceService;
import com.havstrut.menumatic.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-preferences/") //byta till "/registeredUsers" ?

public class FoodPreferenceController {

    private FoodPreferenceService foodPreferenceService;

    @Autowired
    public FoodPreferenceController(FoodPreferenceService foodPreferenceService, ObjectMapper objectMapper, RegisteredUserService registeredUserService) {
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
        String newUid = uid.replace('"', ' ').trim();
        foodPreferenceService.setUserFoodPreference(uid, parameters);
    }
}
