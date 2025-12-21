package com.example.demo.controller;
import com.example.demo.service.impl.CategorizationRuleservice;
import com.example.demo.model.CategorizationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@RequestMapping("/rule")
@RestController
class CategrizationRuleController{
    @Autowired
    CategorizationRuleservice obj;

    @PostMapping("/categories/{categoryId}/rules")
    CategorizationRule CreateRule(@PathVariable Long categoryId,@RequestBody CategorizationRule rule){
        return obj.createRule(categoryId,rule);
    }
    @GetMapping("/id/{categoryId}")
    List<CategorizationRule> GetRule(@PathVariable Long categoryId){
        return obj.getRulesByCategory(categoryId);
    }
    @GetMapping("/ruleid/{id}")
    CategorizationRule gettingRule(@PathVariable Long id){
        return obj.getRule(id);
    }
}