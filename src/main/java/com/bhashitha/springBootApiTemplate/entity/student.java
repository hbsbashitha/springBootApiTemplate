package com.bhashitha.springBootApiTemplate.entity;

import jakarta.persistence.*;

@Entity
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;




}
