package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.FoodPreference;
import com.havstrut.menumatic.model.RecipeMealplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodPreferenceRepository extends JpaRepository<FoodPreference, Integer> {


    // Get list of foodpreferences
    @Query("SELECT fp FROM FoodPreference fp WHERE fp.foodPreferenceId.userId = ?1")
    List<FoodPreference> findByUserId(String id);

}
