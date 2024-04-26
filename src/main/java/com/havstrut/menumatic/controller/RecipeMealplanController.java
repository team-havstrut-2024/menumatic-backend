package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.service.RecipeMealplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeMealplanController {

    private final RecipeMealplanService recipeMealplanService;

    @Autowired
    public RecipeMealplanController(RecipeMealplanService recipeMealplanService) {
        this.recipeMealplanService = recipeMealplanService;
    }

    /**
     * Vi måste se till att POST kan tas emot här.
     */
}
