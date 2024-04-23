package com.havstrut.menumatic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RegisteredUserController {


    final User user = new User(0, "blablabla2@blablabla.com");
    @GetMapping(path = "getStudent/{user_id}")
    public User read(@PathVariable String user_id) {
        return user;
    }
}
