package com.example.finance_tracker.repository;

import com.example.finance_tracker.model.Expense;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryExpenseRepository implements ExpenseRepository {
    private final List<Expense> expenses = new ArrayList<>();

    @Override
    public void save(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public List<Expense> findAll() {
        return Collections.unmodifiableList(expenses);
    }
}
