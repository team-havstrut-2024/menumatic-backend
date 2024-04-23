package com.havstrut.menumatic.service;

import com.havstrut.menumatic.repository.ExcludedIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcludedIngredientService {

    private final ExcludedIngredientRepository excludedIngredientRepository;

    @Autowired
    public ExcludedIngredientService(ExcludedIngredientRepository excludedIngredientRepository) {
        this.excludedIngredientRepository = excludedIngredientRepository;
    }


}
