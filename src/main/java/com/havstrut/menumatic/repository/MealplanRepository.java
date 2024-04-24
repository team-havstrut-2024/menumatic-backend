package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.Mealplan;
import com.havstrut.menumatic.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MealplanRepository extends JpaRepository<Mealplan, Integer> {

    @Query("SELECT mp FROM Mealplan mp WHERE mp.mealplanId = ?1")
    Optional<Mealplan> findByMealplanId(int id);
    // Get all mealplans associated with userid
    @Query("SELECT mp FROM Mealplan mp WHERE mp.userId = ?1")
    List<Mealplan> findByUserId(String id);
}
