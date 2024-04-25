package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.service.ExcludedIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/excludedIngredient/")
public class ExcludentIngredientController {

    private final ExcludedIngredientService excludedIngredientService;

    @Autowired
    public ExcludentIngredientController(ExcludedIngredientService excludedIngredientService) {
        this.excludedIngredientService = excludedIngredientService;
    }

    @CrossOrigin
    @PostMapping("set/")
    public void setExcludedIngredient(@RequestHeader("User-id") String uid, @RequestBody Map<String, Object> json) {
        if (uid != null)
            excludedIngredientService.excludeIngredient((int)json.get("mealplan_id"), (String)json.get("name"));
    }
    @CrossOrigin
    @GetMapping("get/")
    public List<String> getExcludedIngredientsForMealplan(@RequestHeader("User-id") String uid, @RequestBody Map<String, Object> json) {
        return excludedIngredientService.getExcludedIngredientsForMealplan((int)json.get("mealplan_id"));
    }



}
