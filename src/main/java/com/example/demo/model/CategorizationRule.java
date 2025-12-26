package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Category category;

    private String keyword;

    private String matchType;

    private Integer priority;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (priority == null) {
            priority = 1;
        }
        createdAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public Integer getPriority() { return priority; }
}
