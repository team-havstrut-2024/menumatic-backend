package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.service.ExcludedIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/mealplan/excluded-ingredients/")
@RestController
public class ExcludedIngredientController {

    private final ExcludedIngredientService excludedIngredientService;

    @Autowired
    public ExcludedIngredientController(ExcludedIngredientService excludedIngredientService) {
        this.excludedIngredientService = excludedIngredientService;
    }
    @CrossOrigin
    @GetMapping("get/")
    public List<String> getUserPreference(@RequestHeader("Mealplan-id") int mid) {
        return excludedIngredientService.getAllExcludedIngredientsForMealplan(mid);
    }

    
    /*
     *  Set user preference
     *  Will write over current preferences with the new list
     * */

    @CrossOrigin
    @PostMapping("set/")
    public void setUserPreference(@RequestHeader("mealplan-id") int mid, @RequestBody List<String> parameters) {
        this.excludedIngredientService.setExcludedIngredient(mid, parameters);
    }
    
}
