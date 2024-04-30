package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.FoodPreference;
import com.havstrut.menumatic.model.FoodPreferenceId;
import com.havstrut.menumatic.repository.FoodPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FoodPreferenceService {

    private final FoodPreferenceRepository foodPreferenceRepository;

    @Autowired
    public FoodPreferenceService(FoodPreferenceRepository foodPreferenceRepository) {
        this.foodPreferenceRepository = foodPreferenceRepository;
    }

    // Create a foodpreference if it is not already present
    public void createFoodPreference(String uid, String preference) throws Exception{
        List<FoodPreference> table = foodPreferenceRepository.findByUserId(uid);
        for (FoodPreference row : table) {
            if (row.getFoodPreferenceId().getPreference().equals(preference))
                    throw new Exception("Food preference \"" + preference + "\" already exists for user " + uid);
        }
        FoodPreference fp = new FoodPreference(new FoodPreferenceId(uid, preference));
        this.foodPreferenceRepository.save(fp); // store new foodpreference in table
    }

    // Delete, not used.
    public void deleteFoodPreference(String uid, String preference) throws Exception {
        List<FoodPreference> table = foodPreferenceRepository.findByUserId(uid);
        boolean exists = false;
        for (FoodPreference row : table) {
            if (row.equals(preference)) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            throw new Exception("Food preference \"" + preference + "\" not present for user " + uid);
        }
        FoodPreference fp = new FoodPreference(new FoodPreferenceId(uid, preference));
            this.foodPreferenceRepository.delete(fp);
    }

    // getAllFoodPreferencesForUser
    public List<String> getAllFoodPreferencesForUser (String uid) {
        List<FoodPreference> prefs = foodPreferenceRepository.findByUserId(uid);
        LinkedList<String> strs = new LinkedList<>();
        for (FoodPreference fp : prefs) {
            strs.add(fp.getFoodPreferenceId().getPreference());
        }
        return strs;
    }
    // Delete all food preferences associated with an user
    public void nuke (String uid) {
        List<FoodPreference> prefs = foodPreferenceRepository.findByUserId(uid);
        for (FoodPreference fp : prefs)
            this.foodPreferenceRepository.delete(fp);
    }








}
