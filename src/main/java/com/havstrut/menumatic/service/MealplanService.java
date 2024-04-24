package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.Mealplan;
import com.havstrut.menumatic.model.RecipeMealplan;
import com.havstrut.menumatic.model.RecipeMealplanId;
import com.havstrut.menumatic.repository.MealplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MealplanService {

    private final MealplanRepository mealplanRepository;

    @Autowired
    public MealplanService(MealplanRepository mealplanRepository) {
        this.mealplanRepository = mealplanRepository;
    }

    public List<Mealplan> getMealplanByUserId(String user_id) {
        return mealplanRepository.findByUserId(user_id);
    }
    public void addNewMealplan(int mealplanId, Timestamp timeOfMealplan, String nameOfMealplan, String userId) {
        // to do: check for duplicates
        mealplanRepository.save(new Mealplan(mealplanId, timeOfMealplan, nameOfMealplan, userId));
    }
}
