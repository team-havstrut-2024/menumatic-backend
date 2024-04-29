package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.MealplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

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

        /**
         * Debugging printout.
         */
        int mealplanIdInt = Integer.parseInt(mealplanId);
        System.out.println("This is the mealplan id: " + mealplanId);
        System.out.println(mealplanId instanceof String);
        System.out.println(mealplanIdInt == Integer.parseInt(mealplanId));
        System.out.println(mealplanIdInt);

        mealplanService.deleteMealplan(mealplanIdInt);
    }

}
