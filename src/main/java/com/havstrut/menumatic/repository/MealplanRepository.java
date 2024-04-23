package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.Mealplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealplanRepository extends JpaRepository<Mealplan, Integer> {
}
