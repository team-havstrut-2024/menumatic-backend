package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.ExcludedIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcludedIngredientRepository extends JpaRepository<ExcludedIngredient, Integer> {
}
