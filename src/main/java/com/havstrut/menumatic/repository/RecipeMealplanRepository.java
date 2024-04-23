package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.RecipeMealplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeMealplanRepository extends JpaRepository<RecipeMealplan, Integer> {

}
