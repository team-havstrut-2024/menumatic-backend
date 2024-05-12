package com.havstrut.menumatic.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.MealplanService;
import com.havstrut.menumatic.service.RecipeMealplanService;
import com.havstrut.menumatic.service.RecipeService;
import com.havstrut.menumatic.service.RegisteredUserService;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/api/user/") //byta till "/registeredUsers" ?
public class RegisteredUserController {

    private final RegisteredUserService registeredUserService;

    public RegisteredUserController(RegisteredUserService registeredUserService, MealplanService mealplanService, RecipeService recipeService, ObjectMapper objectMapper, RecipeMealplanService recipeMealplanService ) {
        this.registeredUserService = registeredUserService;
    }

    // Will fetch information for mealplans of an user.
    // This could be moved to mealplans but... then this needs to be changed in the frontend.
    @CrossOrigin
    @GetMapping("mealplans/")
    public List<Map<String, Object>> fetchMealplans(@RequestHeader("User-id") String uid) {
        String newUid = uid.replace('"', ' ').trim();
        System.out.println("[fetchMealPlans] fetching for mealplans for uid: " + newUid);
        return registeredUserService.fetchUserMealplans(newUid);
    }


    // Will delete any present user with matching uid in the database
    @CrossOrigin
    @PostMapping("delete/")
    public void deleteUser(@RequestHeader("User-id") String uid) {
        String newUid = uid.replace('"', ' ').trim();
        System.out.println(newUid);
        registeredUserService.deleteUser(newUid);
    }


    // Will create an user for uid, mealplans can also be specified in json
    // Returns a list of mealplan ids
    // Raises an exception if there already exists an user
    @CrossOrigin
    @PostMapping("create/")
    public Map<String, Integer> CreateTestUser(@RequestHeader("User-id") String uid, @RequestBody String json) throws Exception {
        String newUid = uid.replace('"', ' ').trim();
        return registeredUserService.createNewUser(newUid, json);
    }



}
