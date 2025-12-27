package com.example.demo.util;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Category;
import com.example.demo.model.UrgencyPolicy;

import java.util.List;

public class TicketCategorizationEngine {

    // ✅ Category logic
    public static Category categorize(String text, List<CategorizationRule> rules) {

        for (CategorizationRule rule : rules) {
            if (text.toLowerCase().contains(rule.getKeyword().toLowerCase())) {
                return rule.getCategory();
            }
        }
        return null;
    }

    // ✅ Urgency logic
    public static String determineUrgency(String text, List<UrgencyPolicy> policies) {

        for (UrgencyPolicy policy : policies) {
            if (text.toLowerCase().contains(policy.getKeyword().toLowerCase())) {
                return policy.getUrgencyLevel();
            }
        }
        return "LOW";
    }
}
