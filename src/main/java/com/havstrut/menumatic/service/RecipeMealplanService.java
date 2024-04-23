package com.havstrut.menumatic.service;

import com.havstrut.menumatic.repository.RecipeMealplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeMealplanService {

    private final RecipeMealplanRepository recipeMealplanRepository;

    @Autowired
    public RecipeMealplanService(RecipeMealplanRepository recipeMealplanRepository) {
        this.recipeMealplanRepository = recipeMealplanRepository;
    }
}
