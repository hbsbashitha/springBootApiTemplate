package com.bhashitha.springBootApiTemplate.models;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "email")
    private String email;




}
