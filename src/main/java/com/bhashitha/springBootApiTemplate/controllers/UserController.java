package com.bhashitha.springBootApiTemplate.controllers;
import com.bhashitha.springBootApiTemplate.models.User;
import com.bhashitha.springBootApiTemplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService theUserService){
        userService=theUserService;
    }
    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId){
        User theUser=userService.findById(userId);

        if(theUser==null){
            throw new RuntimeException("User id not found -" + userId);
        }
        return theUser;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        theUser.setId(0L);
//        theUser.setPassword();
        User dbUser=userService.save(theUser);
        return dbUser;
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User theUser,@PathVariable Long userId){
//        User DbUser=userService.findById(userId);
//        if(DbUser==null){
//            throw new RuntimeException("User id not found -" + userId);
//        }
        System.out.println("ddddddd"+userId);
        theUser.setId(userId);
        User dbUser=userService.save(theUser);
        return  dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId){
        User theUser =userService.findById(userId);

        if(theUser==null){
            throw new RuntimeException("User id not found - " + userId);

        }

        userService.deleteById(userId);
        return "Deleted user id -" + userId;
    }
}
