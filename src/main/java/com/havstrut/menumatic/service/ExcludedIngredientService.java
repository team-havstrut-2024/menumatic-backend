package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.ExcludedIngredient;
import com.havstrut.menumatic.model.ExcludedIngredientId;
import com.havstrut.menumatic.repository.ExcludedIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

@Service
public class ExcludedIngredientService {

    private final ExcludedIngredientRepository excludedIngredientRepository;

    @Autowired
    public ExcludedIngredientService(ExcludedIngredientRepository excludedIngredientRepository) {
        this.excludedIngredientRepository = excludedIngredientRepository;
    }

    // Add excludedingredient, currently does not check the integrity of the database
    public void excludeIngredient(int mealplanId, String name) {
        if (excludedIngredientRepository.findById(mealplanId, name).isEmpty())
            this.excludedIngredientRepository.save(new ExcludedIngredient(new ExcludedIngredientId(mealplanId, name)));
    }
    public List<String> getExcludedIngredientsForMealplan(int mealplanId) {
        List<ExcludedIngredient> ei =  this.excludedIngredientRepository.findByMealplanId(mealplanId);
        List<String> str_list = new ArrayList<String>();
        for (ExcludedIngredient e : ei) {
            str_list.add(e.getExcludedIngredientId().getNameOfExcludedIngredient());
        }
        return str_list;
    }

}
