package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.ExpenseRequestDto;
import com.example.finance_tracker.dto.ExpenseResponseDto;
import com.example.finance_tracker.exception.ExpenseNotFoundException;
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

    public ExpenseResponseDto addExpense(ExpenseRequestDto dto) {
        // DTO -> Entity
        Expense expense = new Expense(
                dto.getAmount(),
                dto.getDescription(),
                dto.getCategory()
        );

        // save Entity
        Expense saved = repository.save(expense);

        // Entity -> Response DTO
        return new ExpenseResponseDto (
                saved.getId(),
                saved.getAmount(),
                saved.getDescription(),
                saved.getCategory()
        );
    }
    public void deleteExpense(Long id) {
        Expense expense= repository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
        repository.delete(expense);

    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

}
