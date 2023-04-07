package com.bhashitha.springBootApiTemplate.services;

import com.bhashitha.springBootApiTemplate.models.User;
import com.bhashitha.springBootApiTemplate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){
        userRepository=theUserRepository;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long theId) {
        Optional<User> result = userRepository.findById(theId);
        User theUser=null;
        if(result.isPresent()){
            theUser=result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theUser;
    }

    @Override
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

    @Override
    public void deleteById(Long theId) {
        userRepository.deleteById(theId);
    }
}
