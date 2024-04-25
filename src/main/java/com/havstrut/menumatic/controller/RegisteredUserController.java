package com.havstrut.menumatic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.model.RegisteredUser;
import com.havstrut.menumatic.request.CreateUserRequest;
import com.havstrut.menumatic.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.json.JacksonJsonParser;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;


@RestController
@RequestMapping("/api/user/") //byta till "/registeredUsers" ?
public class RegisteredUserController {

    private final RegisteredUserService registeredUserService;
    private final ObjectMapper objectMapper;


    //final RegisteredUser registeredUser = new RegisteredUser("blablabla2@blablabla.com");

    public RegisteredUserController(RegisteredUserService registeredUserService, ObjectMapper objectMapper) {
        this.registeredUserService = registeredUserService;
        this.objectMapper = objectMapper;
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
    public void CreateTestUser(@RequestHeader("User-id") String uid, @RequestBody String json) throws JsonProcessingException {
        String newUid = uid.replace('"', ' ').trim();
        System.out.println(newUid);
        System.out.println(json);
        //recipes:[{name:Light Greek Lemon Chicken Orzo Soup,portion:1,id:1098350}
        //Är en array av objects
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap = objectMapper.readValue(json, HashMap.class);

        System.out.println(("This is the json object: " + jsonMap));

        String planName = (String) jsonMap.get("planName");
        System.out.println(("This is the plan name of the week: " + planName));

        List<Map<String, Object>> recipes = (List<Map<String, Object>>) jsonMap.get("recipes");
        System.out.println("This is the recipes object: " + recipes);

        String rName = (String) recipes.get(0).get("name");
        //System.out.println(recipes.get(0));
        System.out.println(rName);


        int rPortion = (int) recipes.get(0).get("portion");
        System.out.println(("This is the portion: " + rPortion));

        int rId = (int) recipes.get(0).get("id");
        System.out.println(("This is the id of the recipe: " + rId));

        registeredUserService.addNewStudent(newUid, planName, rName, rPortion, rId);





        /*int rPortion = recipes.get(Integer.parseInt("portion"));
        System.out.println(rPortion);
        String rPortion = (String) recipes.get(0).get("portion");
        String rId = (String) recipes.get(0).get("id");
        System.out.println(rName);
        System.out.println(rPortion);
        System.out.println(rId);*/







    }



}
