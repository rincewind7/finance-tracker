package com.example.finance_tracker.model;

import java.math.BigDecimal;

public class Expense {

    private BigDecimal amount;
    private String description;
    private String category;

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
}
