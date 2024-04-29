package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.MealplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mealplan/")
public class MealplanController {

    private final MealplanService mealplanService;

    private final ObjectMapper objectMapper;


    @Autowired
    public MealplanController(MealplanService mealplanService, ObjectMapper objectMapper) {
        this.mealplanService = mealplanService;
        this.objectMapper = objectMapper;
    }


    @CrossOrigin
    @PostMapping("delete/")
    public void deleteMealplan(@RequestHeader("User-id") String uid, @RequestBody String json) throws Exception {
        String newUid = uid.replace('"', ' ').trim();
        System.out.println(newUid);
        System.out.println(json);

        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap = objectMapper.readValue(json, HashMap.class);

        System.out.println(("This is the json object: " + jsonMap));

        String mealplanId = (String) jsonMap.get("mealplanId");

        System.out.println("This is the mealplan id: " + mealplanId);
        System.out.println(mealplanId instanceof String);
        //System.out.println(mealplanId instanceof int);

        /*List<Map<String, Object>> recipes = (List<Map<String, Object>>) jsonMap.get("mealplanId");
        System.out.println("This is the recipes object: " + recipes);*/
        /*registeredUserService.addNewStudent(newUid);
        int mealplan_id = mealplanService.addNewMealplan(planName, Timestamp.valueOf(LocalDateTime.now()), newUid);
        for (Map<String, Object> map : recipes) {
            String rName = (String) map.get("name");
            //System.out.println(recipes.get(0));
//            System.out.println(rName);
            Object rPortion = map.get("portion");
            int rId = (int) map.get("id");
//            System.out.println(("This is the id of the recipe: " + rId));
            if (rPortion.getClass() == String.class) {
                recipeService.addNewRecipe(rId, rName, Integer.parseInt((String) rPortion));
            } else {
                recipeService.addNewRecipe(rId, rName, (int) rPortion);
            }

            recipeMealplanService.addNewRecipeMealplan(rId, mealplan_id);
        }*/
    }

}
