package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.service.ExcludedIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcludentIngredientController {

    private final ExcludedIngredientService excludedIngredientService;

    @Autowired
    public ExcludentIngredientController(ExcludedIngredientService excludedIngredientService) {
        this.excludedIngredientService = excludedIngredientService;
    }
}
