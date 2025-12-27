package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorization_log")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String urgency;

    private LocalDateTime createdAt;

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Category getCategory() {
        return category;
    }

    public String getUrgency() {
        return urgency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
