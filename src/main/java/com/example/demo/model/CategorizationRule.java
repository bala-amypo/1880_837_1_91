package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorization_rule")
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    private String matchType; // EXACT / CONTAINS

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getMatchType() {
        return matchType;
    }

    public Category getCategory() {
        return category;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
