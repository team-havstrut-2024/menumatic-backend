package com.havstrut.menumatic.service;


import com.havstrut.menumatic.model.Recipe;
import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RegisteredUserService {


    private final RegisteredUserRepository registeredUserRepository;
    private ObjectMapper objectMapper;
    private MealplanService mealplanService;
    private RecipeService recipeService;
    private RecipeMealplanService recipeMealplanService;

    @Autowired
    public RegisteredUserService(RegisteredUserRepository registeredUserRepository, ObjectMapper objectMapper, MealplanService mealplanService, RecipeService recipeService, RecipeMealplanService recipeMealplanService) {
        this.registeredUserRepository = registeredUserRepository;
        this.objectMapper = objectMapper;
        this.mealplanService = mealplanService;
        this.recipeService = recipeService;
        this.recipeMealplanService = recipeMealplanService;
    }


    public List<Map<String,Object>> fetchUserMealplans(String uid) {
        return mealplanService.getMealplansByUserId(uid);
    }

    @Transactional
    public RegisteredUser getUserByID(String user_id) {
        Optional<RegisteredUser> studentOptional = registeredUserRepository.findById(user_id);
        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("No user with such id");
        }
        return studentOptional.get();
    }

    @Transactional
    public void addNewStudent(String newUid) {
        Optional<RegisteredUser> studentOptional = registeredUserRepository.findById(newUid);
        System.out.println(studentOptional);
        if(studentOptional.isEmpty()) {
            registeredUserRepository.save(new RegisteredUser(newUid));
        }
        System.out.println(registeredUserRepository.findById(newUid).get().getUserId());

        //registeredUserRepository.save(new RegisteredUser(uid));
    }

    //@Transactional Annotation wasn't needed in the controller, why would it be here?
    public Map<String, Integer>  createNewUser(String uid, String json) throws Exception{

        //recipes:[{name:Light Greek Lemon Chicken Orzo Soup,portion:1,id:1098350}
        //Är en array av objects
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap = objectMapper.readValue(json, HashMap.class);

        System.out.println(("This is the json object: " + jsonMap));

        String planName = (String) jsonMap.get("planName");
        System.out.println(("This is the plan name of the week: " + planName));

        List<Map<String, Object>> recipes = (List<Map<String, Object>>) jsonMap.get("recipes");
        System.out.println("This is the recipes object: " + recipes);
        this.addNewStudent(uid);
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
        Map<String, Integer> mealplanResultToFrontend = new HashMap<>();
        mealplanResultToFrontend.put("mealplan_id", mealplan_id);
        return mealplanResultToFrontend;
    }

    public void deleteUser(String uid) {
        Optional<RegisteredUser> userOptional = registeredUserRepository.findById(uid);
        if(userOptional.isPresent()) {
            registeredUserRepository.delete(new RegisteredUser(userOptional.get().getUserId()));
        }
    }

}
