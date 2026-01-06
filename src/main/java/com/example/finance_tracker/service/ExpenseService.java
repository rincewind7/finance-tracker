package com.example.finance_tracker.service;

import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    //constructor-based Dependency Injection
    //Service nie tworzy repozytorium (Nie ma new InMemoryExpenseRepository()_
    //Zamiast tego mówi: „potrzebuję ExpenseRepository” (interfejs) Spring wstrzykuje konkretną implementację
    //Service zależy od abstrakcji a nie od implementacji (DIP – Dependency Inversion Principle
    // serwis nie powinien wiedzieć, jak dane są zapisywane tylko co może z nimi zrobić
    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

}
