package com.havstrut.menumatic.service;

import com.havstrut.menumatic.repository.MealplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealplanService {

    private final MealplanRepository mealplanRepository;

    @Autowired
    public MealplanService(MealplanRepository mealplanRepository) {
        this.mealplanRepository = mealplanRepository;
    }
}
