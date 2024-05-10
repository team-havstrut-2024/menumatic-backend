package com.havstrut.menumatic.model;
import jakarta.persistence.*;


/*
* RegisteredUser
*  Java object that corresponds to the registered user table in the database
* */


@Entity //For hibernate
@Table  //For table in our database
public class RegisteredUser {

    @Id
    @Column(name = "user_id") // Specify the column name
    private String userId;

    // Default constructor needed by JPA. Avoid using this, however.
    public RegisteredUser() {
    }
    public RegisteredUser(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
