package com.havstrut.menumatic.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class KitchenEquipment {

    @EmbeddedId
    KitchenEquipmentId kitchenEquipmentId;

    public KitchenEquipment(KitchenEquipmentId kitchenEquipmentId) {
        this.kitchenEquipmentId = kitchenEquipmentId;
    }

    public KitchenEquipment() {
    }

    public KitchenEquipmentId getKitchenEquipmentId() {
        return kitchenEquipmentId;
    }

    public void setKitchenEquipmentId(KitchenEquipmentId kitchenEquipmentId) {
        this.kitchenEquipmentId = kitchenEquipmentId;
    }
}
