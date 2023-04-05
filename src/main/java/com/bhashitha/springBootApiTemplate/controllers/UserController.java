package com.bhashitha.springBootApiTemplate.controllers;
import com.bhashitha.springBootApiTemplate.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    coach cricket01;
    @Autowired
    public UserController(@Qualifier("tennisCoach") coach cc1){
        cricket01=cc1;
    }
    @GetMapping("/user")
    public String userName(){
        return  "Hi My name is "+cricket01.name();
    }
}
