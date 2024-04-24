package com.havstrut.menumatic.service;

import com.havstrut.menumatic.repository.FoodPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodPreferenceService {

    private final FoodPreferenceRepository foodPreferenceRepository;

    @Autowired
    public FoodPreferenceService(FoodPreferenceRepository foodPreferenceRepository) {
        this.foodPreferenceRepository = foodPreferenceRepository;
    }
}
