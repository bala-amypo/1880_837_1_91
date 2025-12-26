package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    private String matchType;   // EXACT name used in engine

    private int priority;

    @ManyToOne
    private Category category;

    // ===== REQUIRED GETTERS / SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {            // 🔥 REQUIRED
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMatchType() {           // 🔥 REQUIRED
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) { // 🔥 REQUIRED
        this.priority = priority;
    }

    public Category getCategory() {          // 🔥 REQUIRED
        return category;
    }

    public void setCategory(Category category) { // 🔥 REQUIRED
        this.category = category;
    }
}
