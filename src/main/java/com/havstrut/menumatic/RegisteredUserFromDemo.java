package com.havstrut.menumatic;

public class RegisteredUserFromDemo {

    private Integer userId;
    private String email;


    public RegisteredUserFromDemo(Integer userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
