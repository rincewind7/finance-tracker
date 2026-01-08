package com.example.finance_tracker.exception;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(Long id) {
        super("Expense with id " + id + " not found");
    }
}


