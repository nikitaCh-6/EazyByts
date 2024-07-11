package com.example.crm_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @SuppressWarnings("unused")
    private String title;
    @SuppressWarnings("unused")
    private String description;
    @SuppressWarnings("unused")
    private Date dueDate;
    @SuppressWarnings("unused")
    private Boolean completed;

    // Getters and Setters
}
