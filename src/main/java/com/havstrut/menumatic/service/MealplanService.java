package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.Mealplan;
import com.havstrut.menumatic.model.Recipe;
import com.havstrut.menumatic.model.RecipeMealplan;
import com.havstrut.menumatic.model.RecipeMealplanId;
import com.havstrut.menumatic.repository.MealplanRepository;
import com.havstrut.menumatic.repository.RecipeMealplanRepository;
import com.havstrut.menumatic.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class MealplanService {

    private final MealplanRepository mealplanRepository;
    private final RecipeRepository recipeRepository;
    private final RecipeMealplanRepository recipeMealplanRepository;
    private final ExcludedIngredientService excludedIngredientService;

    @Autowired
    public MealplanService(MealplanRepository mealplanRepository, RecipeRepository recipeRepository, RecipeMealplanRepository recipeMealplanRepository, ExcludedIngredientService excludedIngredientService) {
        this.mealplanRepository = mealplanRepository;
        this.recipeRepository = recipeRepository;
        this.recipeMealplanRepository = recipeMealplanRepository;
        this.excludedIngredientService = excludedIngredientService;
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
                Recipe recipe = recipeRepository.findById(rmp.getRecipeMealplanId().getRecipeId()).orElseThrow();
                String recipe_name = recipe.getNameOfRecipe();

                int recipe_portions = recipe.getPortions();
                Map<String,Object> recipe_json = new LinkedHashMap<>();
                recipe_json.put("id", recipe_id);
                recipe_json.put("name", recipe_name);
                recipe_json.put("portions", recipe_portions);
                recipes.add(recipe_json);
            }
            map.put("recipes", recipes);
            maps.add(map);
        }
        return maps;
    }

    public List<Mealplan> getMealplanByUserId(String user_id) {
        return mealplanRepository.findByUserId(user_id);
    }

    public void deleteMealplan(int mealplan_id) {
        excludedIngredientService.nuke(mealplan_id); // Remove all excluded ingredients
        mealplanRepository.deleteById(mealplan_id);
    }

    public int addNewMealplan(String nameOfMealplan, Timestamp timeOfMealplan, String userId) throws Exception {
        List<Mealplan> mealplanOptional = mealplanRepository.findByUserId(userId);
        for (Mealplan mp : mealplanOptional) {
            if (mp.getNameOfMealplan().equals(nameOfMealplan) && mp.getUserId().equals(userId)) {
                System.out.println("This is the name of meal plan: " + nameOfMealplan + " This is the time of the meal plan: " + timeOfMealplan + " This is the userId: " + userId);
            }
        }
        Mealplan mp = mealplanRepository.save(new Mealplan(Timestamp.valueOf(LocalDateTime.now()), nameOfMealplan, userId));
        System.out.println(mp.getMealplanId());
        return mp.getMealplanId();
    }

}
