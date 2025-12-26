package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    private int priority;

    // ===== REQUIRED BY TESTCASES =====

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {   // 🔥 REQUIRED
        this.priority = priority;
    }

    // existing getters/setters ok
}
