package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.FoodPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/") //byta till "/registeredUsers" ?

public class FoodPreferenceController {

    private FoodPreferenceService foodPreferenceService;
    private final ObjectMapper objectMapper;

    @Autowired
    public FoodPreferenceController(FoodPreferenceService foodPreferenceService, ObjectMapper objectMapper) {
        this.foodPreferenceService = foodPreferenceService;
        this.objectMapper = objectMapper;
    }










}
