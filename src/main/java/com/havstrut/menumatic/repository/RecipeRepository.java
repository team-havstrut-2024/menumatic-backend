package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
