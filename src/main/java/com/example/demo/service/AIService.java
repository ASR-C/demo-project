package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

    public String getSuggestion(double budget, String category) {

        if (budget < 5000) {
            return "You should look for budget " + category + " products.";
        } else if (budget < 20000) {
            return "Mid-range " + category + " would be best.";
        } else {
            return "Go for premium " + category + " products.";
        }
    }
}