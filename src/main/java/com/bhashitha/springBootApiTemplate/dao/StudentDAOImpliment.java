package com.bhashitha.springBootApiTemplate.dao;

import com.bhashitha.springBootApiTemplate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDAOImpliment implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpliment(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {

//        that is the way how to create custom quires
//        TypedQuery<Student> theQuery=entityManager.createQuery("from student",Student.class);

        entityManager.persist(theStudent);
    }
}
