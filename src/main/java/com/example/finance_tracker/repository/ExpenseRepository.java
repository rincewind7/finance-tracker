package com.example.finance_tracker.repository;

import com.example.finance_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("SELECT DISTINCT e.category FROM Expense e WHERE e.category IS NOT NULL")
    Set<String> findDistinctCategories();
}


