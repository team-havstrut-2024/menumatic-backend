package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.ExcludedIngredientId;
import com.havstrut.menumatic.repository.ExcludedIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.havstrut.menumatic.model.ExcludedIngredient
import java.util.LinkedList;
import java.util.List;

@Service
public class ExcludedIngredientService {

    private final ExcludedIngredientRepository excludedIngredientRepository;

    @Autowired
    public ExcludedIngredientService(ExcludedIngredientRepository excludedIngredientRepository) {
        this.excludedIngredientRepository = excludedIngredientRepository;
    }

    // Create a Excluded ingredient if it is not already present
    public void CreateExcludedIngredient(int mealplan_id, String name) throws Exception{
        List<ExcludedIngredient> table = excludedIngredientRepository.findByMealPlan(mealplan_id);
        for (ExcludedIngredient row : table) {
            if (row.getExcludedIngredientId().getNameOfExcludedIngredient().equals(name))
                throw new Exception("Excluded ingredient \"" + name + "\" already exists for user " + mealplan_id);
        }
        ExcludedIngredient ei = new ExcludedIngredient(new ExcludedIngredientId(mealplan_id, name));
        this.excludedIngredientRepository.save(ei); // store new foodpreference in table
    }
    // Delete
    public void deleteExcludedIngredient(int mealplan_id, String name) throws Exception {
        List<ExcludedIngredient> table = excludedIngredientRepository.findByMealPlan(mealplan_id);
        boolean exists = false;
        for (ExcludedIngredient row : table) {
            if (row.getExcludedIngredientId().getNameOfExcludedIngredient().equals(name)) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            throw new Exception("Excluded ingredient\"" + name + "\" not present for mealplan id " + mealplan_id);
        }
        ExcludedIngredient ei = new ExcludedIngredient(new ExcludedIngredientId(mealplan_id, name));
        this.excludedIngredientRepository.delete(ei);
    }

    // getAllFoodPreferencesForUser
    public List<String> getAllExcludedIngredientsForMealplan (int mealplan_id) {
        List<ExcludedIngredient> prefs = excludedIngredientRepository.findByMealPlan(mealplan_id);
        LinkedList<String> strs = new LinkedList<>();
        for (ExcludedIngredient ei : prefs) {
            strs.add(ei.getExcludedIngredientId().getNameOfExcludedIngredient());
        }
        return strs;
    }
    // Delete all food preferences associated with an user
    public void nuke (int mealplan_id) {
        List<ExcludedIngredient> list = excludedIngredientRepository.findByMealPlan(mealplan_id);
        for (ExcludedIngredient ei : list)
            this.excludedIngredientRepository.delete(ei);
    }

}
