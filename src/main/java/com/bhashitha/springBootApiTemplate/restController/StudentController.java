package com.bhashitha.springBootApiTemplate.restController;
import com.bhashitha.springBootApiTemplate.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    coach cricket01;
    @Autowired
    public StudentController(@Qualifier("tennisCoach") coach cc1){
        cricket01=cc1;
    }
    @GetMapping("/student")
    public String studentName(){
        return  "Hi My name is "+cricket01.name();
    }
}
