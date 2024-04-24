package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.Mealplan;
import com.havstrut.menumatic.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {


    // get recipe
    @Query("SELECT r FROM Recipe r WHERE r.recipeId = ?1")
    Optional<Recipe> findById(int id);
}
