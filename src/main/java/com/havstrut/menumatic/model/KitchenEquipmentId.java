package com.havstrut.menumatic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KitchenEquipmentId implements Serializable {


    @Column(name = "user_id")
    private String userId;

    @Column(name = "utility")
    private String utility;

    public KitchenEquipmentId(String userId, String utility) {
        this.userId = userId;
        this.utility = utility;
    }

    public KitchenEquipmentId() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }
}
