package com.example.wife.blog.simple.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BlogUsers")
@Data
public class BlogUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String login;

    // constructors, getters, and setters
}
