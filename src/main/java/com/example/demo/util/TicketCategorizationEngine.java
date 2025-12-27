package com.example.demo.util;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Category;
import com.example.demo.model.UrgencyPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketCategorizationEngine {

    public Category categorize(String description, List<CategorizationRule> rules) {
        for (CategorizationRule rule : rules) {
            if ("EXACT".equalsIgnoreCase(rule.getMatchType())
                    && description.equalsIgnoreCase(rule.getKeyword())) {
                return rule.getCategory();
            }

            if ("CONTAINS".equalsIgnoreCase(rule.getMatchType())
                    && description.toLowerCase().contains(rule.getKeyword().toLowerCase())) {
                return rule.getCategory();
            }
        }
        return null;
    }

    public int calculatePriority(String description, List<UrgencyPolicy> policies) {
        for (UrgencyPolicy policy : policies) {
            if (description.toLowerCase().contains(policy.getKeyword().toLowerCase())) {
                return policy.getPriority();
            }
        }
        return 0;
    }
}
