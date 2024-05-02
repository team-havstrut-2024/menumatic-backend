package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.FavoriteDish;
import com.havstrut.menumatic.model.KitchenEquipment;
import com.havstrut.menumatic.repository.FavoriteDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FavoriteDishService {

    private final FavoriteDishRepository favoriteDishRepository;

    @Autowired
    public FavoriteDishService(FavoriteDishRepository favoriteDishRepository) {
        this.favoriteDishRepository = favoriteDishRepository;
    }

    public List<Integer> getAllFavoriteDishesForUser (String newUid) {
        List<FavoriteDish> favoriteDishes = favoriteDishRepository.findByUserId(newUid);
        LinkedList<Integer> ids = new LinkedList<>();
        for (FavoriteDish fp : favoriteDishes) {
            ids.add(fp.getFavoriteDishId().getRecipe_id());
        }
        return ids;
    }
}
