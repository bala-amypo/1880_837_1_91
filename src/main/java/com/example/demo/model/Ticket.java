package com.example.demo.model;

public class Ticket {

    private Long id;
    private String description;
    private Category category;
    private String urgency;

    public Ticket(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() { return id; }

    public String getDescription() { return description; }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
}
