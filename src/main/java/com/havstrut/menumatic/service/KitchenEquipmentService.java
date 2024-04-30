package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.KitchenEquipment;
import com.havstrut.menumatic.model.KitchenEquipmentId;
import com.havstrut.menumatic.repository.KitchenEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class KitchenEquipmentService {


    private final KitchenEquipmentRepository kitchenEquipmentRepository;

    @Autowired
    public KitchenEquipmentService(KitchenEquipmentRepository kitchenEquipmentRepository) {
        this.kitchenEquipmentRepository = kitchenEquipmentRepository;
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
