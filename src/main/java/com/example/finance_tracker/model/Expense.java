package com.example.finance_tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String description;
    private String category;

    protected Expense() {
        // wymagane przez JPA
    }
    public Expense(BigDecimal amount, String description, String category){
        this.amount = amount;
        this.description = description;
        this.category = category;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public Long getId() { return id;
    }
}
