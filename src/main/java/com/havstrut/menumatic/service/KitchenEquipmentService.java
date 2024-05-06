package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.KitchenEquipment;
import com.havstrut.menumatic.model.KitchenEquipmentId;
import com.havstrut.menumatic.repository.FoodPreferenceRepository;
import com.havstrut.menumatic.repository.KitchenEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class KitchenEquipmentService {


    private final KitchenEquipmentRepository kitchenEquipmentRepository;
    private final FoodPreferenceRepository foodPreferenceRepository;

    @Autowired
    public KitchenEquipmentService(KitchenEquipmentRepository kitchenEquipmentRepository, FoodPreferenceRepository foodPreferenceRepository) {
        this.kitchenEquipmentRepository = kitchenEquipmentRepository;
        this.foodPreferenceRepository = foodPreferenceRepository;
    }

    public List<String> getAllKitchenEquipmentsForUser (String newUid) {
        List<KitchenEquipment> equipments = kitchenEquipmentRepository.findByUserId(newUid);
        LinkedList<String> strs = new LinkedList<>();
        for (KitchenEquipment fp : equipments) {
            strs.add(fp.getKitchenEquipmentId().getUtility());
        }
        return strs;
    }


    public void createKitchenEquipment(String newUid, String utilities) throws Exception {
            List<KitchenEquipment> table = kitchenEquipmentRepository.findByUserId(newUid);
            for (KitchenEquipment row : table) {
                if (row.getKitchenEquipmentId().getUtility().equals(utilities))
                    throw new Exception("Kitchen equipments \"" + utilities + "\" already exists for user " + newUid);
            }
            KitchenEquipment fp = new KitchenEquipment(new KitchenEquipmentId(newUid, utilities));
            this.kitchenEquipmentRepository.save(fp); // store new kitchen equipment in table

    }

    public void deleteKitchenEquipment(String newUid, String utilities) throws Exception {
        List<KitchenEquipment> table = kitchenEquipmentRepository.findByUserId(newUid);
        boolean found = false;
        for (KitchenEquipment row : table) {
            if (row.getKitchenEquipmentId().getUtility().equals(utilities)) {
                found = true;
                break;
            }
        }
        if (!found) throw new Exception("Equipment requested for deletion is not present");
        kitchenEquipmentRepository.delete(new KitchenEquipment(new KitchenEquipmentId(newUid, utilities)));
    }


    public void nuke(String newUid) {
        List<KitchenEquipment> equipments = kitchenEquipmentRepository.findByUserId(newUid);
        this.kitchenEquipmentRepository.deleteAll(equipments);
    }

    public List<KitchenEquipment> getKitchenEquipments(String newUid) {
        List<KitchenEquipment> equipments = kitchenEquipmentRepository.findByUserId(newUid);
        System.out.println(equipments);
        return equipments;
    }
}
