package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.Recipe;
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


    /**
     *
     * Från POST-operation, vi vill att RecipeMealplanController ska anropa på denna istället.
     */
    public RecipeMealplan getRecipeMealplanByMealplanId(int mealplan_id) {
        Optional<RecipeMealplan> recipeMealplanOptional = recipeMealplanRepository.findById(mealplan_id);
        if (recipeMealplanOptional.isEmpty()) {
            throw new NullPointerException("No such recipe exists");
        }
        return recipeMealplanOptional.get();
    }
    public void addNewRecipeMealplan(int recipeId, int mealplanId) {
        // to do: check for duplicates
        recipeMealplanRepository.save(new RecipeMealplan(new RecipeMealplanId(recipeId, mealplanId)));
    }
}
