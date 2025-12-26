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

        // 1️⃣ Sort rules by priority DESC
        rules.sort(Comparator.comparing(CategorizationRule::getPriority).reversed());

        String text = (ticket.getTitle() + " " + ticket.getDescription()).toLowerCase();

        // 2️⃣ Apply categorization rules
        for (CategorizationRule rule : rules) {
            if (categoryAssigned) break;

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
                log.setTicket(ticket);
                log.setAppliedRule(rule);
                log.setMatchedKeyword(rule.getKeyword());
                log.setAssignedUrgency(ticket.getUrgencyLevel());
                log.setAssignedCategory(rule.getCategory());

                logs.add(log);
                categoryAssigned = true;
            }
        }

        // 3️⃣ Apply urgency policy override
        for (UrgencyPolicy policy : policies) {
            if (text.contains(policy.getKeyword().toLowerCase())) {
                ticket.setUrgencyLevel(policy.getUrgencyOverride());
            }
        }

        // 4️⃣ Default urgency
        if (ticket.getUrgencyLevel() == null) {
            ticket.setUrgencyLevel("LOW");
        }
    }
}
