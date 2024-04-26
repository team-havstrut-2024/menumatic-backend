package com.havstrut.menumatic.service;

import com.havstrut.menumatic.model.Recipe;
import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;



//import com.havstrut.menumatic.util.Utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RegisteredUserService {


    private final RegisteredUserRepository registeredUserRepository;

    @Autowired
    public RegisteredUserService(RegisteredUserRepository registeredUserRepository) {
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
    public void addNewStudent(String newUid) {
        Optional<RegisteredUser> studentOptional = registeredUserRepository.findById(newUid);
        System.out.println(studentOptional);
        if(studentOptional.isEmpty()) {
            registeredUserRepository.save(new RegisteredUser(newUid));
        }
        System.out.println(registeredUserRepository.findById(newUid).get().getUserId());

        //registeredUserRepository.save(new RegisteredUser(uid));
    }

    @Transactional
    public void createNewUser(String uid, String json) {
        String newUid = uid.replace('"', ' ').trim();
        System.out.println(newUid);
        System.out.println(json);

        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap = objectMapper.readValue(json, HashMap.class);

        System.out.println(("This is the json object: " + jsonMap));

        String planName = (String) jsonMap.get("planName");
        System.out.println(("This is the plan name of the week: " + planName));


        JacksonJsonParser jjp = new JacksonJsonParser();
        Map<String, Object> map = jjp.parseMap(json);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("Key: " + key + ", Val: " + val);
            //recipeRepository.save(new RegisteredUser(key, (String) val));
            //registeredUserRepository.save(new RegisteredUser(key, (String) val));
            //utility.invokeRepositoryMethod(key, val);


        }
    }
}
