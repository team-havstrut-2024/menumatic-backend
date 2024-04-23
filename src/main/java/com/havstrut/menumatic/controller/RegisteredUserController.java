package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.RegisteredUser;
import com.havstrut.menumatic.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class RegisteredUserController {

    private final RegisteredUserRepository registeredUserRepository;

    final RegisteredUser registeredUser = new RegisteredUser(0, "blablabla2@blablabla.com");

    @Autowired
    public RegisteredUserController(RegisteredUserRepository registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }

    @GetMapping(path = "getStudent/{user_id}")
    public RegisteredUser read(@PathVariable int user_id) {
        Optional<RegisteredUser> registedUserOptional = registeredUserRepository.findRegisteredUserById(user_id);
        if(registedUserOptional.isEmpty()) {
            throw new IllegalStateException("id is not found");
        }
        return registedUserOptional.get();
    }

}
