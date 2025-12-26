package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.impl.CategorizationEngineServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorize")
public class CategorizationEngineController {

    private final CategorizationEngineServiceImpl engineService;

    public CategorizationEngineController(CategorizationEngineServiceImpl engineService) {
        this.engineService = engineService;
    }

    @PostMapping("/run/{ticketId}")
    public Ticket run(@PathVariable Long ticketId) {
        return engineService.categorizeTicket(ticketId);
    }

    @GetMapping("/logs/{ticketId}")
    public List<CategorizationLog> logs(@PathVariable Long ticketId) {
        return engineService.getLogsForTicket(ticketId);
    }

    @GetMapping("/log/{id}")
    public CategorizationLog log(@PathVariable Long id) {
        return engineService.getLog(id);
    }
}
