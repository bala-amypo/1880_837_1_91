package com.example.demo.service.impl;
import com.example.demo.model.CategorizationRule;
import java.util.List;
public interface CategorizationRuleservice{
    public CategorizationRule createRule(Long categoryId,CategorizationRule rule);
    public List<CategorizationRule> getRulesByCategory(Long categoryId);
    public CategorizationRule getRule(Long id);
} 