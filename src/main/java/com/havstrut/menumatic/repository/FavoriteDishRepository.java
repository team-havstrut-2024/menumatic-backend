package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.FavoriteDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteDishRepository extends JpaRepository<FavoriteDish, Integer> {
    // Select favorite dish with user id
    // Multiple results, so a list is returned
    @Query("SELECT fd FROM FavoriteDish fd WHERE fd.favoriteDishId.userId = ?1")
    List<FavoriteDish> findByUserId(String uid);

    // Select favorite dish with recipe id
    // Multiple results, so a list is returned
    @Query("SELECT fd FROM FavoriteDish fd WHERE fd.favoriteDishId.recipeId= ?1")
    List<FavoriteDish> findByRecipeId(Integer id);
}
