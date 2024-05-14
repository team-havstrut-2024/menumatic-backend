package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.Mealplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MealplanRepository extends JpaRepository<Mealplan, Integer> {

    // Get all mealplans associated with userid
    @Query("SELECT mp FROM Mealplan mp WHERE mp.userId = ?1")
    List<Mealplan> findByUserId(String id);
}
