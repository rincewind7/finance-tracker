package com.example.finance_tracker.repository;

import com.example.finance_tracker.model.Expense;

import java.util.List;

public interface ExpenseRepository {
    void save(Expense expense);
    List<Expense> findAll();
}


