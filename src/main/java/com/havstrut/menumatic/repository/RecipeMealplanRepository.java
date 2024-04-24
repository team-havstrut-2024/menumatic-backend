package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.Recipe;
import com.havstrut.menumatic.model.RecipeMealplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeMealplanRepository extends JpaRepository<RecipeMealplan, Integer> {

    @Query("SELECT rmp FROM RecipeMealplan rmp WHERE rmp.recipeMealplanId.mealplanId = ?1")
    List<Recipe> findByMealplanId(int id);
}
