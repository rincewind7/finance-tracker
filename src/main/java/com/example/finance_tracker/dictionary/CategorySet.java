package com.example.finance_tracker.dictionary;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

    @Component
    public class CategorySet {

        //final blokuje przed zmianą referencji (ale zawartość setu można zmieniać) - dobra praktyka przy beans
        private final Set<String> categories = new HashSet<>();

        public void addCategory(String category) {
            categories.add(category.toLowerCase());
        }
        // Zwracam unmodifiableSet, żeby ktoś z zewnątrz nie mógł zmieniać zawartości beana i przypadkowo zepsuć jego stanu (ENKAPSULACJA)
        // Nie unmodifiableCollection ponieważ użyty został Set (bez duplikatów) i chcę to jasno komunikować w API.
        // Ten bean jest singletonem z automatu (współdzielony przez wiele klas) więc ochrona jest szczególnie ważna
        //w kontekście wielowątkowości
        public Set<String> getAllCategories() {
            return Collections.unmodifiableSet(categories);
        }
        public boolean exists(String category) {
            return categories.contains(category.toLowerCase());
        }
    }

