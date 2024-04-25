package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.ExcludedIngredient;
import com.havstrut.menumatic.model.ExcludedIngredientId;
import com.havstrut.menumatic.model.Mealplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExcludedIngredientRepository extends JpaRepository<ExcludedIngredient, Integer> {
    @Query("SELECT ei FROM ExcludedIngredient ei WHERE ei.excludedIngredientId.mealplanId = ?1 AND ei.excludedIngredientId.nameOfExcludedIngredient = ?2")
    Optional<ExcludedIngredient> findById(int mealplan_id, String ingredientName);
    @Query("SELECT ei FROM ExcludedIngredient ei WHERE ei.excludedIngredientId.mealplanId = ?1")
    List<ExcludedIngredient> findByMealplanId(int mealplan_id);
}
