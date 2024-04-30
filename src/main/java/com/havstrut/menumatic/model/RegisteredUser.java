package com.havstrut.menumatic.model;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;


@Entity //For hibernate
@Table  //For table in our database
public class RegisteredUser {

    @Id
    @Column(name = "user_id") // Specify the column name
    private String userId;

    //@OneToMany(mappedBy = "registeredUser")
    //@OnDelete(action = OnDeleteAction.CASCADE)

    //hmmm...
  /*  @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "user_id")
    private List<Mealplan> mealplan = new ArrayList<>();*/


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
