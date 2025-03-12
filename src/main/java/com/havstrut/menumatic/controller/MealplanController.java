package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.MealplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    // Deletes
    @CrossOrigin
    @DeleteMapping("delete/")
    public void deleteMealplan(@RequestHeader("User-id") String uid, @RequestBody String json) throws Exception {
        String newUid = uid.replace('"', ' ').trim();
        System.out.println(newUid);
        System.out.println(json);
        mealplanService.deleteMealplansForUser(newUid, json);
    }

}
