package com.example.finance_tracker.service;

import com.example.finance_tracker.dictionary.CategorySet;
import com.example.finance_tracker.dto.ExpensePatchRequestDto;
import com.example.finance_tracker.dto.ExpenseRequestDto;
import com.example.finance_tracker.dto.ExpenseResponseDto;
import com.example.finance_tracker.exception.ExpenseNotFoundException;
import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.repository.ExpenseRepository;
import jakarta.validation.Valid;
import jdk.jfr.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
                dto.getCategory().trim().toLowerCase()
        );

        // save Entity
        Expense saved = repository.save(expense);

        // Entity -> Response DTO

        return new ExpenseResponseDto(
                saved.getId(),
                saved.getAmount(),
                saved.getDescription(),
                saved.getCategory()
        );

    }

    public void deleteExpense(Long id) {
        Expense expense = repository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
        repository.delete(expense);

    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public ExpenseResponseDto updateExpense(ExpenseRequestDto dto, Long id) {
        Expense expense = repository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));

        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory().trim().toLowerCase());
        expense.setDescription(dto.getDescription());

        // save Entity
        Expense saved = repository.save(expense);

        // Entity -> Response DTO
        return new ExpenseResponseDto(
                saved.getId(),
                saved.getAmount(),
                saved.getDescription(),
                saved.getCategory()
        );

    }

    public ExpenseResponseDto patchExpense(ExpensePatchRequestDto dto, Long id) {
        Expense expense = repository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));

        if (dto.getAmount() != null) {
            expense.setAmount(dto.getAmount());
        }
        if (dto.getCategory() != null) {
            expense.setCategory(dto.getCategory().trim().toLowerCase());
        }
        if (dto.getDescription() != null) {
            expense.setDescription(dto.getDescription());
        }
        // save Entity
        Expense saved = repository.save(expense);

        // Entity -> Response DTO
        return new ExpenseResponseDto(
                saved.getId(),
                saved.getAmount(),
                saved.getDescription(),
                saved.getCategory()
        );

    }
    public Set<String> getAllCategories() {
        return repository.findDistinctCategories();
    }
}
