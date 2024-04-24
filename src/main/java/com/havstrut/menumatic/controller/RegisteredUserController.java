package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.request.CreateUserRequest;
import com.havstrut.menumatic.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.json.JacksonJsonParser;

import java.util.Map;
import java.util.Optional;
import java.util.LinkedList;


@RestController
@RequestMapping("/api/user/") //byta till "/registeredUsers" ?
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

    /*@GetMapping("/mealplans/{user_id}")
    public LinkedList<Object> fetchMealplans(@PathVariable String user_id) {
        
    }*/



    /*@GetMapping("/get/{user_id}")
    public RegisteredUser fetchUserWithId(@PathVariable String user_id) {
        return registeredUserService.getUserByID(user_id);
    }
    // TODO: Change to also accept a UserID string
    @PostMapping("/create/")
   public void registerNewUser(@RequestBody String json) {
        JacksonJsonParser jjp = new JacksonJsonParser();
        Map<String, Object> map = jjp.parseMap(json);
        String uid = (String)(map.get("User-id"));
        if (uid == null) throw new IllegalArgumentException("User-id not found");
        String email = (String)(map.get("email"));
        registeredUserService.addNewStudent(uid, email);
    }
*/
    /*@PostMapping("/create/")
    public void createNewUser(@RequestHeader String json) {
        registeredUserService.createNewUser(json);
    }*/

    @CrossOrigin
    @PostMapping("/create/")
    public void CreateTestUser(@RequestHeader("User-id") String uid, @RequestBody String createUserRequest) {
        System.out.println(uid);
        System.out.println(createUserRequest);
    }



}
