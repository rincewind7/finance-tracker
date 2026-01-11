package com.example.finance_tracker.controller;

import com.example.finance_tracker.dto.ExpensePatchRequestDto;
import com.example.finance_tracker.dto.ExpenseRequestDto;
import com.example.finance_tracker.dto.ExpenseResponseDto;
import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/expenses")
public class ExpenseController  {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExpenseResponseDto> addExpense( @Valid @RequestBody ExpenseRequestDto dto) {
        ExpenseResponseDto saved = service.addExpense(dto);
        return ResponseEntity
                .created(URI.create("/expenses/" + saved.getId()))
                .body(saved);
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return service.getAllExpenses();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);

    }
    @PutMapping("/{id}")
    ResponseEntity<ExpenseResponseDto> updateExpense
            (@Valid @RequestBody ExpenseRequestDto dto, @PathVariable Long id) {
        return ResponseEntity.ok(service.updateExpense(dto, id));
    }
    @PatchMapping("/{id}")
    ResponseEntity<ExpenseResponseDto> patchExpense
            (@Valid @RequestBody ExpensePatchRequestDto dto, @PathVariable Long id) {
        return ResponseEntity.ok(service.patchExpense(dto,id));
    }
    @GetMapping("/categories")
    public Set<String> getCategories() {
        return service.getAllCategories();
    }

}
