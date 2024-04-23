package com.havstrut.menumatic.model;
import jakarta.persistence.*;


@Entity //For hibernate
@Table  //For table in our database
public class RegisteredUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // Specify the column name
    private int userId;

    private String email;

    public RegisteredUser(String email) {
        this.email = email;
    }

    public RegisteredUser() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
