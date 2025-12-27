package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository urgencyPolicyRepository;
    private final CategorizationLogRepository logRepository;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategoryRepository categoryRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository urgencyPolicyRepository,
            CategorizationLogRepository logRepository) {

        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ruleRepository = ruleRepository;
        this.urgencyPolicyRepository = urgencyPolicyRepository;
        this.logRepository = logRepository;
    }

    @Override
    public CategorizationResult categorizeTicket(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        List<CategorizationRule> rules = ruleRepository.findAll();
        List<UrgencyPolicy> policies = urgencyPolicyRepository.findAll();

        // ✅ Category calculate
        Category category = TicketCategorizationEngine
                .categorize(ticket.getDescription(), rules);

        // ✅ Urgency calculate
        String urgency = TicketCategorizationEngine
                .determineUrgency(ticket.getDescription(), policies);

        // ✅ Ticket update (CORRECT setters)
        ticket.setCategory(category);
        ticket.setUrgency(urgency);
        ticketRepository.save(ticket);

        // ✅ Log save
        CategorizationLog log = new CategorizationLog();
        log.setTicketId(ticket.getId());
        log.setCategory(category);
        log.setUrgency(urgency);
        log.setCreatedAt(LocalDateTime.now());
        logRepository.save(log);

        // ✅ RETURN RESULT OBJECT
        return new CategorizationResult(category, urgency);
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findAll()
                .stream()
                .filter(l -> l.getTicketId().equals(ticketId))
                .collect(Collectors.toList());
    }

    @Override
    public CategorizationLog getLog(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }
}
