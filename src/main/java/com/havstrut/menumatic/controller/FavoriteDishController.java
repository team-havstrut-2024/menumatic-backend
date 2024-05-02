package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.FavoriteDishService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/favoritedish/")
public class FavoriteDishController {

    private FavoriteDishService favoriteDishService;
    private final ObjectMapper objectMapper;


    public FavoriteDishController(FavoriteDishService favoriteDishService, ObjectMapper objectMapper) {
        this.favoriteDishService = favoriteDishService;
        this.objectMapper = objectMapper;
    }

    @CrossOrigin
    @GetMapping("get/")
    public List<String> getFavoriteDishes(@RequestHeader("User-id") String uid) {

        List<Integer> recipe_ids = favoriteDishService.getAllFavoriteDishesForUser(uid);
        favoriteDishService.getRecipeNamesForFavorite
    }
}
