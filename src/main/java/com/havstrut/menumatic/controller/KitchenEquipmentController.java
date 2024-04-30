package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.service.KitchenEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitchenequipment/")
public class KitchenEquipmentController {

    private final KitchenEquipmentService kitchenEquipmentService;

    private final ObjectMapper objectMapper;

    @Autowired
    public KitchenEquipmentController(KitchenEquipmentService kitchenEquipmentService, ObjectMapper objectMapper) {
        this.kitchenEquipmentService = kitchenEquipmentService;
        this.objectMapper = objectMapper;
    }

    @CrossOrigin
    @GetMapping("get/")
    public List<String> getEquipments(@RequestHeader("User-id") String uid) {
        String newUid = uid.replace('"', ' ').trim();
        return kitchenEquipmentService.getAllKitchenEquipmentsForUser(newUid);
    }

    @CrossOrigin
    @PostMapping("set/")
    public void addKitchenEquipment(@RequestHeader("User-id") String uid, @RequestBody List<String> parameters) throws Exception {
        String newUid = uid.replace('"', ' ').trim();
        System.out.println(newUid);
        System.out.println(parameters);

        kitchenEquipmentService.nuke(newUid);

        for (String s : parameters) {
            System.out.println("s");
            try {
                kitchenEquipmentService.createKitchenEquipment(newUid, s);
            }
            catch(Exception e) {
                // Log or handle the exception appropriately
                System.out.println("Error creating preference for user: " + uid + ", item: " + s + ", error: " + e.getMessage());
            }
        }
    }



}
