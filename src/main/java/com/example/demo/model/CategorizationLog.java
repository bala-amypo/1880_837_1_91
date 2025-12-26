package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private CategorizationRule appliedRule;

    private String matchedKeyword;

    private String assignedUrgency;

    @ManyToOne
    private Category assignedCategory;

    private LocalDateTime loggedAt;

    @PrePersist
    public void prePersist() {
        loggedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
}
