package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.impl.TicketServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketServiceImpl ticketService;

    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/{id}")
    public Ticket get(@PathVariable Long id) {
        return ticketService.getTicket(id);
    }

    @GetMapping
    public List<Ticket> getAll() {
        return ticketService.getAllTickets();
    }
}
