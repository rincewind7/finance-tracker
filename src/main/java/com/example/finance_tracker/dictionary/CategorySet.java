package com.example.finance_tracker.dictionary;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

    @Component
    public class CategorySet {

        private final Set<String> categories = new HashSet<>();

        public void addCategory(String category) {
            categories.add(category.toLowerCase());
        }

        public Set<String> getAllCategories() {
            return Collections.unmodifiableSet(categories);
        }
        public boolean exists(String category) {
            return categories.contains(category.toLowerCase());
        }
    }

