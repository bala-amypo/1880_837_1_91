package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.model.CategorizationLog;
import com.example.demo.service.impl.CategorizationEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RestController
@RequestMapping("/engine")
public class CategorizationEnginecontroller{

    @Autowired
    private CategorizationEngineService service;

    @PostMapping("/tickets/{ticketId}/categorize")
    public Ticket categorizeTicket(@PathVariable Long ticketId) {
        return service.categorizeTicket(ticketId);
    }
    @GetMapping("/tickets/{ticketId}/logs")
    public List<CategorizationLog> getLogsForTicket(@PathVariable Long ticketId) {
        return service.getLogsForTicket(ticketId);
    }
    @GetMapping("/logs/{id}")
    public CategorizationLog getLog(@PathVariable Long id) {
        return service.getLog(id);
    }
}
