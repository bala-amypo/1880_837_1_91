package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;

import java.util.List;

public class TicketCategorizationEngine {

    public Category categorize(String text, List<CategorizationRule> rules) {

        for (CategorizationRule rule : rules) {
            if (text.toLowerCase().contains(rule.getKeyword().toLowerCase())) {
                return rule.getCategory();
            }
        }
        return null;
    }
}
