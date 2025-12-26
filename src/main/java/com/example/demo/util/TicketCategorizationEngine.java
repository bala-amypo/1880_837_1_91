package com.example.demo.util;

import com.example.demo.model.*;

import java.util.Comparator;
import java.util.List;

public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs) {

        boolean categoryAssigned = false;

        // 1️⃣ Apply categorization rules (by priority DESC)
        rules.stream()
                .sorted(Comparator.comparing(CategorizationRule::getPriority).reversed())
                .forEach(rule -> {
                    if (categoryAssigned) return;

                    String text = (ticket.getTitle() + " " + ticket.getDescription()).toLowerCase();
                    String keyword = rule.getKeyword().toLowerCase();

                    boolean match = false;

                    if ("CONTAINS".equalsIgnoreCase(rule.getMatchType())) {
                        match = text.contains(keyword);
                    } else if ("EXACT".equalsIgnoreCase(rule.getMatchType())) {
                        match = text.equals(keyword);
                    }

                    if (match) {
                        ticket.setAssignedCategory(rule.getCategory());
                        ticket.setUrgencyLevel(rule.getCategory().getDefaultUrgency());

                        CategorizationLog log = new CategorizationLog();
                        log.setAssignedCategory(rule.getCategory());
                        log.setAppliedRule(rule);
                        log.setMatchedKeyword(rule.getKeyword());
                        log.setAssignedUrgency(ticket.getUrgencyLevel());
                        log.setTicket(ticket);

                        logs.add(log);
                        categoryAssigned = true;
                    }
                });

        // 2️⃣ Apply urgency policy override
        for (UrgencyPolicy policy : policies) {
            String text = (ticket.getTitle() + " " + ticket.getDescription()).toLowerCase();
            if (text.contains(policy.getKeyword().toLowerCase())) {
                ticket.setUrgencyLevel(policy.getUrgencyOverride());
            }
        }

        // 3️⃣ Default urgency if nothing matched
        if (ticket.getUrgencyLevel() == null) {
            ticket.setUrgencyLevel("LOW");
        }
    }
}
