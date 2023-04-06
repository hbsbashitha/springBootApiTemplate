package com.bhashitha.springBootApiTemplate.services;

import com.bhashitha.springBootApiTemplate.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User findById(Long theId);

    User save(User theUser);
    void deleteById(Long theId);
}
