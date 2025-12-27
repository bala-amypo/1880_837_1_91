package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketCategorizationEngine engine = new TicketCategorizationEngine();

    private final List<CategorizationLog> logs = new ArrayList<>();

    @Override
    public Ticket categorizeTicket(Long ticketId) {

        Ticket ticket = new Ticket(ticketId, "System not working");

        Category category = engine.categorize(
                ticket.getDescription(),
                List.of(new CategorizationRule("system", "EXACT", new Category(1L, "IT")))
        );

        ticket.setCategory(category);
        ticket.setUrgency("HIGH");

        CategorizationLog log = new CategorizationLog();
        log.setTicketId(ticketId);
        log.setCategory(category);
        log.setUrgency("HIGH");
        log.setCreatedAt(LocalDateTime.now());

        logs.add(log);

        return ticket;
    }

    @Override
    public CategorizationLog getLog(Long logId) {
        return logs.stream()
                .filter(l -> l.getId().equals(logId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logs.stream()
                .filter(l -> l.getTicketId().equals(ticketId))
                .toList();
    }
}
