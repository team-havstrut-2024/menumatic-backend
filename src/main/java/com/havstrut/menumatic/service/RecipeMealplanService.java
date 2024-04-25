package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.RecipeMealplan;
import com.havstrut.menumatic.model.RecipeMealplanId;
import com.havstrut.menumatic.repository.RecipeMealplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeMealplanService {

    private final RecipeMealplanRepository recipeMealplanRepository;

    @Autowired
    public RecipeMealplanService(RecipeMealplanRepository recipeMealplanRepository) {
        this.recipeMealplanRepository = recipeMealplanRepository;
    }


    public List<RecipeMealplan> getRecipeMealplanByMealplanId(int mealplan_id) {
        return recipeMealplanRepository.findByMealplanId(mealplan_id);
    }
    public void addNewRecipeMealplan(int mealplan_id, int recipe_id, int portions) {
        // to do: check for duplicates
        recipeMealplanRepository.save(new RecipeMealplan( new RecipeMealplanId(recipe_id, mealplan_id), portions));
    }
}
