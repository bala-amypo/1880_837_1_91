package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CategorizationRuleRepository;

import java.util.List;

public class CategorizationRuleServiceImpl {

    private final CategorizationRuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository ruleRepository,
                                         CategoryRepository categoryRepository) {
        this.ruleRepository = ruleRepository;
        this.categoryRepository = categoryRepository;
    }

    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        rule.setCategory(category);
        return ruleRepository.save(rule);
    }

    public List<CategorizationRule> getRulesByCategory(Long categoryId) {
        categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));
        return ruleRepository.findAll();
    }

    public CategorizationRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found"));
    }
}
