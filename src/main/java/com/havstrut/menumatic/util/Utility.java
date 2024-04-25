/*package com.havstrut.menumatic.util;

import com.havstrut.menumatic.model.Mealplan;
import com.havstrut.menumatic.model.RecipeMealplan;
import com.havstrut.menumatic.model.RecipeMealplanId;
import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utility {


    private final ExcludedIngredientRepository excludedIngredientRepository;
    private final MealplanRepository mealplanRepository;
    private final RecipeMealplanRepository recipeMealplanRepository;
    private final RecipeRepository recipeRepository;
    private final RegisteredUserRepository registeredUserRepository;

    public Utility(ExcludedIngredientRepository excludedIngredientRepository, MealplanRepository mealplanRepository, RecipeMealplanRepository recipeMealplanRepository, RecipeRepository recipeRepository, RegisteredUserRepository registeredUserRepository) {
        this.excludedIngredientRepository = excludedIngredientRepository;
        this.mealplanRepository = mealplanRepository;
        this.recipeMealplanRepository = recipeMealplanRepository;
        this.recipeRepository = recipeRepository;
        this.registeredUserRepository = registeredUserRepository;
    }



    public void invokeRepositoryMethod(String key, Object val) {
        switch(key) {
            case "User-id":
                registeredUserRepository.save(new RegisteredUser(key, (String) (val)));
                break;

            case "planName":
                mealplanRepository.save(new Mealplan(val));
                break;
            case "portions":
                recipeMealplanRepository.save(new RecipeMealplan((String) val));
                break;
        }
    }


}
 */
