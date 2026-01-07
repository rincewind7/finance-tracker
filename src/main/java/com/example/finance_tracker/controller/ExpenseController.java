package com.example.finance_tracker.controller;

import com.example.finance_tracker.dto.ExpenseRequestDto;
import com.example.finance_tracker.dto.ExpenseResponseDto;
import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController  {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public ExpenseResponseDto addExpense( @Valid @RequestBody ExpenseRequestDto dto) {
        return service.addExpense(dto);
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return service.getAllExpenses();
    }

}
