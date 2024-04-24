package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.Recipe;
import com.havstrut.menumatic.model.RecipeMealplan;
import com.havstrut.menumatic.repository.RecipeMealplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeMealplanService {

    private final RecipeMealplanRepository recipeMealplanRepository;

    @Autowired
    public RecipeMealplanService(RecipeMealplanRepository recipeMealplanRepository) {
        this.recipeMealplanRepository = recipeMealplanRepository;
    }


    public RecipeMealplan getRecipeMealplanByMealplanId(int mealplan_id) {
        Optional<RecipeMealplan> recipeMealplanOptional = recipeMealplanRepository.findById(mealplan_id);
        if (recipeMealplanOptional.isEmpty()) {
            throw new NullPointerException("No such recipe exists");
        }
        return recipeMealplanOptional.get();
    }
}
