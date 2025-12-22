package com.example.demo.controller;
import com.example.demo.model.Ticket;
import com.example.demo.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tickets")
@RestController
public class TicketController{
    @Autowired
    TicketService obj;
    @PostMapping("/ticket")
    public Ticket create(@RequestBody Ticket ti){
        return obj.createTicket(ti);
    }
    @GetMapping("/top")
    public List<Ticket> getall(){
        return obj.getAllTicket();
    }
    @GetMapping("/{id}")
    public Ticket getid(@PathVariable Long id){
        return obj.getTicket(id);
    }
}
