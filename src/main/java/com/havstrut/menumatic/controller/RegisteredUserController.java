package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.model.RecipeMealplan;
import com.havstrut.menumatic.model.RegisteredUser;
//import com.havstrut.menumatic.request.CreateUserRequest;
import com.havstrut.menumatic.service.MealplanService;
import com.havstrut.menumatic.service.RecipeMealplanService;
import com.havstrut.menumatic.service.RecipeService;
import com.havstrut.menumatic.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.json.JacksonJsonParser;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;


@RestController
@RequestMapping("/api/user/") //byta till "/registeredUsers" ?
public class RegisteredUserController {

    private final RegisteredUserService registeredUserService;

    private final MealplanService mealplanService;
    private final RecipeService recipeService;
    private final ObjectMapper objectMapper;

    private final RecipeMealplanService recipeMealplanService;




    //final RegisteredUser registeredUser = new RegisteredUser("blablabla2@blablabla.com");

    public RegisteredUserController(RegisteredUserService registeredUserService, MealplanService mealplanService, RecipeService recipeService, ObjectMapper objectMapper, RecipeMealplanService recipeMealplanService ) {
        this.registeredUserService = registeredUserService;
        this.mealplanService = mealplanService;
        this.recipeService = recipeService;
        this.objectMapper = objectMapper;
        this.recipeMealplanService = recipeMealplanService;
    }




    /*@GetMapping(path = "getStudent/{user_id}")
    public RegisteredUser read(@PathVariable int user_id) {
        Optional<RegisteredUser> registedUserOptional = registeredUserRepository.findRegisteredUserById(user_id);
        if(registedUserOptional.isEmpty()) {
            throw new IllegalStateException("id is not found");
        }
        return registedUserOptional.get();
    }*/

    /*@GetMapping("/mealplans/{user_id}")
    public LinkedList<Object> fetchMealplans(@PathVariable String user_id) {
        
    }*/



    /*@GetMapping("/get/{user_id}")
    public RegisteredUser fetchUserWithId(@PathVariable String user_id) {
        return registeredUserService.getUserByID(user_id);
    }
    // TODO: Change to also accept a UserID string
    @PostMapping("/create/")
   public void registerNewUser(@RequestBody String json) {
        JacksonJsonParser jjp = new JacksonJsonParser();
        Map<String, Object> map = jjp.parseMap(json);
        String uid = (String)(map.get("User-id"));
        if (uid == null) throw new IllegalArgumentException("User-id not found");
        String email = (String)(map.get("email"));
        registeredUserService.addNewStudent(uid, email);
    }
*/
    /*@PostMapping("/create/")
    public void createNewUser(@RequestHeader String json) {
        registeredUserService.createNewUser(json);
    }*/

     //Gustav FETCH
    @CrossOrigin
    @GetMapping("mealplans/")
    public List<Map<String,Object>> fetchMealplans(@RequestHeader("User-id") String uid) {
        System.out.println(uid);
        return mealplanService.getMealplansByUserId(uid);
    }

    @CrossOrigin
    @DeleteMapping("delete/")
    public void deleteUser(@RequestHeader("User-id") String uid) {
        registeredUserService.deleteUser(uid);
    }


    @CrossOrigin
    @PostMapping("create/")
    public void CreateTestUser(@RequestHeader("User-id") String uid, @RequestBody String json) throws Exception {
        System.out.println(uid);
        System.out.println(json);
        //recipes:[{name:Light Greek Lemon Chicken Orzo Soup,portion:1,id:1098350}
        //Är en array av objects
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap = objectMapper.readValue(json, HashMap.class);

        System.out.println(("This is the json object: " + jsonMap));

        String planName = (String) jsonMap.get("planName");
        System.out.println(("This is the plan name of the week: " + planName));

        List<Map<String, Object>> recipes = (List<Map<String, Object>>) jsonMap.get("recipes");
        System.out.println("This is the recipes object: " + recipes);
        registeredUserService.addNewStudent(uid);
        int mealplan_id = mealplanService.addNewMealplan(planName, Timestamp.valueOf(LocalDateTime.now()) ,uid);
        for (Map<String, Object> map : recipes) {
            String rName = (String) map.get("name");
            //System.out.println(recipes.get(0));
//            System.out.println(rName);
            Object rPortion = map.get("portion");
            int rId = (int) map.get("id");
//            System.out.println(("This is the id of the recipe: " + rId));
            if (rPortion.getClass() == String.class)
            {
                recipeService.addNewRecipe(rId,  rName, Integer.parseInt((String)rPortion));
            }
            else{
                recipeService.addNewRecipe(rId,  rName, (int) rPortion);
            }

            recipeMealplanService.addNewRecipeMealplan(rId, mealplan_id);
        }


        /*int rPortion = recipes.get(Integer.parseInt("portion"));
        System.out.println(rPortion);
        String rPortion = (String) recipes.get(0).get("portion");
        String rId = (String) recipes.get(0).get("id");
        System.out.println(rName);
        System.out.println(rPortion);
        System.out.println(rId);*/

    }



}
