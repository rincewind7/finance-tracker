package com.example.finance_tracker.service;

import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void addExpense(Expense expense) {
        repository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

}
