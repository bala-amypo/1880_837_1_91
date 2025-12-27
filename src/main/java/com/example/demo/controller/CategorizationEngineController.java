package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engine")
public class CategorizationEngineController {

    private final CategorizationEngineService engineService;

    public CategorizationEngineController(CategorizationEngineService engineService) {
        this.engineService = engineService;
    }

    @PostMapping("/categorize/{id}")
    public Ticket categorize(@PathVariable Long id) {
        return engineService.categorizeTicket(id);
    }

    @GetMapping("/logs/{ticketId}")
    public List<CategorizationLog> logs(@PathVariable Long ticketId) {
        return engineService.getLogsForTicket(ticketId);
    }
}
