package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.FavoriteDishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/favoritedish/")
public class FavoriteDishController {

    private FavoriteDishService favoriteDishService;
    private final ObjectMapper objectMapper;


    public FavoriteDishController(FavoriteDishService favoriteDishService, ObjectMapper objectMapper) {
        this.favoriteDishService = favoriteDishService;
        this.objectMapper = objectMapper;
    }

    @CrossOrigin
    @GetMapping("get/")
    //Ska returnera en String i slutändan.
    public Map<Integer, String> getFavoriteDishes(@RequestHeader("User-id") String uid) {
        String newUid = uid.replace('"', ' ').trim();
        List<Integer> recipe_ids = favoriteDishService.getAllFavoriteDishesForUser(newUid);
        System.out.println("These are the recipe ids: " + recipe_ids);
        Map<Integer, String> favoriteDishes = favoriteDishService.getRecipeNamesForFavoriteDish(recipe_ids);
        System.out.println("The favorite dishes are: " + favoriteDishes);
        return favoriteDishes;
    }

    @CrossOrigin
    @PostMapping("set/")
    public void addFavoriteDishes(@RequestHeader("User-id") String uid, @RequestBody List<Integer> recipeIdsToFavorite) throws Exception {
        String newUid = uid.replace('"', ' ').trim();
        try {
            for (Integer recipeId : recipeIdsToFavorite) {
                favoriteDishService.createFavoriteFood(newUid, recipeId);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
