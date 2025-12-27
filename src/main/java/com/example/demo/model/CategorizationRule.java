package com.example.demo.model;

public class CategorizationRule {

    private String keyword;
    private String matchType;
    private Category category;

    public CategorizationRule(String keyword, String matchType, Category category) {
        this.keyword = keyword;
        this.matchType = matchType;
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public Category getCategory() {
        return category;
    }
}
