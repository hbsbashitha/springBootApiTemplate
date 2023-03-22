package com.bhashitha.springBootApiTemplate.dao;

import com.bhashitha.springBootApiTemplate.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class studentDAOImpliment implements studentDAO{

    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(student theStudent) {
        entityManager.persist(theStudent);
    }
}
