package com.havstrut.menumatic.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiLimitRepository extends JpaRepository<ExcludedIngredient, Integer> {
    // Select excluded ingredients for mealplan id
    @Query("SELECT ei FROM ExcludedIngredient ei WHERE ei.excludedIngredientId.mealplanId = ?1")
    List<ExcludedIngredient> findByMealPlan(int id);
}
