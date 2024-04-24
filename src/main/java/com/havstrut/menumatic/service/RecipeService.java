package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.Recipe;
import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;

    }
    public Recipe getRecipeById(int recipe_id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipe_id);
        if (recipeOptional.isEmpty()) {
            throw new NullPointerException("No such recipe exists");
        }
        return recipeOptional.get();
    }
    @Transactional
    public void addNewRecipe(int id, String title) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(recipeOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        recipeRepository.save(new Recipe(id, title));
    }
}
