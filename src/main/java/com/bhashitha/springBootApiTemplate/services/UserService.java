package com.bhashitha.springBootApiTemplate.services;

import com.bhashitha.springBootApiTemplate.models.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findById(Long theId);

    User save(User theUser);
    void deleteById(Long theId);
}
