package com.example.crm_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
    @SuppressWarnings("unused")
    private Double amount;
    @SuppressWarnings("unused")
    private String status;

    // Getters and Setters
}
