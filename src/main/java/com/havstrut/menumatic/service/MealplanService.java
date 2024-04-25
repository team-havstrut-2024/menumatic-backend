package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.Mealplan;
import com.havstrut.menumatic.model.RecipeMealplan;
import com.havstrut.menumatic.model.RecipeMealplanId;
import com.havstrut.menumatic.repository.MealplanRepository;
import com.havstrut.menumatic.repository.RecipeMealplanRepository;
import com.havstrut.menumatic.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class MealplanService {

    private final MealplanRepository mealplanRepository;
    private final RecipeMealplanRepository recipeMealplanRepository;
    private final RecipeRepository recipeRepository;
    @Autowired
    public MealplanService(MealplanRepository mealplanRepository, RecipeMealplanRepository recipeMealplanRepository, RecipeRepository recipeRepository) {
        this.mealplanRepository = mealplanRepository;
        this.recipeMealplanRepository = recipeMealplanRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<Map<String, Object>> getMealplansByUserId(String uid){
        List<Mealplan> mealplans = mealplanRepository.findByUserId(uid);
        // id
        // name
        // recipes
            // id
            // recipes
        ArrayList<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        for (Mealplan mp : mealplans) {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("id", mp.getMealplanId());
            map.put("name", mp.getNameOfMealplan());
            List<RecipeMealplan> references = recipeMealplanRepository.findByMealplanId(mp.getMealplanId());
            List<Map<String, Object>> recipes = new ArrayList<Map<String, Object>>();
            for (RecipeMealplan rmp : references) {
                int recipe_id = rmp.getRecipeMealplanId().getRecipeId();
                String recipe_name = recipeRepository.findById(rmp.getRecipeMealplanId().getRecipeId()).orElseThrow().getNameOfRecipe();
                Map<String,Object> recipe = new LinkedHashMap<>();
                recipe.put("id", recipe_id);
                recipe.put("name", recipe_name);
                recipes.add(recipe);
            }
            map.put("recipes", recipes);
            maps.add(map);
        }
        return maps;
    }
    public int addNewMealplan(Timestamp timeOfMealplan, String nameOfMealplan, String userId) {
        // to do: check for duplicates
        Mealplan mp = mealplanRepository.save(new Mealplan(timeOfMealplan, nameOfMealplan, userId));
       return mp.getMealplanId();
    }
}
