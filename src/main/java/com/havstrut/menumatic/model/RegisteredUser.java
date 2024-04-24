package com.havstrut.menumatic.model;
import jakarta.persistence.*;


@Entity //For hibernate
@Table  //For table in our database
public class RegisteredUser {

    @Id
    private String userId;

    private String email;

    public RegisteredUser(String email) {
        this.email = email;
    }

    public RegisteredUser() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
