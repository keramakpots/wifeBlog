package com.example.wife.blog.simple.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BlogRecord")
@Data
public class BlogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String blogTextEntry;
    private String author;
    private String date;

    // constructors, getters, and setters
}