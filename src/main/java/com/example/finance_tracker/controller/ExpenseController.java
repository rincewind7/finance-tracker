package com.example.finance_tracker.controller;

import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public void addExpense(@RequestBody Expense expense) {
        service.addExpense(expense);
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return service.getAllExpenses();
    }

}
