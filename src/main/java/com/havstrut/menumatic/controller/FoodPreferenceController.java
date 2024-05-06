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
    private RegisteredUserService registeredUserService;
    private final ObjectMapper objectMapper;

    @Autowired
    public FoodPreferenceController(FoodPreferenceService foodPreferenceService, ObjectMapper objectMapper, RegisteredUserService registeredUserService) {
        this.foodPreferenceService = foodPreferenceService;
        this.objectMapper = objectMapper;
        this.registeredUserService = registeredUserService;
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
        registeredUserService.addNewStudent(newUid);
        foodPreferenceService.nuke(newUid);
        for (String s : parameters) {
            System.out.println("s");
            try {
            foodPreferenceService.createFoodPreference(newUid, s);
            }
            catch(Exception e) {
                // Log or handle the exception appropriately
                System.out.println("Error creating preference for user: " + newUid + ", item: " + s + ", error: " + e.getMessage());
            }
        }
    }
}
