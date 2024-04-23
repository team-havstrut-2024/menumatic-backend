package com.havstrut.menumatic.service;

import com.havstrut.menumatic.RegisteredUserRepositoryFromDemo;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserService {

    private final RegisteredUserRepositoryFromDemo registeredUserRepository;


    public RegisteredUserService(RegisteredUserRepositoryFromDemo registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }
}
