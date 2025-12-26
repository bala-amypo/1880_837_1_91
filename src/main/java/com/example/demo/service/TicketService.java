package com.example.demo.service.impl;
import java.util.List;
import com.example.demo.model.Ticket;
public interface TicketService{
    public Ticket createTicket(Ticket Ticket);
    public Ticket getTicket(Long id);
    public List<Ticket> getAllTicket();
}