package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.FavoriteDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteDishRepository extends JpaRepository<FavoriteDish, Integer> {

    @Query("SELECT fd FROM FavoriteDish fd WHERE fd.favoriteDishId.userId = ?1")
    List<FavoriteDish> findByUserId(String uid);

}
