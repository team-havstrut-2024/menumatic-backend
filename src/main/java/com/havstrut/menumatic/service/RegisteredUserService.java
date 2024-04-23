package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.repository.RegisteredUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisteredUserService {

    private final RegisteredUserRepository registeredUserRepository;

    @Autowired
    public RegisteredUserService(RegisteredUserRepository registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }


    @Transactional
    public RegisteredUser getUserByID(int user_id) {
        Optional<RegisteredUser> studentOptional = registeredUserRepository.findById(user_id);
        if(studentOptional.isEmpty()) {
            throw new IllegalStateException("No user with such id");
        }
        return studentOptional.get();
    }

    @Transactional
    public void addNewStudent(String email) {
        Optional<RegisteredUser> studentOptional = registeredUserRepository.findByEmail(email);
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        registeredUserRepository.save(new RegisteredUser((email)));
    }
}
