package com.example.finance_tracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ExpenseResponseDto {

    private Long id;
    private BigDecimal amount;
    private String description;
    private String category;
    public ExpenseResponseDto(
            Long id,
            BigDecimal amount,
            String description,
            String category
    ) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.category = category;
    }
    public Long getId() {
        return id;
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
