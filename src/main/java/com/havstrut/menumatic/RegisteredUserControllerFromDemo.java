package com.havstrut.menumatic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class RegisteredUserControllerFromDemo {

    private final RegisteredUserRepositoryFromDemo registeredUserRepository;

    final RegisteredUserFromDemo registeredUser = new RegisteredUserFromDemo(0, "blablabla2@blablabla.com");

    @Autowired
    public RegisteredUserControllerFromDemo(RegisteredUserRepositoryFromDemo registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }

    @GetMapping(path = "getStudent/{user_id}")
    public RegisteredUserFromDemo read(@PathVariable int user_id) {
        Optional<RegisteredUserFromDemo> registedUserOptional = registeredUserRepository.findRegisteredUserById(user_id);
        if(registedUserOptional.isEmpty()) {
            throw new IllegalStateException("id is not found");
        }
        return registedUserOptional.get();
    }

}
