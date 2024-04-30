package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.FoodPreference;
import com.havstrut.menumatic.model.KitchenEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KitchenEquipmentRepository extends JpaRepository<KitchenEquipment, Integer> {

    @Query("SELECT fp FROM KitchenEquipment fp WHERE fp.kitchenEquipmentId.userId = ?1")
    List<KitchenEquipment> findByUserId(String newUid);

}
