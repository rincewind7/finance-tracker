package com.example.finance_tracker.dto;

import java.math.BigDecimal;

public class ExpensePatchRequestDto {

    private BigDecimal amount;
    private String description;
    private String category;

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
