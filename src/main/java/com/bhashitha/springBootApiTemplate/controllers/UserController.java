package com.bhashitha.springBootApiTemplate.controllers;

import com.bhashitha.springBootApiTemplate.models.LoginRequest;
import com.bhashitha.springBootApiTemplate.models.User;
import com.bhashitha.springBootApiTemplate.services.UserService;
import com.bhashitha.springBootApiTemplate.utils.PasswordHashingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bhashitha.springBootApiTemplate.utils.PasswordHashingUtils.hashPassword;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping
    public List<User> findAll() {
        List<User> users =userService.findAll();
        return users;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        User theUser = userService.findById(userId);
        return theUser;
    }

    @PostMapping
    public User addUser(@RequestBody User theUser) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        theUser.setId(0L);

        //encode the password to hashed one
        String hashedPassword = hashPassword(theUser.getPassword());
        theUser.setPassword(hashedPassword);
        User dbUser = userService.save(theUser);
        return dbUser;
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId,@RequestBody User theUser) {
        theUser.setId(userId);
        User dbUser = userService.save(theUser);
        return dbUser;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        User theUser = userService.findById(userId);

        if (theUser == null) {
            throw new RuntimeException("User id not found - " + userId);

        }

        userService.deleteById(userId);
        return "Deleted user id -" + userId;
    }


}
