package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.Mealplan;
import com.havstrut.menumatic.model.Recipe;
import com.havstrut.menumatic.model.RecipeMealplan;
import com.havstrut.menumatic.model.RecipeMealplanId;
import com.havstrut.menumatic.repository.MealplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
