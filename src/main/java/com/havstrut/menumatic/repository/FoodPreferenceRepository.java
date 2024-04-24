package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.FoodPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPreferenceRepository extends JpaRepository<FoodPreference, Integer> {
}
