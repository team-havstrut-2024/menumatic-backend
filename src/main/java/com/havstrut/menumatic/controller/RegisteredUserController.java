package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.json.JacksonJsonParser;

import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api") //byta till "/registeredUsers" ?
public class RegisteredUserController {

    private final RegisteredUserService registeredUserService;

    //final RegisteredUser registeredUser = new RegisteredUser("blablabla2@blablabla.com");

    public RegisteredUserController(RegisteredUserService registeredUserService) {
        this.registeredUserService = registeredUserService;
    }


    /*@GetMapping(path = "getStudent/{user_id}")
    public RegisteredUser read(@PathVariable int user_id) {
        Optional<RegisteredUser> registedUserOptional = registeredUserRepository.findRegisteredUserById(user_id);
        if(registedUserOptional.isEmpty()) {
            throw new IllegalStateException("id is not found");
        }
        return registedUserOptional.get();
    }*/

    @GetMapping("/fetchUserWithId/{user_id}")
    public RegisteredUser fetchUserWithId(@PathVariable int user_id) {
        return registeredUserService.getUserByID(user_id);
    }
    @PostMapping("/createUserWithEmail/")
   public void registerNewUser(@RequestBody String email_json) {
        JacksonJsonParser jjp = new JacksonJsonParser();
        Map<String, Object> map = jjp.parseMap(email_json);
        String email = (String)(map.get("email"));
        registeredUserService.addNewStudent(email);
    }

}
