package com.example.finance_tracker.controller;

import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CONTROLLER = POŚREDNIK HTTP (nic nie liczy, nie zapisuje, przekazuje dalej)

//@RestController zawiera w sobie @Controller → kontroler oraz @ResponseBody → zwracaj JSON, a nie widoki HTML
// (nie musisz pisać ResponseNody nad metodami)
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    //zależność, final oznacza że referencja nie może się zmienić
    private final ExpenseService service;

    //Consructor-based dependency injection
    public ExpenseController(ExpenseService service) {
        this.service = service;
    }
    //RequestBody - JSON z requestu zamieniany jest na obiek Java (tu klasa Expense), jeśli JSON nie pasuje to 400
    @PostMapping
    public void addExpense(@RequestBody Expense expense) {
        service.addExpense(expense);
    }

    //mapuje metodę na HTTP GET, ścieżka: /expenses
    @GetMapping
    public List<Expense> getExpenses() {
        return service.getAllExpenses();
    }

}
