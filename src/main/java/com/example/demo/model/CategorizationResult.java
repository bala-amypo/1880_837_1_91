package com.example.demo.model;

public class CategorizationResult {

    private Category category;
    private String urgency;

    public CategorizationResult() {
    }

    public CategorizationResult(Category category, String urgency) {
        this.category = category;
        this.urgency = urgency;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
}
