package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository urgencyPolicyRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategoryRepository categoryRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository urgencyPolicyRepository,
            CategorizationLogRepository logRepository,
            TicketCategorizationEngine engine
    ) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ruleRepository = ruleRepository;
        this.urgencyPolicyRepository = urgencyPolicyRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }

    @Override
    public Ticket categorizeTicket(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        List<CategorizationRule> rules = ruleRepository.findAll();

        // engine returns category + urgency
        CategorizationResult result =
                engine.categorize(ticket.getDescription(), rules);

        // set values to ticket
        ticket.setAssignedCategory(result.getCategory());
        ticket.setUrgencyLevel(result.getUrgency());

        ticketRepository.save(ticket);

        // create log
        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket); // ✅ IMPORTANT (NO ticketId)
        log.setCategory(result.getCategory());
        log.setUrgency(result.getUrgency());
        log.setCreatedAt(LocalDateTime.now());

        logRepository.save(log);

        return ticket;
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findAll()
                .stream()
                .filter(l -> l.getTicket().getId().equals(ticketId))
                .toList();
    }

    @Override
    public CategorizationLog getLog(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }
}
