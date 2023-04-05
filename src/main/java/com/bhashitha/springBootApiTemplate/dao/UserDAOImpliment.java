package com.bhashitha.springBootApiTemplate.dao;

import com.bhashitha.springBootApiTemplate.models.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImpliment implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpliment(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    @Transactional
    public void save(User theUser) {

//        that is the way how to create custom quires
//        TypedQuery<Student> theQuery=entityManager.createQuery("from student",Student.class);

        entityManager.persist(theUser);
    }
}
