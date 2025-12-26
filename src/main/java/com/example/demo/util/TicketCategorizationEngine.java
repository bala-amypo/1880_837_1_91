package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component   // 🔥 THIS IS THE FIX
public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs) {

        boolean assigned = false;
        String text = (ticket.getTitle() + " " + ticket.getDescription()).toLowerCase();

        rules.sort(Comparator.comparing(CategorizationRule::getPriority).reversed());

        for (CategorizationRule rule : rules) {
            if (assigned) break;

            boolean match = false;
            String keyword = rule.getKeyword().toLowerCase();

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
                assigned = true;
            }
        }

        for (UrgencyPolicy policy : policies) {
            if (text.contains(policy.getKeyword().toLowerCase())) {
                ticket.setUrgencyLevel(policy.getUrgencyOverride());
            }
        }

        if (ticket.getUrgencyLevel() == null) {
            ticket.setUrgencyLevel("LOW");
        }
    }
}
