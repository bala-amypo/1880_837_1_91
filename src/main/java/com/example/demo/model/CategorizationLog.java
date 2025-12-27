package com.example.demo.model;

import java.time.LocalDateTime;

public class CategorizationLog {

    private static long counter = 1;

    private Long id = counter++;
    private Long ticketId;
    private Category category;
    private String urgency;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
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
