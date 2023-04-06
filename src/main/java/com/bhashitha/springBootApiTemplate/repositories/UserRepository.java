package com.bhashitha.springBootApiTemplate.repositories;

import com.bhashitha.springBootApiTemplate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

}
