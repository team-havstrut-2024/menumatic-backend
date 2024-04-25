package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.model.Mealplan;
import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.service.MealplanService;
import com.havstrut.menumatic.service.RecipeMealplanService;
import com.havstrut.menumatic.service.RecipeService;
import com.havstrut.menumatic.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.json.JacksonJsonParser;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;


@RestController
@RequestMapping("/api/user/") //byta till "/registeredUsers" ?
public class RegisteredUserController {

    private final RegisteredUserService registeredUserService;
    MealplanService mealplanService;

    public RegisteredUserController(RecipeService recipeService, RecipeMealplanService recipeMealplanService, MealplanService mealplanService, RegisteredUserService registeredUserService) {
        this.recipeService = recipeService;
        this.recipeMealplanService = recipeMealplanService;
        this.mealplanService = mealplanService;
        this.registeredUserService = registeredUserService;
    }

    RecipeMealplanService recipeMealplanService;
    RecipeService recipeService;


    //final RegisteredUser registeredUser = new RegisteredUser("blablabla2@blablabla.com");



    /*@GetMapping(path = "getStudent/{user_id}")
    public RegisteredUser read(@PathVariable int user_id) {
        Optional<RegisteredUser> registedUserOptional = registeredUserRepository.findRegisteredUserById(user_id);
        if(registedUserOptional.isEmpty()) {
            throw new IllegalStateException("id is not found");
        }
        return registedUserOptional.get();
    }*/

    @GetMapping("/mealplans/")
    public List<Map<String,Object>> fetchMealplans(@RequestHeader("User-id") String uid) {
        return mealplanService.getMealplansByUserId(uid);
    }




    @GetMapping("/get/{user_id}")
    public RegisteredUser fetchUserWithId(@PathVariable String user_id) {
        return registeredUserService.getUserByID(user_id);
    }
    // TODO: Refactor to use in Services.

    /*
    * This code looks pretty nasty. What you need to know is that when JacksonJsonParser is invoked the whole json in converted.
    * Lists are converted to ArrayList<Object>, and plain values are converted to LinkedHashMap<String, Object>.
    * Hence, the astronomical amount of type casts.
    * I was not able to find alot of documentation about JacksonJsonParser online..
    * */
    @CrossOrigin
    @PostMapping("create/")
   public void registerNewUser(@RequestHeader("User-id") String uid, @RequestBody String json) {
        // First, parse header
        JacksonJsonParser jjp = new JacksonJsonParser();
        /*Map<String, Object> map = jjp.parseMap(uid_json);
        String uid = (String)(map.get("User-id"));
        if (uid == null) throw new IllegalArgumentException("User-id not found");
        String email = (String)(map.get("email"));
        */
        // Parse mealplans in body
        List<Object> mealplans = jjp.parseList(json);

        for (Object i : mealplans) {
            //Map<String, Object> mealplan_map = jjp.parseMap((String)i);
            String mealplan_name = /*(String)mealplan_map*/(String)((LinkedHashMap<String, Object>)i).get("planName");

            List<Object> recipes = (ArrayList<Object>)((LinkedHashMap<String, Object>)i).get("recipes");
            int saved_id = mealplanService.addNewMealplan(Timestamp.valueOf(LocalDateTime.now()),mealplan_name,uid);
            for (Object j : recipes) {
                int recipe_id = (Integer)((LinkedHashMap<String, Object>)j).get("id");
                int recipe_portions = (Integer)((LinkedHashMap<String, Object>)j).get("portion");
                String recipe_name = (String)((LinkedHashMap<String, Object>)j).get("name");
                recipeService.addNewRecipe(recipe_id, recipe_name);
                recipeMealplanService.addNewRecipeMealplan(saved_id, recipe_id, recipe_portions);
            }
        }


        // only if both are successfully parsed (no exceptions)
        registeredUserService.addNewStudent(uid, "email");

    }

}
