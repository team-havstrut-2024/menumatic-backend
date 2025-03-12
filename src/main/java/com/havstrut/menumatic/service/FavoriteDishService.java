package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.FavoriteDish;
import com.havstrut.menumatic.model.FavoriteDishId;
import com.havstrut.menumatic.model.Recipe;
import com.havstrut.menumatic.model.KitchenEquipment;
import com.havstrut.menumatic.repository.FavoriteDishRepository;
import com.havstrut.menumatic.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

@Service
public class FavoriteDishService {

    private final FavoriteDishRepository favoriteDishRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    public FavoriteDishService(FavoriteDishRepository favoriteDishRepository, RecipeRepository recipeRepository) {
        this.favoriteDishRepository = favoriteDishRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<Integer> getAllFavoriteDishesForUser (String newUid) {
        List<FavoriteDish> favoriteDishes = favoriteDishRepository.findByUserId(newUid);
        System.out.println("The list ... of favorite...: " + favoriteDishes);
        LinkedList<Integer> ids = new LinkedList<>();
        System.out.println("the linked list: " + ids);
        for (FavoriteDish fp : favoriteDishes) {
            ids.add(fp.getFavoriteDishId().getRecipeId());
        }
        return ids;
    }

    public Map<Integer, String> getRecipeNamesForFavoriteDish(List<Integer> recipeIds) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (Integer id : recipeIds) {
            if (recipeRepository.findById(id).isPresent()) {
                Recipe r = recipeRepository.findById(id).get();
                map.put(id, r.getNameOfRecipe());
            }
            else {
                map.put(id, "Recipe " + id);
            }
        }
        System.out.println("[getRecipeNamesForFavoriteDish] This is the map: " + map);
        return map;
    }

        public void createFavoriteFood(String uid, int recipeId) throws Exception{
            FavoriteDish fd = new FavoriteDish(new FavoriteDishId(uid, recipeId));
            List<FavoriteDish> favoriteDishes = favoriteDishRepository.findByRecipeId(recipeId);
            boolean exists = false;
            for (FavoriteDish row : favoriteDishes) {
                if (row.equals(fd)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                throw new Exception("Favorite dish \"" + recipeId + "\" is present for user " + uid);
            }
        this.favoriteDishRepository.save(fd); // store new foodpreference in table

    }


}
