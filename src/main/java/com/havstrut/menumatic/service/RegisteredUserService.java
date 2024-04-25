package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.Recipe;
import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;

import com.havstrut.menumatic.util.Utility;

import java.util.Map;
import java.util.Optional;

@Service
public class RegisteredUserService {

    private final Utility utility;
    private final RegisteredUserRepository registeredUserRepository;

    @Autowired
    public RegisteredUserService(Utility utility, RegisteredUserRepository registeredUserRepository) {
        this.utility = utility;
        this.registeredUserRepository = registeredUserRepository;
    }


    @Transactional
    public RegisteredUser getUserByID(String user_id) {
        Optional<RegisteredUser> studentOptional = registeredUserRepository.findById(user_id);
        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("No user with such id");
        }
        return studentOptional.get();
    }

    @Transactional
    public void addNewStudent(String newUid, String planName, String rName, int rPortion, int rId) {
        Optional<RegisteredUser> studentOptional = registeredUserRepository.findById(newUid);
        System.out.println(studentOptional);
        //registeredUserRepository.save(new RegisteredUser(uid));
    }

    @Transactional
    public void createNewUser(String json) {
        JacksonJsonParser jjp = new JacksonJsonParser();
        Map<String, Object> map = jjp.parseMap(json);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("Key: " + key + ", Val: " + val);
            //recipeRepository.save(new RegisteredUser(key, (String) val));
            //registeredUserRepository.save(new RegisteredUser(key, (String) val));
            utility.invokeRepositoryMethod(key, val);


        }
    }
}
